import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../shared/statistics.service';
import {Chart} from'chart.js';

export class stats{
month: string;
totalOrders: number;
}

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
  chart;
  monthdata = [];
  Stat:stats[];
 
  constructor(private service: StatisticsService) { }

  ngOnInit(): void {
   this.GetAllTotals();


   this.service.getTest()
   .subscribe((data)=>{
     
    this.Stat = <stats[]>data;
    console.log(this.Stat);

    this.monthdata.push(this.Stat.find(s => s.month == 'JANUARY').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'FEBRUARY').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'MARCH').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'APRIL').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'MAY').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'JUNE').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'JULY').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'AUGUST').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'SEPTEMBER').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'OCTOBER').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'NOVEMBER').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'DECEMBER').totalOrders);
    console.log(this.monthdata);
    this.Thechart();
   });
   
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

  Thechart(){
 this.chart = new Chart('myChart', {
      type: 'line',
      data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
          datasets: [{
              label:'Orders per month',
              data: this.monthdata,
              backgroundColor:'rgba(255, 99, 132, 0.2)' ,
              borderColor:  'rgba(255, 99, 132, 1)' ,
              fill: false,
         
          }]
      },
      options: {
          scales: {
            xAxes: [{
              display: true,
              scaleLabel: {
                display: true,
                labelString: 'Month'
              }
            }],
            yAxes: [{
              display: true,
              scaleLabel: {
                display: true,
                labelString: 'Orders'
              }
            }]
          }
      }
  });
  }

}
