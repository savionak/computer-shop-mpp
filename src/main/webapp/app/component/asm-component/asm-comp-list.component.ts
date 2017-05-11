import {Component, Input} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {AssemblyComponentModel} from "../../model/full/assembly-component-model";
import {AssemblyComponentService} from "../../service/assembly-component.service";
import {AssemblyComponentBriefModel} from "../../model/brief/assembly-component-brief-model";


@Component({
    selector: 'asm-comp-list',
    templateUrl: './asm-comp-list.component.html'
})
export class AssemblyComponentListComponent extends ListComponent <AssemblyComponentModel, AssemblyComponentBriefModel> {
    @Input() assemblyId: number;

    constructor(private asmCompService: AssemblyComponentService) {
        super(asmCompService);
    }

    protected getEmptyModel(): AssemblyComponentModel {
        let result = AssemblyComponentModel.empty();
        result.assemblyId = this.assemblyId;
        return result;
    }

    // override service methods

    protected refreshList(): void {
        this.asmCompService.getList(this.assemblyId + '')
            .subscribe(
                page => {
                    this.modelsList = page.content
                },
                error => {
                    this.errorCallBack.emit(error);
                }
            )
    }

    protected loadModel(id: number): any {
        this.asmCompService.get(id, this.assemblyId + '').subscribe(
            res => {
                this.model = res
            },
            error => {
                this.errorCallBack.emit(error);
            }
        )
    }

    protected remove(id: number): any {
        this.asmCompService.remove(id, this.assemblyId + '')
            .subscribe(
                () => {
                    this.onRefresh();
                    this.deleteCallBack.emit(id);
                },
                (error) => {
                    this.errorCallBack.emit(error);
                }
            );
    }
}
