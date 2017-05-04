import {BaseModel} from "../base-model";
import {Timestamp} from "rxjs/Rx";

export class ExportBriefModel extends BaseModel {
    orderId :number;
    customerId:number;
    customerName:string;
    orderCost:number;
    exportDate: Timestamp;
    address: string;
    done:boolean;

}