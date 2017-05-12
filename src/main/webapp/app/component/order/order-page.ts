import {Component, ViewChild} from "@angular/core";

import {OrderListComponent} from "./order-list.component";
import {OrderService} from "../../service/order.service";
import {OrderCanceledListComponent} from "./order-canceled-list.component";
import {BasePage} from "../base/base-page";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'order-page',
    templateUrl: './order-page.html'
})
export class OrderPage extends BasePage {
    private service: OrderService;
    protected error: string;

    @ViewChild(OrderListComponent) list: OrderListComponent;
    @ViewChild(OrderCanceledListComponent) removedList: OrderCanceledListComponent;

    constructor(service: OrderService, route: ActivatedRoute) {
        super(route);
        this.service = service;
    }

    onCancelDone() {
        this.removedList.onRefresh();
    }

    onRestoreDone() {
        this.list.onRefresh();
    }

    onDeleteDone() {

    }
}
