import {Component} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {AssemblyModel} from "../../model/full/assembly-model";
import {AssemblyBriefModel} from "../../model/brief/assembly-brief-model";
import {AssemblyService} from "../../service/assembly.service";


@Component({
    selector: 'asm-edit',
    templateUrl: './assembly-edit.component.html'
})
export class AssemblyEditComponent extends EditComponent<AssemblyModel, AssemblyBriefModel> {

    constructor(service: AssemblyService) {
        super(service);
    }

}
