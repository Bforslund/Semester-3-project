import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  constructor(private httpClient: HttpClient) {this.readLocalStorageValue(); }


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
  public getRecipes(){
    return this.httpClient.get('http://localhost:19090/recipes/', this.httpOptions);
  }
  postRecipes(data) {
    return this.httpClient.post('http://localhost:19090/recipes/', data, this.httpOptions);
  }

}
