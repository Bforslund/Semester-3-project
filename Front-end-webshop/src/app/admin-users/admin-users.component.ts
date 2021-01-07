import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormArray, FormBuilder, Validators, FormGroup  } from '@angular/forms';
import { UsersService } from '../shared/users.service';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.scss']
})
export class AdminUsersComponent implements OnInit {
  usersForms : FormArray = this.fb.array([]);
  usersList = [];
  notification = null;
  loggedIn:boolean;
  constructor(public fb: FormBuilder, private service: UsersService) { }

  ngOnInit(): void {
 
    this.service.getUsers().subscribe(
      res => {
        if (res == [])
          this.addUserForm();
        else {
          //generate formarray as per the data received from BankAccont table
          (res as []).forEach((user: any) => {
            this.usersForms.push(this.fb.group({
              id: [user.id],
              firstName: [user.firstName, Validators.required],
              lastName: [user.lastName, Validators.required],
              address: [user.address, Validators.required],
              points: [user.points,  Validators.min(1)],
              birthday: [user.birthday,Validators.required],
              email: [user.email, Validators.required],
              password: [user.password],
              role: [user.role]
            }));
          });
        }
      }
    );
  }

  addUserForm(){
    this.usersForms.push(this.fb.group({
      id: [0],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      points: ['',  Validators.min(1)],
      birthday: ['',Validators.required],
      email: ['', Validators.required],
      password: [0],
      role:[0]
    }));
  }

  recordSubmit(fg: FormGroup) {
      this.service.updateUser(fg.value).subscribe(
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
  
  onDelete(id, i) {
    if (id == 0)
      this.usersForms.removeAt(i);
    else if (confirm('Are you sure to delete this user ?'))
      this.service.deleteUser(id).subscribe(
        res => {
          this.usersForms.removeAt(i);
          this.showNotification('delete');
        });
  }
}
