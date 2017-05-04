import {BaseModel} from "../base-model";

export class ProviderModel extends BaseModel {
    name: string;
    description: string;
    removed: boolean

    public static empty(): ProviderModel {
        return {id: null, name: "", description: null, removed: false}
    }
}