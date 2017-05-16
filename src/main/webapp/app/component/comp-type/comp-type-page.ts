import {Component, ViewChild} from "@angular/core";

import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypesListComponent} from "./comp-type-list.component";
import {ComponentTypeRemovedListComponent} from "./comp-type-removed-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";

@Component({
    selector: 'type-page',
    templateUrl: './comp-type-page.html'
})
export class ComponentTypePage extends BasePage {
    private service: ComponentTypeService;

    @ViewChild(ComponentTypesListComponent) list: ComponentTypesListComponent;
    @ViewChild(ComponentTypeRemovedListComponent) removedList: ComponentTypeRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ComponentTypeService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    onAddDone() {
        this.popSuccess('Тип добавлен');
    }

    onSaveDone() {
        this.popSuccess('Тип обновлен');
    }

    onDeleteDone() {
        this.popSuccess('Тип удален');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Тип восстановлен');
        this.list.onRefresh();
    }
}
