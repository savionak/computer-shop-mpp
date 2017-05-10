import {Component} from "@angular/core";

import {ListComponent} from "../base/list.component";
import {UserBriefModel} from "../../model/brief/user-brief-model";
import {UserAuthService} from "../../service/user-auth.service";
import {UserAuthModel} from "../../model/full/user-auth-model";


@Component({
    selector: 'user-list',
    templateUrl: './user-list.component.html'
})
export class UserListComponent extends ListComponent<UserAuthModel, UserBriefModel> {

    constructor(service: UserAuthService) {
        super(service);
    }

    protected getEmptyModel(): UserAuthModel {
        return UserAuthModel.empty();
    }
}
