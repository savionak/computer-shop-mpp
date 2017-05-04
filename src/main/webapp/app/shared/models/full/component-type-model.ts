import {BaseModel} from "../../base-model";

export class ComponentTypeModel extends BaseModel {
    name: string;
    description: string;
    removed: boolean;

    public static empty(): ComponentTypeModel {
        return {id: null, name: "", description: null, removed: false}
    }
}