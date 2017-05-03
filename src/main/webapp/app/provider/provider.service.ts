import {Injectable} from "@angular/core";


import {ProviderModel} from "./provider-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "../shared/crud.service";
import {ProviderBriefModel} from "./provider-brief-model";


@Injectable()
export class ProviderService extends CrudService<ProviderModel, ProviderBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/provider');
    }

}
