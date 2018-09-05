import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { EtudiantService } from '../shared/etudiant/etudiant.service';
import { GiphyService } from '../shared/giphy/giphy.service';
//import { NgxPaginationModule } from 'ngx-pagination';



@Component({
    selector: 'app-etudiant-list',
	templateUrl: './etudiant-list.component.html',
    styleUrls: ['./etudiant-list.component.css']
})

export class EtudiantListComponent implements OnInit {

    constructor(
        private etudiantService: EtudiantService,
        private giphyService: GiphyService
    ) { }

    private etudiants: Array<any>;

    ngOnInit() {
        this.etudiantService.getAll().subscribe(data => {
            this.etudiants = data;

            for (const etudiant of this.etudiants) {
                this.giphyService.get(etudiant.name).subscribe(url => etudiant.giphyUrl = url);
            }
        });

    }

}
