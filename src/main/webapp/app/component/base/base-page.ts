import {OnDestroy, OnInit} from "@angular/core";

import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {ACCESS, EDIT, VIEW} from "../../shared/route-consts";
import {HttpOAuthService} from "../../shared/http-oauth.service";

export class BasePage implements OnInit, OnDestroy {
    protected route: ActivatedRoute;
    protected error: string;
    protected isReadOnly: boolean;
    private sub: Subscription;

    constructor(private authService: HttpOAuthService, route: ActivatedRoute) {
        this.route = route;
    }

    ngOnInit(): void {
        this.route.url.subscribe(
            x => {
                let routes = this.authService.getUserRoutes()['items'];
                let path = x.join('/');
                alert(path);
                let exists = false;
                for (let i in routes) {
                    if (i['path'] == path) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    alert("!!!");
// TODO: navigate to 404
                }
            }
        );
        this.sub = this.route.params.subscribe(
            x => {
                let type = x[ACCESS];
                switch (type) {
                    case VIEW:
                        this.isReadOnly = true;
                        break;
                    case EDIT:
                        this.isReadOnly = false;
                        break;
                    default:
                        alert("404!");
                    // TODO: navigate to 404
                }
            },
            error => this.error = error
        );
    }

    ngOnDestroy(): void {
        if (this.sub) {
            this.sub.unsubscribe();
        }
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
