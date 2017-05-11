import {Component, ViewChild} from "@angular/core";

import {OrderListComponent} from "./order-list.component";
import {OrderService} from "../../service/order.service";
import {OrderCanceledListComponent} from "./order-canceled-list.component";


@Component({
    selector: 'order-page',
    templateUrl: './order-page.html'
})
export class OrderPage {
    private service: OrderService;
    protected error: string;

    protected isReadOnly: boolean;

    @ViewChild(OrderListComponent) list: OrderListComponent;
    @ViewChild(OrderCanceledListComponent) removedList: OrderCanceledListComponent;

    constructor(service: OrderService) {
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

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
