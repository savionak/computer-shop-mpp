import {Injectable} from "@angular/core";
import {CanActivate, Router} from "@angular/router";


@Injectable()
export class CanActivateViaOAuthGuard implements CanActivate {

    constructor(public router: Router) {

    }

    canActivate() {
        if (!localStorage.getItem('currentUser')) {
            this.router.navigateByUrl('/login');
            // TODO: pass abstract method to redirect-back: check role and show appropriate page
        }
        return (localStorage.getItem('currentUser') !== null);
    }
}
