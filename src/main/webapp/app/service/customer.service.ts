import {Injectable} from "@angular/core";


import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ProviderModel} from "../model/full/provider-model";
import {ProviderBriefModel} from "../model/brief/provider-brief-model";
import {CustomerModel} from "../model/full/customer-model";
import {CustomerBriefModel} from "../model/brief/customer-brief-model";


@Injectable()
export class CustomerService extends CrudService<CustomerModel, CustomerBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/customer');
    }

}
