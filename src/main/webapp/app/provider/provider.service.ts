import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";


import {ProviderModel} from "./provider-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";



@Injectable()
export class ProviderService {
    private url: string = 'api/provider';

    constructor(private http: Http) {

    }

    getList(): Observable<ProviderModel[]> {
        return this.http.get(this.url)
            .map(ProviderService.extractData)
            .catch(ProviderService.handleError);
    }

    add(provider: ProviderModel): Observable<ProviderModel> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.url + '/add', JSON.stringify(provider), options)
            .map(ProviderService.extractData)
            .catch(ProviderService.handleError);
    }

    remove(id: number): Observable<ProviderModel> {
        return this.http.delete(this.url + '/delete/' + id)
            .map(ProviderService.extractData)
            .catch(ProviderService.handleError);
    }

    update(provider: ProviderModel): Observable<ProviderModel> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.put(this.url + '/update', JSON.stringify(provider), options)
            .map(ProviderService.extractData)
            .catch(ProviderService.handleError);
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
