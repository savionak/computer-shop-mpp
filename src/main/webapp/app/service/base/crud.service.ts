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
        let path = ((url || this.apiUrl) + '/' + CrudService.ADD_PART);
        let body = JSON.stringify(model);

        return this.http.post(path, body)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    remove(id: number, url?: string): Observable<T> {
        let path = ((url || this.apiUrl) + '/' + CrudService.DELETE_PART + '/' + id);

        return this.http.delete(path)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    update(id: number, model: T, url?: string): Observable<T> {
        let path = ((url || this.apiUrl) + '/' + CrudService.UPDATE_PART + '/' + id);
        let body = JSON.stringify(model);

        return this.http.put(path, body)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    static readonly DELETE_PART: string = 'delete';
    static readonly ADD_PART: string = 'add';
    static readonly UPDATE_PART: string = 'update';
}
