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
    componentTypesList: ComponentTypeModel[];
    error: string;
    // newType: ComponentTypeModel = EmptyComponentTypeModel;
    // editingIndex: number;
    // editingTypeCopy: ComponentTypeModel;

    constructor(private componentTypeService: ComponentTypeService) {
        
    }

    ngOnInit() {
        this.getList();
    }

    getList() {
        this.componentTypeService.getList()
            .subscribe(
                (list) => { this.componentTypesList = list },
                (error) => { this.error = error}
            )
    }

    // onAdd(): void {
    //     this.componentTypeService.add(this.newType);
    //     this.newType = EmptyComponentTypeModel;
    // }
    //
    // onDelete(type: ComponentTypeModel): void {
    //     this.componentTypeService.remove(type);
    // }
    //
    // onEdit(type: ComponentTypeModel): void {
    //     this.editingIndex = this.componentTypeService.indexOf(type);
    //     this.editingTypeCopy = JSON.parse(JSON.stringify(type));
    // }
    //
    // onSave(): void {
    //     this.componentTypeService.update(this.editingIndex, this.editingTypeCopy);
    //     this.endEditing();
    // }
    //
    // onCancel(): void {
    //     this.endEditing();
    // }
    //
    // endEditing(): void {
    //     this.editingTypeCopy = null;
    //     this.editingIndex = null;
    // }
}
