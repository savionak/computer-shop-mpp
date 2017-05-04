import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";

import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";


import {HomeComponent} from "./home.component";
import {FooterComponent} from "./footer.component";
import {HeaderComponent} from "./header.component";


import {ProviderListComponent} from "./component/provider/provider-list.component";
import {ComponentTypesListComponent} from "./component/component-type/component-type-list.component";
import {LoginComponent} from "./component/login/login.component";

const appRoutes: Routes = [
    {path: 'component', component: ComponentTypesListComponent},
    {path: 'provider', component: ProviderListComponent},
    {path: 'login', component: LoginComponent}
];
@NgModule({
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes),
        FormsModule,
        HttpModule,
        JsonpModule
    ],
    declarations: [
        AppComponent,
        ComponentTypesListComponent,
        ProviderListComponent,
        HomeComponent,
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
