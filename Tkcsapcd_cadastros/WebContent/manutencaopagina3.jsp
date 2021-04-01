<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Autocompletar</title>  
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 

<script type="text/javascript">
$(document).ready(function(){
	$('#conteudo').hide();
	
	$('#mostrar').click(function(event){
		event.preventDefault();	
		$("#conteudo").show("slow");
	});
	
	$('#ocultar').click(function(event){
		event.preventDefault();	
		$("#conteudo").hide("slow");
	});
});
</script>

</head>
<body>
 	<a href="#" id="mostrar">Exibir conte�do</a>
	    <a href="#" id="ocultar">Ocultar conte�do</a>
	    <div id="conteudo">
		<div class="ui-widget">
		  <label for="codigoprojeto">C�digo Projeto: </label>
		  <input type="text" id="codigoprojeto" name="codigoprojeto" placeholder="Informe o c�digo"/>
		</div> 
	</div>
 
</body>
</html>
