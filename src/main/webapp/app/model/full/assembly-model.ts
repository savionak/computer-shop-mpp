import {BaseModel} from "../base-model";
import {OrderBriefModel} from "../brief/order-brief-model";


export class AssemblyModel extends BaseModel {
    order: OrderBriefModel;
    cost: number;
    count: number;

    public static empty(): AssemblyModel {
        return {id: null, order: {id: null}, cost: null, count: 0}
    }
}