import {Component, ViewChild} from "@angular/core";

import {UserAuthService} from "../../service/user-auth.service";
import {UserListComponent} from "./user-list.component";
import {UserRemovedListComponent} from "./user-removed-list.component";


@Component({
    selector: 'user-page',
    templateUrl: './user-page.html'
})
export class UserPage {
    private service: UserAuthService;
    protected error: string;

    @ViewChild(UserListComponent) list: UserListComponent;
    @ViewChild(UserRemovedListComponent) removedList: UserRemovedListComponent;

    constructor(service: UserAuthService) {
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
