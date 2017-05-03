import {BaseModel} from "../shared/base-model";

export class ComponentTypeBriefModel extends BaseModel {
    name: string;
    description: string;

    public static empty(): ComponentTypeBriefModel {
        return {id: null, name: null, description: null}
    }
}