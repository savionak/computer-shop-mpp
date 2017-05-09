import {EventEmitter, OnInit, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";

// T - FullDto, U - BriefDto
export class ReadOnlyListComponent<T extends BaseModel, U> implements OnInit {
    protected modelsList: U[];

    @Output('onView') viewCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onError') errorCallBack: EventEmitter<string> = new EventEmitter();

    constructor(private service: CrudService<T, U>) {
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

    protected refreshList() {
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
