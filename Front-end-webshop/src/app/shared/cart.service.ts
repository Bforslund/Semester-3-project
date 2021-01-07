import { Injectable } from '@angular/core';
import { OrderItem } from '../model/OrderItem';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

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
