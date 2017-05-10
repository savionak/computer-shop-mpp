import {Component} from "@angular/core";

import {HttpOAuthService} from "../../shared/http-oauth.service";
import {ProviderService} from "../../service/provider.service";
import {ComponentTypeService} from "../../service/component-type.service";
import {ComponentModelService} from "../../service/component-model.service";

import {CustomerService} from "../../service/customer.service";
import {ImportService} from "../../service/import.service";
import {ComponentStoreService} from "../../service/component-store.service";
import {OrderService} from "../../service/order.service";
import {AssemblyService} from "../../service/assembly.service";
import {UserAuthService} from "../../service/user-auth.service";


@Component({
    selector: 'app',
    template: `
        <header></header>
        <router-outlet></router-outlet>
        <!--<footer></footer>-->
    `,
    providers: [
        HttpOAuthService,

        ProviderService,
        ComponentTypeService,
        ProviderService,
        ComponentModelService,
        CustomerService,
        ImportService,
        ComponentStoreService,
        OrderService,
        AssemblyService,
        UserAuthService
    ]
})
export class AppComponent {

}
