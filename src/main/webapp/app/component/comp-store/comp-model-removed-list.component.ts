import {Component} from "@angular/core";
import {RemovedListComponent} from "../base/removed-list.component";
import {ComponentModelService} from "../../service/component-model.service";
import {ComponentModelModel} from "../../model/full/component-model-model";
import {ComponentModelBriefModel} from "../../model/brief/component-model-brief-model";


@Component({
    selector: 'comp-model-removed-list',
    templateUrl: './comp-model-removed-list.component.html'
})
export class ComponentModelRemovedListComponent extends RemovedListComponent<ComponentModelModel, ComponentModelBriefModel> {
    constructor(service: ComponentModelService) {
        super(service);
    }
}
