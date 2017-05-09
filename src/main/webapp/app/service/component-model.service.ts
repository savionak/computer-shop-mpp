import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {ComponentModelModel} from "../model/full/component-model-model";
import {ComponentModelBriefModel} from "../model/brief/component-model-brief-model";
import {SoftDeleteService} from "./base/soft-delete.service";


@Injectable()
export class ComponentModelService extends SoftDeleteService<ComponentModelModel, ComponentModelBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/model');
    }
}
