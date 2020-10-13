export class Order{

    constructor(
        public orderNumber: number,
        public totalPrice: number,
        public userId: number,
        public customerName: string,
        public address: string,
        public status: string,
        public time: string,
    ) {  }

}