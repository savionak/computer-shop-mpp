import {BaseModel} from "../base-model";
import {OrderBriefModel} from "../brief/order-brief-model";


export class ExportModel extends BaseModel {
    order: OrderBriefModel;
    exportDate: number;
    address: string;
    done: boolean;

    public static empty(): ExportModel {
        return {id: null, order: {id: null}, exportDate: (new Date().getTime()), address: null, done: false}
    }
}