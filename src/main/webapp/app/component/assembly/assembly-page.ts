import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyListComponent} from "./assembly-list.component";
import {AssemblyService} from "../../service/assembly.service";
import {ActivatedRoute} from "@angular/router";
import {OrderModel} from "../../model/full/order-model";
import {OrderService} from "../../service/order.service";
import {BasePage} from "../base/base-page";


@Component({
    selector: 'asm-page',
    templateUrl: './assembly-page.html'
})
export class AssemblyPage extends BasePage implements OnInit {
    private service: AssemblyService;

    protected orderId: number;
    protected order: OrderModel;

    @ViewChild(AssemblyListComponent) list: AssemblyListComponent;

    constructor(service: AssemblyService, private orderService: OrderService, route: ActivatedRoute) {
        super(route);
        this.service = service;
    }

    ngOnInit(): void {
        super.ngOnInit();
        this.orderId = +this.route.snapshot.params['id'];
        this.orderService.get(this.orderId).subscribe(
            model => this.order = model,
            error => this.error = error
        );
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
