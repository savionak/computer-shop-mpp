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
        let result: any;
        let text: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body || JSON.stringify(body);
            text = `${error.status} - ${error.statusText || ''}`;
            result = err;
        } else {
            text = error.message ? error.message : error.toString();
            result = text;
        }
        console.error(text);
        return Observable.throw(result);
    }
}
