import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {Observable} from "rxjs/Rx";
import {Http, Response, URLSearchParams} from "@angular/http";


@Injectable()
export class AuthService {

    clientId: string;
    clientSecret: string;
    oauthLogInEndpointUrl: string;
    oauthLogOutEndpointUrl: string;

    constructor(private http: Http) {
        this.clientId = "web-client";
        this.clientSecret = "123456789";
        this.oauthLogInEndpointUrl = "/api/oauth/token";
        this.oauthLogOutEndpointUrl = "/api/oauth/revoke_token";
    }

    login(username: string, password: string): Observable<any> {
        let params: URLSearchParams = new URLSearchParams();
        params.set('username', username);
        params.set('password', password);
        params.set('client_id', this.clientId);
        params.set('client_secret', this.clientSecret);
        params.set('grant_type', 'password');

        return this.http.get(this.oauthLogInEndpointUrl, {
            search: params
        }).map(this.handleData)
            .catch(this.handleError);
    }

    logout(): Observable<boolean> {
        return this.http.get(this.oauthLogInEndpointUrl, {
            search: {}
        }).map(this.handleData)
            .catch(this.handleError);
    }

    private handleData(res: Response) {
        // TODO: create UserModel
        let body = res.json();
        return body;
    }

    private handleError(error: any) {
        let errMsg = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
}
