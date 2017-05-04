import {Component} from "@angular/core";

import {ProviderModel} from "../shared/models/full/provider-model";
import {ProviderService} from "./provider.service";
import {ProviderBriefModel} from "../shared/models/brief/provider-brief-model";
import {AbstractListComponent} from "../shared/list.component";

@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html',
    providers: [    // local provider -- created for each component <= replace with global
        ProviderService
    ]
})
export class ProviderListComponent extends AbstractListComponent<ProviderModel, ProviderBriefModel> {

    constructor(private componentTypeService: ProviderService) {
        super(componentTypeService);
    }

    getEmptyModel(): ProviderModel {
        return ProviderModel.empty();
    }

}
