import {BaseModel} from "../base-model";
import {ProviderBriefModel} from "../brief/provider-brief-model";
import {ComponentModelBriefModel} from "../brief/component-model-brief-model";


export class ImportModel extends BaseModel {
    provider: ProviderBriefModel;
    model: ComponentModelBriefModel;
    importDate: number;
    count: number;
    purchasePrice: number;
    price: number;
    storedCount: number;

    public static empty(): ImportModel {
        return {
            id: null,
            provider: {id: null},
            model: {id: null},
            importDate: null,
            count: null,
            purchasePrice: null,
            price: null,
            storedCount: null
        }
    }
}