import {BaseModel} from "../../base-model";
import {OrderBriefModel} from "../brief/order-brief-model";
import {Timestamp} from "rxjs/Rx";

export class ExportModel extends BaseModel {
    order: OrderBriefModel;
    exportDate: Timestamp;
    address:string;
    done: boolean

    public static empty(): ExportModel {
        return {id: null, order: null, exportDate: null, address:null, done: false}
    }
}