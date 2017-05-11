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

    constructor(private orderService: OrderService, private router: Router) {
        super(orderService);
    }

    onViewDetails(model: OrderModel): void {
        this.router.navigate(['order', 'view', model.id]);
    }

    onDeleteOrder(model: OrderModel): void {
        let id: number = model.id;
        if (confirm('Delete order with id = [' + id + '] ?')) {
            this.remove(id);
        }
    }

    protected remove(id: number) {
        this.orderService.remove(id)
            .subscribe(
                () => {
                    this.onRefresh();
                    this.deleteCallBack.emit(id);
                },
                (error) => {
                    this.errorCallBack.emit(error);
                }
            );
    }
}
