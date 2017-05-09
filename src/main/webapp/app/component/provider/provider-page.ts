import {Component, ViewChild} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderListComponent} from "./provider-list.component";
import {ProviderRemovedListComponent} from "./provider-removed-list.component";


@Component({
    selector: 'provider-page',
    templateUrl: './provider-page.html'
})
export class ProviderPage {
    private service: ProviderService;
    protected error: string;

    @ViewChild(ProviderListComponent) list: ProviderListComponent;
    @ViewChild(ProviderRemovedListComponent) removedList: ProviderRemovedListComponent;

    constructor(service: ProviderService) {
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
