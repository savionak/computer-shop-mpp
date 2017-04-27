import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response, Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "./shared/oauth-http-client/http-oauth.service";
import {ComponentTypeModel} from "./componentTypes/component-type-model";


export abstract class CrudService <T>{

    protected readonly http;
    protected readonly apiUrl;
    constructor (http, apiUrl: string) {
     this.apiUrl= apiUrl;
      this.http= http;
    }

    getList(): Observable<T> {
        return this.http.get(this.apiUrl)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    add(type: T): Observable<T[]> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.apiUrl + '/add', JSON.stringify(type), options)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    remove(id: number): Observable<T> {
        return this.http.delete(this.apiUrl + '/delete/' + id)
            .map(CrudService.extractData)
            .catch(CrudService.handleError);
    }

    update(type: T): Observable<T> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.put(this.apiUrl + '/update', JSON.stringify(type), options)
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

    private static handleError (error: Response | any) {
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
}
