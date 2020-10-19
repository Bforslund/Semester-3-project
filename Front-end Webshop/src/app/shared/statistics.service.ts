import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private httpClient: HttpClient) { }

  public getTotalOrders(){
    return this.httpClient.get('http://localhost:9090/statistics/revenue');
  }
  public getTotalCakes(){
    return this.httpClient.get('http://localhost:9090/statistics/cakes');
  }
  public getTotalCupcakes(){
    return this.httpClient.get('http://localhost:9090/statistics/cupcakes');
  }
  public getTotalCookies(){
    return this.httpClient.get('http://localhost:9090/statistics/cookies');
  }
  public getTotalOther(){
    return this.httpClient.get('http://localhost:9090/statistics/other');
  }

}
