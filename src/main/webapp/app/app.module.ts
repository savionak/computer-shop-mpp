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

const appRoutes: Routes = [
    {path: 'component', component: ComponentTypesListComponent},
    {path: 'provider', component: ProviderListComponent},
    {path: 'login', component: LoginComponent}
];
@NgModule({
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes, {useHash: true}),
        FormsModule,
        HttpModule,
        JsonpModule
    ],
    declarations: [
        AppComponent,
        ComponentTypesListComponent,
        ProviderListComponent,
        FooterComponent,
        HeaderComponent,
        LoginComponent

    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}
