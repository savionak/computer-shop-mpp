import {BaseModel} from "../shared/base-model";

export class ProviderModel extends BaseModel {
    name: string;
    description: string;

    public static empty(): ProviderModel {
        return {id: null, name: null, description: null}
    }
}