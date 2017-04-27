import {Inject, Injectable} from "@angular/core";
import {Http, RequestOptionsArgs, Response} from "@angular/http";

import {Observable} from "rxjs/Observable";

// TODO: handle OAuth2 to api requests
@Injectable()
export class HttpOAuthService {
    constructor(@Inject(Http) private http: Http) {

    }

    public get(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.get(url, options);
    }

    public post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.post(url, body, options);
    }

    public put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.put(url, body, options);
    }

    public delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.delete(url, options);
    }
}
