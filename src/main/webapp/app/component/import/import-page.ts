import {Component, ViewChild} from "@angular/core";
import {ImportService} from "../../service/import.service";
import {ImportListComponent} from "./import-list.component";


@Component({
    selector: 'import-page',
    templateUrl: './import-page.html'
})
export class ImportPage {
    private service: ImportService;
    protected error: string;

    @ViewChild(ImportListComponent) list: ImportListComponent;

    constructor(service: ImportService) {
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
