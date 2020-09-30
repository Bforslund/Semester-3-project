import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private httpClient: HttpClient) { }

  public getUsers(){
    return this.httpClient.get('http://localhost:9090/users/');
  }

  
  updateUser(formData) {
    return this.httpClient.put('http://localhost:9090/users/', formData);
  }

  deleteUser(id) {
    return this.httpClient.delete('http://localhost:9090/users/' + id);
  }
}
