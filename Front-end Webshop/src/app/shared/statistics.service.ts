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
export class StatisticsService {

  constructor(private httpClient: HttpClient) { }

  public getTotalOrders(){
    return this.httpClient.get('http://localhost:9090/statistics/revenue', httpOptions);
  }
  public getTotalCakes(){
    return this.httpClient.get('http://localhost:9090/statistics/cakes', httpOptions);
  }
  public getTotalCupcakes(){
    return this.httpClient.get('http://localhost:9090/statistics/cupcakes', httpOptions);
  }
  public getTotalCookies(){
    return this.httpClient.get('http://localhost:9090/statistics/cookies', httpOptions);
  }
  public getTotalOther(){
    return this.httpClient.get('http://localhost:9090/statistics/other', httpOptions);
  }
  public getTest(){
    return this.httpClient.get('http://localhost:9090/statistics/', httpOptions);
  }
  

}
