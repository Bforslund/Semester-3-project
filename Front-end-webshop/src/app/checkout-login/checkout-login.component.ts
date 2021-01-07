import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkout-login',
  templateUrl: './checkout-login.component.html',
  styleUrls: ['./checkout-login.component.scss']
})
export class CheckoutLoginComponent implements OnInit {

  constructor(private router: Router, public dialogRef: MatDialogRef<CheckoutLoginComponent>,@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
  }
  continue(){
    this.dialogRef.close();
  }
  existing(){
    this.router.navigate(['/login']);
    this.dialogRef.close();
  }
}
