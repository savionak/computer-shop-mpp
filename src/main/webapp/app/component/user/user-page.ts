import {Component, ViewChild} from "@angular/core";

import {UserAuthService} from "../../service/user-auth.service";
import {UserListComponent} from "./user-list.component";
import {UserRemovedListComponent} from "./user-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {DocumentService, DocumentType} from "../../shared/document.service";

@Component({
    selector: 'user-page',
    templateUrl: './user-page.html'
})
export class UserPage extends BasePage {
    private service: UserAuthService;

    @ViewChild(UserListComponent) list: UserListComponent;
    @ViewChild(UserRemovedListComponent) removedList: UserRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: UserAuthService, route: ActivatedRoute,
                toasterService: ToasterService,
                private documentService: DocumentService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    getOperationErrorMessage() {
        return 'Forbidden: cannot leave system without Admin';
    }

    onAddDone() {
        this.popSuccess('User added');
    }

    onSaveDone() {
        this.popSuccess('User updated');
    }

    onChangePassDone() {
        this.popSuccess('Пароль successfully changed');
    }

    onDeleteDone() {
        this.popWarning('User blocked');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('User restored');
        this.list.onRefresh();
    }

    onDropDone(id: number) {
        this.popSuccess('User deleted from system');
    }

    onGetAllPage(documentType: DocumentType) {
        // alert("here");
        this.documentService.getUserState(documentType);
    }
}
