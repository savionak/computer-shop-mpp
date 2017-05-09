import {EventEmitter, OnInit, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";

// T - FullDto, U - BriefDto
export class ListComponent<T extends BaseModel, U> implements OnInit {
    private service: CrudService<T, U>;
    protected modelsList: U[];

    @Output('onView') viewCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onAdd') addCallBack: EventEmitter<null> = new EventEmitter();
    @Output('onEdit') editCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onDelete') deleteCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onError') errorCallBack: EventEmitter<string> = new EventEmitter();

    constructor(service: CrudService<T, U>) {
        this.service = service;
    }

    ngOnInit() {
        this.refreshList();
    }

    onRefresh(): void {
        // alert('Refresh list');
        this.refreshList();
    }

    onViewDetails(model: T): void {
        this.viewCallBack.emit(model.id);
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

    private refreshList() {
        this.service.getList()
            .subscribe(
                (page) => {
                    this.modelsList = page.content
                },
                (error) => {
                    this.errorCallBack.emit(error);
                }
            )
    }
}
