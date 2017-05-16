import {Component} from "@angular/core";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Router} from "@angular/router";
import {Util} from "../../shared/utils";
import {LOGIN} from "../../shared/route-consts";


@Component({
    selector: 'header',
    templateUrl: './header.html'
})
export class HeaderComponent {

    constructor(private authService: HttpOAuthService, private router: Router) {

    }

    private getUserRole() {
        return this.authService.getCurrentUser().user.role;
    }

    private getNavItems(): any[] {
        let routes = this.authService.getUserRoutes();
        return routes['items'];
    }

    private getActive(item: any): string {
        let itemPath = '/' + item['path'] + '/' + item['access'];
        return (this.router.url.startsWith(itemPath)) ? "active" : "";
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
                        this.router.navigate([LOGIN]);
                    },
                    (err) => {
                        // TODO: show popup
                        alert(err);
                        localStorage.removeItem(Util.STORAGE_KEY);
                        this.router.navigate([LOGIN]);
                    }
                );
    }
}
