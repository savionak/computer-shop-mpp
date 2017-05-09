import {Component} from "@angular/core";
import {HttpOAuthService} from "../../shared/http-oauth.service";

@Component({
    selector: 'app',
    template: `
        <header></header>
        <router-outlet></router-outlet>
        <router-outlet id="popup"></router-outlet>
        <footer></footer>
    `,
    providers: [
        HttpOAuthService
    ]
})
export class AppComponent {

}
