import {BaseModel} from "../base-model";
import {CustomerBriefModel} from "../brief/customer-brief-model";


export class OrderModel extends BaseModel {
    customer: CustomerBriefModel;
    cost: number;
    orderDate: number;
    status: Status;
    canceled: boolean;
    exportAddress: Status;

    public static empty(): OrderModel {
        return {
            id: null,
            customer: {id: null},
            cost: null,
            orderDate: null,
            status: Status.IN_PROGRESS,
            canceled: false,
            exportAddress: null
        }
    }
}

export const enum Status{
    IN_PROGRESS,
    READY
}

export const StatusNames: string[] = ["В процессе", "Принят"];
