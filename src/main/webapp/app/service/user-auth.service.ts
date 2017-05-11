import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {UserAuthModel} from "../model/full/user-auth-model";
import {UserBriefModel} from "../model/brief/user-brief-model";
import {SoftDeleteService} from "./base/soft-delete.service";
import {Observable} from "rxjs/Observable";
import {ResponseHandler} from "../shared/response-handler";
import {UpdateUserPass} from "../model/helper/update-user-pass";


@Injectable()
export class UserAuthService extends SoftDeleteService<UserAuthModel, UserBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/user');
    }

    drop(id: number): Observable<null> {
        return this.http.delete(this.apiUrl + '/drop/' + id)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    updatePass(upd: UpdateUserPass): Observable<null> {
        return this.http.post(this.apiUrl + '/update/password', upd)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }
}
