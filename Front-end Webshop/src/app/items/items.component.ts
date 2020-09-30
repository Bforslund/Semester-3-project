import { Component, OnInit } from '@angular/core';
import { ItemsService } from '../shared/items.service';

export interface Item{
name:string;
ingredients:string;
price:number;
type:string;
}

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {

  itemsList: Item[];

  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.itemsService.getItems()
    .subscribe((data)=>{
      console.log(data);
      this.itemsList = <Item[]>data;
  });
  
}

}
