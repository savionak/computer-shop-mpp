import {Component, OnDestroy, OnInit} from "@angular/core";
import {AssemblyService} from "../../service/assembly.service";
import {ActivatedRoute, Router} from "@angular/router";
import {OrderModel} from "../../model/full/order-model";
import {OrderService} from "../../service/order.service";
import {BasePage} from "../base/base-page";
import {Subscription} from "rxjs/Subscription";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {AssemblyModel} from "../../model/full/assembly-model";
import {EDIT, ORDER} from "../../shared/route-consts";

@Component({
    selector: 'asm-page',
    templateUrl: './assembly-page.html'
})
export class AssemblyPage extends BasePage implements OnInit, OnDestroy {
    private service: AssemblyService;
    private routeSub: Subscription;

    protected orderId: number;
    protected order: OrderModel;

    constructor(authService: HttpOAuthService, private r: Router, service: AssemblyService, private orderService: OrderService, route: ActivatedRoute,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
        this.service = service;
    }

    ngOnInit(): void {
        super.ngOnInit();
        this.routeSub = this.route.params.subscribe(
            p => {
                this.orderId = +p['id'];
                this.orderService.get(this.orderId).subscribe(
                    model => this.order = model,
                    error => this.popConnectionError()
                );
            },
            error => {
                this.popNavigationError()
            }
        );
    }

    ngOnDestroy(): void {
        this.routeSub.unsubscribe();
        super.ngOnDestroy();
    }

    onOrderSaveDone(model: OrderModel): void {
        this.orderService.accept(model.id)
            .subscribe(
                () => {
                    this.popSuccess('Заказ обновлен');
                    setTimeout(() => {
                        this.goToOrders();
                    }, 500);

                },
                error => this.onError(error)
            )
    }

    goToOrders() {
        this.r.navigate([ORDER, EDIT]);
    }

    onAddDone(model: AssemblyModel) {
        this.popSuccess('Сборка добавлена');
    }

    onDeleteDone() {
        this.popSuccess('Сборка удалена из заказа');
    }
}
