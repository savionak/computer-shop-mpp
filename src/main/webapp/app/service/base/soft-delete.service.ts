import {Observable} from "rxjs/Observable";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/observable/throw";

import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Page} from "../../model/page";
import {ResponseHandler} from "../../shared/response-handler";
import {CrudService} from "./crud.service";


export abstract class SoftDeleteService<T, U> extends CrudService<T, U> {
    constructor(http: HttpOAuthService, apiUrl: string) {
        super(http, apiUrl);
    }

    getRemovedList(url?: string): Observable<Page<U>> {
        return this.http.get((url || this.apiUrl) + '/' + SoftDeleteService.REMOVED_LIST_PART)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    restore(id: number): Observable<void> {
        return this.http.post(this.apiUrl + '/' + SoftDeleteService.RESTORE_PART + '/' + id, "")
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    private static readonly REMOVED_LIST_PART: string = 'removed';
    private static readonly RESTORE_PART: string = 'restore';
}
