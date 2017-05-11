import {Component, OnDestroy, OnInit} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {Subscription} from "rxjs/Subscription";
import {CustomerService} from "../../service/customer.service";
import {OrderModel, Status} from "../../model/full/order-model";
import {OrderBriefModel} from "../../model/brief/order-brief-model";
import {OrderService} from "../../service/order.service";
import {CustomerBriefModel} from "../../model/brief/customer-brief-model";


@Component({
    selector: 'order-edit',
    templateUrl: './order-edit.component.html'
})
export class OrderEditComponent extends EditComponent<OrderModel, OrderBriefModel> implements OnInit, OnDestroy {
    private customersList: CustomerBriefModel[];
    private sub: Subscription;

    private ReadyStatus = Status.READY;

    constructor(private _service: OrderService, private customerService: CustomerService) {
        super(_service);
    }

    ngOnInit(): void {
        this.sub = this.customerService.getList().subscribe(
            page => {
                this.customersList = page.content;
            },
            error => {
                this.errorCallback.emit(error);
            }
        )
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }
}
