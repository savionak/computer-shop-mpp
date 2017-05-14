import {Component, ViewChild} from "@angular/core";
import {ComponentStoreService} from "../../service/component-store.service";
import {ComponentStoreListComponent} from "./comp-store-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'store-page',
    templateUrl: './comp-store-page.html'
})
export class ComponentStorePage extends BasePage {
    private service: ComponentStoreService;

    @ViewChild(ComponentStoreListComponent) list: ComponentStoreListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ComponentStoreService, route: ActivatedRoute) {
        super(authService, r, route);
        this.service = service;
    }

    onRestoreDone() {
        this.list.onRefresh();
    }
}
