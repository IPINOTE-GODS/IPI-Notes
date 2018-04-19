import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { EtudiantService } from '../shared/etudiant/etudiant.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-etudiant-edit',
  templateUrl: './etudiant-edit.component.html',
  styleUrls: ['./etudiant-edit.component.css']
})
export class EtudiantEditComponent implements OnInit, OnDestroy {
  etudiant: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private etudiantService: EtudiantService,
              private giphyService: GiphyService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.etudiantService.get(id).subscribe((etudiant: any) => {
          if (etudiant) {
            this.etudiant = etudiant;
            this.etudiant.href = etudiant._links.self.href;
            this.giphyService.get(etudiant.name).subscribe(url => etudiant.giphyUrl = url);
          } else {
            console.log(`Etudiant with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/etudiant-list']);
  }

  save(form: NgForm) {
    this.etudiantService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.etudiantService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}