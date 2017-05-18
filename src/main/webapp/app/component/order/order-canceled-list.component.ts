import {Component, EventEmitter, Output} from "@angular/core";
import {RemovedListComponent} from "../base/removed-list.component";
import {OrderModel} from "../../model/full/order-model";
import {OrderBriefModel} from "../../model/brief/order-brief-model";
import {OrderService} from "../../service/order.service";
import {Router} from "@angular/router";


@Component({
    selector: 'order-removed-list',
    templateUrl: './order-canceled-list.component.html'
})
export class OrderCanceledListComponent extends RemovedListComponent<OrderModel, OrderBriefModel> {
    @Output('onDelete') deleteCallBack: EventEmitter<number> = new EventEmitter();

    private idToDrop: number;

    constructor(private orderService: OrderService, private router: Router) {
        super(orderService);
    }

    onViewDetails(model: OrderModel): void {
        this.router.navigate(['order', 'view', model.id]);
    }

    onDrop(model: OrderModel) {
        this.idToDrop = model.id;
    }

    getRemoveTitle(): string {
        return "Drop order ?";
    }

    onDropOk() {
        this.remove(this.idToDrop);
        this.closePopup();
    }

    closePopup() {
        this.idToDrop = null;
    }

    protected remove(id: number) {
        this.orderService.remove(id)
            .subscribe(
                () => {
                    this.onRefresh();
                    this.deleteCallBack.emit(id);
                },
                (error) => {
                    this.errorCallback.emit(error);
                }
            );
    }
}
