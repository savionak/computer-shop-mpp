import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";

import {AppComponent} from "./app.component";
import {ComponentTypesListComponent} from "./components/componentTypesList.component";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule
    ],
    declarations: [
        AppComponent,
        ComponentTypesListComponent
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule { }
