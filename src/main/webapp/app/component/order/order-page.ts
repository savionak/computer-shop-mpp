import {Component, ViewChild} from "@angular/core";

import {OrderListComponent} from "./order-list.component";
import {OrderService} from "../../service/order.service";


@Component({
    selector: 'order-page',
    templateUrl: './order-page.html'
})
export class OrderPage {
    private service: OrderService;
    protected error: string;

    protected isReadOnly: boolean;

    @ViewChild(OrderListComponent) list: OrderListComponent;

    constructor(service: OrderService) {
        this.service = service;
    }

    onDeleteDone() {
        this.list.onRefresh();
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
