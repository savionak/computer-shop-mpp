import {Component, EventEmitter, Output} from "@angular/core";
import {RemovedListComponent} from "../base/removed-list.component";

import {UserBriefModel} from "../../model/brief/user-brief-model";
import {UserAuthModel} from "../../model/full/user-auth-model";
import {UserAuthService} from "../../service/user-auth.service";


@Component({
    selector: 'user-removed-list',
    templateUrl: './user-removed-list.component.html'
})
export class UserRemovedListComponent extends RemovedListComponent<UserAuthModel, UserBriefModel> {
    @Output('onDrop') dropCallBack: EventEmitter<number> = new EventEmitter();

    constructor(private userService: UserAuthService) {
        super(userService);
    }

    onDrop(model: UserBriefModel) {
        if (confirm("DROP User with id = " + model.id + " ?")) {
            if (confirm("Are You Sure ?")) {
                this.userService.drop(model.id).subscribe(
                    () => {
                        this.dropCallBack.emit(model.id);
                        this.onRefresh();
                    },
                    error => this.errorCallback.emit(error)
                )
            }
        }
    }
}
