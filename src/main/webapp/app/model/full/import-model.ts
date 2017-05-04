import {BaseModel} from "../base-model";
import {Timestamp} from "rxjs/Rx";
import {ProviderBriefModel} from "../brief/provider-brief-model";
import {ComponentModelBriefModel} from "../brief/component-model-brief-model";

export class ImportModel extends BaseModel {
    provider: ProviderBriefModel;
    model:ComponentModelBriefModel;
    importDate: Timestamp;
    count:number;
    purchasePrice:number;
    price:number;
    storedCount:number;

    public static empty(): ImportModel {
        return {id: null, provider: null, model: null, importDate:null, count: null, purchasePrice:null, price:null, storedCount:null}
    }
}