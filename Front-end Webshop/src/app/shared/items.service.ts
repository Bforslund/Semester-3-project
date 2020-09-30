import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private httpClient: HttpClient) { }
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
