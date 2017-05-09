import {Component} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";
import {ListComponent} from "../base/list.component";


@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html'
})
export class ProviderListComponent extends ListComponent<ProviderBriefModel, ProviderBriefModel> {

    constructor(service: ProviderService) {
        super(service);
    }
}
