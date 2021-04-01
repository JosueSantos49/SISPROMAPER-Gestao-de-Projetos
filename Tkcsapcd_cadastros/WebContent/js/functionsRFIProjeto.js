$(function(){    
    var atual_fs, next_fs, prev_fs;
    var formulario = $('form[name=formulario]');
    

    function next(elem){
    	atual_fs = $(elem).parent();
    	next_fs = $(elem).parent().next();
    	
    	$('#progress li').eq($('fieldset').index(next_fs)).addClass('ativo');
    	atual_fs.hide(800);
    	next_fs.show(800);
    }


    $('.prev').click(function(){
    	atual_fs = $(this).parent();
    	prev_fs = $(this).parent().prev();
    	
    	$('#progress li').eq($('fieldset').index(atual_fs)).removeClass('ativo');
    	atual_fs.hide(800);
    	prev_fs.show(800);
    }); 
    
    /*RFP-Projeto*/
    $('input[name=nextRFIProjeto1]').click(function(){
    	var array = formulario.serializeArray();
    	if(array[0].value == '' || array[1].value == '' || array[2].value == '' || array[3].value == '' || array[4].value == '' || array[5].value == '' || array[6].value == ''){
      		$('.resp').html('<div class="erros"><p>Preencha todos os dados da primeira etapa, para poder ir para a segunda etapa!</p></div>');
    	}else{
    		$('.resp').html('');
    		next($(this));
    	}
    });
    
    $('input[name=nextRFIProjeto2]').click(function(){
    	var array = formulario.serializeArray();
    	if(array[7].value == ''){
      		$('.resp').html('<div class="erros"><p>Preencha todos os dados da segunda etapa, para poder ir para a terceira etapa!</p></div>');
    	}else{
    		$('.resp').html('');
    		next($(this));
    	}
    });
    $('input[name=nextRFIProjeto3]').click(function(){
    	var array = formulario.serializeArray();
    	if(array[8].value == ''){
      		$('.resp').html('<div class="erros"><p>Preencha todos os dados da terceira etapa, para poder ir para a quarta etapa!</p></div>');
    	}else{
    		$('.resp').html('');
    		next($(this));
    	}
    });
    
    $('input[type=submit]').click(function(evento){
    	var array = formulario.serializeArray();
    	if(array[9].value == '' || array[10].value == '' || array[11].value == ''){
      		$('.resp').html('<div class="erros"><p>Informe-nos algumas informações sobre a quarta etapa, para podermos efetuar o cadastro!</p></div>');
    	}else{
    		$('.resp').html('<div class="erros"><p></p></div>');
    	}
    	/*evento.preventDefault();*/
    });
    
    

});