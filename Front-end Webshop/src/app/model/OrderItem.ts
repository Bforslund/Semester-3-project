import {Item} from '../model/Item';
export class OrderItem{

    constructor(
        public id: number,
        public item: Item,
        public quantity: number,
      
    ) {  }

}