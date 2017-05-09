import {EventEmitter, Output} from "@angular/core";
import {BaseModel} from "../../model/base-model";
import {ReadOnlyListComponent} from "./read-only-list.component";
import {SoftDeleteService} from "../../service/base/soft-delete.service";

// T - FullDto, U - BriefDto
export class RemovedListComponent<T extends BaseModel, U> extends ReadOnlyListComponent<T, U> {
    @Output('onRestore') restoreCallBack: EventEmitter<number> = new EventEmitter();

    constructor(private _service: SoftDeleteService<T, U>) {
        super(_service);
    }

    refreshList() {
        this._service.getRemovedList()
            .subscribe(
                page => {
                    this.modelsList = page.content
                },
                error => {
                    this.errorCallBack.emit(error);
                }
            )
    }

    onRestore(model: T): void {
        this._service.restore(model.id)
            .subscribe(
                () => {
                    this.refreshList();
                    this.restoreCallBack.emit(model.id);
                },
                error => {
                    this.errorCallBack.emit(error);
                }
            );

    }
}
