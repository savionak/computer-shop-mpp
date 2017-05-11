import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyComponentListComponent} from "./asm-comp-list.component";
import {ActivatedRoute} from "@angular/router";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyService} from "../../service/assembly.service";


@Component({
    selector: 'asm-comp-page',
    templateUrl: './asm-comp-page.html'
})
export class AssemblyComponentPage implements OnInit {
    protected error: string;

    protected asmId: number;
    protected assembly: AssemblyModel;

    protected isReadOnly: boolean;

    @ViewChild(AssemblyComponentListComponent) list: AssemblyComponentListComponent;

    constructor(private route: ActivatedRoute, private assemblyService: AssemblyService) {
    }

    ngOnInit(): void {
        this.asmId = +this.route.snapshot.params['asmId'];
        this.assemblyService.get(this.asmId).subscribe(
            model => this.assembly = model,
            error => this.error = error
        );

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
