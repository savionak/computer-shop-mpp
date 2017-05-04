import {BaseModel} from "../../base-model";
import {ComponentTypeBriefModel} from "../brief/component-type-brief-model";

export class ComponentModelModel extends BaseModel {
    type:ComponentTypeBriefModel;
    name: string;
    description: string;
    removed: boolean;

    public static empty(): ComponentModelModel {
        return {id: null, type:null, name: "", description: null, removed: false}
    }
}