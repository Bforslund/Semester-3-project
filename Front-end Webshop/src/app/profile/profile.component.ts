import { Component, OnInit } from '@angular/core';

import { UsersService } from '../shared/users.service';
import {User} from '../model/User';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
user: User = new User(1, "test", "test2", "test3", 200, "test5", "adsas", "jasdjasj");

  constructor(private service: UsersService) { }

  ngOnInit(): void {
    
    this.service.getUserById(1)
    .subscribe((data)=>{
      console.log(data);
     this.user = <User>data;
    });
  }

}
