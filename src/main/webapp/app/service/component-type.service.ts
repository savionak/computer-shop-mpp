import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {ComponentTypeModel} from "../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../model/brief/component-type-brief-model";
import {SoftDeleteService} from "./base/soft-delete.service";


@Injectable()
export class ComponentTypeService extends SoftDeleteService<ComponentTypeModel, ComponentTypeBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/type');
    }
}
