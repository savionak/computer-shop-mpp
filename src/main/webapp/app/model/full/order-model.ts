import {BaseModel} from "../base-model";
import {ExportBriefModel} from "../brief/export-brief-model";
import {CustomerBriefModel} from "../brief/customer-brief-model";


export class OrderModel extends BaseModel {
    customer: CustomerBriefModel;
    cost: number;
    orderDate: number;
    status: Status;
    export: ExportBriefModel;
    canceled: boolean;

    public static empty(): OrderModel {
        return {
            id: null,
            customer: null,
            cost: null,
            orderDate: null,
            status: Status.IN_PROGRESS,
            export: null,
            canceled: false
        }
    }
}
const enum Status{
    IN_PROGRESS,
    READY,
    FINISHED
}