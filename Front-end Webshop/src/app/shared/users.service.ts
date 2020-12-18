import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Order } from '../model/Order';
import jwt_decode from 'jwt-decode';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  readLocalStorageValue() {
    if(localStorage.getItem("userToken") != null){
      this.httpOptions.headers = this.httpOptions.headers.set('Authorization',  localStorage.getItem("userToken"));
    };
}
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) {
    this.readLocalStorageValue();
   }

  public getUsers(){
    
    console.log(this.httpOptions.headers);
    //httpOptions.headers = httpOptions.headers.delete('Authorization');
   // console.log(httpOptions.headers);
    return this.httpClient.get('http://localhost:19090/users/', this.httpOptions);
  }
order:Order;
  login(email, password){
   this.order = new Order( 0, 1, "","");
 
   const body = email+":"+password;
   return this.httpClient.post('http://localhost:19090/users/login', body, {responseType: 'text'});
  }

  logout(){
    this.httpOptions.headers = this.httpOptions.headers.delete('Authorization');
  }

   getDecodedAccessToken(token: string): any {
    try{
        return jwt_decode(token);
    }
    catch(Error){
        return null;
    }
  }



  
  updateUser(formData) {
    return this.httpClient.put('http://localhost:19090/users/', formData, this.httpOptions);
  }

  deleteUser(id) {
    return this.httpClient.delete('http://localhost:19090/users/' + id, this.httpOptions);
  }
  getUser(){
    return this.httpClient.get('http://localhost:19090/users/me', this.httpOptions);
}

registerUser(model){
  return this.httpClient.post('http://localhost:19090/users/', model, this.httpOptions);
}



}
