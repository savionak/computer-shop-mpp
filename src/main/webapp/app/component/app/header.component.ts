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

    private getNavItems(): any[] {
        let result: any[] = [
            {'link': "provider/view", 'text': "View Providers"},
            {'link': "provider/edit", 'text': "Edit Providers"},

            {'link': "type/view", 'text': "View ComponentTypes"},
            {'link': "type/edit", 'text': "Edit ComponentTypes"},

            {'link': "model/view", 'text': "View ComponentModels"},
            {'link': "model/edit", 'text': "Edit ComponentModels"},

            {'link': "store/view", 'text': "View Store"},
            {'link': "store/edit", 'text': "Edit Store"},

            {'link': "customer/view", 'text': "View Customers"},
            {'link': "customer/edit", 'text': "Edit Customers"},

            {'link': "user/view", 'text': "View Users"},
            {'link': "user/edit", 'text': "Edit Users"},

            {'link': "import/view", 'text': "View Imports"},
            {'link': "import/edit", 'text': "Edit Imports"},

            {'link': "order/view", 'text': "View Order"},
            {'link': "order/edit", 'text': "Edit Order"}
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
