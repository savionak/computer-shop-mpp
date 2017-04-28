import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";


import {ProviderModel} from "./provider-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpOAuthService} from "../shared/oauth-http-client/http-oauth.service";
import {CrudService} from "../crud.service";


@Injectable()
export class ProviderService extends CrudService<ProviderModel>{

    constructor(http: HttpOAuthService) {
        super(http, '/api/provider');
    }

}
