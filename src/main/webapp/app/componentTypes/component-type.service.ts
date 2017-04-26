import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

import {ComponentTypeModel} from "./component-type-model";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

@Injectable()
export class ComponentTypeService {
    private url: string = 'api/component/type';

    constructor(private http: Http) {

    }
    //
    // add(type: ComponentTypeModel): void {
    //
    // }
    //
    // remove(type: ComponentTypeModel): void {
    //
    // }
    //
    // update(index: number, type: ComponentTypeModel): void {
    //
    // }

    getList(): Observable<ComponentTypeModel[]> {
        return this.http.get(this.url)
            .map(this.extractData)
            .catch(this.handleError);
    }

    // indexOf(type: ComponentTypeModel): number {
    //
    // }

    private extractData(res: Response) {
        let body = res.json();
        return body || [ ]; //body.data || { };
    }

    private handleError (error: Response | any) {
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
