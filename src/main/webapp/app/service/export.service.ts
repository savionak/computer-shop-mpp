import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ComponentTypeModel} from "../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../model/brief/component-type-brief-model";
import {ImportModel} from "../model/full/import-model";
import {ImportBriefModel} from "../model/brief/import-brief-model";
import {ExportModel} from "../model/full/export-model";
import {ExportBriefModel} from "../model/brief/export-brief-model";


@Injectable()
export class ExportService extends CrudService<ExportModel, ExportBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/export');
    }
}
