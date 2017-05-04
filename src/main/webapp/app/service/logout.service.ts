import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {Observable} from "rxjs/Rx";
import {LoginModel} from "../component/login/login-model";


@Injectable()
export class LogoutService {


    // i don't know

    constructor(http: HttpOAuthService) {
        (http, '/oauth/revoke_token');
    }


}
