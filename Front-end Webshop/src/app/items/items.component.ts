import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ItemsService } from '../shared/items.service';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';

import {Item} from '../model/Item';
import { MatSliderChange } from '@angular/material/slider';
import { MatRadioChange } from '@angular/material/radio';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit{
  itemsList: Item[];
  items$: Observable<Item[]>;
  filterItems$: Observable<Item[]>;

  price:number =0;
  type:string = null;
  constructor(private itemsService: ItemsService) { }



  item = new Item(1,"",1,1,"","");
  productTypes: string[] = ['CAKE', 'CUPCAKE', 'COOKIE', 'OTHER'];

  onInputChange(event: MatSliderChange) {
   
    this.price=event.value;
  //   this.itemsService.filterItems(this.type,event.value, )
  //   .subscribe((data)=>{
  //     console.log(data);
  //     this.itemsList = <Item[]>data;
  // });
  }
  radioChange(event: MatRadioChange) {
    this.type=event.value;
    this.itemsService.filterItems(event.value, this.price)
    .subscribe((data)=>{
      console.log(data);
      this.itemsList = <Item[]>data;
  });
}

  formatLabel(value: number) {
  
    return value;
  }


  search(term: string): void {
    this.searchTerms.next(term);
  }
  private searchTerms = new Subject<string>();
  ngOnInit(): void {
  //   this.itemsService.getItems()
  //   .subscribe((data)=>{
  //     console.log(data);
  //     this.itemsList = <Item[]>data;
  // });

  this.items$ = this.searchTerms.pipe(
    // wait 300ms after each keystroke before considering the term
    debounceTime(300),

    // ignore new term if same as previous term
    distinctUntilChanged(),

    // switch to new search observable each time the term changes
    switchMap((term: string) => this.itemsService.searchItems(term)),
  );

 
}

}




