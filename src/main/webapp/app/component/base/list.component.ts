import {EventEmitter, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";
import {ReadOnlyListComponent} from "./read-only-list.component";

// T - FullDto, U - BriefDto
export abstract class ListComponent<T extends BaseModel, U> extends ReadOnlyListComponent<T, U> {
    protected isEditing: boolean = false;

    @Output('onDelete') deleteCallBack: EventEmitter<number> = new EventEmitter();

    constructor(private _service: CrudService<T, U>) {
        super(_service);
    }

    protected abstract getEmptyModel(): T;

    onAdd(): void {
        this.isViewing = false;
        this.isEditing = false;
        this.model = this.getEmptyModel();
    }

    onAddDone(model: T) {
        this.onRefresh();
        this.closeDialog();
    }

    onEdit(model: T): void {
        this.isViewing = false;
        this.isEditing = true;
        this.loadModel(model.id);
    }

    onEditDone(model: T) {
        this.onRefresh();
        this.closeDialog();
    }

    onDelete(model: T): void {
        let id: number = model.id;
        if (confirm('Delete model with id = [' + id + '] ?')) {
            this._service.remove(id)
                .subscribe(
                    () => {
                        this.onRefresh();
                        this.deleteCallBack.emit(model.id);
                    },
                    (error) => {
                        this.errorCallBack.emit(error);
                    }
                );
        }
    }
}
