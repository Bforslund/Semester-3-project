import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-checkout-login',
  templateUrl: './checkout-login.component.html',
  styleUrls: ['./checkout-login.component.scss']
})
export class CheckoutLoginComponent implements OnInit {

  constructor( public dialogRef: MatDialogRef<CheckoutLoginComponent>,@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
  }
  continue(){
    this.dialogRef.close();
  }
  existing(){
    this.dialogRef.close();
  }
}
