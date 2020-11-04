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

    this.monthdata.push(this.Stat.find(s => s.month == 'jan').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'feb').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'mar').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'apr').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'may').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'jun').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'jul').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'aug').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'sep').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'oct').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'nov').totalOrders);
    this.monthdata.push(this.Stat.find(s => s.month == 'dec').totalOrders);
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
