import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private httpClient: HttpClient) { }
  public getOrders(){
    return this.httpClient.get('http://localhost:9090/orders/');
  }

  
  updateOrder(formData) {
    return this.httpClient.put('http://localhost:9090/orders/', formData);
  }

  deleteAllOrders() {
    return this.httpClient.delete('http://localhost:9090/deleteAll/');
  }
}
