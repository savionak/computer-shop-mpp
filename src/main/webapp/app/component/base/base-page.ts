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
        let urlSegments = this.route.snapshot.url;
        this.isReadOnly = urlSegments[1].toString() !== 'edit';
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
