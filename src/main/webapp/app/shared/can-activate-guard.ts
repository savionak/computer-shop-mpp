import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot} from "@angular/router";
import {HttpOAuthService} from "./http-oauth.service";
import {LOGIN} from "./route-consts";


@Injectable()
export class CanActivateViaOAuthGuard implements CanActivate, CanActivateChild {
    constructor(private router: Router, private authService: HttpOAuthService) {

    }

    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        return true;
    }

    canActivate() {
        if (!this.authService.getCurrentUser()) {
            this.router.navigate([LOGIN]);
        }
        return true;
    }
}
