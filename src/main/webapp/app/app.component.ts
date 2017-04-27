import {Component} from "@angular/core";
import {HttpOAuthService} from "./shared/oauth-http-client/http-oauth.service";

@Component({
    selector: 'app',
    template:
    `
        <provider-list></provider-list>
        <!--<comp-type-list></comp-type-list>-->
    `,
    providers:[HttpOAuthService]
})
export class AppComponent {

}
