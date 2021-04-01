<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="#" type="image/x-icon"><!-- Icone na aba da página -->
<title>Iniciação</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap_consultar_processos.css" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>   
<script type="text/javascript" src="js/conteudo_mostrar_ocultar.js"></script>

</head>
<body>

<%@include file="menuperantecssadm.jsp"%>

			<div id="main" class="container">
				<div class="wow slideInLeft" data-wow-duration="1s">
				<%@include file="indice_paleativo.jsp"%>
				</div>
			</div>
			
<div id="main" class="container">

 	<div class="wow fadeInDown top__element" data-wow-delay="2s">
	 <div class="sitemap">	
	 	
	 	<div class="sitemap"> 
	 		
			<div class="alert alert-success">Iniciação - Grupo de processo de Iniciação</div>
					
			<br><br>
					
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>		
							<li><a>4.1 Desenvolver o Termo de Abertura do Projeto<br>
								<font id="mostrar0" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar0" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
								</a>																						
								<ul id="conteudo0">									 								
									<li>
									
									<a>1. Entradas<br>
									<font id="mostrar00" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar00" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>																													 
										<ul id="conteudo00">
											<li><a>1. Especificação do Trabalho do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarBusinessCase">2. Business Case</a></li>
											<li><a>3. Acordos</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>									
									<li>									
									<a>2. Ferramentas e Técnicas<br>
									<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>																				
										<ul id="conteudo1">
											<li><a>1. Opinião Especializada</a></li>
											<li><a>2. Técnicas de Facilitação</a></li>
										</ul>
									</li>
									<li>									
									<a>3. Saídas<br>
									<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>																														
										<ul id="conteudo4">
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>
										</ul>
									</li>
								</ul>								
							</li>
							<li ><a>13.1 Identificar as Partes Interessadas<br>
									<font id="mostrar01" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar01" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>	
									</a>															
									<ul id="conteudo01">							
									<li>									
									<a>1. Entradas<br>
									<font id="mostrar2" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar2" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>																				
										<ul id="conteudo2">
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>
											<li><a>2. Documentos das Aquisições</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li>									
									<a>2. Ferramentas e Técnicas<br>
									<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>										
										<ul id="conteudo3">
											<li><a>1. Análise das Partes Interessadas</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li>									
									<a>3. Saídas<br>
									<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
									</a>																				
										<ul id="conteudo5">
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
	<%@include file="configuracao_wow.jsp" %>
	<script src="js/modal_dialog.js"></script>	
	<%@include file="gif_load_page.jsp" %> 
</body>
</html>
