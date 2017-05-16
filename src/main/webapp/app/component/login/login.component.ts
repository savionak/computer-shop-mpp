import {Component} from "@angular/core";
import {CredentialsModel} from "./login-model";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Router} from "@angular/router";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'login',
    templateUrl: './login.html'
})
export class LoginComponent {

    private credentials = new CredentialsModel();

    constructor(private authService: HttpOAuthService, private router: Router, private toasterService: ToasterService) {

    }

    onSubmit(event: Event) {
        event.preventDefault();
        this.authService.login(this.credentials)
            .subscribe(
                (res) => {
                    console.log("Success!\nUser is:\n", res);
                    this.authService.setCurrentUser(res);
                    let next = this.authService.getUserRoutes()['default'];
                    this.router.navigate([next['path'], next['access']]);
                },
                (err) => {
                    this.toasterService.pop('error', 'Ошибка', 'Проверьте введенные данные');
                }
            );
    }
}
