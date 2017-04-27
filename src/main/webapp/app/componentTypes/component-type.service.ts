import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response, Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/oauth-http-client/http-oauth.service";
import {ComponentTypeModel} from "./component-type-model";
import {CrudService} from "../crud.service";

@Injectable()
export class ComponentTypeService extends CrudService<ComponentTypeModel>{

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/type');
    }
}
