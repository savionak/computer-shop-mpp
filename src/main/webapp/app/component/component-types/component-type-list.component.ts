import {Component} from "@angular/core";

import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypeModel} from "../../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../../model/brief/component-type-brief-model";
import {ListComponent} from "../base/list.component";


@Component({
    selector: 'comp-type-list',
    templateUrl: './component-type-list.component.html'
})
export class ComponentTypesListComponent extends ListComponent<ComponentTypeModel, ComponentTypeBriefModel> {

    constructor(private componentTypeService: ComponentTypeService) {
        super(componentTypeService);
    }
}
