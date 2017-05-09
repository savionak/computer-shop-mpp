import {Component} from "@angular/core";
import {ProviderService} from "../../service/provider.service";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";
import {RemovedListComponent} from "../base/removed-list.component";


@Component({
    selector: 'provider-removed-list',
    templateUrl: './provider-removed-list.component.html'
})
export class ProviderRemovedListComponent extends RemovedListComponent<ProviderBriefModel, ProviderBriefModel> {
    constructor(service: ProviderService) {
        super(service);
    }
}
