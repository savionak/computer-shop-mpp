import {Component} from "@angular/core";
import {RemovedListComponent} from "../base/removed-list.component";

import {UserBriefModel} from "../../model/brief/user-brief-model";
import {UserAuthModel} from "../../model/full/user-auth-model";
import {UserAuthService} from "../../service/user-auth.service";


@Component({
    selector: 'user-removed-list',
    templateUrl: './user-removed-list.component.html'
})
export class UserRemovedListComponent extends RemovedListComponent<UserAuthModel, UserBriefModel> {
    constructor(service: UserAuthService) {
        super(service);
    }
}
