import {BaseModel} from "../base-model";


export class ImportBriefModel extends BaseModel {
    importDate: number;
    typeid: string;
    typeName: string;
    modelId: string;
    modelName: string;
    purchasePrice: number;
    count: number;
    providerName: string;
}