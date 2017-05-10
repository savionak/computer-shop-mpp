import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {CustomerModel} from "../../model/full/customer-model";
import {CustomerService} from "../../service/customer.service";
import {CustomerBriefModel} from "../../model/brief/customer-brief-model";


@Component({
    selector: 'customer-list',
    templateUrl: './customer-list.component.html'
})
export class CustomerListComponent extends ListComponent<CustomerBriefModel, CustomerBriefModel> {
    constructor(service: CustomerService) {
        super(service);
    }

    protected getEmptyModel(): CustomerModel {
        return CustomerModel.empty();
    }
}
