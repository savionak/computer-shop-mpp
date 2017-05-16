import {Component, EventEmitter, Output} from "@angular/core";

import {EditComponent} from "../base/edit.component";
import {Role, UserAuthModel} from "../../model/full/user-auth-model";
import {UserBriefModel} from "../../model/brief/user-brief-model";
import {UserAuthService} from "../../service/user-auth.service";
import {UpdateUserPass} from "../../model/helper/update-user-pass";


@Component({
    selector: 'user-edit',
    templateUrl: './user-edit.component.html'
})
export class UserEditComponent extends EditComponent<UserAuthModel, UserBriefModel> {
    @Output('onUpdatePass') updatePassCallBack: EventEmitter<null> = new EventEmitter();

    roles: string[] = Object.keys(Role).filter((v) => +v !== +v);

    private updatePassModel: UpdateUserPass = null;

    constructor(private _service: UserAuthService) {
        super(_service);
    }

    onStartChangePass(model: UserAuthModel) {
        this.updatePassModel = new UpdateUserPass(model.id);
    }

    onCancelChangePass() {
        this.updatePassModel = null;
    }

    onChangePass() {
        this._service.updatePass(this.updatePassModel)
            .subscribe(
                () => {
                    this.updatePassCallBack.emit();
                    this.updatePassModel = null;
                },
                error => this.errorCallback.emit(error)
            )
    }
}
