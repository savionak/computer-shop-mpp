import {Component, ViewChild} from "@angular/core";
import {ComponentStoreService} from "../../service/component-store.service";
import {ComponentStoreListComponent} from "./comp-store-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'store-page',
    templateUrl: './comp-store-page.html'
})
export class ComponentStorePage extends BasePage {
    private service: ComponentStoreService;

    @ViewChild(ComponentStoreListComponent) list: ComponentStoreListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ComponentStoreService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    getOperationErrorMessage() {
        return this.COMPONENTS_ERROR_MSG;
    }

    onUpdateDone() {
        this.popSuccess('Склад обновлен');
        this.list.onRefresh();
    }
}
