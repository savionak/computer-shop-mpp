import {Component, ViewChild} from "@angular/core";
import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentTypeModel} from "../../model/full/component-type-model";
import {ComponentTypesListComponent} from "./component-type-list.component";


@Component({
    selector: 'type-page',
    templateUrl: './component-type-page.html'
})
export class ComponentTypePage {
    private service: ComponentTypeService;
    protected error: string;

    private model: ComponentTypeModel = null;
    private isViewing: boolean = true;
    private isEditing: boolean = false;

    @ViewChild(ComponentTypesListComponent) list: ComponentTypesListComponent;

    constructor(service: ComponentTypeService) {
        this.service = service;
    }

    getEmptyModel(): ComponentTypeModel {
        return ComponentTypeModel.empty();
    }

    onView(id: number) {
        // alert('View: ' + id);
        this.isViewing = true;
        this.loadModel(id);
    }

    private loadModel(id: number) {
        this.service.get(id).subscribe(
            res => {
                this.model = res
            },
            err => {
                alert(err);
                this.error = err
            }
        )
    }

    onAdd(): void {
        // alert('Add');
        this.isViewing = false;
        this.isEditing = false;
        this.model = this.getEmptyModel();
    }

    onEdit(id: number): void {
        // alert('Edit: ' + id);
        this.isViewing = false;
        this.isEditing = true;
        this.loadModel(id);
    }

    onAddDone() {
        this.closeDialog();
        this.list.onRefresh();
    }

    onEditDone() {
        this.closeDialog();
        this.list.onRefresh();
    }

    onCancel() {
        this.closeDialog();
        this.list.onRefresh();
    }

    onDelete(id: number): void {
        if (confirm('Delete: ' + id)) {
            this.service.remove(id)
                .subscribe(
                    () => {
                        this.list.onRefresh();
                    },
                    (error) => {
                        // TODO: show popup
                        this.error = error;
                        alert(error);
                    }
                );
        }
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }

    private closeDialog() {
        this.model = null;
    }
}
