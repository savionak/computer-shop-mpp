import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {ComponentTypeModel} from "./component-type-model";
import {CrudService} from "../shared/crud.service";

@Injectable()
export class ComponentTypeService extends CrudService<ComponentTypeModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/type');
    }
}
