import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {OrderModel} from "../../model/full/order-model";
import {OrderBriefModel} from "../../model/brief/order-brief-model";
import {OrderService} from "../../service/order.service";


@Component({
    selector: 'order-list',
    templateUrl: './order-list.component.html'
})
export class OrderListComponent extends ListComponent <OrderModel, OrderBriefModel> {
    constructor(private orderService: OrderService) {
        super(orderService);
    }

    protected getEmptyModel(): OrderModel {
        return OrderModel.empty();
    }
}
