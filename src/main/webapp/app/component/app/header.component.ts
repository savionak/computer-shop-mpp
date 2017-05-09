import {Component} from "@angular/core";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Router} from "@angular/router";

@Component({
    selector: 'header',
    templateUrl: './header.html'
})
export class HeaderComponent {

    constructor(private authService: HttpOAuthService, private router: Router) {

    }

    onLogout() {
        this.authService.logout()
            .subscribe(
                (res) => { this.router.navigateByUrl("/login"); },
                (err) => { /* show error popup */ }
            );
    }
}
