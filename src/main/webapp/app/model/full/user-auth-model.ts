import {BaseModel} from "../base-model";
import {UserInfoModel} from "./user-info-model";


export class UserAuthModel extends BaseModel {
    email: string;
    pass: string;
    role: Role;
    blocked: boolean;
    removed?: boolean;
    userInfo: UserInfoModel;

    public static empty(): UserAuthModel {
        return {
            id: null,
            email: "",
            pass: null,
            role: Role.MANAGER,
            blocked: false,
            removed: false,
            userInfo: UserInfoModel.empty()
        }
    }
}

export const enum Role{
    MANAGER = 0,
    DIRECTOR = 1,
    ADMIN = 2
}