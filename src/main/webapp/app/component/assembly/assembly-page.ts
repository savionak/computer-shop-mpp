import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyListComponent} from "./assembly-list.component";
import {AssemblyService} from "../../service/assembly.service";
import {ActivatedRoute} from "@angular/router";
import {OrderModel} from "../../model/full/order-model";
import {OrderService} from "../../service/order.service";


@Component({
    selector: 'asm-page',
    templateUrl: './assembly-page.html'
})
export class AssemblyPage implements OnInit {
    private service: AssemblyService;
    protected error: string;

    protected orderId: number;
    protected order: OrderModel;

    protected isReadOnly: boolean;

    @ViewChild(AssemblyListComponent) list: AssemblyListComponent;

    constructor(service: AssemblyService, private orderService: OrderService, private route: ActivatedRoute) {
        this.service = service;
    }

    ngOnInit(): void {
        let urlSegments = this.route.snapshot.url;
        this.isReadOnly = urlSegments[1].toString() !== 'edit';
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
