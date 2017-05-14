import {Component, ViewChild} from "@angular/core";
import {ImportService} from "../../service/import.service";
import {ImportListComponent} from "./import-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'import-page',
    templateUrl: './import-page.html'
})
export class ImportPage extends BasePage {
    private service: ImportService;

    @ViewChild(ImportListComponent) list: ImportListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ImportService, route: ActivatedRoute) {
        super(authService, r, route);
        this.service = service;
    }

    onRestoreDone() {
        this.list.onRefresh();
    }

    onDeleteDone() {
        this.list.onRefresh();
    }
}
