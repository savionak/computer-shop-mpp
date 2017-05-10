import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {ImportModel} from "../../model/full/import-model";
import {ImportBriefModel} from "../../model/brief/import-brief-model";
import {ImportService} from "../../service/import.service";


@Component({
    selector: 'import-list',
    templateUrl: './import-list.component.html'
})
export class ImportListComponent extends ListComponent <ImportModel, ImportBriefModel> {
    constructor(private modelService: ImportService) {
        super(modelService);
    }

    protected getEmptyModel(): ImportModel {
        return ImportModel.empty();
    }
}
