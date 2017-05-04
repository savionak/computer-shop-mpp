import {Injectable} from "@angular/core";


import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "./crud.service";
import {ProviderModel} from "../model/full/provider-model";
import {ProviderBriefModel} from "../model/brief/provider-brief-model";


@Injectable()
export class ProviderService extends CrudService<ProviderModel, ProviderBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/provider');
    }

}
