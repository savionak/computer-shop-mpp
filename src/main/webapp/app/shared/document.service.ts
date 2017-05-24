import {Injectable} from "@angular/core";

import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";

import {HttpOAuthService} from "./http-oauth.service";


@Injectable()
export class DocumentService {
    constructor(private http: HttpOAuthService) {
    }

    private static readonly DOCS_URL = "api/documents";
    private static readonly STORE_URL = "/store";

    // отчет о текущем состоянии склада
    public getStoreState(documentType: DocumentType) {
        console.log("type:" + documentType);
        this.http.getDocument(DocumentService.DOCS_URL + DocumentService.STORE_URL, documentType);
    }

}

export enum DocumentType {
    CSV,
    XSLX,
    PDF
}
