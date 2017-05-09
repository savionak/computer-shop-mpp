import {Component, ViewChild} from "@angular/core";
import {Router} from "@angular/router";

import {ProviderService} from "../../service/provider.service";
import {ProviderModel} from "../../model/full/provider-model";
import {ProviderListComponent} from "./provider-list.component";


@Component({
    selector: 'provider-page',
    templateUrl: './provider-page.html'
})
export class ProviderPage {
    private service: ProviderService;
    protected error: string;

    private model: ProviderModel = null;
    private isViewing: boolean = true;
    private isEditing: boolean = false;

    @ViewChild(ProviderListComponent) list: ProviderListComponent;

    constructor(service: ProviderService, private router: Router) {
        this.service = service;
    }

    getEmptyModel(): ProviderModel {
        return ProviderModel.empty();
    }

    onView(id: number) {
        alert('View: ' + id);
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
        alert('Add');
        this.isViewing = false;
        this.isEditing = false;
        this.model = this.getEmptyModel();
    }

    onEdit(id: number): void {
        alert('Edit: ' + id);
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
