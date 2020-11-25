import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ItemsService } from '../shared/items.service';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';

import {Item} from '../model/Item';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {
  itemsList: Item[];
  items$: Observable<Item[]>;
  private searchTerms = new Subject<string>();

  search(term: string): void {
    this.searchTerms.next(term);
  }
  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.itemsService.getItems()
    .subscribe((data)=>{
      console.log(data);
      this.itemsList = <Item[]>data;
  });

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




