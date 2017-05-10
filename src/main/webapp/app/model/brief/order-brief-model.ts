import {BaseModel} from "../base-model";
import {CustomerBriefModel} from "./customer-brief-model";


export class OrderBriefModel extends BaseModel {
    customer: CustomerBriefModel;
    cost: number;
    orderDate: number;
    status: Status;
    canceled: boolean;
}
const enum Status{
    IN_PROGRESS,
    READY,
    FINISHED
}