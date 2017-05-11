import {Component} from "@angular/core";
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
    constructor(service: OrderService, private router: Router) {
        super(service);
    }

    onViewDetails(model: OrderModel): void {
        this.router.navigate(['order', 'view', model.id]);
    }
}
