import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {ComponentTypeBriefModel} from "../shared/models/brief/component-type-brief-model";
import {CrudService} from "../shared/crud.service";
import {ComponentTypeModel} from "../shared/models/full/component-type-model";

@Injectable()
export class ComponentTypeService extends CrudService<ComponentTypeModel, ComponentTypeBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/type');
    }
}
