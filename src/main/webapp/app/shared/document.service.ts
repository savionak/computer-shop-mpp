import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {Response} from "@angular/http";
import {HttpOAuthService} from "./http-oauth.service";


@Injectable()
export class DocumentService {
    constructor(private http: HttpOAuthService) {
    }

    private static readonly DOCS_URL = "api/documents";
    private static readonly STORE_URL = "/store";

    private static readonly TYPE_PARAM = "type";

    // отчет о текущем состоянии склада
    public getStoreState(documentType: DocumentType) {
        console.log("type:" + documentType);

        this.http.get(DocumentService.DOCS_URL + DocumentService.STORE_URL + '?type=' + documentType)
            .subscribe(
                (data) => {
                    this.downloadFile(data);
                    console.log('go!')
                }
            );
    }

    private downloadFile(data: Response) {
        let blob = new Blob([data], {type: data.headers.get("Content-Type")});
        let url = window.URL.createObjectURL(blob);
        window.open(url);
    }

}

export enum DocumentType {
    CSV,
    XSLX,
    PDF
}
