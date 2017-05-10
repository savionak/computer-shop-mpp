import {Component} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {UserAuthModel, Role} from "../../model/full/user-auth-model";
import {UserBriefModel} from "../../model/brief/user-brief-model";
import {UserAuthService} from "../../service/user-auth.service";
import {UserInfoModel} from "../../model/full/user-info-model";
import {Subscription} from "rxjs/Rx";


@Component({
    selector: 'user-edit',
    templateUrl: './user-edit.component.html'
})
export class UserEditComponent extends EditComponent<UserAuthModel, UserBriefModel>{

    rolesNames :string[] = ["MANAGER", "DIRECTOR", "ADMIN"];
     roles: Role[] = [Role.MANAGER, Role.ADMIN, Role.DIRECTOR];
    constructor(service: UserAuthService) {
        super(service);
    }


}
