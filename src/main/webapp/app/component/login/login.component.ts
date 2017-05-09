import {Component} from "@angular/core";
import {CredentialsModel} from "./login-model";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'login',
    templateUrl: './login.html'
})
export class LoginComponent {

    private credentials = new CredentialsModel();
    private error: string;

    constructor(private authService: HttpOAuthService) {

    }

    onSubmit(event: Event) {
        event.preventDefault();
        this.authService.login(this.credentials)
            .subscribe(
                (res) => {
                    alert("Success!");
                    console.log("Success!\nUser is:\n", res);
                    this.authService.setCurrentUser(res);
                },
                (err) => {
                    // TODO: show popup
                    this.error = err;
                    alert(err);
                }
            );
    }

    onCloseError() {
        this.error = null;
    }
}
