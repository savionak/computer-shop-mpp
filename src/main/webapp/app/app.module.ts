import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";
import {RouterModule, Routes} from "@angular/router";

import {AppComponent} from "./component/app/app.component";

import {CanActivateViaOAuthGuard} from "./shared/can-activate-guard";

import {HeaderComponent} from "./component/app/header.component";
import {FooterComponent} from "./component/app/footer.component";
import {LoginComponent} from "./component/login/login.component";

import {ProviderPage} from "./component/provider/provider-page";
import {ProviderListComponent} from "./component/provider/provider-list.component";
import {ProviderRemovedListComponent} from "./component/provider/provider-removed-list.component";
import {ProviderEditComponent} from "./component/provider/provider-edit.component";

import {ComponentTypePage} from "./component/comp-type/comp-type-page";
import {ComponentTypesListComponent} from "./component/comp-type/comp-type-list.component";
import {ComponentTypeRemovedListComponent} from "./component/comp-type/comp-type-removed-list.component";
import {ComponentTypeEditComponent} from "./component/comp-type/comp-type-edit.component";

import {ComponentModelPage} from "./component/comp-model/comp-model-page";
import {ComponentModelListComponent} from "./component/comp-model/comp-model-list.component";
import {ComponentModelRemovedListComponent} from "./component/comp-model/comp-model-removed-list.component";
import {ComponentModelEditComponent} from "./component/comp-model/comp-model-edit.component";

import {CustomerPage} from "./component/customer/customer-page";
import {CustomerRemovedListComponent} from "./component/customer/customer-removed-list.component";
import {CustomerListComponent} from "./component/customer/customer-list.component";
import {CustomerEditComponent} from "./component/customer/customer-edit.component";

import {ImportListComponent} from "./component/import/import-list.component";
import {ImportEditComponent} from "./component/import/import-edit.component";
import {ImportPage} from "./component/import/import-page";
import {ComponentStorePage} from "./component/comp-store/comp-store-page";
import {ComponentStoreListComponent} from "./component/comp-store/comp-store-list.component";


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
                path: 'provider',
                component: ProviderPage
            },
            {
                path: 'type',
                component: ComponentTypePage
            },
            {
                path: 'model',
                component: ComponentModelPage
            },
            {
                path: 'customer',
                component: CustomerPage
            },
            {
                path: 'import',
                component: ImportPage
            },
            {
                path: 'store',
                component: ComponentStorePage
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
        ComponentTypeRemovedListComponent,
        ComponentTypeEditComponent,

        ComponentModelPage,
        ComponentModelListComponent,
        ComponentModelRemovedListComponent,
        ComponentModelEditComponent,

        CustomerPage,
        CustomerListComponent,
        CustomerRemovedListComponent,
        CustomerEditComponent,

        ImportPage,
        ImportListComponent,
        ImportEditComponent,

        ComponentStorePage,
        ComponentStoreListComponent
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {

}
