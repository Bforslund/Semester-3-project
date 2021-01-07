import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
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

 error:boolean;
 
 user: User = new User(1, "","","",1,"","","","USER");
  constructor(private userService: UsersService,private router: Router,public dialog: MatDialog,private itemsService: ItemsService, private service: UsersService, private cartService: CartService,private orderService: OrdersService) { }

  ngOnInit(): void {
  this.shoppingCart = this.cartService.getItems();
  console.log(this.shoppingCart)
  this.nrOfItems = this.shoppingCart.length;
  for (var val of this.shoppingCart) {
    this.totalPrice += val.item.sellingPrice;
    this.totalPrice *= val.quantity;
  }
  this.service.getUser()
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
if(order.orderedItemsList.length < 1){
  this.error= true;
}else{
  this.user.points += 10;
this.service.updateUser(this.user).subscribe(
  (res: any) => {
    console.log(this.user.points);
  });
  this.orderService.postOrder(order).subscribe((res: any)=>{
    localStorage.setItem('justOrdered', 'yes');
    this.cartService.clearCart();
    this.router.navigate(['/thankyou/' + res.orderNumber]);
  },       (error: Response) => {
      console.log(error);
  });
}


}


}
