import {Component} from "@angular/core";


import {ComponentStoreModel} from "../../model/full/component-store-model";
import {ComponentStoreBriefModel} from "../../model/brief/component-store-brief-model";
import {ComponentStoreService} from "../../service/component-store.service";
import {ReadOnlyListComponent} from "../base/read-only-list.component";


@Component({
    selector: 'comp-store-list',
    templateUrl: './comp-store-list.component.html'
})
export class ComponentStoreListComponent extends ReadOnlyListComponent<ComponentStoreModel, ComponentStoreBriefModel> {
    constructor(private modelService: ComponentStoreService) {
        super(modelService);
    }

    protected getEmptyModel(): ComponentStoreModel {
        return ComponentStoreModel.empty();
    }
}
