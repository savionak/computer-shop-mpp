import {Component} from "@angular/core";

import {HttpOAuthService} from "../../shared/http-oauth.service";
import {ProviderService} from "../../service/provider.service";
import {ComponentTypeService} from "../../service/component-type.service";

@Component({
    selector: 'app',
    template: `
        <header></header>
        <router-outlet></router-outlet>
        <router-outlet id="popup"></router-outlet>
        <footer></footer>
    `,
    providers: [
        HttpOAuthService,
        ComponentTypeService,
        ProviderService
    ]
})
export class AppComponent {

}
