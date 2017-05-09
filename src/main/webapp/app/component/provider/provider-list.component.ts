import {Component} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {AbstractListComponent} from "../app/list.component";
import {ProviderModel} from "../../model/full/provider-model";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";


@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html'
})
export class ProviderListComponent extends AbstractListComponent<ProviderModel, ProviderBriefModel> {

    constructor(private componentTypeService: ProviderService) {
        super(componentTypeService);
    }

    getEmptyModel(): ProviderModel {
        return ProviderModel.empty();
    }

}
