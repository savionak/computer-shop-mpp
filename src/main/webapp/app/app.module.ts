import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";
import {RouterModule, Routes} from "@angular/router";

import {AppComponent} from "./component/app/app.component";
import {ComponentTypesListComponent} from "./component/component-types/component-type-list.component";
import {ProviderListComponent} from "./component/provider/provider-list.component";
import {FooterComponent} from "./component/app/footer.component";
import {HeaderComponent} from "./component/app/header.component";
import {LoginComponent} from "./component/login/login.component";
import {CanActivateViaOAuthGuard} from "./shared/can-activate-guard";
import {ProviderEditComponent} from "./component/provider/provider-edit.component";
import {ProviderPage} from "./component/provider/provider-page";
import {ComponentTypePage} from "./component/component-types/component-type-page";
import {ComponentTypeEditComponent} from "./component/component-types/component-type-edit.component";
import {ProviderRemovedListComponent} from "./component/provider/provider-removed-list.component";

const appRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: '',
        canActivate: [CanActivateViaOAuthGuard],
        children: [
            {
                path: 'type',
                component: ComponentTypePage
            },
            {
                path: 'provider',
                component: ProviderPage
            }
        ]
    }
];

@NgModule({
    providers: [
        CanActivateViaOAuthGuard
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes, {useHash: true}),
        FormsModule,
        HttpModule,
        JsonpModule
    ],
    declarations: [
        AppComponent,

        FooterComponent,
        HeaderComponent,
        LoginComponent,

        ProviderPage,
        ProviderListComponent,
        ProviderRemovedListComponent,
        ProviderEditComponent,

        ComponentTypePage,
        ComponentTypesListComponent,
        ComponentTypeEditComponent
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {

}
