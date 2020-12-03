import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
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
  constructor(private httpClient: HttpClient) {this.readLocalStorageValue(); }
  public getOrders(){
    return this.httpClient.get('http://localhost:9090/orders/', this.httpOptions);
  }

  
  updateOrder(formData) {
    console.log(formData);
    return this.httpClient.put('http://localhost:9090/orders/', formData, this.httpOptions);
  }

  deleteAllOrders() {
    return this.httpClient.delete('http://localhost:9090/orders/deleteAll/', this.httpOptions);
  }
  getUserByOrderId(id){
    return this.httpClient.get('http://localhost:9090/orders/order/' + id + '/user', this.httpOptions);
}
getOrderById(id){
  return this.httpClient.get('http://localhost:9090/orders/order/' + id, this.httpOptions);
}

public getOrderItems(id){
  return this.httpClient.get('http://localhost:9090/orders/order/' + id + '/orderitems', this.httpOptions);
}
public getOrderItemsOfOneUser(id){
  return this.httpClient.get('http://localhost:9090/orders/user/' + id, this.httpOptions);
}
public postOrder(order) {
  return this.httpClient.post('http://localhost:9090/orders/', order, this.httpOptions);
}


}
