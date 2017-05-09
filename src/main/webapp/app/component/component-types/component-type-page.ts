import {Component} from "@angular/core";

import {ComponentTypeService} from "../../service/component-type.service";


@Component({
    selector: 'type-page',
    templateUrl: './component-type-page.html'
})
export class ComponentTypePage {
    private service: ComponentTypeService;
    protected error: string;

    constructor(service: ComponentTypeService) {
        this.service = service;
    }

    onDeleteDone() {

    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
