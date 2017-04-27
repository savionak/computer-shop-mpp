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
    newType: ComponentTypeModel = ComponentTypeModel.empty();
    editingIndex: number;
    editingTypeCopy: ComponentTypeModel;

    constructor(private componentTypeService: ComponentTypeService) {
        
    }

    onCloseError() {
        this.error = null;
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

    onRefresh(): void {
        this.getList();
    }

    onAdd(): void {
        this.componentTypeService.add(this.newType)
            .subscribe(
                (res) => { this.getList() },
                (error) => { this.error = error}
            );
        this.newType = ComponentTypeModel.empty();
    }
    onDelete(type: ComponentTypeModel): void {
        this.componentTypeService.remove(type.id)
            .subscribe(
                (res) => { this.getList() },
                (error) => { this.error = error}
            );
    }

    onEdit(type: ComponentTypeModel): void {
        this.editingTypeCopy = JSON.parse(JSON.stringify(type));
    }

    onSave(): void {
        this.componentTypeService.update(this.editingTypeCopy)
            .subscribe(
                (res) => {
                    this.endEditing();
                    this.getList();
                },
                (error) => { this.error = error}
            );
    }

    onCancel(): void {
        this.endEditing();
    }

    endEditing(): void {
        this.editingTypeCopy = null;
        this.editingIndex = null;
    }
}
