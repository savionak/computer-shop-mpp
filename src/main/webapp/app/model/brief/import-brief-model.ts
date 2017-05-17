import {BaseModel} from "../base-model";


export class ImportBriefModel extends BaseModel {
    importDate?: any;
    typeid?: string;
    typeName?: string;
    modelId?: string;
    modelName?: string;
    purchasePrice?: number;
    count?: number;
    providerName?: string;
}