import {BaseModel} from "../base-model";
import {Timestamp} from "rxjs/Rx";
import {ExportBriefModel} from "../brief/export-brief-model";
import {CustomerBriefModel} from "../brief/customer-brief-model";

export class OrderModel extends BaseModel {
    customer: CustomerBriefModel;
    cost:number;
    orderDate: Timestamp;
    status:Status;
    export:ExportBriefModel;

    public static empty(): OrderModel {
        return {id: null, customer: null, cost: null, orderDate:null, status: null, export:null}
    }
}
const enum Status{
    IN_PROGRESS,
    READY,
    FINISHED
}