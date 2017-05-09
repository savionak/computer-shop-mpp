import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./base/crud.service";
import {ExportModel} from "../model/full/export-model";
import {ExportBriefModel} from "../model/brief/export-brief-model";


@Injectable()
export class ExportService extends CrudService<ExportModel, ExportBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/export');
    }
}
