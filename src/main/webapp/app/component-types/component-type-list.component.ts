import {Component} from "@angular/core";

import {ComponentTypeBriefModel} from "./component-type-brief-model";
import {ComponentTypeService} from "./component-type.service";
import {ComponentTypeModel} from "./component-type-model";
import {AbstractListComponent} from "../shared/list.component";

@Component({
    selector: 'comp-type-list',
    templateUrl: './component-type-list.component.html',
    providers: [    // local provider -- created for each component <= replace with global
        ComponentTypeService
    ]
})
export class ComponentTypesListComponent extends AbstractListComponent<ComponentTypeModel, ComponentTypeBriefModel>{

    constructor(private componentTypeService: ComponentTypeService) {
        super(componentTypeService);
    }

    getEmptyModel(): ComponentTypeModel {
        return ComponentTypeModel.empty();
    }

}
