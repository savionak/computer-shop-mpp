import {BaseModel} from "../base-model";
import {Timestamp} from "rxjs/Rx";
import {CustomerBriefModel} from "./customer-brief-model";

export class OrderBriefModel extends BaseModel {
    customer :CustomerBriefModel;
    cost:number;
    orderDate:Timestamp;
    status: Status;

}
const enum Status{
    IN_PROGRESS,
    READY,
    FINISHED
}