import {BaseModel} from "../../base-model";
import {Timestamp} from "rxjs/Rx";
import {CustomerBriefModel} from "./customer-brief-model";


export class UserBriefModel extends BaseModel {
    email:string;
    role:Role;
    firstName:string;
    lastName:string;
    blocked:boolean;
    removed:boolean;

}
const enum Role{
    MANAGER,
    DIRECTOR,
    ADMIN
}