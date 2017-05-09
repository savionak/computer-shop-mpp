import {Component, ViewChild} from "@angular/core";

import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypesListComponent} from "./component-type-list.component";
import {ComponentTypeRemovedListComponent} from "./comp-type-removed-list.component";


@Component({
    selector: 'type-page',
    templateUrl: './component-type-page.html'
})
export class ComponentTypePage {
    private service: ComponentTypeService;
    protected error: string;

    @ViewChild(ComponentTypesListComponent) list: ComponentTypesListComponent;
    @ViewChild(ComponentTypeRemovedListComponent) removedList: ComponentTypeRemovedListComponent;

    constructor(service: ComponentTypeService) {
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
