import {Component} from "@angular/core";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Router} from "@angular/router";
import {Util} from "../../shared/utils";

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
        if (confirm("Are you sure ?"))
            this.authService.logout()
                .subscribe(
                    (res) => {
                        localStorage.removeItem(Util.STORAGE_KEY);
                        this.router.navigateByUrl("/login");
                    },
                    (err) => {
                        // TODO: show popup
                        alert(err);
                        localStorage.removeItem(Util.STORAGE_KEY);
                        this.router.navigateByUrl("/login");
                    }
                );
    }
}
