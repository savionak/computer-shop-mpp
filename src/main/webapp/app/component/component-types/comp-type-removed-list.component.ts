import {Component} from "@angular/core";
import {RemovedListComponent} from "../base/removed-list.component";
import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypeBriefModel} from "../../model/brief/component-type-brief-model";
import {ComponentTypeModel} from "../../model/full/component-type-model";


@Component({
    selector: 'comp-type-removed-list',
    templateUrl: './comp-type-removed-list.component.html'
})
export class ComponentTypeRemovedListComponent extends RemovedListComponent<ComponentTypeModel, ComponentTypeBriefModel> {
    constructor(service: ComponentTypeService) {
        super(service);
    }
}
