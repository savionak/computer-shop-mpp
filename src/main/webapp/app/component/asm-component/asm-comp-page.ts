import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyComponentListComponent} from "./asm-comp-list.component";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'asm-comp-page',
    templateUrl: './asm-comp-page.html'
})
export class AssemblyComponentPage implements OnInit {
    protected error: string;

    protected asmId: number;
    protected isReadOnly: boolean;

    @ViewChild(AssemblyComponentListComponent) list: AssemblyComponentListComponent;

    constructor(private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.asmId = +this.route.snapshot.params['id'];
        let urlSegments = this.route.snapshot.url;
        this.isReadOnly = urlSegments[1].toString() !== 'edit';
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
