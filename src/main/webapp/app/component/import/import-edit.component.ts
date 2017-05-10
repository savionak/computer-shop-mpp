import {Component, OnDestroy, OnInit} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {ComponentModelBriefModel} from "../../model/brief/component-model-brief-model";
import {ComponentModelService} from "../../service/component-model.service";
import {Subscription} from "rxjs/Subscription";
import {ImportService} from "../../service/import.service";
import {ImportModel} from "../../model/full/import-model";
import {ImportBriefModel} from "../../model/brief/import-brief-model";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";
import {ProviderService} from "../../service/provider.service";


@Component({
    selector: 'import-edit',
    templateUrl: './import-edit.component.html'
})
export class ImportEditComponent extends EditComponent<ImportModel, ImportBriefModel> implements OnInit, OnDestroy {
    private modelsList: ComponentModelBriefModel[];
    private providersList: ProviderBriefModel[];
    private sub: Subscription;

    constructor(service: ImportService, private modelService: ComponentModelService, private providerService: ProviderService) {
        super(service);
    }

    ngOnInit(): void {
        this.sub = this.modelService.getList().subscribe(
            page => {
                this.modelsList = page.content;

            },
            error => {
                this.errorCallback.emit(error);
            }
        ),
            this.sub = this.providerService.getList().subscribe(
                page => {
                    this.providersList = page.content;
                },
                error => {
                    this.errorCallback.emit(error);
                }
            );
    }

    // ngOnInit(): void {
    //     this.sub = this.providerService.getList().subscribe(
    //         page => {
    //             this.providersList = page.content;
    //         },
    //         error => {
    //             this.errorCallback.emit(error);
    //         }
    //     );
    // }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    compareBriefProvider(t1: ComponentModelBriefModel, t2: ComponentModelBriefModel): boolean {
        return t1 && t2 ? t1.id === t2.id : t1 === t2;
    }

    compareBriefModel(t1: ProviderBriefModel, t2: ProviderBriefModel): boolean {
        return t1 && t2 ? t1.id === t2.id : t1 === t2;
    }
}
