import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/users.service';
import {User} from '../model/User';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {
  notification = null; 
  constructor(private service: UsersService) { }
user = new User(1, "Bea", "dummy data", "test1", 200, "1999", "kuk@live.se", "123")
  ngOnInit(): void {

    this.service.getUserById(1)
    .subscribe((data)=>{
      console.log(data);
     this.user = <User>data;
    });
  
  }
  update() {
    this.service.updateUserById(this.user, 1).subscribe(
      (res: any) => {
        this.showNotification();
      });
}

showNotification() {
      this.notification = { class: 'text-primary', message: 'updated!' };

}
}
