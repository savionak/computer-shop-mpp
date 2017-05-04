import {Injectable} from "@angular/core";


import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ProviderModel} from "../model/full/provider-model";
import {ProviderBriefModel} from "../model/brief/provider-brief-model";
import {CustomerModel} from "../model/full/customer-model";
import {CustomerBriefModel} from "../model/brief/customer-brief-model";
import {UserAuthModel} from "../model/full/user-auth-model";
import {UserBriefModel} from "../model/brief/user-brief-model";


@Injectable()
export class UserAuthService extends CrudService<UserAuthModel, UserBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/user');
    }

}
