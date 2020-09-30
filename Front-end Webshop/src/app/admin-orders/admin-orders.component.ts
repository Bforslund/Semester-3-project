import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators, FormGroup  } from '@angular/forms';
import { OrdersService } from '../shared/orders.service';

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
              userId: [order.userId,  Validators.min(1)],
              address: [order.address, Validators.required],
              status: [order.status,  Validators.required],
              totalPrice: [order.totalPrice, Validators.min(1)],
            }));
          });
        }
      }
    );
  }
  
  addOrdersForm(){
    this.ordersForms.push(this.fb.group({
      orderNumber: [0],
      userId: ['',  Validators.min(1)],
      address: ['', Validators.required],
      status: ['',  Validators.required],
      totalPrice: ['', Validators.min(1)],
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
    
      this.service.deleteAllOrders().subscribe(
        res => {
          this.ordersForms.reset;
          this.showNotification('delete');
        });
  }

}
