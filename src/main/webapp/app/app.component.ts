import {Component} from "@angular/core";
import {HttpOAuthService} from "./shared/http-oauth.service";

@Component({
    selector: 'app',
    template: `
            <header></header>
            <home-app></home-app>
            <footer></footer>
    `,
    providers: [HttpOAuthService]
})
export class AppComponent {

}
