;(function($){

		Dootax = window.Dootax || {};

		Dootax.init = function(){};
		
		Dootax.ready = function(){

			$('#btn-select-all > div').on('click', function (e) {
				if ( !$('.selectItemClass').is(':checked') ) {
					$('.selectItemClass').click();
					return false;
				}
				if ( $('.selectItemClass').length > 0 ) {
					$('.selectItemClass').removeAttr('checked');
					return false;
				}
			});


			$('#btn-filter-advanced').on('click', function (e) {
				e.preventDefault();
				$('#btn-filter').toggleClass('filter-advanced');
				$('.main').toggleClass('filter-advanced');
				$('#filter-advanced').slideToggle();
				$('#btn-filter-advanced img').toggleClass('flip');
			});

			$('#itens thead tr th').on('click', function (e) {
				e.preventDefault();

				if ( $(this).hasClass('sort-desc') ){
					$(this).removeClass('sort-desc').addClass('sort-asc');
				}

				else if ( $(this).hasClass('sort-asc') ){
					$(this).removeClass('sort-asc').addClass('sort-desc');
				}

				else if ( !$(this).hasClass('sort-asc') && !$(this).hasClass('sort-desc') ){
					$('#itens thead tr th').removeClass('sort-asc').removeClass('sort-desc');
					$(this).addClass('sort-asc');
				}

			});

			$('.dateCalendar').datepicker({
				showOn: 'button',
				buttonText: '',
				dateFormat: 'dd/mm/yy',
				changeMonth: true,
				changeYear: true,
				showOtherMonths: true,
				selectOtherMonths: true,
				dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
				dayNamesMin: ['D','S','T','Q','Q','S','S'],
				dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
				monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
				monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
			});


			var options = {
				valueNames: [ 'status', 'emitente', 'nfe', 'serie', 'data', 'cnpj', 'destinatario', 'valor', 'es' ]
			};

			var itensList = new List('itens', options);

			$('#btn-filter').click( function (e) {
				 e.preventDefault();
				 
				$('#btn-filter').toggleClass('divResult');
				$('.main').toggleClass('divResult');
				$('#divResult').slideToggle();
				
				var startDate = $('#filter-date-from').val().split('/');
				var startDate = startDate[1]+'/'+startDate[0]+'/'+startDate[2];
				var startDate = new Date(startDate);
				
				$('#divResult').show();

				var endDate = $('#filter-date-to').val().split('/');
				var endDate = endDate[1]+'/'+endDate[0]+'/'+endDate[2];
				var endDate = new Date(endDate);

				itensList.filter( function (item) {
					var thistDate = item.values().data.split('/');
					var thistDate = thistDate[1]+'/'+thistDate[0]+'/'+thistDate[2];
					var thistDate = new Date(thistDate);
					if ( ( $('#filter-status').val() == $(item.values().status).attr('data-tip') ||
								 $('#filter-status').val() == "" )
						&& ( $('#filter-emitente').val() == item.values().emitente ||
							 	 $('#filter-emitente').val() == "")
						&& ( $('#filter-destinatario').val() == item.values().destinatario ||
								 $('#filter-destinatario').val() == "" )
						&& ( $('#filter-numero-nf').val() == item.values().nfe ||
								 $('#filter-numero-nf').val() == "" )
						&& ( $('#filter-valor').val() == item.values().valor ||
								 $('#filter-valor').val() == "" )
						&& ( $('#filter-chave-nf').val() == item.values().es ||
								 $('#filter-chave-nf').val() == "" )
						&& ( startDate <= thistDate ||
								 $('#filter-date-from').val() == "" )
						&& ( endDate >= thistDate ||
								 $('#filter-date-to').val() == "" )
							 ){
						return true;
					} else {
						return false;
					}
				});
				return false;
			});

			$('#filter-date-from').mask('00/00/0000');
			$('#filter-date-to').mask('00/00/0000');
			$('#filter-numero-nf').mask('000000-0000');
			$('#filter-valor').mask('000.000.000,00', {reverse: true});

				// $('#log').prepend( "item.values().status = "+$(item.values().status).attr('data-tip')+"<br>" );

		};

		Dootax.load = function(){};

		$(window).on('ready', Dootax.ready);
		$(window).on('load', Dootax.load);

})(jQuery);