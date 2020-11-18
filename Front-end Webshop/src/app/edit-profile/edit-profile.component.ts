import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/users.service';
import {User} from '../model/User';
import { Router } from '@angular/router';
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {
  notification = null; 
  loggedIn:boolean;
  id:string;
  token:string;
  constructor(private service: UsersService, private router : Router) { }
user = new User(1, "Bea", "dummy data", "test1", 200, "1999", "kuk@live.se", "123","USER")
readLocalStorageValue() {
  return localStorage.getItem('userToken');
}

ngOnInit(): void {
  if(this.readLocalStorageValue() != null){
    this.loggedIn= true;
  }else{
    this.loggedIn = false;
    this.router.navigate(['/login']);
  }
  this.id = localStorage.getItem('userId');
    this.service.getUserById(this.id)
    .subscribe((data)=>{
      console.log(data);
     this.user = <User>data;
    });
  
  }
  update() {
    this.service.updateUser(this.user).subscribe(
      (res: any) => {
        this.showNotification();
      });
}

showNotification() {
      this.notification = { class: 'text-primary', message: 'updated!' };

}

updatePassword(data){
  this.user.password = data.password;
  this.token = btoa(this.user.email+':'+this.user.password);
  localStorage.clear();
  localStorage.setItem('userToken', this.token);
  localStorage.setItem('userId', this.user.id.toString());
  location.reload();
  this.service.updateUser(this.user).subscribe(
    (res: any) => {
      console.log("updated password!");
    });
}
}
