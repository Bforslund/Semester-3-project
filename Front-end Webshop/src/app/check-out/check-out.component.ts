import { Component, OnInit } from '@angular/core';
import { OrderItem } from '../model/OrderItem';
import { User } from '../model/User';
import { ItemsService } from '../shared/items.service';
import { UsersService } from '../shared/users.service';
@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.scss']
})
export class CheckOutComponent implements OnInit {
 shoppingCart: OrderItem[];
 totalPrice: number = 0;
 nrOfItems:number;
 user: User = new User(1, "test", "test2", "test3", 200, "test5", "adsas", "jasdjasj", "USER");
  constructor(private itemsService: ItemsService, private service: UsersService) { }

  ngOnInit(): void {
  this.shoppingCart = this.itemsService.GetShoppingCart();
  this.nrOfItems = this.shoppingCart.length;
  for (var val of this.shoppingCart) {
    this.totalPrice += val.item.sellingPrice;
  }
  this.service.getUserById(1)
  .subscribe((data)=>{
    console.log(data);
   this.user = <User>data;
  });
}
submit() {
  console.log("submitted");
}


}
