import {Component, Input, OnDestroy, OnInit} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {Subscription} from "rxjs/Subscription";
import {AssemblyComponentBriefModel} from "../../model/brief/assembly-component-brief-model";
import {AssemblyComponentModel} from "../../model/full/assembly-component-model";
import {AssemblyComponentService} from "../../service/assembly-component.service";
import {ComponentStoreService} from "../../service/component-store.service";
import {ComponentStoreBriefModel} from "../../model/brief/component-store-brief-model";


@Component({
    selector: 'asm-comp-edit',
    templateUrl: './asm-comp-edit.component.html'
})
export class AssemblyComponentEditComponent extends EditComponent<AssemblyComponentModel, AssemblyComponentBriefModel> implements OnInit, OnDestroy {
    private storeList: ComponentStoreBriefModel[];
    private sub: Subscription;
    @Input() asmId: number;

    constructor(private _service: AssemblyComponentService, private storeService: ComponentStoreService) {
        super(_service);
    }

    ngOnInit(): void {
        this.sub = this.storeService.getList().subscribe(
            page => {
                this.storeList = page.content;
            },
            error => {
                this.errorCallback.emit(error);
            }
        );
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    protected update(): void {
        this._service.update(this.model.id, this.model, this.asmId + '').subscribe(
            (res) => {
                this.editCallback.emit(res);
            },
            (error) => {
                this.errorCallback.emit(error);
            }
        );
    }

    protected add(): void {
        console.log(this.model);
        this._service.add(this.model, this.asmId + '').subscribe(
            (res) => {
                this.addCallback.emit(res);
            },
            (error) => {
                this.errorCallback.emit(error);
            }
        );
    }
}
