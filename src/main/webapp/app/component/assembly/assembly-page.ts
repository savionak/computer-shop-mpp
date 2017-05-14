import {Component, OnDestroy, OnInit, ViewChild} from "@angular/core";

import {AssemblyListComponent} from "./assembly-list.component";
import {AssemblyService} from "../../service/assembly.service";
import {ActivatedRoute} from "@angular/router";
import {OrderModel} from "../../model/full/order-model";
import {OrderService} from "../../service/order.service";
import {BasePage} from "../base/base-page";
import {Subscription} from "rxjs/Subscription";
import {HttpOAuthService} from "../../shared/http-oauth.service";


@Component({
    selector: 'asm-page',
    templateUrl: './assembly-page.html'
})
export class AssemblyPage extends BasePage implements OnInit, OnDestroy {
    private service: AssemblyService;
    private routeSub: Subscription;

    protected orderId: number;
    protected order: OrderModel;

    @ViewChild(AssemblyListComponent) list: AssemblyListComponent;

    constructor(authService: HttpOAuthService, service: AssemblyService, private orderService: OrderService, route: ActivatedRoute) {
        super(authService, route);
        this.service = service;
    }

    ngOnInit(): void {
        super.ngOnInit();
        this.routeSub = this.route.params.subscribe(
            p => {
                this.orderId = +p['id'];
                this.orderService.get(this.orderId).subscribe(
                    model => this.order = model,
                    error => this.error = error
                );
            },
            error => {
                this.error = error;
            }
        );
    }

    ngOnDestroy(): void {
        this.routeSub.unsubscribe();
        super.ngOnDestroy();
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
