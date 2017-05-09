import {Response} from "@angular/http";

import {Observable} from "rxjs/Observable";


export class ResponseHandler {
    static extractData(res: Response) {
        let body;
        if (res.text()) {
            body = res.json();
        }
        return body || {};
    }

    static handleError(error: Response | any) {
        // TODO: rewrite
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
