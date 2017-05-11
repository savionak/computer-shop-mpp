import {Component} from "@angular/core";


import {ComponentStoreModel} from "../../model/full/component-store-model";
import {ComponentStoreBriefModel} from "../../model/brief/component-store-brief-model";
import {ComponentStoreService} from "../../service/component-store.service";
import {ReadOnlyListComponent} from "../base/read-only-list.component";
import {UpdateStorePrice} from "../../model/helper/update-store-price";


@Component({
    selector: 'comp-store-list',
    templateUrl: './comp-store-list.component.html'
})
export class ComponentStoreListComponent extends ReadOnlyListComponent<ComponentStoreModel, ComponentStoreBriefModel> {
    private updatePriceModel: UpdateStorePrice = null;
    private updatedStoreRecord: ComponentStoreBriefModel = null;

    constructor(private storeService: ComponentStoreService) {
        super(storeService);
    }

    protected getEmptyModel(): ComponentStoreModel {
        return ComponentStoreModel.empty();
    }

    onChange(model: ComponentStoreBriefModel) {
        this.updatedStoreRecord = model;
        this.updatePriceModel = new UpdateStorePrice(model.id, model.count, model.price);
    }

    onCancelChange() {
        this.cancelChange();
    }

    onApplyPrice() {
        this.storeService.updatePrice(this.updatePriceModel)
            .subscribe(
                () => {
                    this.cancelChange();
                    this.refreshList();
                },
                error => this.errorCallBack.emit(error)
            );
    }

    cancelChange() {
        this.updatePriceModel = null;
        this.updatedStoreRecord = null;
    }
}
