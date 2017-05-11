import {Observable} from "rxjs/Observable";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/observable/throw";

import {HttpOAuthService} from "../../shared/http-oauth.service";
import {ReadOnlyService} from "./read-only.service";
import {ResponseHandler} from "../../shared/response-handler";


export abstract class CrudService<T, U> extends ReadOnlyService<T, U> {
    constructor(http: HttpOAuthService, apiUrl: string) {
        super(http, apiUrl);
    }

    add(model: T, url?: string): Observable<T> {
        return this.http.post((url || this.apiUrl) + '/' + CrudService.ADD_PART, JSON.stringify(model))
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    remove(id: number, url?: string): Observable<T> {
        return this.http.delete((url || this.apiUrl) + '/' + CrudService.DELETE_PART + '/' + id)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    update(id: number, model: T, url?: string): Observable<T> {
        return this.http.put((url || this.apiUrl) + '/' + CrudService.UPDATE_PART + '/' + id, JSON.stringify(model))
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    protected static readonly DELETE_PART: string = 'delete';
    protected static readonly ADD_PART: string = 'add';
    protected static readonly UPDATE_PART: string = 'update';
}
