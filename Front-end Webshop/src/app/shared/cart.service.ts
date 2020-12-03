import { Injectable } from '@angular/core';
import { OrderItem } from '../model/OrderItem';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }
//   public GetShoppingCart() {
//     return this.shoppingCart;
// }
// public Add(data){
//     this.shoppingCart.push(data);
// }
// public GetOrder(){
  
// }

// order:Order = new Order(1, 100, 1, "Bea", "idk", "SHIPPED", "dummy");
// i2: Item = new Item(1, "Choclate cake", 67, 30, "choclate, flour", "CAKE");
// i3: Item = new Item(2, "Chocolate chip cookies", 70, 30, "choclate, flour", "COOKIE");
// i4: Item = new Item(3, "Vanilla cupcakes", 50, 30, "vanilla bean, flour", "CUPCAKE");

// o1: OrderItem = new OrderItem(1, this.order, this.i2, 2);
// o2: OrderItem = new OrderItem(2, this.order, this.i3, 5);
// o3: OrderItem = new OrderItem(3,  this.order,this.i4, 2);
//   public shoppingCart: OrderItem[] = [this.o1, this.o2, this.o3];

shoppingCart: Array<OrderItem> = [];

  addToCart(product) {
    this.shoppingCart.push(product);
  }

  getItems() {
    return this.shoppingCart;
  }

  clearCart() {
    this.shoppingCart = [];
    return this.shoppingCart;
  }

}
