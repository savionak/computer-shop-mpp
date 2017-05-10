import {Component, OnDestroy, OnInit} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {ComponentTypeBriefModel} from "../../model/brief/component-type-brief-model";
import {ComponentModelModel} from "../../model/full/component-model-model";
import {ComponentModelBriefModel} from "../../model/brief/component-model-brief-model";
import {ComponentModelService} from "../../service/component-model.service";
import {ComponentTypeService} from "../../service/component-type.service";
import {Subscription} from "rxjs/Subscription";


@Component({
    selector: 'comp-model-edit',
    templateUrl: './comp-model-edit.component.html'
})
export class ComponentModelEditComponent extends EditComponent<ComponentModelModel, ComponentModelBriefModel> implements OnInit, OnDestroy {
    private typesList: ComponentTypeBriefModel[];
    private sub: Subscription;

    constructor(service: ComponentModelService, private typeService: ComponentTypeService) {
        super(service);
    }

    ngOnInit(): void {
        this.sub = this.typeService.getList().subscribe(
            page => {
                this.typesList = page.content;
            },
            error => {
                this.errorCallback.emit(error);
            }
        );
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    compareBrief(t1: ComponentTypeBriefModel, t2: ComponentTypeBriefModel): boolean {
        return t1 && t2 ? t1.id === t2.id : t1 === t2;
    }
}
