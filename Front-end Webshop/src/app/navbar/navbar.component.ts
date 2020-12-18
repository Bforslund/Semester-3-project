import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/users.service';
import {User} from '../model/User';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  id:string;
  admin:boolean;
  user:User;
  constructor(private service: UsersService) { }
loggedIn:boolean;
  ngOnInit(): void {
    if(this.readLocalStorageValue() != null){
      this.loggedIn= true;
      this.service.getUser()
      .subscribe((data)=>{
       this.user = <User>data;
       console.log(this.user);
       if(this.user.role === "ADMIN"){
        this.admin = true;
        
      }else{
        this.admin = false;
      }
      });
      console.log("logged innnn");
    }else{
      this.loggedIn = false;
    }


   


  }
  readLocalStorageValue() {
    return localStorage.getItem('userToken');
}

logout(){
  location.reload();
  localStorage.clear();
  this.service.logout();
}


}
