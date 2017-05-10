import {BaseModel} from "../base-model";
import {ComponentModelBriefModel} from "../brief/component-model-brief-model";


export class ComponentStoreModel extends BaseModel {
    model: ComponentModelBriefModel;
    price: number;
    count: number;

    public static empty(): ComponentStoreModel {
        return {id: null, model: {id: null}, price: null, count: null}
    }
}