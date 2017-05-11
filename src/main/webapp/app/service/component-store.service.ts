import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {ComponentStoreModel} from "../model/full/component-store-model";
import {ComponentStoreBriefModel} from "../model/brief/component-store-brief-model";
import {ReadOnlyService} from "./base/read-only.service";
import {ResponseHandler} from "../shared/response-handler";
import {Observable} from "rxjs/Observable";
import {UpdateStorePrice} from "../model/helper/update-store-price";


@Injectable()
export class ComponentStoreService extends ReadOnlyService<ComponentStoreModel, ComponentStoreBriefModel> {

    static url = '/api/component/store';

    constructor(http: HttpOAuthService) {
        super(http, ComponentStoreService.url);
    }

    updatePrice(upd: UpdateStorePrice): Observable<number> {
        return this.http.post(ComponentStoreService.url + '/update/price', upd)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }
}
