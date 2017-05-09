import {EventEmitter, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";
import {ReadOnlyListComponent} from "./read-only-list.component";

// T - FullDto, U - BriefDto
export class ListComponent<T extends BaseModel, U> extends ReadOnlyListComponent<T, U> {

    @Output('onAdd') addCallBack: EventEmitter<null> = new EventEmitter();
    @Output('onEdit') editCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onDelete') deleteCallBack: EventEmitter<number> = new EventEmitter();

    constructor(service: CrudService<T, U>) {
        super(service);
    }

    onAdd(): void {
        this.addCallBack.emit(null);
    }

    onEdit(model: T): void {
        this.editCallBack.emit(model.id);
    }

    onDelete(model: T): void {
        this.deleteCallBack.emit(model.id);
    }
}
