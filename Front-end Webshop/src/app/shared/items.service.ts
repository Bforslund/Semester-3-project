import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import {OrderItem} from '../model/OrderItem';
import {Item} from '../model/Item';
import { Order } from '../model/Order';

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
  constructor(private httpClient: HttpClient) {this.readLocalStorageValue(); }


  readLocalStorageValue() {
    if(localStorage.getItem("userToken") != null){
      this.httpOptions.headers = this.httpOptions.headers.set('Authorization',  'Basic ' + localStorage.getItem("userToken"));
    };
}
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };



  public GetShoppingCart() {
    return this.shoppingCart;
}
public Add(data){
    this.shoppingCart.push(data);
}
public GetOrder(){
  
}


  public getItems(){
    return this.httpClient.get('http://localhost:9090/items/', this.httpOptions);
  }

  postItems(formData) {
    return this.httpClient.post('http://localhost:9090/items/', formData, this.httpOptions);
  }

  updateItems(formData) {
    return this.httpClient.put('http://localhost:9090/items/', formData, this.httpOptions);
  }

  deleteItem(id) {
    return this.httpClient.delete('http://localhost:9090/items/' + id, this.httpOptions);
  }
}
