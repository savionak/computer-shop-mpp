import {Component, OnDestroy, OnInit, ViewChild} from "@angular/core";

import {AssemblyComponentListComponent} from "./asm-comp-list.component";
import {ActivatedRoute, Router} from "@angular/router";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyService} from "../../service/assembly.service";
import {BasePage} from "../base/base-page";
import {HttpOAuthService} from "../../shared/http-oauth.service";

import {ToasterService} from "angular2-toaster";
import {AssemblyComponentModel} from "../../model/full/assembly-component-model";
import {Subscription} from "rxjs/Subscription";
import {EDIT, ORDER} from "../../shared/route-consts";

@Component({
    selector: 'asm-comp-page',
    templateUrl: './asm-comp-page.html'
})
export class AssemblyComponentPage extends BasePage implements OnInit, OnDestroy {
    protected asmId: number;
    protected assembly: AssemblyModel;
    private routeSub: Subscription;

    @ViewChild(AssemblyComponentListComponent) list: AssemblyComponentListComponent;

    constructor(authService: HttpOAuthService, private r: Router, route: ActivatedRoute, private assemblyService: AssemblyService,
                toasterService: ToasterService) {
        super(authService, r, route, toasterService);
    }

    ngOnInit(): void {
        super.ngOnInit();
        this.routeSub = this.route.params.subscribe(
            p => {
                this.asmId = +p['asmId'];
                this.assemblyService.get(this.asmId).subscribe(
                    model => this.assembly = model,
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

    getOperationErrorMessage() {
        return this.COMPONENTS_ERROR_MSG;
    }

    onAsmSave(model: AssemblyModel) {
        this.popSuccess('Сборка обновлена');
        setTimeout(() => {
            this.goToAssemblies();
        }, 500);
    }

    goToAssemblies() {
        let orderId = this.assembly.order.id;
        this.r.navigate([ORDER, EDIT, orderId]);
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
