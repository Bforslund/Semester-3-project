import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators, FormGroup  } from '@angular/forms';
import { OrdersService } from '../shared/orders.service';
import {Order} from '../model/Order';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.scss']
})
export class AdminOrdersComponent implements OnInit {
  ordersForms : FormArray = this.fb.array([]);
  ordersList = [];
  notification = null;
  constructor(public fb: FormBuilder, private service: OrdersService) { }

  ngOnInit(): void {
    this.service.getOrders().subscribe(
      res => {
        if (res == [])
          this.addOrdersForm();
        else {
          //generate formarray as per the data received from BankAccont table
          (res as []).forEach((order: any) => {
            this.ordersForms.push(this.fb.group({
              orderNumber: [order.orderNumber],
              address: [order.address, Validators.required],
              status: [order.status,  Validators.required],
              totalPrice: [order.totalPrice,],
           
            }));
          });
          
        }
      }
    );
   

  }
  
  addOrdersForm(){
    this.ordersForms.push(this.fb.group({
      orderNumber: [0] ,
      address: ['', Validators.required],
      status: ['',  Validators.required],
      totalPrice: [0],
    }));
  }

  recordSubmit(fg: FormGroup) {
      this.service.updateOrder(fg.value).subscribe(
        (res: any) => {
          this.showNotification('update');
        });
  }
  
  showNotification(category) {
    switch (category) {
      case 'insert':
        this.notification = { class: 'text-success', message: 'saved!' };
        break;
      case 'update':
        this.notification = { class: 'text-primary', message: 'updated!' };
        break;
      case 'delete':
        this.notification = { class: 'text-danger', message: 'deleted!' };
        break;
  
      default:
        break;
    }
  }
  
  onDelete() {
   if (confirm('Are you sure to delete all orders ?'))
   this.service.deleteAllOrders().subscribe(() => console.log("Everything deleted"));
       this.TheWhileLoop();
       this.showNotification('delete');
   
  }
  TheWhileLoop(){
    while ( this.ordersForms.length !== 0) {
      this.ordersForms.removeAt(0)
  }
}

}