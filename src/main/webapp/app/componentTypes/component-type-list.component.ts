import {Component} from "@angular/core";

import {ComponentTypeModel} from "./component-type-model";
import {ComponentTypeService} from "./component-type.service";

@Component({
    selector: 'comp-type-list',
    templateUrl: './component-type-list.component.html',
    providers: [    // local provider -- created for each component
        ComponentTypeService
    ]
})
export class ComponentTypesListComponent  {

    newType: ComponentTypeModel = {};
    editingIndex: number;
    editingTypeCopy: ComponentTypeModel;

    constructor(private componentTypeService: ComponentTypeService) {
        
    }

    onAdd(): void {
        this.componentTypeService.add(this.newType);
        this.newType = {};
    }

    onDelete(type: ComponentTypeModel): void {
        this.componentTypeService.delete(type);
    }

    onEdit(type: ComponentTypeModel): void {
        this.editingIndex = this.componentTypeService.indexOf(type);
        this.editingTypeCopy = JSON.parse(JSON.stringify(type));
    }

    onSave(): void {
        this.componentTypeService.update(this.editingIndex, this.editingTypeCopy);
        this.endEditing();
    }

    onCancel(): void {
        this.endEditing();
    }

    endEditing(): void {
        this.editingTypeCopy = null;
        this.editingIndex = null;
    }
}
