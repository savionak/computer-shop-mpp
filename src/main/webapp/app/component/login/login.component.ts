import {Component} from "@angular/core";
import {LoginModel} from "./login-model";
import {LoginService} from "../../service/login.service";


@Component({
    selector: 'login',
    templateUrl: './login.html',
    providers: [    // local provider -- created for each component
        LoginService
    ]
})
export class LoginComponent {

    loginUser = new LoginModel();
    error: string;

    constructor(private loginService: LoginService) {

    }

    onSubmit(event: Event, email: string, pass: string) {
        event.preventDefault();
        this.loginService.login(email, pass)
            .subscribe(
                (res) => {/* TODO: say OK and place UserModel in localStorage*/},
                (err) => {/* TODO: show Error */}
            );
    }
}
