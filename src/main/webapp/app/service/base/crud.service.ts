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

    add(model: T): Observable<T> {
        return this.http.post(this.apiUrl + '/' + CrudService.ADD_PART, JSON.stringify(model))
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    remove(id: number): Observable<T> {
        return this.http.delete(this.apiUrl + '/' + CrudService.DELETE_PART + '/' + id)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    update(id: number, model: T): Observable<T> {
        return this.http.put(this.apiUrl + '/' + CrudService.UPDATE_PART + '/' + id, JSON.stringify(model))
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    private static readonly DELETE_PART: string = 'delete';
    private static readonly ADD_PART: string = 'add';
    private static readonly UPDATE_PART: string = 'update';
}
