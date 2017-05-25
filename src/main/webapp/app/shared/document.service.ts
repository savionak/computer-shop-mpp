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
    private static readonly USER_URL = "/user";
    private static readonly PROVIDER_URL = "/provider";
    private static readonly PROVIDER_ID_URL = "/provider/{id}";
    private static readonly CUSTOMER_URL = "/customer";

    // отчет о текущем состоянии склада
    public getStoreState(documentType: DocumentType) {
        console.log("type:" + documentType);
        this.http.getDocument(DocumentService.DOCS_URL + DocumentService.STORE_URL, documentType);
    }

    public getCustomerState(documentType: DocumentType) {
        console.log("type:" + documentType);
        this.http.getDocument(DocumentService.DOCS_URL + DocumentService.CUSTOMER_URL, documentType);
    }

    public getImportState(,documentType: DocumentType) {
        console.log("type:" + documentType);
        this.http.getDocument(DocumentService.DOCS_URL + DocumentService.PROVIDER_ID_URL, documentType);
    }

    public getUserState(documentType: DocumentType) {
        console.log("type:" + documentType);
        this.http.getDocument(DocumentService.DOCS_URL + DocumentService.USER_URL, documentType);
    }

    public getProviderState(documentType: DocumentType) {
        console.log("type:" + documentType);
        this.http.getDocument(DocumentService.DOCS_URL + DocumentService.PROVIDER_URL, documentType);
    }

}

export enum DocumentType {
    CSV,
    XSLX,
    PDF
}
