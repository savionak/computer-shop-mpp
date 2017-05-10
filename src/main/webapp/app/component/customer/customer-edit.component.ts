import {Component} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {CustomerBriefModel} from "../../model/brief/customer-brief-model";
import {CustomerModel} from "../../model/full/customer-model";
import {CustomerService} from "../../service/customer.service";


@Component({
    selector: 'customer-edit',
    templateUrl: './customer-edit.component.html'
})
export class CustomerEditComponent extends EditComponent<CustomerModel, CustomerBriefModel>{
    constructor(service: CustomerService) {
        super(service);
    }
}
