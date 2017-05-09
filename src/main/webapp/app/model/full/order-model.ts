import {BaseModel} from "../base-model";
import {ExportBriefModel} from "../brief/export-brief-model";
import {CustomerBriefModel} from "../brief/customer-brief-model";


export class OrderModel extends BaseModel {
    customer: CustomerBriefModel;
    cost: number;
    orderDate: number;
    status: Status;
    export: ExportBriefModel;

    public static empty(): OrderModel {
        return {id: null, customer: null, cost: null, orderDate: null, status: Status.IN_PROGRESS, export: null}
    }
}
const enum Status{
    IN_PROGRESS,
    READY,
    FINISHED
}