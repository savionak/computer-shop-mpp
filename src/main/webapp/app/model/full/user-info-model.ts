import {BaseModel} from "../base-model";


export class UserInfoModel extends BaseModel {
    firstName: string;
    lastName: string;
    patronymic: string;
    phone: string;

    public static empty(): UserInfoModel {
        return {id: null, firstName: "", lastName: null, patronymic: null, phone: null}
    }
}