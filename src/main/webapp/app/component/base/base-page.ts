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
    private pageAccess: string;

    private readonly viewAccess: string = VIEW;
    private readonly editAccess: string = EDIT;

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
                this.pageAccess = x[ACCESS];
                switch (this.pageAccess) {
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
            if (errNum == "OPERATION_ERROR") {
                this.popError(this.getOperationErrorMessage());
            } else if (errNum == "CONSTRAINTS_ERROR") {
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

    protected getOperationErrorMessage(): string {
        return this.DATA_ERROR_MSG;
    }

    popSuccess(text: string) {
        this.toasterService.pop('success', text);
    }

    popWarning(text: string) {
        this.toasterService.pop('warning', text);
    }

    popError(text?: string) {
        this.toasterService.pop('error', this.ERROR_TITLE, text);
    }

    popServerError() {
        this.toasterService.pop('error', this.SERVER_ERROR_TITLE, this.CONTACT_ADMIN);
    }

    popDataError() {
        this.toasterService.pop('error', this.INVALID_DATA_TITLE, this.DATA_ERROR_MSG);
    }

    popConnectionError() {
        this.toasterService.pop('error', this.CONNECTION_ERROR_TITLE);
    }

    popNavigationError() {
        this.toasterService.pop('error', this.NAVIGATION_ERROR_TITLE, this.NAVIGATION_ERROR_MSG);
    }

    protected ERROR_TITLE = 'Ошибка';

    protected INVALID_DATA_TITLE = 'Неверные данные';
    protected readonly DATA_ERROR_MSG = 'Проверьте корректность данных';

    protected SERVER_ERROR_TITLE = 'Ошибка сервера';
    protected readonly CONTACT_ADMIN = 'Свяжитесь с администаратором';

    protected CONNECTION_ERROR_TITLE = 'Ошибка подключения';

    protected NAVIGATION_ERROR_TITLE = 'Oops...';
    protected NAVIGATION_ERROR_MSG = 'Что-то пошло не так';

    protected COMPONENTS_ERROR_MSG = 'Недостаточно компонентов для проведения операции';
}
