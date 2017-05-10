import {BaseModel} from "../base-model";


export class CustomerBriefModel extends BaseModel {
    name?: string;
    description?: string;
    ordersCount?: number;
}