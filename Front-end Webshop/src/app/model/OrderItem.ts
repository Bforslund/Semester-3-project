import {Item} from '../model/Item';
import { Order } from './Order';
export class OrderItem{

    constructor(
        public id: number,
        public order: Order,
        public item: Item,
        public quantity: number,
      
    ) {  }

}