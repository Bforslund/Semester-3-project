import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'Basic ' + btoa('test@gmail.com:1234')
  })
};
@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private httpClient: HttpClient) { }
  public getOrders(){
    return this.httpClient.get('http://localhost:9090/orders/', httpOptions);
  }

  
  updateOrder(formData) {
    console.log(formData);
    return this.httpClient.put('http://localhost:9090/orders/', formData, httpOptions);
  }

  deleteAllOrders() {
    return this.httpClient.delete('http://localhost:9090/orders/deleteAll/', httpOptions);
  }
  getUserByOrderId(id){
    return this.httpClient.get('http://localhost:9090/orders/order/' + id + '/user', httpOptions);
}
getOrderById(id){
  return this.httpClient.get('http://localhost:9090/orders/order/' + id, httpOptions);
}

public getOrderItems(id){
  return this.httpClient.get('http://localhost:9090/orders/order/' + id + '/orderitems', httpOptions);
}
public getOrderItemsOfOneUser(id){
  return this.httpClient.get('http://localhost:9090/orders/user/' + id, httpOptions);
}


}
