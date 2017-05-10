import {Component, ViewChild} from "@angular/core";

import {CustomerService} from "../../service/customer.service";
import {CustomerListComponent} from "./customer-list.component";
import {CustomerRemovedListComponent} from "./customer-removed-list.component";


@Component({
    selector: 'customer-page',
    templateUrl: './customer-page.html'
})
export class CustomerPage {
    private service: CustomerService;
    protected error: string;

    @ViewChild(CustomerListComponent) list: CustomerListComponent;
    @ViewChild(CustomerRemovedListComponent) removedList: CustomerRemovedListComponent;

    constructor(service: CustomerService) {
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
