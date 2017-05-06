import { Component} from '@angular/core';

@Component({
    selector: 'header',
    template: `

		<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">

				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar">
					</span> <span class="icon-bar">
					</span> <span class="icon-bar">
					</span>
				 </button>
			<div class="navbar-header">
				<a class="navbar-brand" routerLink=""><img src="app/styles/logo.png" alt="MPP"></a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li ><a routerLink="provider">Provider</a></li>
					<li><a routerLink="component">ComponentType</a></li>
					<li><a class="btn" routerLink="login">Exit</a></li>
				</ul>
			</div>
		</div>
	</div>

`
})
export class HeaderComponent { }