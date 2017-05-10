import {Component, ViewChild} from "@angular/core";
import {ComponentStoreService} from "../../service/component-store.service";
import {ComponentStoreListComponent} from "./comp-store-list.component";


@Component({
    selector: 'store-page',
    templateUrl: './comp-store-page.html'
})
export class ComponentStorePage {
    private service: ComponentStoreService;
    protected error: string;

    @ViewChild(ComponentStoreListComponent) list: ComponentStoreListComponent;

    constructor(service: ComponentStoreService) {
        this.service = service;
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
