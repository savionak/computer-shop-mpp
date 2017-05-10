import {Component, Input} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyBriefModel} from "../../model/brief/assembly-brief-model";
import {AssemblyService} from "../../service/assembly.service";


@Component({
    selector: 'asm-list',
    templateUrl: './assembly-list.component.html'
})
export class AssemblyListComponent extends ListComponent <AssemblyModel, AssemblyBriefModel> {
    @Input() orderId: number;

    constructor(private asmService: AssemblyService) {
        super(asmService);
    }

    protected getEmptyModel(): AssemblyModel {
        let result = AssemblyModel.empty();
        result.order.id = this.orderId;
        return result;
    }

    refreshList() {
        this.asmService.getListByOrderId(this.orderId).subscribe(
            page => {
                this.modelsList = page.content
            },
            error => {
                this.errorCallBack.emit(error)
            }
        );
    }

    onViewDetails(model: AssemblyModel): void {
        alert("VIEW ASSEMBLY!");
        // TODO: view components list
    }

    onEdit(model: AssemblyModel): void {
        alert("EDIT ASM!");
        // TODO: edit components list
    }
}
