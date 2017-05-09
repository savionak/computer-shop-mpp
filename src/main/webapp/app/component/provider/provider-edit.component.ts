import {Component} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderModel} from "../../model/full/provider-model";
import {EditComponent} from "../base/edit.component";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";


@Component({
    selector: 'provider-edit',
    templateUrl: './provider-edit.component.html'
})
export class ProviderEditComponent extends EditComponent<ProviderModel, ProviderBriefModel>{

    constructor(service: ProviderService) {
        super(service);
    }
}
