import {Injectable} from "@angular/core";

import {LoginModel} from "../component/login/login-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {Observable} from "rxjs/Rx";


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
