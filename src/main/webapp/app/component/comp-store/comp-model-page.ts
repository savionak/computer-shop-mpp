import {Component, ViewChild} from "@angular/core";
import {ComponentModelListComponent} from "./comp-model-list.component";
import {ComponentModelRemovedListComponent} from "./comp-model-removed-list.component";
import {ComponentModelService} from "../../service/component-model.service";


@Component({
    selector: 'model-page',
    templateUrl: './comp-model-page.html'
})
export class ComponentModelPage {
    private service: ComponentModelService;
    protected error: string;

    @ViewChild(ComponentModelListComponent) list: ComponentModelListComponent;
    @ViewChild(ComponentModelRemovedListComponent) removedList: ComponentModelRemovedListComponent;

    constructor(service: ComponentModelService) {
        this.service = service;
    }

    onDeleteDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
