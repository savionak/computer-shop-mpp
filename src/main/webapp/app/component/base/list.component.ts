import {EventEmitter, Input, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";
import {ReadOnlyListComponent} from "./read-only-list.component";

// T - FullDto, U - BriefDto
export abstract class ListComponent<T extends BaseModel, U> extends ReadOnlyListComponent<T, U> {
    private idToDelete: number = null;

    protected isEditing: boolean = false;
    @Input() isReadOnly: boolean = false;

    @Input('isReadOnly')
    set setReadOnly(value: boolean) {
        this.isReadOnly = value;
        this.isViewing = value;
    }

    @Output('onAdd') addCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onSave') saveCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onDelete') deleteCallBack: EventEmitter<number> = new EventEmitter();

    constructor(private _service: CrudService<T, U>) {
        super(_service);
    }

    protected abstract getEmptyModel(): T;

    protected getDeleteTitle(): string {
        return "Are you sure?";
    }

    onAdd(): void {
        this.isViewing = false;
        this.isEditing = false;
        this.model = this.getEmptyModel();
    }

    onAddDone(model: T) {
        this.onRefresh();
        this.addCallBack.emit(model.id);
        this.closeDialog();
    }

    onEdit(model: T): void {
        this.isViewing = false;
        this.isEditing = true;
        this.loadModel(model.id);
    }

    onEditDone(model: T) {
        this.onRefresh();
        this.saveCallBack.emit(model.id);
        this.closeDialog();
    }

    onDelete(model: T): void {
        this.idToDelete = model.id;
    }

    onDeleteOk() {
        if (this.idToDelete) {
            this.remove(this.idToDelete);
        }
        this.closePopup();
    }

    protected closePopup() {
        this.idToDelete = null;
    }

    protected remove(id: number) {
        this._service.remove(id)
            .subscribe(
                () => {
                    this.onRefresh();
                    this.deleteCallBack.emit(id);
                },
                (error) => {
                    this.errorCallback.emit(error);
                }
            );
    }
}
