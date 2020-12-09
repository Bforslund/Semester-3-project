import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../model/Order';
import { User } from '../model/User';
import { OrdersService } from '../shared/orders.service';

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.scss']
})
export class ThankyouComponent implements OnInit {
  readLocalStorageValue() {
    return localStorage.getItem('justOrdered');
}
user: User = new User(1, "", "", "", 0, "", "", "", "USER");
  id: number;
  order: Order = new Order(0, 0, "", "");
  constructor(private router: Router,private service: OrdersService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    var justOrdered = this.readLocalStorageValue();
    this.id = +this.route.snapshot.paramMap.get('id');
    if(justOrdered == "yes"){
      console.log("Okay");
      localStorage.removeItem('justOrdered');
    }
      else{
        this.router.navigate(['/home']);
      }
    this.service.getOrderById(this.id)
    .subscribe((data)=>{
      this.order = <Order>data;
      console.log(this.order);
      this.service.getUserByOrderId(this.order.userId)
    .subscribe((data)=>{
    
     this.user = <User>data;
    });
    });
  }

}
