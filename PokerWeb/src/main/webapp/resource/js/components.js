;(function($){

		Dootax = window.Dootax || {};

		Dootax.init = function(){};
		
		Dootax.ready = function(){

			$('#itens thead tr th:not(first-of-type):not(last-of-type)').on('click', function (e) {
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

			$('#form-date').datepicker({
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

			$('#signup-birthday').datepicker({
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


			$('.datepicker').mask('00/00/0000');
			$('.cep').mask('00.000-000');
			
				// $('#log').prepend( "item.values().status = "+$(item.values().status).attr('data-tip')+"<br>" );

			$('.wrapper-dropdown').click( function () {
				$('.wrapper-dropdown').removeClass('active');
			});

			function DropDownCombo(el) {
				this.dd = el;
				this.opts = this.dd.find('ul.dropdown > li');
				this.val = [];
				this.index = [];
				this.initEvents();
			}
			DropDownCombo.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});

					obj.opts.children('label').on('click',function(event){
						var opt = $(this).parent(),
							chbox = opt.children('input'),
							val = chbox.val(),
							idx = opt.index();

						($.inArray(val, obj.val) !== -1) ? obj.val.splice( $.inArray(val, obj.val), 1 ) : obj.val.push( val );
						($.inArray(idx, obj.index) !== -1) ? obj.index.splice( $.inArray(idx, obj.index), 1 ) : obj.index.push( idx );
					});
				},
				getValue : function() {
					return this.val;
				},
				getIndex : function() {
					return this.index;
				}
			}

			$(function() {

				var combo1 = new DropDownCombo( $('#form-combo-status-1') );
				var combo2 = new DropDownCombo( $('#form-combo-status-2') );
				var combo3 = new DropDownCombo( $('#form-combo-status-3') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-4').removeClass('active');
				});

			});



			function DropDownSelect(el) {
				this.dd = el;
				this.placeholder = this.dd.children('span');
				this.opts = this.dd.find('ul.dropdown > li');
				this.val = '';
				this.index = -1;
				this.initEvents();
			}
			DropDownSelect.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						return false;
					});

					obj.opts.on('click',function(){
						var opt = $(this);
						obj.val = opt.text();
						obj.index = opt.index();
						obj.placeholder.text(obj.val);
					});
				},
				getValue : function() {
					return this.val;
				},
				getIndex : function() {
					return this.index;
				}
			}

			$(function() {

				var select1 = new DropDownSelect( $('#select-1') );
				var select2 = new DropDownSelect( $('#select-2') );
				var select3 = new DropDownSelect( $('#select-3') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown').removeClass('active');
				});

				$('.dropdown a').on('click', function (e) {
					// $(this).closest('.dropdown').fadeOut();
					$('.wrapper-dropdown').removeClass('active');
				});

			});
			

			// Listas de inclusão

			$('.include-list li').on('click', function (e){
				$(this).toggleClass('selected');
			});

			// Desabilita itens selecionados
			$('button.exclude-one').on('click', function (e){
				var thisList = $(this).closest('.include-list');
				var itensSelected = thisList.find('.list-enable .selected');
				var targetList = thisList.find('.list-disable');
				itensSelected.prependTo(targetList);
				itensSelected.removeClass('selected');
			});

			// Habilita itens selecionados
			$('button.include-one').on('click', function (e){
				var thisList = $(this).closest('.include-list');
				var itensSelected = thisList.find('.list-disable .selected');
				var targetList = thisList.find('.list-enable');
				itensSelected.prependTo(targetList);
				itensSelected.removeClass('selected');
			});

			// Desabilita todos os itens
			$('button.exclude-all').on('click', function (e){
				var thisList = $(this).closest('.include-list');
				var itensSelected = thisList.find('.list-enable li');
				var targetList = thisList.find('.list-disable');
				itensSelected.prependTo(targetList);
				itensSelected.removeClass('selected');
			});

			// Habilita todos os itens
			$('button.include-all').on('click', function (e){
				var thisList = $(this).closest('.include-list');
				var itensSelected = thisList.find('.list-disable li');
				var targetList = thisList.find('.list-enable');
				itensSelected.prependTo(targetList);
				itensSelected.removeClass('selected');
			});


			// Alerts

			$('a.modal').on('click', function (e) {
				e.preventDefault();
				thisModal = $(this).attr('href');
				$(thisModal).fadeIn();

				$('div.modal.alert .overlay').on('click', function (e) {
					e.preventDefault();
					$(thisModal).fadeOut();
				});

				$('div.modal .buttons .btn').on('click', function (e) {
					e.preventDefault();
					$(thisModal).fadeOut();
				});

			});


		};

		Dootax.load = function(){};

		$(window).on('ready', Dootax.ready);
		$(window).on('load', Dootax.load);

})(jQuery);