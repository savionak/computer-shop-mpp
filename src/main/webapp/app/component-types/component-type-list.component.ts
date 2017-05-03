import {Component, OnInit} from "@angular/core";

import {ComponentTypeBriefModel} from "./component-type-brief-model";
import {ComponentTypeService} from "./component-type.service";
import {ComponentTypeModel} from "./component-type-model";

@Component({
    selector: 'comp-type-list',
    templateUrl: './component-type-list.component.html',
    providers: [    // local provider -- created for each component
        ComponentTypeService
    ]
})
export class ComponentTypesListComponent implements OnInit {
    private componentTypeService: ComponentTypeService;
    componentTypesList: ComponentTypeBriefModel[];
    error: string;
    newType: ComponentTypeModel = ComponentTypeModel.empty();
    editingType: ComponentTypeModel;

    constructor(componentTypeService: ComponentTypeService) {
        this.componentTypeService = componentTypeService;
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
                (page) => {
                    this.componentTypesList = page.content
                },
                (error) => {
                    this.error = error
                }
            )
    }

    onRefresh(): void {
        this.getList();
    }

    onAdd(): void {
        this.componentTypeService.add(this.newType)
            .subscribe(
                (res) => {
                    this.getList();
                    this.newType = ComponentTypeModel.empty();
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onDelete(type: ComponentTypeBriefModel): void {
        this.componentTypeService.remove(type.id)
            .subscribe(
                (res) => {
                    this.getList()
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onEdit(type: ComponentTypeBriefModel): void {
        this.componentTypeService.get(type.id)
            .subscribe(
                (res) => {
                    this.editingType = res;
                },
                (error) => {
                    this.error = error;
                }
            );
    }

    onSave(): void {
        this.componentTypeService.update(this.editingType)
            .subscribe(
                (res) => {
                    this.endEditing();
                    this.getList();
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onCancel(): void {
        this.endEditing();
    }

    endEditing(): void {
        this.editingType = null;
    }
}
