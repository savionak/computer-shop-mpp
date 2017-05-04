import {BaseModel} from "../../base-model";
import {UserInfoModel} from "./user-info-model";

export class UserAuthModel extends BaseModel {
    email: string;
    path: string;
    role: Role;
    blocked:boolean;
    removed:boolean;
    userInfo: UserInfoModel;

    public static empty(): UserAuthModel {
        return {id: null, email: "", path: null, role: null, blocked:false,removed:false,userInfo:null}
    }
}
const enum Role{
    MANAGER,
    DIRECTOR,
    ADMIN
}