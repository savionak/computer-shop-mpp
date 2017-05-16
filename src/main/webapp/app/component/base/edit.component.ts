import {EventEmitter, Input, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";


export class EditComponent<T extends BaseModel, U> {
    private service: CrudService<T, U>;

    @Input() isEmbedded: boolean = false;
    @Input() isViewing: boolean;
    @Input() isEditing: boolean;
    model: T;

    @Input('model')
    set setModel(model: T) {
        this.model = model;
        this.onModelSet(model);
    }

    @Output('onAdd') addCallback: EventEmitter<T> = new EventEmitter();
    @Output('onSave') saveCallback: EventEmitter<T> = new EventEmitter();
    @Output('onCancel') cancelCallback: EventEmitter<null> = new EventEmitter();
    @Output('onError') errorCallback: EventEmitter<any> = new EventEmitter();

    constructor(service: CrudService<T, U>) {
        this.service = service;
    }

    onAction(): void {
        if (this.isViewing) {
            return;
        }

        if (this.isEditing) {
            this.update();
        } else {
            this.add();
        }
    }

    onClose(): void {
        this.cancelCallback.emit();
    }

    compareBriefModel(t1: T, t2: T): boolean {
        return t1 && t2 ? t1.id === t2.id : t1 === t2;
    }

    protected update(): void {
        this.service.update(this.model.id, this.model)
            .subscribe(
                (res) => {
                    this.saveCallback.emit(res);
                },
                (error) => {
                    this.errorCallback.emit(error);
                }
            );
    }

    protected add(): void {
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

    protected onModelSet(model: T) {

    }
}
