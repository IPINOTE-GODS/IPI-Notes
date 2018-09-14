import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { EtudiantService } from '../shared/etudiant/etudiant.service';
import { AuthenticationService } from '../shared/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-ficheeleves',
    templateUrl: './ficheeleves.component.html',
    styleUrls: ['./ficheeleves.component.css']
})
export class FicheelevesComponent implements OnInit, OnDestroy {

    etudiant: any = {};

    sub: Subscription;

    constructor(
        private etudiantService: EtudiantService,
        private _authService: AuthenticationService,
        private route: ActivatedRoute,
        private router: Router) {
    }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            const id = this._authService.currentUser.id;
            
            this.etudiantService.get(id).subscribe((etudiant: any) => {
                if (etudiant) {
                    this.etudiant = etudiant;
                } else {
                    console.log(`Etudiant with id '${id}' not found, returning to list`);
                    this.gotoIndex();
                }
            });
        });
    }

    gotoIndex() {
      this.router.navigate(['/index']);
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

}