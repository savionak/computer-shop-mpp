import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ComponentTypeModel} from "../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../model/brief/component-type-brief-model";
import {AssemblyModel} from "../model/full/assembly-model";
import {AssemblyBriefModel} from "../model/brief/assembly-brief-model";


@Injectable()
export class AssemblyService extends CrudService<AssemblyModel,AssemblyBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/assembly');
    }
}
