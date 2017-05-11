import {Observable} from "rxjs/Observable";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/observable/throw";

import {HttpOAuthService} from "../../shared/http-oauth.service";
import {Page} from "../../model/page";
import {ResponseHandler} from "../../shared/response-handler";


export abstract class ReadOnlyService<T, U> {
    protected readonly http: HttpOAuthService;
    protected readonly apiUrl: string;

    constructor(http: HttpOAuthService, apiUrl: string) {
        this.apiUrl = apiUrl;
        this.http = http;
    }

    getList(url?: string): Observable<Page<U>> {
        let path = (url || this.apiUrl);

        return this.http.get(path)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    get(id: number, url?: string): Observable<T> {
        let path = (url || this.apiUrl) + '/' + id;

        return this.http.get(path)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }
}
