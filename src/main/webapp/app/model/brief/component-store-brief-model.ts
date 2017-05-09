import {BaseModel} from "../base-model";


export class ComponentStoreBriefModel extends BaseModel {
    typeId: string;
    typeName: string;
    modelId: string;
    modelName: string;
    price: number;
    count: number;
}