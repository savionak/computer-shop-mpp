import {Component, ViewChild} from "@angular/core";

import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypesListComponent} from "./comp-type-list.component";
import {ComponentTypeRemovedListComponent} from "./comp-type-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'type-page',
    templateUrl: './comp-type-page.html'
})
export class ComponentTypePage extends BasePage {
    private service: ComponentTypeService;

    @ViewChild(ComponentTypesListComponent) list: ComponentTypesListComponent;
    @ViewChild(ComponentTypeRemovedListComponent) removedList: ComponentTypeRemovedListComponent;

    constructor(authService: HttpOAuthService, service: ComponentTypeService, route: ActivatedRoute) {
        super(authService, route);
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }
}
