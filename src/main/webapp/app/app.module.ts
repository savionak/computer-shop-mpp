import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";
import {Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {ComponentTypesListComponent} from "./component-types/component-type-list.component";
import {ProviderListComponent} from "./provider/provider-list.component";
import {HomeComponent} from "./home.component";

const appRoutes: Routes =[
    { path: '', component: HomeComponent},
    { path: 'component', component: ComponentTypesListComponent},
    { path: 'provider', component: ProviderListComponent }
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
        HomeComponent
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}
