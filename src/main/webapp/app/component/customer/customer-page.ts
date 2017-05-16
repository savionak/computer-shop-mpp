import {Component, ViewChild} from "@angular/core";

import {CustomerService} from "../../service/customer.service";
import {CustomerListComponent} from "./customer-list.component";
import {CustomerRemovedListComponent} from "./customer-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'customer-page',
    templateUrl: './customer-page.html'
})
export class CustomerPage extends BasePage {
    private service: CustomerService;

    @ViewChild(CustomerListComponent) list: CustomerListComponent;
    @ViewChild(CustomerRemovedListComponent) removedList: CustomerRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: CustomerService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    onAddDone() {
        this.popSuccess('Заказчик добавлен');
    }

    onSaveDone() {
        this.popSuccess('Заказчик обновлен');
    }

    onDeleteDone() {
        this.popSuccess('Заказчик удален');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Заказчик восстановлен');
        this.list.onRefresh();
    }
}
