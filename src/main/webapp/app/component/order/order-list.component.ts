import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {OrderModel} from "../../model/full/order-model";
import {OrderBriefModel} from "../../model/brief/order-brief-model";
import {OrderService} from "../../service/order.service";
import {Router} from "@angular/router";


@Component({
    selector: 'order-list',
    templateUrl: './order-list.component.html'
})
export class OrderListComponent extends ListComponent <OrderModel, OrderBriefModel> {
    constructor(private orderService: OrderService, private router: Router) {
        super(orderService);
    }

    protected getEmptyModel(): OrderModel {
        return OrderModel.empty();
    }

    onViewDetails(model: OrderModel): void {
        alert("VIEW ORDER!");
        // TODO: view assemblies list
    }

    onEdit(model: OrderModel): void {
        alert("EDIT ORDER!");
        this.router.navigate(['order', model.id, 'assembly']);
    }

}
