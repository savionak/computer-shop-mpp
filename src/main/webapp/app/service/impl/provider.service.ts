import {Injectable} from "@angular/core";


import {ProviderModel} from "../../provider/provider-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../../shared/http-oauth.service";
import {CrudService} from "../crud.service";
import {ProviderBriefModel} from "../../provider/provider-brief-model";


@Injectable()
export class ProviderService extends CrudService<ProviderModel, ProviderBriefModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/provider');
    }

}
