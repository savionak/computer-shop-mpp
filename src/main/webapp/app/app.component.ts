import {Component} from "@angular/core";
import {HttpOAuthService} from "./shared/http-oauth.service";

@Component({
    selector: 'app',
    template: `
      <div>
         <nav>
             <a routerLink="/provider">Providers</a>
             <a routerLink="/component">Components Types</a>
         </nav>
         <router-outlet></router-outlet>
      </div>
    `,
    providers: [HttpOAuthService]
})
export class AppComponent {

}
