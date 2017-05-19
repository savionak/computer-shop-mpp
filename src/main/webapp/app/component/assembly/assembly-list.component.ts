import {Component, Input} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyBriefModel} from "../../model/brief/assembly-brief-model";
import {AssemblyService} from "../../service/assembly.service";
import {Router} from "@angular/router";
import {ASSEMBLY, EDIT, ORDER, VIEW} from "../../shared/route-consts";


@Component({
    selector: 'asm-list',
    templateUrl: './assembly-list.component.html'
})
export class AssemblyListComponent extends ListComponent <AssemblyModel, AssemblyBriefModel> {
    @Input() orderId: number;

    constructor(private asmService: AssemblyService, private router: Router) {
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
                this.errorCallback.emit(error)
            }
        );
    }

    onViewDetails(model: AssemblyModel): void {
        this.router.navigate([ORDER, VIEW, this.orderId, ASSEMBLY, model.id]);
    }

    onEdit(model: AssemblyModel): void {
        this.router.navigate([ORDER, EDIT, this.orderId, ASSEMBLY, model.id]);
    }
}
