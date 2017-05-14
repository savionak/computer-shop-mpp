import {Component} from "@angular/core";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Router} from "@angular/router";
import {Util} from "../../shared/utils";
import {CUSTOMER, EDIT, IMPORT, MODEL, ORDER, PROVIDER, STORE, TYPE, USER, VIEW} from "../../shared/route-consts";

@Component({
    selector: 'header',
    templateUrl: './header.html'
})
export class HeaderComponent {

    constructor(private authService: HttpOAuthService, private router: Router) {

    }

    private getNavItems(): any[] {
        let result: any[] = [
            {'link': PROVIDER + "/" + VIEW, 'text': "View Providers"},
            {'link': PROVIDER + "/" + EDIT, 'text': "Edit Providers"},

            {'link': TYPE + "/" + VIEW, 'text': "View ComponentTypes"},
            {'link': TYPE + "/" + EDIT, 'text': "Edit ComponentTypes"},

            {'link': MODEL + "/" + VIEW, 'text': "View ComponentModels"},
            {'link': MODEL + "/" + EDIT, 'text': "Edit ComponentModels"},

            {'link': STORE + "/" + VIEW, 'text': "View Store"},
            {'link': STORE + "/" + EDIT, 'text': "Edit Store"},

            {'link': CUSTOMER + "/" + VIEW, 'text': "View Customers"},
            {'link': CUSTOMER + "/" + EDIT, 'text': "Edit Customers"},

            {'link': USER + "/" + VIEW, 'text': "View Users"},
            {'link': USER + "/" + EDIT, 'text': "Edit Users"},

            {'link': IMPORT + "/" + VIEW, 'text': "View Imports"},
            {'link': IMPORT + "/" + EDIT, 'text': "Edit Imports"},

            {'link': ORDER + "/" + VIEW, 'text': "View Order"},
            {'link': ORDER + "/" + EDIT, 'text': "Edit Order"}
        ];
        return result;
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
