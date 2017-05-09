import {Injectable} from "@angular/core";
import {CanActivate, Router} from "@angular/router";

@Injectable()
export class CanActivateViaOAuthGuard implements CanActivate {

    constructor(public router: Router) {

    }

    canActivate() {
        if (localStorage.getItem('currentUser') === null) {
            this.router.navigateByUrl('/login');
            // TODO: return here after redirect
        }
        // TODO: call abstract method to check user
        return (localStorage.getItem('currentUser') !== null);
    }
}
