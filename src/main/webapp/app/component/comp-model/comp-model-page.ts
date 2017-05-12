import {Component, ViewChild} from "@angular/core";
import {ComponentModelListComponent} from "./comp-model-list.component";
import {ComponentModelRemovedListComponent} from "./comp-model-removed-list.component";
import {ComponentModelService} from "../../service/component-model.service";
import {BasePage} from "../base/base-page";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'model-page',
    templateUrl: './comp-model-page.html'
})
export class ComponentModelPage extends BasePage {
    private service: ComponentModelService;

    @ViewChild(ComponentModelListComponent) list: ComponentModelListComponent;
    @ViewChild(ComponentModelRemovedListComponent) removedList: ComponentModelRemovedListComponent;

    constructor(service: ComponentModelService, route: ActivatedRoute) {
        super(route);
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }
}
