import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class UsersService {
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

  constructor(private httpClient: HttpClient) {
    this.readLocalStorageValue();
   }

  public getUsers(){
    
    console.log(this.httpOptions.headers);
    //httpOptions.headers = httpOptions.headers.delete('Authorization');
   // console.log(httpOptions.headers);
    return this.httpClient.get('http://localhost:9090/users/', this.httpOptions);
  }

  login(email, password){
   
   const body = email+":"+password;
   return this.httpClient.post('http://localhost:9090/users/login', body, this.httpOptions);
  }

  
  updateUser(formData) {
    return this.httpClient.put('http://localhost:9090/users/', formData, this.httpOptions);
  }

  deleteUser(id) {
    return this.httpClient.delete('http://localhost:9090/users/' + id, this.httpOptions);
  }
  getUserById(id){
    return this.httpClient.get('http://localhost:9090/users/' + id, this.httpOptions);
}



}
