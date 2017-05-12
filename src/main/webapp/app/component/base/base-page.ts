import {OnDestroy, OnInit} from "@angular/core";

import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

export class BasePage implements OnInit, OnDestroy {
    protected route: ActivatedRoute;
    protected error: string;
    protected isReadOnly: boolean;
    private sub: Subscription;

    constructor(route: ActivatedRoute) {
        this.route = route;
    }

    ngOnInit(): void {
        this.sub = this.route.params.subscribe(
            x => {
                let type = x['type'];
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
                    // TODO: navigate to 404
                }
            },
            error => this.error = error
        );
    }

    ngOnDestroy(): void {
        if (this.sub) {
            this.sub.unsubscribe();
        }
    }

    onError(error: string) {
        this.error = error;
    }

    onCloseError() {
        this.error = null;
    }
}
