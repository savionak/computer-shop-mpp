import {EventEmitter, Input, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";


export class EditComponent<T extends BaseModel, U> {
    private service: CrudService<T, U>;

    @Input() isViewing: boolean;
    @Input() isEditing: boolean;
    @Input() model: T;

    @Output('onAdd') addCallback: EventEmitter<T> = new EventEmitter();
    @Output('onEdit') editCallback: EventEmitter<T> = new EventEmitter();
    @Output('onCancel') cancelCallback: EventEmitter<null> = new EventEmitter();
    @Output('onError') errorCallback: EventEmitter<string> = new EventEmitter();

    constructor(service: CrudService<T, U>) {
        this.service = service;
    }

    onAction(): void {
        if (this.isViewing) {
            alert('View only!');
            return;
        }

        if (this.isEditing) {
            this.service.update(this.model.id, this.model)
                .subscribe(
                    (res) => {
                        this.editCallback.emit(res);
                    },
                    (error) => {
                        this.errorCallback.emit(error);
                    }
                );
        } else {
            this.service.add(this.model)
                .subscribe(
                    (res) => {
                        this.addCallback.emit(res);
                    },
                    (error) => {
                        this.errorCallback.emit(error);
                    }
                );
        }
    }

    onClose(): void {
        this.cancelCallback.emit();
    }

    compareBriefModel(t1: BaseModel, t2: BaseModel): boolean {
        return t1 && t2 ? t1.id === t2.id : t1 === t2;
    }
}
