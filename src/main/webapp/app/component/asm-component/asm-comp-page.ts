import {Component, OnInit, ViewChild} from "@angular/core";

import {AssemblyComponentListComponent} from "./asm-comp-list.component";
import {ActivatedRoute, Router} from "@angular/router";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyService} from "../../service/assembly.service";
import {BasePage} from "../base/base-page";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {AssemblyComponentModel} from "../../model/full/assembly-component-model";

@Component({
    selector: 'asm-comp-page',
    templateUrl: './asm-comp-page.html'
})
export class AssemblyComponentPage extends BasePage implements OnInit {
    protected asmId: number;
    protected assembly: AssemblyModel;

    @ViewChild(AssemblyComponentListComponent) list: AssemblyComponentListComponent;

    constructor(authService: HttpOAuthService, r: Router, route: ActivatedRoute, private assemblyService: AssemblyService,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
    }

    ngOnInit(): void {
        super.ngOnInit();
        this.asmId = +this.route.snapshot.params['asmId'];
        this.assemblyService.get(this.asmId).subscribe(
            model => this.assembly = model,
            error => this.popConnectionError()
        );
    }

    getOperationErrorMessage() {
        return this.COMPONENTS_ERROR_MSG;
    }

    onAsmSave(model: AssemblyModel) {
        this.popSuccess('Сборка обновлена');
    }

    onComponentAdd(model: AssemblyComponentModel) {
        this.popSuccess('Компонент добавлен');
    }

    onComponentSave(model: AssemblyComponentModel) {
        this.popSuccess('Компонент обновлен');
    }

    onDeleteDone() {
        this.popSuccess('Компонент удален из сборки');
        this.list.onRefresh();
    }
}
