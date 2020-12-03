import { OrderItem } from './OrderItem';

export class Order{
    public orderedItemsList: OrderItem[];
    public status: string;
    public time: string;
     public orderNumber: number;
    constructor(
       
        public totalPrice: number,
        public userId: number,
        public customerName: string,
        public address: string,
      
    ) { 
        this.orderedItemsList = [];
     }

}