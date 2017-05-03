import {BaseModel} from "../shared/base-model";

export class ComponentTypeModel extends BaseModel {
    name: string;
    description: string;

    public static empty(): ComponentTypeModel {
        return {id: null, name: null, description: null}
    }
}