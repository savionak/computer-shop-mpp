import {Component, OnInit} from "@angular/core";

import {ProviderModel} from "./provider-model";
import {ProviderService} from "./provider.service";

@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html',
    providers: [    // local provider -- created for each component
        ProviderService
    ]
})
export class ProviderListComponent implements OnInit {
    providerList: ProviderModel[];
    error: string;
    newProvider: ProviderModel = ProviderModel.empty();
    editingIndex: number;
    editingProviderCopy: ProviderModel;

    constructor(private providerService: ProviderService) {

    }

    onCloseError() {
        this.error = null;
    }

    ngOnInit() {
        this.getList();
    }

    getList() {
        this.providerService.getList()
            .subscribe(
                (list) => {
                    this.providerList = list
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
        this.providerService.add(this.newProvider)
            .subscribe(
                (res) => {
                    this.getList();
                    this.newProvider = ProviderModel.empty();
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onDelete(provider: ProviderModel): void {
        this.providerService.remove(provider.id)
            .subscribe(
                (res) => {
                    this.getList()
                },
                (error) => {
                    this.error = error
                }
            );
    }

    onEdit(provider: ProviderModel): void {
        this.editingProviderCopy = JSON.parse(JSON.stringify(provider));
    }

    onSave(): void {
        this.providerService.update(this.editingProviderCopy)
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
        this.editingProviderCopy = null;
        this.editingIndex = null;
    }
}
