import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {ComponentStoreModel} from "../model/full/component-store-model";
import {ComponentStoreBriefModel} from "../model/brief/component-store-brief-model";
import {ReadOnlyService} from "./base/read-only.service";


@Injectable()
export class ComponentStoreService extends ReadOnlyService<ComponentStoreModel, ComponentStoreBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/store');
    }
}
