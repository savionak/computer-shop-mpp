import { Component} from '@angular/core';

@Component({
    selector: 'home-app',

    template: `
<div class="mycontainer">
         <div>         
        <ul class="nav nav-pills">
               <li role="presentation" class="active"><a href="">Home</a></li>
              <li role="presentation"><a routerLink="/provider">Providers</a></li>
              <li role="presentation"><a routerLink="/component">Components Types</a></li>
              <li role="presentation"><a routerLink="/login">Login</a></li>
        </ul>
        </div>
   <div>
           <router-outlet></router-outlet>
    </div>
    
</div>
      
`
})
export class HomeComponent { }