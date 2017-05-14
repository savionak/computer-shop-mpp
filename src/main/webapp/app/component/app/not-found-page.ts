import {Component, OnDestroy, OnInit} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

@Component({
    selector: 'not-found',
    templateUrl: './not-found-page.html'
})
export class NotFoundPage implements OnInit, OnDestroy {
    private path: string = null;
    private sub: Subscription;

    constructor(private router: Router) {

    }

    ngOnInit(): void {
        this.sub = this.router.events.subscribe(
            event => {
                if (event instanceof NavigationEnd) {
                    this.path = event.url;
                }
            }
        );
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }
}
