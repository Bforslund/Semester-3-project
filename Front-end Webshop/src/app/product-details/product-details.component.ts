import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Item} from '../model/Item';
import { ItemsService } from '../shared/items.service';
import { CartService } from '../shared/cart.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { OrderItem } from '../model/OrderItem';
import { Order } from '../model/Order';
import { UsersService } from '../shared/users.service';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {
  product: Item;
  id: number;
  order:Order;
  quantity:number;
  constructor(private userservice: UsersService,private service: ItemsService,private route: ActivatedRoute, private cartService: CartService, public dialogRef: MatDialogRef<ProductDetailsComponent>,@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    console.log(this.data.item.id);
    this.id = this.data.item.id
this.order = this.userservice.order;
    this.service.getItemById(this.id)
    .subscribe((data)=>{
      console.log(data);
     this.product = <Item>data;
    });
  }
  addToCart(product) {
   this.product = product;
  }

  recordSubmit(quantity){
    let newOrderItem = new OrderItem(this.product, quantity);
    this.cartService.addToCart(newOrderItem);
    window.alert('Your product has been added to the cart!');
    this.dialogRef.close();
  }

}
