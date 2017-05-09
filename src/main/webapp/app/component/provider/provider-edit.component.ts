import {Component, EventEmitter, Input, Output} from "@angular/core";

import {ProviderService} from "../../service/provider.service";
import {ProviderModel} from "../../model/full/provider-model";


@Component({
    selector: 'provider-edit',
    templateUrl: './provider-edit.component.html'
})
export class ProviderEditComponent {
    private service: ProviderService;

    @Input() isViewing: boolean;
    @Input() isEditing: boolean;
    @Input() model: ProviderModel;

    @Output('onAdd') addCallback: EventEmitter<ProviderModel> = new EventEmitter();
    @Output('onEdit') editCallback: EventEmitter<ProviderModel> = new EventEmitter();
    @Output('onCancel') cancelCallback: EventEmitter<null> = new EventEmitter();
    @Output('onError') errorCallback: EventEmitter<string> = new EventEmitter();

    constructor(service: ProviderService) {
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

    onCancel(): void {
        this.cancelCallback.emit();
    }
}
