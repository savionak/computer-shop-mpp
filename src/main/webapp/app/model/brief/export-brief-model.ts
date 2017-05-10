import {BaseModel} from "../base-model";


export class ExportBriefModel extends BaseModel {
    orderId?: number;
    customerId?: number;
    customerName?: string;
    orderCost?: number;
    exportDate?: number;
    address?: string;
    done?: boolean;
}