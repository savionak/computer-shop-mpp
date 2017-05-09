import {Injectable} from "@angular/core";
import {Headers, Http, Request, RequestOptions, RequestOptionsArgs, Response, URLSearchParams} from "@angular/http";

import {Observable} from "rxjs/Observable";
import {CredentialsModel} from "../component/login/login-model";
import {ResponseHandler} from "./response-handler";


@Injectable()
export class HttpOAuthService {
    private readonly clientId: string = "web-client";
    private readonly clientSecret: string = "123456789";
    private readonly oauthLogInEndpointUrl: string = "/oauth/token";
    private readonly oauthLogOutEndpointUrl: string = "/oauth/revoke_token";
    private readonly grantType: string = 'password';

    constructor(private http: Http) {

    }

    login(credentials: CredentialsModel): Observable<any> {
        let headers = this.getDefaultHeaders();
        let options = new RequestOptions({headers: headers});

        let body: URLSearchParams = new URLSearchParams();
        body.set('grant_type', this.grantType);
        body.set('username', credentials.email);
        body.set('password', credentials.password);

        // TODO: save to localstorage

        return this.http.post(this.oauthLogInEndpointUrl, body, options)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    logout(): Observable<boolean> {
        // TODO: post to endpoint + delete from localstorage
        return this.post(this.oauthLogOutEndpointUrl, "")
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    private getDefaultHeaders() {
        let result = new Headers();
        result.append("Authorization", "Basic " + btoa(this.clientId + ":" + this.clientSecret));
        // result.append("Content");
        return result;
    }

    //----------------------------------------------------------------------------------
    // TODO: handle OAuth2 to api requests
    //----------------------------------------------------------------------------------

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
