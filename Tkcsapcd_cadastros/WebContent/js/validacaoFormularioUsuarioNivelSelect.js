/*Validação Nível de acesso*/
$(function(){
			$('#nivel').combo({
					required:true,
					editable:false
				});
					$('#sp').appendTo($('#nivel').combo('panel'));
					$('#sp input').click(function(){
						var v = $(this).val();
						var s = $(this).next('span').text();
					$('#nivel').combo('setValue', v).combo('setText', s).combo('hidePanel');
				});
			});