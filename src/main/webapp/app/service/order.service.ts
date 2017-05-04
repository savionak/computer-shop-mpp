import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ComponentTypeModel} from "../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../model/brief/component-type-brief-model";
import {OrderModel} from "../model/full/order-model";
import {OrderBriefModel} from "../model/brief/order-brief-model";


@Injectable()
export class OrderService extends CrudService<OrderModel, OrderBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/order');
    }
}
