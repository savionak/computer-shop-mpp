import {OnInit} from "@angular/core";

import {BaseModel} from "./models/base-model";
import {CrudService} from "./crud.service";

// T - FullDto, U - BriefDto
export abstract class AbstractListComponent<T extends BaseModel, U extends BaseModel> implements OnInit {
    private service: CrudService<T, U>;
    // access by "this"
    modelsList: U[];
    error: string;
    newModel: T = this.getEmptyModel();
    editingModel: T;

    abstract getEmptyModel(): T;

    constructor(componentTypeService: CrudService<T, U>) {
        this.service = componentTypeService;
    }

    ngOnInit() {
        this.refreshList();
    }

    refreshList() {
        this.service.getList()
            .subscribe(
                (page) => {
                    this.modelsList = page.content
                },
                (error) => {
                    this.error = error
                }
            )
    }

    onRefresh(): void {
        this.refreshList();
    }

    onAdd(): void {
        this.service.add(this.newModel)
            .subscribe(
                (res) => {
                    this.refreshList();
                    this.newModel = this.getEmptyModel();
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onDelete(type: U): void {
        this.service.remove(type.id)
            .subscribe(
                (res) => {
                    this.refreshList()
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onEdit(type: U): void {
        this.service.get(type.id)
            .subscribe(
                (res) => {
                    this.editingModel = res;
                },
                (error) => {
                    this.error = error;
                }
            );
    }

    onSave(): void {
        this.service.update(this.editingModel)
            .subscribe(
                (res) => {
                    this.endEditing();
                    this.refreshList();
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
        this.editingModel = null;
    }

    onCloseError() {
        this.error = null;
    }
}
