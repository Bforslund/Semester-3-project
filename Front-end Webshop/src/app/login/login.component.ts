import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../shared/users.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
token:string;
isLoginError : boolean = false;
  constructor(private service: UsersService,private router : Router) { }

  ngOnInit(): void {
  }
  OnSubmit(email,password){
    this.token = btoa(email+':'+password);
  this.service.login(email, password)
  .subscribe(
    (res: any) => {
      console.log(this.token);
     localStorage.setItem('userToken', this.token)
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

}
