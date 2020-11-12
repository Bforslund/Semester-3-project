import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../shared/users.service';
import {User} from '../model/User';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
token:string;
loggedIn:boolean;
isLoginError : boolean = false;
  constructor(private service: UsersService,private router : Router) { }
  user = new User(1, "Bea", "dummy data", "test1", 200, "1999", "kuk@live.se", "123", "USER")
  ngOnInit(): void {
    if(this.readLocalStorageValue() != null){
      this.loggedIn= true;
      this.router.navigate(['/profile']);
    }else{
      this.loggedIn = false;
      
    }
  }
  OnSubmit(email,password){
    this.token = btoa(email+':'+password);
  this.service.login(email, password)
  .subscribe(
    (res: any) => {
      console.log(this.token);
      this.user = <User>res;
     localStorage.setItem('userToken', this.token);
     localStorage.setItem('userId', this.user.id.toString());
     location.reload();
     this.router.navigate(['/profile']);
    },
    (error: Response) => {
      if(error.status === 404){
        console.log("not found");
        this.isLoginError = true;
       }
      }
);
}
readLocalStorageValue() {
  return localStorage.getItem('userToken');
}

}
