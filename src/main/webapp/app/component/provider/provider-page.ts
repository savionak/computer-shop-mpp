import {Component, ViewChild} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderListComponent} from "./provider-list.component";
import {ProviderRemovedListComponent} from "./provider-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {DocumentService} from "../../shared/document.service";

@Component({
    selector: 'provider-page',
    templateUrl: './provider-page.html'
})
export class ProviderPage extends BasePage {
    private service: ProviderService;

    @ViewChild(ProviderListComponent) list: ProviderListComponent;
    @ViewChild(ProviderRemovedListComponent) removedList: ProviderRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ProviderService, route: ActivatedRoute,
                toasterService: ToasterService,
                private documentService: DocumentService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    onAddDone() {
        this.popSuccess('Provider added');
    }

    onSaveDone() {
        this.popSuccess('Provider updated');
    }

    onDeleteDone() {
        this.popSuccess('Provider deleted');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Provider restored');
        this.list.onRefresh();
    }

    onGetAllPage(documentType: DocumentType) {
        alert("here");
        this.documentService.getStoreState(documentType);
    }
}
