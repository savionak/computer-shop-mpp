import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {ComponentModelModel} from "../../model/full/component-model-model";
import {ComponentModelBriefModel} from "../../model/brief/component-model-brief-model";
import {ComponentModelService} from "../../service/component-model.service";


@Component({
    selector: 'comp-model-list',
    templateUrl: './comp-model-list.component.html'
})
export class ComponentModelListComponent extends ListComponent<ComponentModelModel, ComponentModelBriefModel> {
    constructor(private modelService: ComponentModelService) {
        super(modelService);
    }

    protected getEmptyModel(): ComponentModelModel {
        return ComponentModelModel.empty();
    }
}
