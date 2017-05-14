import {Component, ViewChild} from "@angular/core";

import {UserAuthService} from "../../service/user-auth.service";
import {UserListComponent} from "./user-list.component";
import {UserRemovedListComponent} from "./user-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'user-page',
    templateUrl: './user-page.html'
})
export class UserPage extends BasePage {
    private service: UserAuthService;

    @ViewChild(UserListComponent) list: UserListComponent;
    @ViewChild(UserRemovedListComponent) removedList: UserRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: UserAuthService, route: ActivatedRoute) {
        super(authService, r, route);
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }
}
