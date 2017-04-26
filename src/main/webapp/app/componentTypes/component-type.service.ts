import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

import {ComponentTypeModel} from "./component-type-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

@Injectable()
export class ComponentTypeService {
    private url: string = 'api/component/type';

    constructor(private http: Http) {

    }

    getList(): Observable<ComponentTypeModel[]> {
        return this.http.get(this.url)
            .map(ComponentTypeService.extractData)
            .catch(ComponentTypeService.handleError);
    }

    add(type: ComponentTypeModel): Observable<ComponentTypeModel> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.url + '/add', JSON.stringify(type), options)
            .map(ComponentTypeService.extractData)
            .catch(ComponentTypeService.handleError);
    }

    remove(id: number): Observable<ComponentTypeModel> {
        return this.http.delete(this.url + '/delete/' + id)
            .map(ComponentTypeService.extractData)
            .catch(ComponentTypeService.handleError);
    }

    update(type: ComponentTypeModel): Observable<ComponentTypeModel> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.put(this.url + '/update', JSON.stringify(type), options)
            .map(ComponentTypeService.extractData)
            .catch(ComponentTypeService.handleError);
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
