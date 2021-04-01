  <!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> 
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
	
	<!-- Configuração de autocampletar com ajax jquery e json. A servlet AutocompletarController recebe o valo digitado pelo usuário
		onde será filtrado na base de dados se o valor do código existe na tabela, se for verdade retorna todos dados que contem 
		o numero digitado no campo input.
	  -->
  <script>
  $(function() {
    var availablecodigoprojeto = new Array();
    
    $("#codigoprojeto").bind("keydown", function(event){
    	var data = {codigoprojeto:$("#codigoprojeto").val()};
    	//console.log(data);
    	
    	$.getJSON("buscar", data, function(res, est, jqXHR){ /*acessando a servlet mapeada no web.xml buscar URL*/
    		//console.log(getJSON);
    		
    		availablecodigoprojeto.length = 0;
    		$.each(res, function(i, item){    			
    			availablecodigoprojeto[i] = item; //carregando os itens neste array
    			//console.log(each);
    		});
    	});
    });
    
    $("#codigoprojeto").autocomplete({
      source: availablecodigoprojeto,
      minLength : 1 //no minimo 1 valor deve ser digitado
    });
  });
  </script>