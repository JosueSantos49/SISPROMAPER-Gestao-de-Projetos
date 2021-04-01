<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Autocompletar</title>  
  <link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
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

$(document).ready(function(){
	$('#conteudo0').hide();
	
	$('#mostrar0').click(function(event){
		event.preventDefault();	
		$("#conteudo0").show("slow");
	});
	
	$('#ocultar0').click(function(event){
		event.preventDefault();	
		$("#conteudo0").hide("slow");
	});
});

$(document).ready(function(){
	$('#conteudo01').hide();
	
	$('#mostrar01').click(function(event){
		event.preventDefault();	
		$("#conteudo01").show("slow");
	});
	
	$('#ocultar01').click(function(event){
		event.preventDefault();	
		$("#conteudo01").hide("slow");
	});
});

$(document).ready(function(){
	$('#conteudo1').hide();
	
	$('#mostrar1').click(function(event){
		event.preventDefault();	
		$("#conteudo1").show("slow");
	});
	
	$('#ocultar1').click(function(event){
		event.preventDefault();	
		$("#conteudo1").hide("slow");
	});
});

$(document).ready(function(){
	$('#conteudo2').hide();
	
	$('#mostrar2').click(function(event){
		event.preventDefault();	
		$("#conteudo2").show("slow");
	});
	
	$('#ocultar2').click(function(event){
		event.preventDefault();	
		$("#conteudo2").hide("slow");
	});
});

$(document).ready(function(){
	$('#conteudo3').hide();
	
	$('#mostrar3').click(function(event){
		event.preventDefault();	
		$("#conteudo3").show("slow");
	});
	
	$('#ocultar3').click(function(event){
		event.preventDefault();	
		$("#conteudo3").hide("slow");
	});
});
</script>

</head>
<body>
 		<!-- <a href="#" id="mostrar">Exibir conteúdo</a>
	    <a href="#" id="ocultar">Ocultar conteúdo</a>
	    <div id="conteudo">
			<div class="ui-widget">
			  <label for="codigoprojeto">Código Projeto: </label>
			  <input type="text" id="codigoprojeto" name="codigoprojeto" placeholder="Informe o código"/>
			</div> 
		</div>-->
		
<div id="main" class="container">
 	<div class="wow fadeInDown top__element" data-wow-delay="2s">
	 <div class="sitemap">	
	 	
	 	<div class="sitemap"> <!-- Iniciação -->
	 		
			<br><div class="alert alert-success">Iniciação - Grupo de processo de Iniciação</div>	
					
			<br><br><br><br>
					
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>		
							<li><a>4.1 Desenvolver o Termo de Abertura do Projeto<br>
								<font id="mostrar0" class="btn btn-mini glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar0" class="btn btn-mini glyphicon glyphicon-minus" color="#FFFFFF"></font>	</a>						
								<ul id="conteudo0">									 								
									<li>
									<a>1. Entradas<br> 	
										<font id="mostrar" class="btn btn-mini glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar" class="btn btn-mini glyphicon glyphicon-minus" color="#FFFFFF"></font>	
										</a>								 
										<ul id="conteudo">
											<li><a>1. Especificação do Trabalho do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarBusinessCase">2. Business Case</a></li>
											<li><a>3. Acordos</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas<br>
										<font id="mostrar1" class="btn btn-mini glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="btn btn-mini glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo1">
											<li><a>1. Opinião Especializada</a></li>
											<li><a>2. Técnicas de Facilitação</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>										
										<ul>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>
										</ul>
									</li>
								</ul>								
							</li>
							<li ><a>13.1 Identificar as Partes Interessadas<br>	
									<font id="mostrar01" class="btn btn-mini glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar01" class="btn btn-mini glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>							
									<ul id="conteudo01">							
									<li><a>1. Entradas<br>
										<font id="mostrar2" class="btn btn-mini glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar2" class="btn btn-mini glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo2">
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>
											<li><a>2. Documentos das Aquisições</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas<br>
										<font id="mostrar3" class="btn btn-mini glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="btn btn-mini glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo3">
											<li><a>1. Análise das Partes Interessadas</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarTabelaParteInteressada">1. Registro das Partes Interessadas Versão 1</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">1. Registro das Partes Interessadas</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
							<ul id="utilityNav">
								<li><a href="index_principal.jsp">Home Page</a></li>
								<li><a href="sair.jsp">Encerrar Sessão</a></li>			
								<li><a href="#" id="subir">Topo</a></li>
							</ul>
						</div>
		</div>
	
</div>
</div>
 
</body>
</html>
