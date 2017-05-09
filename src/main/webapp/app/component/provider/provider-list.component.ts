import {Component, EventEmitter, OnInit, Output} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderBriefModel} from "../../model/brief/provider-brief-model";


@Component({
    selector: 'provider-list',
    templateUrl: './provider-list.component.html'
})
export class ProviderListComponent implements OnInit {
    private service: ProviderService;
    protected modelsList: ProviderBriefModel[];

    @Output('onView') viewCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onAdd') addCallBack: EventEmitter<null> = new EventEmitter();
    @Output('onEdit') editCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onDelete') deleteCallBack: EventEmitter<number> = new EventEmitter();
    @Output('onError') errorCallBack: EventEmitter<string> = new EventEmitter();

    constructor(service: ProviderService) {
        this.service = service;
    }

    ngOnInit() {
        this.refreshList();
    }

    onRefresh(): void {
        alert('Refresh list');
        this.refreshList();
    }

    onViewDetails(model: ProviderBriefModel): void {
        this.viewCallBack.emit(model.id);
    }

    onAdd(): void {
        this.addCallBack.emit(null);
    }

    onEdit(model: ProviderBriefModel): void {
        this.editCallBack.emit(model.id);
    }

    onDelete(model: ProviderBriefModel): void {
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
