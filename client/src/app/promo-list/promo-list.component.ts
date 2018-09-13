import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { PromoService } from '../shared/promo/promo.service';

@Component({
  selector: 'app-promo-list',
  templateUrl: './promo-list.component.html',
  styleUrls: ['./promo-list.component.css']
})
export class PromoListComponent implements OnInit {

  constructor(private promoService: PromoService) { }

  private promos: Array<any> = [];

  ngOnInit() {
    this.promoService.getAll().subscribe(data => {
        this.promos = data;
    });

}

}
