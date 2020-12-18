import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  readLocalStorageValue() {
    if(localStorage.getItem("userToken") != null){
      this.httpOptions.headers = this.httpOptions.headers.set('Authorization', localStorage.getItem("userToken"));
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

  public getTotalOrders(){
    return this.httpClient.get('http://localhost:19090/statistics/revenue', this.httpOptions);
  }
  public getTotalCakes(){
    return this.httpClient.get('http://localhost:19090/statistics/cakes',this.httpOptions);
  }
  public getTotalCupcakes(){
    return this.httpClient.get('http://localhost:19090/statistics/cupcakes', this.httpOptions);
  }
  public getTotalCookies(){
    return this.httpClient.get('http://localhost:19090/statistics/cookies', this.httpOptions);
  }
  public getTotalOther(){
    return this.httpClient.get('http://localhost:19090/statistics/other', this.httpOptions);
  }
  public getTest(){
    return this.httpClient.get('http://localhost:19090/statistics/', this.httpOptions);
  }
  

}
