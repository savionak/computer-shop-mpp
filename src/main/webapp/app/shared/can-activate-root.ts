import {CanActivate, Router} from "@angular/router";
import {HttpOAuthService} from "./http-oauth.service";
import {Injectable} from "@angular/core";

@Injectable()
export class CanActivateRoot implements CanActivate {
    constructor(private router: Router, private authService: HttpOAuthService) {

    }

    canActivate() {
        let defaultRoute = this.authService.getUserRoutes()['default'];
        this.router.navigate([defaultRoute]);
        return true;
    }

}
