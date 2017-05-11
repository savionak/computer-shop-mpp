import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyListComponent} from "./assembly-list.component";
import {AssemblyService} from "../../service/assembly.service";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'asm-page',
    templateUrl: './assembly-page.html'
})
export class AssemblyPage implements OnInit {
    private service: AssemblyService;
    protected error: string;

    protected orderId: number;
    protected isReadOnly: boolean;

    @ViewChild(AssemblyListComponent) list: AssemblyListComponent;

    constructor(service: AssemblyService, private route: ActivatedRoute) {
        this.service = service;
    }

    ngOnInit(): void {
        let urlSegments = this.route.snapshot.url;
        this.isReadOnly = urlSegments[1].toString() !== 'edit';

        this.orderId = +this.route.snapshot.params['id'];
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
