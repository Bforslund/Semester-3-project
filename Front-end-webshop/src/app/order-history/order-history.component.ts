import { Component, OnInit } from '@angular/core';
import {Order} from '../model/Order';
import { OrdersService } from '../shared/orders.service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.scss']
})
export class OrderHistoryComponent implements OnInit {
  

 displayedColumns: string[] = ['orderNumber', 'address', 'time', 'totalPrice', 'actions'];
 dataSource;
  constructor(private service: OrdersService) { }

  ngOnInit(): void {
    this.service.getOrderItemsOfOneUser(1).subscribe((data)=>{
      
      this.dataSource = data;
      console.log(this.dataSource);
    });
 
  
  }

}
