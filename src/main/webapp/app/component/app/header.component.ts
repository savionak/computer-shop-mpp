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

    private isLoggedIn(): boolean {
        return !!this.authService.getCurrentUser();
    }

    onLogout() {
        this.authService.logout()
            .subscribe(
                (res) => {
                    localStorage.removeItem('currentUser');
                    this.router.navigateByUrl("/login");
                },
                (err) => {
                    // TODO: show popup
                    alert(err);
                }
            );
    }
}
