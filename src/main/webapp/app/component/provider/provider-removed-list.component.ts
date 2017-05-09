import {Component} from "@angular/core";
import {ProviderService} from "../../service/provider.service";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";
import {RemovedListComponent} from "../base/removed-list.component";
import {ProviderModel} from "../../model/full/provider-model";


@Component({
    selector: 'provider-removed-list',
    templateUrl: './provider-removed-list.component.html'
})
export class ProviderRemovedListComponent extends RemovedListComponent<ProviderModel, ProviderBriefModel> {
    constructor(service: ProviderService) {
        super(service);
    }
}
