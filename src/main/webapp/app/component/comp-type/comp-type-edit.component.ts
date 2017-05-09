import {Component} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypeModel} from "../../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../../model/brief/component-type-brief-model";


@Component({
    selector: 'comp-type-edit',
    templateUrl: './comp-type-edit.component.html'
})
export class ComponentTypeEditComponent extends EditComponent<ComponentTypeModel, ComponentTypeBriefModel> {
    constructor(service: ComponentTypeService) {
        super(service);
    }
}
