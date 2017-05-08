import { Component} from '@angular/core';

@Component({
    selector: 'home-app',

    template: `

	<div class="container">
	<div class="home-container">
		<br>
		<br>
        <!--<login></login>-->
        <router-outlet></router-outlet>
		<div class="row">
		</div>
        </div>
    </div>
    
`
})
export class HomeComponent { }