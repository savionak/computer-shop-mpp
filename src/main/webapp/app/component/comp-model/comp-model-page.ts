import {Component, ViewChild} from "@angular/core";
import {ComponentModelListComponent} from "./comp-model-list.component";
import {ComponentModelRemovedListComponent} from "./comp-model-removed-list.component";
import {ComponentModelService} from "../../service/component-model.service";
import {BasePage} from "../base/base-page";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {ComponentModelModel} from "../../model/full/component-model-model";

@Component({
    selector: 'model-page',
    templateUrl: './comp-model-page.html'
})
export class ComponentModelPage extends BasePage {
    private service: ComponentModelService;

    @ViewChild(ComponentModelListComponent) list: ComponentModelListComponent;
    @ViewChild(ComponentModelRemovedListComponent) removedList: ComponentModelRemovedListComponent;

    constructor(authService: HttpOAuthService, r: Router, service: ComponentModelService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    onAddDone(model: ComponentModelModel) {
        this.popSuccess('Модель добавлена');
    }

    onSaveDone(model: ComponentModelModel) {
        this.popSuccess('Модель обновлена');
    }

    onDeleteDone() {
        this.popSuccess('Модель удалена');
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.popSuccess('Модель восстановлена');
        this.list.onRefresh();
    }
}
