import {Component} from "@angular/core";

import {ProviderService} from "../../service/provider.service";


@Component({
    selector: 'provider-page',
    templateUrl: './provider-page.html'
})
export class ProviderPage {
    private service: ProviderService;
    protected error: string;

    constructor(service: ProviderService) {
        this.service = service;
    }

    onDeleteDone() {

    }

    onRestoreDone() {

    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
