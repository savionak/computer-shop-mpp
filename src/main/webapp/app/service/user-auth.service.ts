import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./base/crud.service";
import {UserAuthModel} from "../model/full/user-auth-model";
import {UserBriefModel} from "../model/brief/user-brief-model";
import {SoftDeleteService} from "./base/soft-delete.service";


@Injectable()
export class UserAuthService extends SoftDeleteService<UserAuthModel, UserBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/user');
    }
}
