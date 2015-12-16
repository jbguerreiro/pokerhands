;(function($){

		Dootax = window.Dootax || {};

		Dootax.init = function(){};
		
		Dootax.ready = function(){

			// Alerts

			$('a.modal').on('click', function (e) {
				e.preventDefault();
				modal( $(this).attr('href') );
			});

			function modal(thisModal)
			{
				$('div.modal').fadeOut();
				$(thisModal).fadeIn();

				$('div.modal.alert .overlay').on('click', function (e) {
					e.preventDefault();
					$(thisModal).fadeOut();
				});

				$('div.modal .buttons .btn').on('click', function (e) {
					e.preventDefault();
					$(thisModal).fadeOut();
				});

			}

		};

		Dootax.load = function(){
			
		};

		$(window).on('ready', Dootax.ready);
		$(window).on('load', Dootax.load);

})(jQuery);

function modal(thisModal)
{
	$('div.modal').fadeOut();
	$(thisModal).fadeIn();

	$('div.modal.alert .overlay').on('click', function (e) {
		e.preventDefault();
		$(thisModal).fadeOut();
	});

	$('div.modal .buttons .btn').on('click', function (e) {
		e.preventDefault();
		$(thisModal).fadeOut();
	});

}