import {Headers, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/observable/throw";
import {HttpOAuthService} from "../shared/http-oauth.service";
import {Page} from "../shared/page";


export abstract class CrudService<T, U> {
    protected readonly http: HttpOAuthService;
    protected readonly apiUrl: string;

    constructor(http: HttpOAuthService, apiUrl: string) {
        this.apiUrl = apiUrl;
        this.http = http;
    }

    getList(url?: string): Observable<Page<U>> {
        return this.http.get(url || this.apiUrl)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    get(id: number): Observable<T> {
        return this.http.get(this.apiUrl + '/' + id)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    add(type: T): Observable<T> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post(this.apiUrl + '/' + this.ADD_PART, JSON.stringify(type), options)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    remove(id: number): Observable<T> {
        return this.http.delete(this.apiUrl + '/' + this.DELETE_PART + '/' + id)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    update(type: T): Observable<T> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.put(this.apiUrl + '/' + this.UPDATE_PART, JSON.stringify(type), options)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    private static extractData(res: Response) {
        let body;
        if (res.text()) {
            body = res.json();
        }
        return body || {};
    }

    private static handleError(error: Response | any) {
        // TODO: rewrite
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }

    private readonly DELETE_PART: string = 'delete';
    private readonly ADD_PART: string = 'add';
    private readonly UPDATE_PART: string = 'update';
}
