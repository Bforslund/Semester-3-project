import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {OrderItem} from '../model/OrderItem';
import {Item} from '../model/Item';
import { Order } from '../model/Order';
@Injectable({
  providedIn: 'root'
})
export class ItemsService {
i2: Item = new Item(1, "Choclate cake", 67, 30, "choclate, flour", "CAKE");
i3: Item = new Item(2, "Chocolate chip cookies", 70, 30, "choclate, flour", "COOKIE");
i4: Item = new Item(3, "Vanilla cupcakes", 50, 30, "vanilla bean, flour", "CUPCAKE");

o1: OrderItem = new OrderItem(1, this.i2, 2);
o2: OrderItem = new OrderItem(2, this.i3, 5);
o3: OrderItem = new OrderItem(3, this.i4, 2);
  public shoppingCart: OrderItem[] = [this.o1, this.o2, this.o3];
  constructor(private httpClient: HttpClient) { }

  public GetShoppingCart() {
    return this.shoppingCart;
}
public Add(data){
    this.shoppingCart.push(data);
}
public GetOrder(){
  
}


  public getItems(){
    return this.httpClient.get('http://localhost:9090/items/');
  }

  postItems(formData) {
    return this.httpClient.post('http://localhost:9090/items/', formData);
  }

  updateItems(formData) {
    return this.httpClient.put('http://localhost:9090/items/', formData);
  }

  deleteItem(id) {
    return this.httpClient.delete('http://localhost:9090/items/' + id);
  }
}
