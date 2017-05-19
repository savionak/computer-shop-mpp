import {Component, ViewChild} from "@angular/core";
import {ImportService} from "../../service/import.service";
import {ImportListComponent} from "./import-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'import-page',
    templateUrl: './import-page.html'
})
export class ImportPage extends BasePage {
    private service: ImportService;

    @ViewChild(ImportListComponent) list: ImportListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ImportService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    getOperationErrorMessage() {
        return this.COMPONENTS_ERROR_MSG;
    }

    onAddDone() {
        this.popSuccess('Import added');
    }

    onSaveDone() {
        this.popSuccess('Import updated');
    }

    onDeleteDone() {
        this.popSuccess('Import deleted');
        this.list.onRefresh();
    }
}
