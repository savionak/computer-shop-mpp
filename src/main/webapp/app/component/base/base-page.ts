import {OnDestroy, OnInit} from "@angular/core";

import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {ACCESS, EDIT, VIEW} from "../../shared/route-consts";

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
                let type = x[ACCESS];
                // alert(type);
                switch (type) {
                    case VIEW:
                        this.isReadOnly = true;
                        break;
                    case EDIT:
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
