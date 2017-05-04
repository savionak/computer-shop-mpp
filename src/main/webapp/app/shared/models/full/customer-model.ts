import {BaseModel} from "../base-model";

export class CustomerModel extends BaseModel {
    name: string;
    description: string;
    removed: boolean;
    ordersCount:number;

    public static empty(): CustomerModel {
        return {id: null, name: "", description: null, removed: false,ordersCount:null}
    }
}