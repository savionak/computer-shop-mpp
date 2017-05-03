import {Injectable} from "@angular/core";


import {ProviderModel} from "./provider-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {CrudService} from "../shared/crud.service";


@Injectable()
export class ProviderService extends CrudService<ProviderModel> {

    constructor(http: HttpOAuthService) {
        super(http, '/api/provider');
    }

}
