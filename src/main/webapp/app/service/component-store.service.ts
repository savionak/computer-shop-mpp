import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ComponentTypeModel} from "../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../model/brief/component-type-brief-model";
import {ComponentStoreModel} from "../model/full/component-store-model";
import {ComponentStoreBriefModel} from "../model/brief/component-store-brief-model";


@Injectable()
export class ComponentStoreService extends CrudService<ComponentStoreModel, ComponentStoreBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/store');
    }
}
