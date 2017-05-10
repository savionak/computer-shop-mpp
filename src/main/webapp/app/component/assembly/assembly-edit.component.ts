import {Component, OnDestroy, OnInit} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyBriefModel} from "../../model/brief/assembly-brief-model";
import {AssemblyService} from "../../service/assembly.service";
import {OrderService} from "../../service/order.service";
import {OrderBriefModel} from "../../model/brief/order-brief-model";
import {Subscription} from "rxjs/Subscription";


@Component({
    selector: 'asm-edit',
    templateUrl: './assembly-edit.component.html'
})
export class AssemblyEditComponent extends EditComponent<AssemblyModel, AssemblyBriefModel> implements OnInit, OnDestroy {
    private ordersList: OrderBriefModel[];
    private sub: Subscription;

    constructor(service: AssemblyService, private orderService: OrderService) {
        super(service);
    }

    ngOnInit(): void {
        this.sub = this.orderService.getList().subscribe(
            page => {
                this.ordersList = page.content;
            },
            error => {
                this.errorCallback.emit(error);
            }
        );
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }
}
