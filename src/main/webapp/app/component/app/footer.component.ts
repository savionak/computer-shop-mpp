import { Component} from '@angular/core';

@Component({
    selector: 'footer',
    template: `
	<div id="footer" class="top-space">

		<div class="footer1">
			<div class="container">
				<div class="row">

					<div class="col-md-3 widget">
						<h3 class="widget-title">Contact</h3>
						<div class="widget-body">
							<p>+375 29 9873237<br>
								<a href="mailto:#">computer.shop@gmail.com</a><br>
								6 Gikalo, belarus, 220020
							</p>

							<p >
								Copyright &copy; 2017, Savenok, Sandul.
							</p>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
`
})
export class FooterComponent { }