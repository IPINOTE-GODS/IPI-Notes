import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { EnseignantService } from '../shared/enseignant/enseignant.service';
import { PromoService } from '../shared/promo/promo.service';
import { AuthenticationService } from '../shared/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModule } from '@angular/core';

@Component({
    selector: 'app-promo-list',
    templateUrl: './promo-list.component.html',
    styleUrls: ['./promo-list.component.css']
})
export class PromoListComponent implements OnInit, OnDestroy {

    private promos: Array<any> = [];

    enseignant: any = {};

    sub: Subscription;

    constructor(
        private promoService: PromoService,
        private enseignantService: EnseignantService,
        private _authService: AuthenticationService,
        private route: ActivatedRoute,
        private router: Router) {
    }

    ngOnInit() {
        this.promoService.getAll().subscribe(data => {
            this.promos = data;
        });

        this.sub = this.route.params.subscribe(params => {
            const id = this._authService.currentUser.id;

            this.enseignantService.get(id).subscribe((enseignant: any) => {
                if (enseignant) {
                    this.enseignant = enseignant;
                } else {
                    console.log(`Enseignant with id '${id}' not found, returning to list`);
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