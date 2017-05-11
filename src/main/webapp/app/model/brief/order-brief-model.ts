import {BaseModel} from "../base-model";
import {CustomerBriefModel} from "./customer-brief-model";
import {Status} from "../full/order-model";


export class OrderBriefModel extends BaseModel {
    customer?: CustomerBriefModel;
    cost?: number;
    orderDate?: number;
    status?: Status;
    canceled?: boolean;
}