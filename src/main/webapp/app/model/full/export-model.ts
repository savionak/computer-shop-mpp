import {BaseModel} from "../base-model";
import {OrderBriefModel} from "../brief/order-brief-model";
import {Timestamp} from "rxjs/Rx";
import DateTimeFormat = Intl.DateTimeFormat;

export class ExportModel extends BaseModel {
    order: OrderBriefModel;
    exportDate: number;
    address:string;
    done: boolean

    public static empty(): ExportModel {
        return {id: null, order: null, exportDate: (new Date().getTime()), address:null, done: false}
    }
}