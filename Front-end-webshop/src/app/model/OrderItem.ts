import {Item} from '../model/Item';
import { Order } from './Order';
export class OrderItem{
    public id: number;
    constructor(
        
        public item: Item,
        public quantity: number,
      
    ) {  }

}