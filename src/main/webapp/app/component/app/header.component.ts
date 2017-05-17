import {Component} from "@angular/core";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Router} from "@angular/router";
import {Util} from "../../shared/utils";
import {LOGIN} from "../../shared/route-consts";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'header',
    templateUrl: './header.html'
})
export class HeaderComponent {
    private showPopup: boolean;

    constructor(private authService: HttpOAuthService, private router: Router, private toasterService: ToasterService) {

    }

    private isActive(item: any): boolean {
        let itemPath = '/' + item['path'] + '/' + item['access'];
        return this.router.url.startsWith(itemPath);
    }

    private getUser() {
        return this.authService.getCurrentUser().user;
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
        this.showPopup = true;
    }

    onOk() {
        this.authService.logout()
            .subscribe(
                (res) => {
                    this.endLogout();
                },
                (err) => {
                    this.toasterService.pop('error', 'Ошибка при выходе из системы');
                    this.endLogout();
                }
            );
    }

    closePopup() {
        this.showPopup = false;
    }

    endLogout() {
        localStorage.removeItem(Util.STORAGE_KEY);
        this.router.navigate([LOGIN]);
        this.closePopup();
    }
}
