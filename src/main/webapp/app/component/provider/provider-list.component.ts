import {Component} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderModel} from "../../model/full/provider-model";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";


@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html'
})
export class ProviderListComponent {
    private service: ProviderService;

    protected modelsList: ProviderBriefModel[];
    protected error: string;

    protected model: ProviderModel;
    protected isEditing: boolean;

    ngOnInit() {
        this.refreshList();
    }

    constructor(service: ProviderService) {
        this.service = service;
    }

    getEmptyModel(): ProviderModel {
        return ProviderModel.empty();
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

    onDelete(model: ProviderBriefModel): void {
        this.service.remove(model.id)
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

    onAdd(): void {
        this.isEditing = false;
        this.model = this.getEmptyModel();
    }

    onEdit(model: ProviderBriefModel): void {
        this.isEditing = true;

        this.service.get(model.id)
            .subscribe(
                (res) => {
                    this.model = res;
                },
                (error) => {
                    // TODO: show popup
                    this.error = error;
                    alert(error);
                }
            );
    }

    onSave(): void {
        this.service.update(this.model.id, this.model)
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

    onAction(): void {
        if (this.isEditing) {
            this.service.update(this.model.id, this.model)
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
        } else {
            this.service.add(this.model)
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
    }

    onCancel(): void {
        this.endEditing();
    }

    endEditing(): void {
        this.model = null;
    }

    onCloseError() {
        this.error = null;
    }
}
