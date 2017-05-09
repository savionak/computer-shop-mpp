import {EventEmitter, OnInit, Output} from "@angular/core";
import {CrudService} from "../../service/base/crud.service";
import {BaseModel} from "../../model/base-model";

// T - FullDto, U - BriefDto
export abstract class ReadOnlyListComponent<T extends BaseModel, U> implements OnInit {
    public error: string;

    protected modelsList: U[];
    protected model: T = null;
    protected isViewing: boolean = true;

    @Output('onError') errorCallBack: EventEmitter<string> = new EventEmitter();

    constructor(private service: CrudService<T, U>) {
        this.service = service;
    }

    ngOnInit() {
        this.onRefresh();
    }

    onRefresh(): void {
        this.refreshList();
    }

    onViewDetails(model: T): void {
        this.isViewing = true;
        this.loadModel(model.id);
    }

    onCancel() {
        this.closeDialog();
        this.onRefresh();
    }

    onError(error: string) {
        this.errorCallBack.emit(error);
    }

    protected refreshList() {
        this.service.getList()
            .subscribe(
                page => {
                    this.modelsList = page.content
                },
                error => {
                    this.errorCallBack.emit(error);
                }
            )
    }

    protected loadModel(id: number) {
        this.service.get(id).subscribe(
            res => {
                this.model = res
            },
            error => {
                this.errorCallBack.emit(error);
            }
        )
    }

    protected closeDialog() {
        this.model = null;
    }
}
