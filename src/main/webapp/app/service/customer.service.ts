import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CustomerModel} from "../model/full/customer-model";
import {CustomerBriefModel} from "../model/brief/customer-brief-model";
import {SoftDeleteService} from "./base/soft-delete.service";


@Injectable()
export class CustomerService extends SoftDeleteService<CustomerModel, CustomerBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/customer');
    }

}
