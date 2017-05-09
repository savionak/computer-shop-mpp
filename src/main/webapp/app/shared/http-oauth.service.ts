import {Injectable} from "@angular/core";
import {Http, Request, RequestOptionsArgs, Response, URLSearchParams} from "@angular/http";

import {Observable} from "rxjs/Observable";
import {CredentialsModel} from "../component/login/login-model";
import {ResponseHandler} from "./response-handler";


@Injectable()
export class HttpOAuthService {
    private readonly clientId: string = "web-client";
    private readonly clientSecret: string = "123456789";
    private readonly oauthLogInEndpointUrl: string = "/oauth/token";
    private readonly oauthLogOutEndpointUrl: string = "/oauth/revoke_token";
    private readonly defaultSearchParams: URLSearchParams;
    private readonly grantType: string = 'password';

    constructor(private http: Http) {
        this.defaultSearchParams = new URLSearchParams();
    }

    login(credentials: CredentialsModel): Observable<any> {
        let params: URLSearchParams = this.getDefaultSearchParams();

        params.set('username', credentials.email);
        params.set('password', credentials.password);

        return this.http.get(this.oauthLogInEndpointUrl, {search: params})
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    logout(): Observable<boolean> {
        return this.http.post(this.oauthLogOutEndpointUrl, "")
            .map(ResponseHandler.extractData)
            .catch(ResponseHandler.handleError);
    }

    private getDefaultSearchParams(): URLSearchParams {
        let result: URLSearchParams = new URLSearchParams();
        result.set('client_id', this.clientId);
        result.set('client_secret', this.clientSecret);
        result.set('grant_type', this.grantType);
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
