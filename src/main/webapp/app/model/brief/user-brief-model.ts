import {BaseModel} from "../base-model";


export class UserBriefModel extends BaseModel {
    email: string;
    role: Role;
    firstName: string;
    lastName: string;
    blocked: boolean;
    removed: boolean;

}
const enum Role{
    MANAGER,
    DIRECTOR,
    ADMIN
}