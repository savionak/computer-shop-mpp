import {Component} from "@angular/core";

import {ProviderModel} from "./provider-model";
import {ProviderService} from "../../service/impl/provider.service";
import {ProviderBriefModel} from "./provider-brief-model";
import {AbstractListComponent} from "../list.component";

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
