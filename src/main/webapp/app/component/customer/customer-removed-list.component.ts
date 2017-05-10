import {Component} from "@angular/core";
import {RemovedListComponent} from "../base/removed-list.component";
import {CustomerService} from "../../service/customer.service";
import {CustomerBriefModel} from "../../model/brief/customer-brief-model";
import {CustomerModel} from "../../model/full/customer-model";


@Component({
    selector: 'customer-removed-list',
    templateUrl: './customer-removed-list.component.html'
})
export class CustomerRemovedListComponent extends RemovedListComponent<CustomerModel, CustomerBriefModel> {
    constructor(service: CustomerService) {
        super(service);
    }
}
