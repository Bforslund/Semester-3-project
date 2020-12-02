import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { UsersService } from '../shared/users.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user = new User(1, "Bea", "dummy data", "test1", 200, "1999", "kuk@live.se", "123", "USER")
  constructor(private service: UsersService,private router : Router) { }
  years = [
    {year : '<1995'},
    {year : 1996},
    {year : 1997},
    {year : 1998},
    {year : 1999},
    {year : 2000},
    {year : 2001},
    {year : 2002},
    {year : 2003},
    {year : 2004},
    {year : 2005},
    {year : 2006},
    {year : 2007},
    {year : 2008},
    {year : 2009},
    {year : '>2010'},
 
    

  ]

  ngOnInit(): void {

  }
  onSubmitRegistration(data){
    this.user = <User>data;
    console.log(data);
   this.user.role = "USER";
   this.user.points = 0;
    this.service.registerUser(this.user).subscribe(
      (res: any) => {
        console.log(this.user);
        this.router.navigate(['/login']);
                    },       (error: Response) => {
                      if(error.status === 409){
                         console.log('This user already exists');
                        }
                        else{
                          console.log('Wrong data provided');
                        } 
                    })
 }
        

  

}
