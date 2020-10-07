import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/users.service';
export interface User{
  id:number;
  firstName:string;
  lastName:string;
  email:string;
  points:number;
  birthday:string;
  address:string;
  }
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {
  user: User;
  constructor(private service: UsersService) { }

  ngOnInit(): void {

    this.service.getUserById(1)
    .subscribe((data)=>{
      console.log(data);
     this.user = <User>data;
    });
  }
  recordSubmit(fg) {
    this.service.updateUser(fg.value).subscribe(
      (res: any) => {
        console.log("update");
      });
}

}
