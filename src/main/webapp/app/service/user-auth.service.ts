import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./base/crud.service";
import {UserAuthModel} from "../model/full/user-auth-model";
import {UserBriefModel} from "../model/brief/user-brief-model";


@Injectable()
export class UserAuthService extends CrudService<UserAuthModel, UserBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/user');
    }
}
