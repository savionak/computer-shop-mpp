import {Component, EventEmitter, Input, Output} from "@angular/core";

@Component({
    selector: 'popup',
    templateUrl: './popup.component.html'
})
export class Popup {
    @Input() title: string;

    @Output('onOk') okCallback: EventEmitter<null> = new EventEmitter();
    @Output('onCancel') cancelCallback: EventEmitter<null> = new EventEmitter();

    private onOk() {
        this.okCallback.emit();
    }

    private onCancel() {
        this.cancelCallback.emit();
    }
}