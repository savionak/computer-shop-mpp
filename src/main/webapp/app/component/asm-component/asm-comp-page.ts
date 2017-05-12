import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyComponentListComponent} from "./asm-comp-list.component";
import {ActivatedRoute} from "@angular/router";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyService} from "../../service/assembly.service";
import {BasePage} from "../base/base-page";


@Component({
    selector: 'asm-comp-page',
    templateUrl: './asm-comp-page.html'
})
export class AssemblyComponentPage extends BasePage implements OnInit {
    protected asmId: number;
    protected assembly: AssemblyModel;

    @ViewChild(AssemblyComponentListComponent) list: AssemblyComponentListComponent;

    constructor(route: ActivatedRoute, private assemblyService: AssemblyService) {
        super(route);
    }

    ngOnInit(): void {
        super.ngOnInit();
        this.asmId = +this.route.snapshot.params['asmId'];
        this.assemblyService.get(this.asmId).subscribe(
            model => this.assembly = model,
            error => this.error = error
        );
    }

    onDeleteDone() {
        this.list.onRefresh();
    }
}
