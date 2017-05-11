import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {OrderModel} from "../model/full/order-model";
import {OrderBriefModel} from "../model/brief/order-brief-model";
import {SoftDeleteService} from "./base/soft-delete.service";
import {ResponseHandler} from "../shared/response-handler";
import {Observable} from "rxjs/Observable";
import {Page} from "../model/page";


@Injectable()
export class OrderService extends SoftDeleteService<OrderModel, OrderBriefModel> {

    static url: string = '/api/order';
    static ACCEPT_PART = 'accept';
    static START_EDIT_PART = 'start_edit';
    static CANCEL_PART = 'cancel';
    static CANCELED_LIST_PART = 'canceled';
    static RENEW_PART = 'renew';

    constructor(http: HttpOAuthService) {
        super(http, OrderService.url);
    }

    accept(id: number) {
        return this.http.post(OrderService.url + '/' + OrderService.ACCEPT_PART + '/' + id, "");
    }

    startEdit(id: number) {
        return this.http.post(OrderService.url + '/' + OrderService.START_EDIT_PART + '/' + id, "");
    }

    cancel(id: number): Observable<void> {
        return this.http.post(this.apiUrl + '/' + OrderService.CANCEL_PART + '/' + id, "")
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    getRemovedList(url?: string): Observable<Page<OrderBriefModel>> {
        return this.http.get((url || this.apiUrl) + '/' + OrderService.CANCELED_LIST_PART)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    restore(id: number): Observable<void> {
        return this.http.post(this.apiUrl + '/' + OrderService.RENEW_PART + '/' + id, "")
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

}
