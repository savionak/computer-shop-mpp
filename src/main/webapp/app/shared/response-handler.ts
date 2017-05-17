import {Response} from "@angular/http";

import {Observable} from "rxjs/Observable";
import {Util} from "./utils";


export class ResponseHandler {
    static extractData(res: Response) {
        let body;
        if (res.text()) {
            body = res.json();
            body = ResponseHandler.processModel(body);
        }
        return body || {};
    }

    private static processModel(body: any) {
        let result = Util.copy(body);
        let date = body['importDate'];
        if (date) {
            result['importDate'] = new Date(date);
            console.log(date);
        }
        date = body['orderDate'];
        if (date) {
            result['orderDate'] = new Date(date);
        }
        return result;
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
