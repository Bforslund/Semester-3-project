import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../shared/statistics.service';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements OnInit {
  totalRevenue:number;
  totalCakes:number;
  totalCupcakes:number;
  totalCookies:number;
  totalOther:number;
  constructor(private service: StatisticsService) { }

  ngOnInit(): void {
   this.GetAllTotals();
  
  }

  GetAllTotals(){
    this.service.getTotalOrders()
    .subscribe((data)=>{
      console.log(data);
     this.totalRevenue = <number>data;
    });
    this.service.getTotalCakes()
    .subscribe((data)=>{
      console.log(data);
     this.totalCakes = <number>data;
    });
    this.service.getTotalCookies()
    .subscribe((data)=>{
      console.log(data);
     this.totalCookies = <number>data;
    });
    this.service.getTotalCupcakes()
    .subscribe((data)=>{
      console.log(data);
     this.totalCupcakes = <number>data;
    });
    this.service.getTotalOther()
    .subscribe((data)=>{
      console.log(data);
     this.totalOther = <number>data;
    });
  }

}
