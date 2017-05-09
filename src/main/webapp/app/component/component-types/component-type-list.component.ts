import {Component} from "@angular/core";

import {AbstractListComponent} from "../app/list.component";
import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypeModel} from "../../model/full/component-type-model";
import {ComponentTypeBriefModel} from "../../model/brief/component-type-brief-model";


@Component({
    selector: 'comp-type-list',
    templateUrl: './component-type-list.component.html'
})
export class ComponentTypesListComponent extends AbstractListComponent<ComponentTypeModel, ComponentTypeBriefModel> {

    constructor(private componentTypeService: ComponentTypeService) {
        super(componentTypeService);
    }

    getEmptyModel(): ComponentTypeModel {
        return ComponentTypeModel.empty();
    }

}
