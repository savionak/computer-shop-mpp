import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {Observable} from "rxjs/Rx";
import {LoginModel} from "../component/login/login-model";


@Injectable()
export class LoginService {

    // constructor(http: HttpOAuthService) {
    //     (http, '/api/');//?????
    // }

    LogIn(): Observable<LoginModel>{
        //Some code
        return ;
    }
}
