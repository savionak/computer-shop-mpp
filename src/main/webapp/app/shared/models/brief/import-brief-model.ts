import {BaseModel} from "../../base-model";
import {Timestamp} from "rxjs/Rx";

export class ImportBriefModel extends BaseModel {
    importDate :Timestamp;
    typeid:string;
    typeName:string;
    modelId:string;
    modelName: string;
    purchasePrice: number;
    count:number;
    providerName:string;

}