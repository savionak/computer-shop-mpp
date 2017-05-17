import {Response} from "@angular/http";

import {Observable} from "rxjs/Observable";
import {Util} from "./utils";


export class ResponseHandler {
    static extractData(res: Response) {
        let body;
        if (res.text()) {
            body = res.json();
            // console.log(body);
            body = ResponseHandler.processModel(body);
            body = ResponseHandler.processPage(body);
        }
        return body || {};
    }

    public static processModel(body: any, getString: boolean = false) {
        let result = Util.copy(body);
        let dateNum = body['importDate'];
        if (dateNum) {
            let date: any = new Date(dateNum);
            if (getString) {
                date = date.toLocaleString();
            }
            result['importDate'] = date;
        }
        dateNum = body['orderDate'];
        if (dateNum) {
            let date: any = new Date(dateNum);
            if (getString) {
                date = date.toLocaleString();
            }
            result['orderDate'] = date;
        }
        return result;
    }

    private static processPage(page: any) {
        let result = Util.copy(page);
        let content = result['content'];
        if (content) {
            result['content'] = content.map(
                (x: any) => {
                    return ResponseHandler.processModel(x, true);
                });
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
