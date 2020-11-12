import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators, FormGroup  } from '@angular/forms';
import { ItemsService } from '../shared/items.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  loggedIn:boolean;
ItemsForms : FormArray = this.fb.array([]);
itemsList = [];
notification = null;

  constructor(public fb: FormBuilder, private itemsService: ItemsService, private router : Router) { }
  readLocalStorageValue() {
    return localStorage.getItem('userToken');
}

  ngOnInit(): void {
    if(this.readLocalStorageValue() != null){
      this.loggedIn= true;
      console.log("logged innnn");
    }else{
      this.loggedIn = false;
      this.router.navigate(['/login']);
    }
  this.itemsService.getItems().subscribe(
    res => {
      if (res == [])
        this.addItemForm();
      else {
        //generate formarray as per the data received from BankAccont table
        (res as []).forEach((item: any) => {
          this.ItemsForms.push(this.fb.group({
            id: [item.id],
            name: [item.name, Validators.required],
            ingredients: [item.ingredients, Validators.required],
            type: [item.type, Validators.required],
            sellingPrice: [item.sellingPrice, Validators.min(1)],
            buyingPrice: [item.buyingPrice, Validators.min(1)]
          }));
        });
      }
    }
  );
  }

addItemForm(){
  this.ItemsForms.push(this.fb.group({
    id: [0],
    name: ['', Validators.required],
    ingredients: ['', Validators.required],
    type: ['', Validators.required],
    sellingPrice: ['', Validators.min(1)],
    buyingPrice: ['', Validators.min(1)],
  }));
}

recordSubmit(fg: FormGroup) {
  if (fg.value.id == 0)
    this.itemsService.postItems(fg.value).subscribe(
      (res: any) => {
       // fg.patchValue({ id: res.id });
        this.showNotification('insert');
      });
  else
    this.itemsService.updateItems(fg.value).subscribe(
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
    this.ItemsForms.removeAt(i);
  else if (confirm('Are you sure to delete this record ?'))
    this.itemsService.deleteItem(id).subscribe(
      res => {
        this.ItemsForms.removeAt(i);
        this.showNotification('delete');
      });
}

}
