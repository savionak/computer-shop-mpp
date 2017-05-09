import {OnInit} from "@angular/core";

import {BaseModel} from "../../model/base-model";
import {CrudService} from "../../service/base/crud.service";

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
                    // TODO: show popup
                    this.error = error;
                    alert(error);
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
                    // TODO: show popup
                    this.error = error;
                    alert(error);
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
                    // TODO: show popup
                    this.error = error;
                    alert(error);
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
                    // TODO: show popup
                    this.error = error;
                    alert(error);
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
                    // TODO: show popup
                    this.error = error;
                    alert(error);
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
