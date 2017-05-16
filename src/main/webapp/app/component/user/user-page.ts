import {Component, ViewChild} from "@angular/core";

import {UserAuthService} from "../../service/user-auth.service";
import {UserListComponent} from "./user-list.component";
import {UserRemovedListComponent} from "./user-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'user-page',
    templateUrl: './user-page.html'
})
export class UserPage extends BasePage {
    private service: UserAuthService;

    @ViewChild(UserListComponent) list: UserListComponent;
    @ViewChild(UserRemovedListComponent) removedList: UserRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: UserAuthService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    getOperationErrorMessage() {
        return 'Запрещено оставлять систему без Администратора';
    }

    onAddDone() {
        this.popSuccess('Пользователь добавлен');
    }

    onSaveDone() {
        this.popSuccess('Пользователь обновлен');
    }

    onChangePassDone() {
        this.popSuccess('Пароль успешно изменен');
    }

    onDeleteDone() {
        this.popSuccess('Пользователь заблокирован');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Пользователь восстановлен');
        this.list.onRefresh();
    }

    onDropDone(id: number) {
        this.popSuccess('Пользователь удален из системы');
    }
}
