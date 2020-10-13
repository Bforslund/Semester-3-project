import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../shared/orders.service';
import {User} from '../model/User';
import {Order} from '../model/Order';
import {OrderItem} from '../model/OrderItem';
import {Item} from '../model/Item';


@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.scss']
})
export class ReceiptComponent implements OnInit {
order: Order = new Order(5, 55, 3, "akdaksd", "jasdjs", "ajdjs", "22323fsd");
user: User = new User(1, "test", "test2", "test3", 200, "test5", "adsas", "jasdjasj");
orderItemsList: Array<OrderItem> = [];

  constructor(private service: OrdersService) { }

  ngOnInit(): void {
    
    this.service.getUserByOrderId(1)
    .subscribe((data)=>{
    
     this.user = <User>data;
    });
    this.service.getOrderById(1)
    .subscribe((data)=>{
      
     this.order = <Order>data;
    });
    this.service.getOrderItems(1)
    .subscribe((data)=>{
     this.orderItemsList = <Array<OrderItem>>data;
     console.log(this.orderItemsList);
     this.dataSource = this.orderItemsList;
    });
   
  }
 displayedColumns = [ 'item', 'quantity'];
  dataSource;
}
