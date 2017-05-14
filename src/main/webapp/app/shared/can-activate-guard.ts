import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot} from "@angular/router";
import {HttpOAuthService} from "./http-oauth.service";


@Injectable()
export class CanActivateViaOAuthGuard implements CanActivate, CanActivateChild {
    constructor(public router: Router, private authService: HttpOAuthService) {

    }

    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        alert(childRoute.url.toString());
        return true;
    }

    canActivate() {
        if (!this.authService.getCurrentUser()) {
            this.router.navigateByUrl('/login');
        }
        return true;
    }
}
