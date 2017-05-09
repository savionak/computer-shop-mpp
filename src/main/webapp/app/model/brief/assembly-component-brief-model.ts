import {BaseModel} from "../base-model";


export class AssemblyComponentBriefModel extends BaseModel {
    typeId: string;
    typeName: string;
    modelId: string;
    modelName: string;
    price: number;
    count: number;
}