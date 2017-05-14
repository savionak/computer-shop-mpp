import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";
import {RouterModule, Routes} from "@angular/router";

import {AppComponent} from "./component/app/app.component";

import {HttpOAuthService} from "./shared/http-oauth.service";

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

import {ImportPage} from "./component/import/import-page";
import {ImportListComponent} from "./component/import/import-list.component";
import {ImportEditComponent} from "./component/import/import-edit.component";

import {ComponentStorePage} from "./component/comp-store/comp-store-page";
import {ComponentStoreListComponent} from "./component/comp-store/comp-store-list.component";

import {OrderPage} from "./component/order/order-page";
import {OrderListComponent} from "./component/order/order-list.component";
import {OrderCanceledListComponent} from "./component/order/order-canceled-list.component";
import {OrderEditComponent} from "./component/order/order-edit.component";

import {AssemblyPage} from "./component/assembly/assembly-page";
import {AssemblyListComponent} from "./component/assembly/assembly-list.component";
import {AssemblyEditComponent} from "./component/assembly/assembly-edit.component";

import {UserPage} from "./component/user/user-page";
import {UserListComponent} from "./component/user/user-list.component";
import {UserRemovedListComponent} from "./component/user/user-removed-list.component";
import {UserEditComponent} from "./component/user/user-edit.component";

import {AssemblyComponentPage} from "./component/asm-component/asm-comp-page";
import {AssemblyComponentListComponent} from "./component/asm-component/asm-comp-list.component";
import {AssemblyComponentEditComponent} from "./component/asm-component/asm-comp-edit.component";

import {CanActivateViaOAuthGuard} from "./shared/can-activate-guard";
import {CanActivateRoot} from "./shared/can-activate-root";

import {
    ACCESS,
    ASSEMBLY,
    CUSTOMER,
    IMPORT,
    LOGIN,
    MODEL,
    ORDER,
    PROVIDER,
    STORE,
    TYPE,
    USER
} from "./shared/route-consts";
import {NotFoundPage} from "./component/app/not-found-page";


const appRoutes: Routes = [
    {
        path: LOGIN,
        component: LoginComponent
    },
    {
        path: '',
        canActivate: [CanActivateRoot],
        pathMatch: 'full',
        children: []
    },
    {
        path: '',
        canActivate: [CanActivateViaOAuthGuard],
        canActivateChild: [CanActivateViaOAuthGuard],
        children: [
            {
                path: PROVIDER + '/:' + ACCESS,
                component: ProviderPage
            },
            {
                path: TYPE + '/:' + ACCESS,
                component: ComponentTypePage
            },
            {
                path: MODEL + '/:' + ACCESS,
                component: ComponentModelPage
            },
            {
                path: CUSTOMER + '/:' + ACCESS,
                component: CustomerPage
            },
            {
                path: IMPORT + '/:' + ACCESS,
                component: ImportPage
            },
            {
                path: STORE + '/:' + ACCESS,
                component: ComponentStorePage
            },
            {
                path: ORDER + '/:' + ACCESS + '/:id/' + ASSEMBLY + '/:asmId',
                component: AssemblyComponentPage
            },
            {
                path: ORDER + '/:' + ACCESS + '/:id',
                component: AssemblyPage
            },
            {
                path: ORDER + '/:' + ACCESS,
                component: OrderPage,
            },
            {
                path: USER + '/:' + ACCESS,
                component: UserPage
            },
            {
                path: '404',
                component: NotFoundPage
            },
            {
                path: '**',
                component: NotFoundPage
            }
        ]
    }
];

@NgModule({
    providers: [
        HttpOAuthService,
        CanActivateViaOAuthGuard,
        CanActivateRoot
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
        NotFoundPage,

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
        ComponentStoreListComponent,

        OrderPage,
        OrderListComponent,
        OrderCanceledListComponent,
        OrderEditComponent,

        AssemblyPage,
        AssemblyListComponent,
        AssemblyEditComponent,

        AssemblyComponentPage,
        AssemblyComponentListComponent,
        AssemblyComponentEditComponent,

        UserPage,
        UserListComponent,
        UserRemovedListComponent,
        UserEditComponent
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {

}
