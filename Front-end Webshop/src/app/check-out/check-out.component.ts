import { Component, OnInit } from '@angular/core';
import { OrderItem } from '../model/OrderItem';
import { ItemsService } from '../shared/items.service';
@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.scss']
})
export class CheckOutComponent implements OnInit {
 shoppingCart: OrderItem[];
 totalPrice: number = 0;
 nrOfItems:number;
  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
  this.shoppingCart = this.itemsService.GetShoppingCart();
  this.nrOfItems = this.shoppingCart.length;
  for (var val of this.shoppingCart) {
    this.totalPrice += val.item.sellingPrice;
  }
}


}
