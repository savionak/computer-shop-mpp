import {Component, ViewChild} from "@angular/core";

import {CustomerService} from "../../service/customer.service";
import {CustomerListComponent} from "./customer-list.component";
import {CustomerRemovedListComponent} from "./customer-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'customer-page',
    templateUrl: './customer-page.html'
})
export class CustomerPage extends BasePage {
    private service: CustomerService;

    @ViewChild(CustomerListComponent) list: CustomerListComponent;
    @ViewChild(CustomerRemovedListComponent) removedList: CustomerRemovedListComponent;

    constructor(service: CustomerService, route: ActivatedRoute) {
        super(route);
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }
}
