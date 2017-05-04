import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ComponentTypeModel} from "../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../model/brief/component-type-brief-model";
import {ComponentModelModel} from "../model/full/component-model-model";
import {ComponentModelBriefModel} from "../model/brief/component-model-brief-model";


@Injectable()
export class ComponentModelService extends CrudService<ComponentModelModel, ComponentModelBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/component/model');
    }
}
