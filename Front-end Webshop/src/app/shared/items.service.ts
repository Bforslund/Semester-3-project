import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import {OrderItem} from '../model/OrderItem';
import {Item} from '../model/Item';
import { Order } from '../model/Order';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'Basic ' + btoa('test@gmail.com:1234')
  })
};
@Injectable({
  providedIn: 'root'
})
export class ItemsService {
order:Order = new Order(1, 100, 1, "Bea", "idk", "SHIPPED", "dummy");
i2: Item = new Item(1, "Choclate cake", 67, 30, "choclate, flour", "CAKE");
i3: Item = new Item(2, "Chocolate chip cookies", 70, 30, "choclate, flour", "COOKIE");
i4: Item = new Item(3, "Vanilla cupcakes", 50, 30, "vanilla bean, flour", "CUPCAKE");

o1: OrderItem = new OrderItem(1, this.order, this.i2, 2);
o2: OrderItem = new OrderItem(2, this.order, this.i3, 5);
o3: OrderItem = new OrderItem(3,  this.order,this.i4, 2);
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
    return this.httpClient.get('http://localhost:9090/items/', httpOptions);
  }

  postItems(formData) {
    return this.httpClient.post('http://localhost:9090/items/', formData, httpOptions);
  }

  updateItems(formData) {
    return this.httpClient.put('http://localhost:9090/items/', formData, httpOptions);
  }

  deleteItem(id) {
    return this.httpClient.delete('http://localhost:9090/items/' + id, httpOptions);
  }
}
