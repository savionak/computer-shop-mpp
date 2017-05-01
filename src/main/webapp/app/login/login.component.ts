import {Component} from '@angular/core';
import {LoginModel} from "./login-model";
import {LoginService} from "./login.service";

@Component({
    selector: 'login',
    templateUrl: './login.html',
    providers: [    // local provider -- created for each component
        LoginService
    ]
})
export class LoginComponent  {

    loginUser = new LoginModel();
    error:string;

    constructor(private loginService:LoginService) {

    }
    onLogIn() {
        this.error = null;
    }
}
