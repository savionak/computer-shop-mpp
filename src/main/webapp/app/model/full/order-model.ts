import {BaseModel} from "../base-model";
import {CustomerBriefModel} from "../brief/customer-brief-model";


export class OrderModel extends BaseModel {
    customer: CustomerBriefModel;
    cost: number;
    orderDate: number;
    status: Status;
    canceled: boolean;

    public static empty(): OrderModel {
        return {
            id: null,
            customer: {id: null},
            cost: null,
            orderDate: null,
            status: Status.IN_PROGRESS,
            canceled: false
        }
    }
}

export const enum Status{
    IN_PROGRESS,
    READY
}