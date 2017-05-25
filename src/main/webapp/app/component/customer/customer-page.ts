import {Component, ViewChild} from "@angular/core";

import {CustomerService} from "../../service/customer.service";
import {CustomerListComponent} from "./customer-list.component";
import {CustomerRemovedListComponent} from "./customer-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {DocumentService, DocumentType} from "../../shared/document.service";

@Component({
    selector: 'customer-page',
    templateUrl: './customer-page.html'
})
export class CustomerPage extends BasePage {
    private service: CustomerService;

    @ViewChild(CustomerListComponent) list: CustomerListComponent;
    @ViewChild(CustomerRemovedListComponent) removedList: CustomerRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: CustomerService, route: ActivatedRoute,
                toasterService: ToasterService,
                private documentService: DocumentService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }
    getOperationErrorMessage() {
        return this.COMPONENTS_ERROR_MSG;
    }
    onAddDone() {
        this.popSuccess('Customer added');
    }

    onSaveDone() {
        this.popSuccess('Customer updated');
    }

    onDeleteDone() {
        this.popSuccess('Customer deleted');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Customer restored');
        this.list.onRefresh();
    }


    onGetAllPage(documentType: DocumentType) {
        // alert("here");
        this.documentService.getCustomerState(documentType);
    }
}
