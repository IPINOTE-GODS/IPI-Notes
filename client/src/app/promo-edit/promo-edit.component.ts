import { Component, OnInit } from '@angular/core';
/*import { PromotionService } from '../shared/promotion/promotion.service';*/

@Component({
  selector: 'app-promo-edit',
  templateUrl: './promo-edit.component.html',
  styleUrls: ['./promo-edit.component.css']
})
export class PromoEditComponent implements OnInit {

  constructor(
    /*private promotionService: PromotionService*/
  ) { }

  private etudianpromotions: Array<any>;

  ngOnInit() {
    /*this.promotionService.getAll().subscribe(data => {
      this.promotions = data;
    });*/

  }

}
