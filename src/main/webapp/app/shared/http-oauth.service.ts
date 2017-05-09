import {Injectable} from "@angular/core";
import {Headers, Http, Request, RequestOptions, RequestOptionsArgs, Response, URLSearchParams} from "@angular/http";

import {Observable} from "rxjs/Observable";
import {CredentialsModel} from "../component/login/login-model";
import {ResponseHandler} from "./response-handler";
import {CurrentUser} from "./current-user.model";
import {Util} from "./utils";


@Injectable()
export class HttpOAuthService {

    constructor(private http: Http) {

    }

    getCurrentUser(): CurrentUser {
        let result = localStorage.getItem('currentUser');
        return (!!result) ? JSON.parse(result) : null;
    }

    setCurrentUser(user: CurrentUser) {
        localStorage.setItem('currentUser', JSON.stringify(user));
    }

    login(credentials: CredentialsModel): Observable<any> {
        let headers = this.getDefaultHeaders();
        let options = new RequestOptions({headers: headers});

        let body: URLSearchParams = new URLSearchParams();
        body.set('grant_type', this.grantType);
        body.set('username', credentials.email);
        body.set('password', credentials.password);

        return this.http.post(this.oauthLogInEndpointUrl, body, options)
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    logout(): Observable<boolean> {
        localStorage.removeItem('currentUser');
        return this.post(this.oauthLogOutEndpointUrl, "")
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    private getDefaultHeaders() {
        let result = new Headers();
        result.append("Authorization", "Basic " + btoa(this.clientId + ":" + this.clientSecret));
        return result;
    }

    private readonly clientId: string = "web-client";
    private readonly clientSecret: string = "123456789";
    private readonly oauthLogInEndpointUrl: string = "/oauth/token";
    private readonly oauthLogOutEndpointUrl: string = "/oauth/revoke_token";
    private readonly grantType: string = 'password';

    //----------------------------------------------------------------------------------
    // Append access_token to api requests
    //----------------------------------------------------------------------------------

    private readonly AUTH_HEADER: string = "Authorization";

    private appendAuthHeader(options: RequestOptionsArgs): any {
        let result: RequestOptions;
        let currentUser = this.getCurrentUser();
        if (!!currentUser) {
            if (!options) {
                result = new RequestOptions();
                result.headers = new Headers();
            } else {
                result = Util.copy(options);
                if (result.headers.has(this.AUTH_HEADER)) {
                    result.headers.delete(this.AUTH_HEADER);
                }
            }
            result.headers.append(this.AUTH_HEADER, currentUser.token_type + " " + currentUser.access_token);
        }
        return result;
    }

    request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.request(url, options);
    };

    get(url: string, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.get(url, options);
    }

    post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.post(url, body, options);
    }

    put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.put(url, body, options);
    }

    delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.delete(url, options);
    }

    patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.patch(url, body, options);
    };

    head(url: string, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.head(url, options);
    };

    options(url: string, options?: RequestOptionsArgs): Observable<Response> {
        options = this.appendAuthHeader(options);
        return this.http.options(url, options);
    };
}
