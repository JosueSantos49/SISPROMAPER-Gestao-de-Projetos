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
    $('input[name=nextRFPProjeto1]').click(function(){
    	var array = formulario.serializeArray();
    	if(array[0].value == '' || array[1].value == '' || array[2].value == '' || array[3].value == '' || array[4].value == '' || array[5].value == '' || array[6].value == '' || array[7].selectedIndex == '' || array[8].selectedIndex == '' || array[9].value == '' || array[10].value == '' || array[11].value == '' || array[12].value == '' || array[13].value == ''){
      		$('.resp').html('<div class="erros"><p>Preencha todos os dados da primeira etapa, para poder ir para a segunda etapa!</p></div>');
    	}else{
    		$('.resp').html('');
    		next($(this));
    	}
    });
    
    $('input[name=nextRFPProjeto2]').click(function(){
    	var array = formulario.serializeArray();
    	if(array[14].value == '' || array[15].value == '' || array[16].value == '' || array[17].value == '' || array[18].value == '' || array[19].value == ''){
      		$('.resp').html('<div class="erros"><p>Preencha todos os dados da segunda etapa, para poder ir para a terceira etapa!</p></div>');
    	}else{
    		$('.resp').html('');
    		next($(this));
    	}
    });
    
    $('input[type=submit]').click(function(evento){
    	var array = formulario.serializeArray();
    	if(array[18].value == '' || array[19].value == '' || array[20].value == '' || array[21].value == '' || array[22].value == '' || array[23].value == '' || array[24].value == '' || array[25].value == '' || array[26].value == ''){
      		$('.resp').html('<div class="erros"><p>Informe-nos algumas informações sobre partes envolvidas/custos, para podermos efetuar o cadastro!</p></div>');
    	}else{
    		$('.resp').html('<div class="erros"><p></p></div>');
    	}
    	/*evento.preventDefault();*/
    });
    
    

});