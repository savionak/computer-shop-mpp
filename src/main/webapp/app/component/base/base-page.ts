import {OnInit} from "@angular/core";

import {ActivatedRoute} from "@angular/router";

export class BasePage implements OnInit {
    protected route: ActivatedRoute;
    protected error: string;
    protected isReadOnly: boolean;

    constructor(route: ActivatedRoute) {
        this.route = route;
    }

    ngOnInit(): void {
        let type = this.route.snapshot.params['type'];
        alert(type);
        switch (type) {
            case 'view':
                this.isReadOnly = true;
                break;
            case 'edit':
                this.isReadOnly = false;
                break;
            default:
                alert("404!");
        }
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
