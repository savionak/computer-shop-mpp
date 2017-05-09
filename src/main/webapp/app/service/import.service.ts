import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./base/crud.service";
import {ImportModel} from "../model/full/import-model";
import {ImportBriefModel} from "../model/brief/import-brief-model";


@Injectable()
export class ImportService extends CrudService<ImportModel, ImportBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/import');
    }
}
