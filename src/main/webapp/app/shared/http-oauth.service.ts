import {Injectable} from "@angular/core";
import {Headers, Http, Request, RequestOptions, RequestOptionsArgs, Response, URLSearchParams} from "@angular/http";

import {Observable} from "rxjs/Observable";
import {CredentialsModel} from "../component/login/login-model";
import {ResponseHandler} from "./response-handler";
import {CurrentUser} from "./current-user.model";
import {Util} from "./utils";
import {Role} from "../model/full/user-auth-model";
import {ADMIN_ROUTES, DIRECTOR_ROUTES, MANAGER_ROUTES} from "./route-consts";


@Injectable()
export class HttpOAuthService {
    private ROUTES_MAP = {};

    constructor(private http: Http) {
        this.ROUTES_MAP[Role[Role.DIRECTOR]] = DIRECTOR_ROUTES;
        this.ROUTES_MAP[Role[Role.MANAGER]] = MANAGER_ROUTES;
        this.ROUTES_MAP[Role[Role.ADMIN]] = ADMIN_ROUTES;
        console.log(this.ROUTES_MAP);
    }

    getCurrentUser(): CurrentUser {
        let result = localStorage.getItem(Util.STORAGE_KEY);
        return (!!result) ? JSON.parse(result) : null;
    }

    getUserRoutes() {
        let role = this.getCurrentUser().user.role;
        return this.ROUTES_MAP[role];
    }

    setCurrentUser(user: CurrentUser) {
        localStorage.setItem(Util.STORAGE_KEY, JSON.stringify(user));
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

    private static readonly AUTH_HEADER: string = "Authorization";
    private static readonly CONTENT_TYPE = 'Content-Type';
    private static readonly CONTENT_TYPE_VALUE = 'application/json';

    private appendAuthHeader(options: RequestOptionsArgs): RequestOptions {
        let result: RequestOptions;
        let currentUser = this.getCurrentUser();
        if (!!currentUser) {
            if (!options) {
                result = new RequestOptions();
            } else {
                result = Util.copy(options);
            }
            if (!result.headers) {
                result.headers = new Headers();
            }
            result.headers.append(HttpOAuthService.AUTH_HEADER, currentUser.token_type + " " + currentUser.access_token);
            result.headers.append(HttpOAuthService.CONTENT_TYPE, HttpOAuthService.CONTENT_TYPE_VALUE);
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
