import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CheckoutLoginComponent } from '../checkout-login/checkout-login.component';
import { Order } from '../model/Order';
import { OrderItem } from '../model/OrderItem';
import { User } from '../model/User';
import { CartService } from '../shared/cart.service';
import { ItemsService } from '../shared/items.service';
import { OrdersService } from '../shared/orders.service';
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
  constructor(public dialog: MatDialog,private itemsService: ItemsService, private service: UsersService, private cartService: CartService,private orderService: OrdersService) { }

  ngOnInit(): void {
  this.shoppingCart = this.cartService.getItems();
  console.log(this.shoppingCart)
  this.nrOfItems = this.shoppingCart.length;
  for (var val of this.shoppingCart) {
    this.totalPrice += val.item.sellingPrice;
    this.totalPrice *= val.quantity;
  }
  this.service.getUserById(1)
  .subscribe((data)=>{
    console.log(data);
   this.user = <User>data;
  },       (error: Response) => {
       this.user.id = 999;
    this.openDetails();
  });
}

openDetails(): void {
  
  const dialogRef = this.dialog.open(CheckoutLoginComponent, {
    maxWidth: '50%',
  }); 
  dialogRef.afterClosed()
    .subscribe(res => {
  });

}
submit(data) {
  console.log("submitted");
var order = new Order(this.totalPrice, this.user.id, data.firstName +' '+ data.lastName, data.address);
var today = new Date().toISOString().slice(0, 10);
order.orderedItemsList = <OrderItem[]>this.shoppingCart;

order.status = "PENDING";
order.time = today;
console.log(order);
this.orderService.postOrder(order).subscribe((data)=>{
  console.log(data);
},       (error: Response) => {
    console.log(error);
});
}


}
