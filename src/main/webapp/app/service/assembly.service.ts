import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./base/crud.service";
import {AssemblyModel} from "../model/full/assembly-model";
import {AssemblyBriefModel} from "../model/brief/assembly-brief-model";
import {Observable} from "rxjs/Observable";
import {ResponseHandler} from "../shared/response-handler";
import {Page} from "../model/page";


@Injectable()
export class AssemblyService extends CrudService<AssemblyModel, AssemblyBriefModel> {
    constructor(http: HttpOAuthService) {
        super(http, '/api/assembly');
    }

    getListByOrderId(orderId: number): Observable<Page<AssemblyBriefModel>> {
        return this.http.get(this.apiUrl + '/by/order/' + orderId)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }
}
