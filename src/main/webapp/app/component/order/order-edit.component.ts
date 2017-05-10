import {Component, OnDestroy, OnInit} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {Subscription} from "rxjs/Subscription";
import {BaseModel} from "../../model/base-model";
import {CustomerService} from "../../service/customer.service";
import {OrderModel} from "../../model/full/order-model";
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

    constructor(service: OrderService, private customerService: CustomerService) {
        super(service);
    }

    ngOnInit(): void {
        this.sub = this.customerService.getList().subscribe(
            page => {
                this.customersList = page.content;
            },
            error => {
                this.errorCallback.emit(error);
            }
        );
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    compareBriefModel(t1: BaseModel, t2: BaseModel): boolean {
        return t1 && t2 ? t1.id === t2.id : t1 === t2;
    }
}
