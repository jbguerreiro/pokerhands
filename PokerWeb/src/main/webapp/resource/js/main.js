;(function($){

		Dootax = window.Dootax || {};

		Dootax.init = function(){};
		
		Dootax.ready = function(){

			$('.submenu a.item').on('click', function (e) {
				e.preventDefault();
				$('.submenu a.item').removeClass('active');
				$(this).addClass('active');
				$('.header')
					.removeClass('doodoc')
					.removeClass('doolivery')
					.removeClass('doocalc')
					.addClass($(this).attr('id'));
				$('.main-bottom')
					.removeClass('doodoc')
					.removeClass('doolivery')
					.removeClass('doocalc')
					.addClass($(this).attr('id'));
			});

			$('.collapse a').on('click', function (e) {
				e.preventDefault();
				$(this).closest('li').children('ul').slideToggle('slow');
			});
			
		};

		Dootax.load = function(){};

		$(window).on('ready', Dootax.ready);
		$(window).on('load', Dootax.load);
		
		
		
})(jQuery);