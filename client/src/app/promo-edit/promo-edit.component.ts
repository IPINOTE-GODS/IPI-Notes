import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { PromoService } from '../shared/promo/promo.service';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-promo-edit',
    templateUrl: './promo-edit.component.html',
    styleUrls: ['./promo-edit.component.css']
})
export class PromoEditComponent implements OnInit, OnDestroy {
    promo: any = {};
    annee: any;

    sub: Subscription;

    constructor(private route: ActivatedRoute,
        private router: Router,
        private promoService: PromoService) {

    }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            const id = params['id'];
            if (id) {
                this.promoService.get(id).subscribe((promo: any) => {
                    if (promo) {
                        this.promo = promo;
                        this.promo.href = id;//promo._links.self.href;
                    } else {
                        console.log(`Promo with id '${id}' not found, returning to list`);
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
        this.router.navigate(['/promo-list']);
    }

    save(form: any) {
        if(!form.isSemestriel) form.isSemestriel = false;
        delete form.annee;
        this.promoService.save(form, this.annee).subscribe(result => {
            this.gotoList();
        }, error => console.error(error));
    }

    remove(href) {
        this.promoService.remove(href).subscribe(result => {
            this.gotoList();
        }, error => console.error(error));
    }

}