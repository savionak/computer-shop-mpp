import {Component, OnDestroy, OnInit, ViewChild} from "@angular/core";

import {AssemblyListComponent} from "./assembly-list.component";
import {AssemblyService} from "../../service/assembly.service";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/Subscription";


@Component({
    selector: 'asm-page',
    templateUrl: './assembly-page.html'
})
export class AssemblyPage implements OnInit, OnDestroy {
    private service: AssemblyService;
    protected error: string;
    protected orderId: number;
    protected sub: Subscription;

    @ViewChild(AssemblyListComponent) list: AssemblyListComponent;

    constructor(service: AssemblyService, private route: ActivatedRoute) {
        this.service = service;
    }

    ngOnInit(): void {
        this.sub = this.route.params.subscribe(params => {
            this.orderId = +params['id'];
        });
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
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
