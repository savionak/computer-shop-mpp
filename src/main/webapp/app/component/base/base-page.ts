import {OnDestroy, OnInit} from "@angular/core";

import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {ACCESS, EDIT, VIEW} from "../../shared/route-consts";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

export class BasePage implements OnInit, OnDestroy {
    private router: Router;
    protected route: ActivatedRoute;
    protected isReadOnly: boolean;
    private sub: Subscription;
    private routerSub: Subscription;

    constructor(private authService: HttpOAuthService, r: Router, route: ActivatedRoute,
                protected toasterService: ToasterService) {
        this.route = route;
        this.router = r;
    }

    ngOnInit(): void {
        this.routerSub = this.route.url.subscribe(
            u => {
                let current = u[0].toString();
                let routes = this.authService.getUserRoutes()['items'];
                let exists = false;
                let i = 0;
                while (!exists && i < routes.length) {
                    if (routes[i]['path'] == current) {
                        exists = true;
                    }
                    ++i;
                }
                if (exists) {
                    --i;
                    if ((routes[i]['access'] != EDIT) && (u[1].toString() == EDIT)) {
                        this.router.navigate(['404'], {skipLocationChange: true});
                    }
                } else {
                    this.router.navigate(['404'], {skipLocationChange: true});
                }
            },
            error => this.popNavigationError()
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
                        this.router.navigate(['404'], {skipLocationChange: true});
                }
            },
            error => this.popNavigationError()
        );
    }

    ngOnDestroy(): void {
        if (this.sub) {
            this.sub.unsubscribe();
        }
        if (this.routerSub) {
            this.routerSub.unsubscribe();
        }
    }

    onError(error: any) {
        console.log(error);
        let errNum = error['errorNumber'];
        if (errNum) {
            if ((errNum == "OPERATION_ERROR") || (errNum == "CONSTRAINTS_ERROR")) {
                this.popDataError();
            } else {
                this.popServerError();
            }
        } else {
            let fields = error['errors'];
            if (fields) {
                for (let i in fields) {
                    let text = `${fields[i].field} ${fields[i].message}`;
                    this.popError(text);
                }
            } else {
                this.popError();
            }
        }
    }

    popError(text?: string) {
        this.toasterService.pop('error', 'Ошибка', text);
    }

    popServerError() {
        this.toasterService.pop('error', 'Ошибка сервера', 'Свяжитесь с администаратором');
    }

    popDataError() {
        this.toasterService.pop('error', 'Неверные данные', 'Проверьте корректность данных');
    }

    popConnectionError() {
        this.toasterService.pop('error', 'Ошибка подключения');
    }

    popNavigationError() {
        this.toasterService.pop('error', 'Oops...', 'Что-то пошло не так');
    }
}
