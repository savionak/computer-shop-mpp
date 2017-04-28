import {Inject, Injectable} from "@angular/core";
import {Http, RequestOptionsArgs, Request, Response} from "@angular/http";

import {Observable} from "rxjs/Observable";

// TODO: handle OAuth2 to api requests
@Injectable()
export class HttpOAuthService {
    constructor(@Inject(Http) private http: Http) {

    }

    request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.request(url, options);
    };

    get(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.get(url, options);
    }

    post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.post(url, body, options);
    }

    put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.put(url, body, options);
    }

    delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.delete(url, options);
    }

    patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.patch(url, body, options);
    };

    head(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.head(url, options);
    };

    options(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return this.http.options(url, options);
    };
}
