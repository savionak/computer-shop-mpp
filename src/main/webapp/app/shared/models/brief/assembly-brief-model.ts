import {BaseModel} from "../../base-model";
import Order = jasmine.Order;

export class AssemblyBriefModel extends BaseModel {
    orderId: number;
    cost: number;
    count: number;

}