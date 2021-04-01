<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<jsp:include page="sessao.jsp" />
<html>
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da p�gina -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<title>Consultar Plano de Gerenciamento de Qualidade</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
<link type="text/css" rel="stylesheet" href="css/loaderPage.css">
<link rel="stylesheet" type="text/css" media="screen"	href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen"	href="plugindatatable/css/dataTables.jqueryui.css">
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/funcoes.js"></script>
<script type="text/javascript"	src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"	src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"	src="plugindatatable/js/dataTables.jqueryui.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorio.js"></script>


<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap_consultar_processos.css" />

<script>
	$(document).ready(function() {
		$('#tabela').dataTable();
	});
</script >

	<script type="text/javascript">

	$(document).ready(function() {
		$("#consProjeto1").mask("99/99/9999");
	});
</script >

<script src="excellentexport-master/excellentexport.js"></script>

<style>
table,tr,td {
	border: 0px black solid;
}
</style>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<div id="preloader">
		<h1>
			<img src="img/ajax-loaderazul.gif" height="30px">
		</h1>
	</div>
	
	<%@include file="menuperantecssadm.jsp"%>

	<div align="justify" class="container">
		
		<div class="container">
		
		<div id="main">
			<div class="wow slideInLeft" data-wow-duration="1s">
				 <div class="alert alert-danger">
					Ol�, 
					<%=session.getAttribute("theName")%>
						<%  
						//verifica se a sessao do usuario � v�lida  
						if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
					%>
					seja bem-vindo a etapa de consultar processo. Voc� poder� verificar a vis�o geral de cada processo, basta somente clicar no link de cada linha da tabela, que ser� aberta a vis�o geral de cada processo em forma de WBS.  
				</div>
			</div>
		</div>
		
			<div class="table-responsive">	
				<table class="table table-bordered table-hover">
				<caption></caption>
					<caption></caption>
					<thead>
						<tr>
							<th>TABELA DE GUIA VIS�O GERAL DE PROCESSOS</th>
							<th>Link</th>		
						</tr>
					</thead>
					  <tr>
					    <td>Gerenciamento da Integra��o do Projeto</td>
					    <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Verificar</button></td>
					  </tr>
					  <tr>
					    <td>Gerenciamento do Escopo do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg2">Verificar</button></td>
					  </tr>
					  <tr>
					   <td>Gerenciamento do Tempo do Projeto</td>
					   <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg3">Verificar</button></td>
					  </tr>
					  <tr>
					    <td>Gerenciamento dos Custos do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg4">Verificar</button></td>
					  </tr>		  
					  <tr>	
					   <tr>
					    <td>Gerenciamento da Qualidade do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg5">Verificar</button></td>
					  </tr>	
					  <tr>
					    <td>Gerenciamento dos Recursos Humanos do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg6">Verificar</button></td>
					  </tr>		
					  <tr>
					    <td>Gerenciamento das Comunica��es do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg7">Verificar</button></td>
					  </tr>	
					  <tr>
					    <td>Gerenciamento das Comunica��es do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg8">Verificar</button></td>
					  </tr>	
					  <tr>
					    <td>Gerenciamento das Aquisi��es do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg9">Verificar</button></td>
					  </tr>	
					  <tr>
					    <td>Gerenciamento das Partes Interessadas do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg10">Verificar</button></td>
					  </tr>			  
				</table>
			</div>	
			
			<div class="container">	
			<div class="modal fade bs-example-modal-lg " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento de Integra��o do Projeto</h1>
						<h2>Gerencamento da Integra��o do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>						
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>4.1 Desenvolver o Termo de Abertura do Projeto</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a>1. Especifica��o do Trabalho do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarBusinessCase">2. Business Case</a></li>
											<li><a>3. Acordos</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. T�cnicas de Facilita��o</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>4.2 Desenvolver o Plano de Gerenciamento do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>					
											<li><a>2. Sa�das de Outros Processos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. T�cnicas de facilita��o</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.3 Orientar e Gerenciar o Trabalho do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��o de Mudan�as Aprovadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. Sistema de Informa��o de Gerenciamento de Projetos</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Entregas</a></li>
											<li><a>2. Dados de Desenpenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��o de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.4 Monitorar e Controlar o Trabalho do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Previs�es de Cronograma</a></li>
											<li><a>3. Previs�es de Custos</a></li>
											<li><a>4. Mudan�as Validadas</a></li>
											<li><a>5. Informa��es Sobre o Desenpenho do Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. T�cnicas Anal�ticas</a></li>
											<li><a>3. Sistema de Informa��o do Gerenciamento do Projeto</a></li>
											<li><a>4. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�as</a></li>
											<li><a>2. Relat�rio de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerencimaento do Projeto</a></li>
											<li><a>4. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.5 Realizar o Controle Integrado de Mudan�as</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Relat�rio de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��es de Mudan�as</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. Reuni�es</a></li>
											<li><a>3. Ferramentas de Controle de Mudan�as</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�a Aprovada</a></li>
											<li><a>2. Registro de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.6 Encerrar o Projeto ou fase</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Entregas Aceitas</a></li>
											<li><a>3. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. T�cnicas Anal�ticas</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Transi��o do Produto, Servi�o ou Resultado Final</a></li>										
											<li><a>2. Atualiza��o nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>	
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
	</div>	
	</div>
	
	<div class="modal fade bs-example-modal-lg2 " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento de Escopo do Projeto</h1>
						<h2>Gerencamento do Escopo do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>5.1 Planejar o Gerenciamento do Escopo do Projeto</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito">2. Plano de Gerenciamento dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>5.2 Controlar os Requisitos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito">2. Plano de Gerenciamento dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">3. Plano de Gerenciamento das Partes Interessadas</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">4. Termo de Abertura do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">5. Registro das Partes Interessadas</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Entrevistas</a></li>
											<li><a>2. Grupo de Discuss�o</a></li>
											<li><a>3. Oficinas Facilitadas</a></li>
											<li><a>4. T�cnicos de Criatividades em Grupo</a></li>
											<li><a>5. T�cnicas de Tomadas de Decis�o em Grupo</a></li>
											<li><a>6. Question�rios e Pesquisas</a></li>
											<li><a>7. observa��es</a></li>
											<li><a>8. Prot�tipos</a></li>
											<li><a>9. Benchmarking</a></li>
											<li><a>10. Diagrama de Contexto</a></li>
											<li><a>11. An�lise dos Documentos</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Documentos dos Requesitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">2. Matriz de Rastreabilidade dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.3 Definir o Escopo</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>					
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>
											<li><a>3. Documento dos Requisitos</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. An�lise de Produto</a></li>
											<li><a>3. Gera��o de Alternativas</a></li>
											<li><a>4. Oficinas Facilitadoras</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Documentos dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">2. Matriz de Rastreabilidade dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.4 Criar a Estrutura Anal�tica do Projeto (EAP)</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>					
											<li><a>2. Especializa��o do Escopo do Projeto</a></li>
											<li><a>3. Documenta��o dos Requisitos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Decomposi��o</a></li>
											<li><a>2. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Linha de Base do Escopo</a></li>
											<li><a>2. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.5 Validar o Escopo</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documenta��o dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matriz de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Entregas Verificadas</a></li>
											<li><a>5. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Inspe��o</a></li>
											<li><a>2. T�cnicas de Tomada de Decis�o em grupo</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Entregas Aceitas</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a>3. Informa��es sobre o Desempenho do Trabalho</a></li>
											<li><a>4. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.6 Controlar o Escopo</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documenta��o dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matr�s de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. An�lise de Varia��o</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>										
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��o de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es do Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>	
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		
		<div class="modal fade bs-example-modal-lg3 " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento do Tempo do Projeto</h1>
						<h2>Gerencamento do Tempo do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>						
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>6.1 Planejar o Gerenciamento do Cronograma do Projeto</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. T�cnicas Anal�ticas</a></li>
											<li><a>3. Reuni�ess</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>6.2 Definir as Atividades</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. Decomposi��o</a></li>
											<li><a>2. Planejamento em Ondas Sucessivas</a></li>
											<li><a>3. Opini�o especializada</a></li>											
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Lista de Atividades</a></li>
											<li><a>2. Atributos das Atividades</a></li>
											<li><a>3. Lista de Atividades</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.3 Sequ�nciar as Atividades</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a>2. Lista de Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Lista de Marcos</a></li>
											<li><a>5. Especializa��o do Escopo do Projeto</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. M�todo do Diagrama de Preced�ncia (MDP)</a></li>
											<li><a>2. Determina��o de Depend�ncia</a></li>
											<li><a>3. Antecipa��es e Esperas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Diagrama de Rede do Cronograma do Projeto</a></li>
											<li><a>3. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.4 Estimar os Recursos das Atividades</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista de Atividade</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Calend�rios dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">5. Registro dos Riscos</a></li>
											<li><a>6. Estimativas de Custo das Atividades</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">7. Fatores Ambientais da Empresa</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. An�lise de Alternativas</a></li>
											<li><a>3. Dados publicados sobre estimativas</a></li>
											<li><a>4. Estimativa de Bottom-up</a></li>
											<li><a>5. Software de Gerenciamento de Projeto</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Requisitos de Recursos das Atividades</a></li>
											<li><a>2. Estrutura Anal�tica dos Recursos</a></li>
											<li><a>3. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.5 Estimar as Dura��es das Atividades</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista das Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Requisitos de Recursos das Atividades</a></li>
											<li><a>5. Calend�rios dos Recursos</a></li>
											<li><a>6. Especifica��o do Escopo do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">7. Registro do Riscos</a></li>
											<li><a>8. Estrutura Anal�tica dos Recursos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">9. Fatores Ambientais da Empresa</a></li>
											<li><a>10. Ativos de Processo Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. Estimativa An�loga</a></li>
											<li><a>3. Estimativa Param�trica</a></li>
											<li><a>4. Estimativa de 3 pontos</a></li>
											<li><a>5. T�cnica de Tomada de Decis�o em Grupo</a></li>
											<li><a>6. An�lise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Estimativas das dura��es das Atividades</a></li>
											<li><a>2. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.6 Desenvolver o Cronograma</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista de Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Diagrama de Rede do Cronograma do Projeto</a></li>
											<li><a>5. Requisitos de Recursos das Atividades</a></li>
											<li><a>6. Calend�rios dos Recursos</a></li>
											<li><a>7. Estimativa de Dura��o das Atividades</a></li>
											<li><a>8. Especifica��o do Escopo do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">9. Registro do Riscos</a></li>
											<li><a>10. Desgna��es do Pessoal do Projeto</a></li>
											<li><a>11. Estrutura Anal�tica dos Recursos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">12. Fatores Ambientais da Empresa</a></li>
											<li><a>13. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. An�lise de Rede do Cronograma</a></li>
											<li><a>2. M�todo do Caminho Cr�tico</a></li>
											<li><a>3. M�todo da Corrente Cr�tica</a></li>
											<li><a>4. T�cnica de Otimiza��es de Recursos</a></li>
											<li><a>5. T�cnicas de Desenvolvimento de Modelos</a></li>
											<li><a>6. Antecipa��o e Espera</a></li>
											<li><a>7. Compress�o de Cronograma</a></li>
											<li><a>8. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Linha de Base do Cronograma</a></li>										
											<li><a>2. Cronograma do Projeto</a></li>
											<li><a>3. Dados do Cronograma</a></li>
											<li><a>4. Calend�rio do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualiza��o nos Documentos do projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.7 Controlar o Cronograma</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Cronograma do Projeto</a></li>
											<li><a>3. Dados de Desempenho do Projeto</a></li>
											<li><a>4. Calend�rio do Projeto</a></li>
											<li><a>5. Dados do Cronograma</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. An�lise de Dempenho</a></li>
											<li><a>2. Software de Gerenciamento de Projeto</a></li>
											<li><a>3. T�cnicas de Otimiza��o de Recursos</a></li>
											<li><a>4. T�cnicas de Desenvolvimento de Modelos</a></li>
											<li><a>5. Antecipa��es e Esperas</a></li>
											<li><a>6. Compress�o de Cronograma</a></li>
											<li><a>7. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es sobre o Desenvolvimento do Trabalho</a></li>										
											<li><a>2. Previs�o de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��es de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>6. Atualiza��es nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>	
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg4 " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento dos Custos do Projeto</h1>
						<h2>Gerencamento do Custos do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>7.1 Planejar o Gerenciamento do Custo</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. T�cnicas An�liticas</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>7.2 Estimar os Custos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">2. Plano de Gerenciamento dos Recursos Humanos</a></li>
											<li><a>3. Linha de Base do Escopo</a></li>
											<li><a>4. Cronograma do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">5. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�es Especializadas</a></li>
											<li><a>2. Estimativa An�loga</a></li>
											<li><a>3. Estimativa Param�trica</a></li>
											<li><a>4. Estimativa "Bottom-up"</a></li>
											<li><a>5. Estimativa de 3 Pontos</a></li>
											<li><a>6. An�lise de Reservas</a></li>
											<li><a>7. Custo de Qualidade</a></li>
											<li><a>8. Software de Gerenciamento de Projetos</a></li>
											<li><a>9. An�lise de Proposta de Fornecedor</a></li>
											<li><a>10. T�cnicas de Tomada de Decis�o em Grupo</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Estimativa de Custos das Atividades</a></li>
											<li><a>2. Base das Estimativas</a></li>
											<li><a>3. Atualiza��es nos Documentos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>7.3 Determinar o Or�amento</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a>3. Estimativas dos Custos das Atividades</a></li>
											<li><a>4. Base das Estimativas</a></li>
											<li><a>5. Cronograma do Projeto</a></li>
											<li><a>6. Calend�rio dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">7. Registro dos Riscos</a></li>
											<li><a>8. Acordos</a></li>
											<li><a>9. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Agraga��o de Custos</a></li>
											<li><a>2. An�lise de Reservas</a></li>
											<li><a>3. Opini�o Especializada</a></li>
											<li><a>4. Rela��es Hist�ricas</a></li>
											<li><a>Reconcilia��o dos Limites de Recursos Financeiros</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Linha de Base dos Documentos</a></li>
											<li><a>2. Requisitos de Recursos</a></li>
											<li><a>3. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>7.4 Controlar os Custos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do projeto</a></li>					
											<li><a>2. Requisitos de Recursos Financeiros do Projeto</a></li>
											<li><a>3. Dados do Desempenho do Projeto</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Gerenciamento do Valor Agregado</a></li>
											<li><a>2. Previs�o</a></li>
											<li><a>3. �ndice de Desempenho para T�rmino (IDPT)</a></li>
											<li><a>4. An�lise de Desempenho</a></li>
											<li><a>5. Software de Gerenciamento de Projetos</a></li>
											<li><a>6. An�lise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es sobre o desempenho do Trabalho</a></li>
											<li><a>2. Previs�es de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualiza��o no Planode gerenciamento do Projeto</a></li>
											<li><a>5. Atualiza��o nos documentos do Projeto</a></li>
											<li><a>6. atualiza��es nos Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
								</ul>
							</li>	
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg5 " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento da Qualidade do Projeto</h1>
						<h2>Gerencamento da Qualidade do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>8.1 Planejar o Gerenciamento da Qualidade</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">2. Registro das Partes Interessadas</a></li>							
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a>4. Documenta��o dos Requisitos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">5. Fatores Ambientais da Empresa</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. An�lise Custo-Benef�cio</a></li>
											<li><a>2. Custo de Qualidade</a></li>
											<li><a>3. Sete Ferramentas de Qualidade B�sicas</a></li>
											<li><a>4. Benchmarking</a></li>
											<li><a>5. Projeto de Experimentos</a></li>
											<li><a>6. Amostra Art�stica</a></li>
											<li><a>7. Ferramentas Adicionais de Planejamento da Qualidade</a></li>
											<li><a>8. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade">1. Plano de Gerenciamento da Qualidade</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso">2. Plano de Melhorias no Processo</a></li>
											<li><a>3. M�tricas da Qualidade</a></li>
											<li><a>4. Lista de Verifica��o da Qualidade</a></li>
											<li><a>5. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>8.2 Realizar a Garantia da Qualidade</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade">1. Plano de Gerenciamento da Qualidade</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso">2. Plano de Melhorias no Processo</a></li>
											<li><a>3. M�tricas da Qualidade</a></li>
											<li><a>4. Medi��es do Controle de Qualidade</a></li>
											<li><a>5. Documenta��o do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Ferramenta de Gerenciamento e Controle da Qualidade</a></li>
											<li><a>2. Auditoria de Qualidade</a></li>
											<li><a>3. An�lise de Processo</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>4. Atualiza��o nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>8.3 Controlar a Qualidade</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. M�tricas da Qualidade</a></li>
											<li><a>3. Lista de Verifica��o da Qualidade</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicita��es de Mudan�as Aprovadas</a></li>
											<li><a>6. Entregas</a></li>
											<li><a>7. Documentos do Projeto</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Sete Ferramentas de Qualidade B�sicas</a></li>
											<li><a>2. Amostragem Estat�sticas</a></li>
											<li><a>3. Inspe��o</a></li>
											<li><a>4. An�lise das Solicita��es de Mudan�as Aprovadas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Medi��es do Controle de Qualidade</a></li>
											<li><a>2. Altera��es validas</a></li>
											<li><a>3. Entregas Verificadas</a></li>
											<li><a>4. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">6. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>7. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>8. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg6" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento dos Recursos Humanos do Projeto</h1>
						<h2>Gerencamento dos Recursos Humanos do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>9.1 Planejar o Gerenciamento dos Recursos Humanos</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Requisito de Recursos das Atividades</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. Organograma e Descri��es de Cargos</a></li>
											<li><a>2. Networking</a></li>
											<li><a>3. Teoria Organizacional</a></li>
											<li><a>4. Opini�o Especializada</a></li>
											<li><a>5. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>9.2 Mobilizar a Equipe do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a href="cadastro_fatores_ambientais.jsp">2. Fatores Ambientais da Empresa</a></li>
											<li><a>3. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Pr�-designa��o</a></li>
											<li><a>2. Negocia��o</a></li>
											<li><a>3. Contrata��o</a></li>
											<li><a>4. Equipes Virtuais</a></li>
											<li><a>5. An�lise de Decis�o Envolvendo Crit�rios M�ltiplos</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Designa��es do Pessoal do Projeto</a></li>
											<li><a>2. Calend�rio dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>9.3 Desenvolver a Equipe do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>2. Desgna��o do Pessoal do Projeto</a></li>
											<li><a>3. Calend�rios dos Recursos</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Habilidades Interpessoais</a></li>
											<li><a>2. Treinamento</a></li>
											<li><a>3. Atividades de Constru��o da Equipe</a></li>
											<li><a>4. Regr�s B�sicas</a></li>
											<li><a>5. Agrupamento</a></li>
											<li><a>6. Reconhecimento e Recompensas</a></li>
											<li><a>7. Ferramentas de Avalia��o dos Funcion�rios</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Avalia��es de Desempenho da Equipe</a></li>
											<li><a>2. Atualiza��es nos Fatores Ambientais da Empresa</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>9.4 Gerenciar a Equipe do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>2. Desgna��o do Pessoal do Projeto</a></li>
											<li><a>3. Avalia��es de Desempenho da Equipe</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">4. Registro das Quest�es</a></li>
											<li><a>5. Relat�rios do Desempenho do Trabalho</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Observa��es e Conversas</a></li>
											<li><a>2. Avalia��es de Desempenho do Projeto</a></li>
											<li><a>3. Gerenciamento de Conflitos</a></li>
											<li><a>4. Habilidades Interpessoais</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Avalia��es nos Documentos do Projeto</a></li>
											<li><a>4. Atualiza��es nos Fatores Ambientais da Empresa</a></li>
											<li><a>5. Atualiza��es nos Ativos de Processos Organizacionais</a></li>	
										</ul>
									</li>
								</ul>
							</li>
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg7 " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento das Comunica��es do Projeto</h1>
						<h2>Gerencamento das Comunica��es do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>10.1 Planejar o Gerenciamento das Comunica��es</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">2. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. An�lise de Requisitos das Comunica��es</a></li>
											<li><a>2. Tecnologias de Comunica��es</a></li>
											<li><a>3. Modelos de Comunica��es</a></li>
											<li><a>4. M�todos de Comunica��es</a></li>
											<li><a>5. Projeto de Experimentos</a></li>
											<li><a>6. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunica��es</a></li>
											<li><a>2. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>10.2 Gerenciar as Comunica��es</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunica��es</a></li>					
											<li><a>2. Relat�rio de Desempenho de Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Tecnologias de Comunica��es</a></li>
											<li><a>2. Modelos de Comunica��es</a></li>
											<li><a>3. M�todos de Comunica��es</a></li>
											<li><a>4. Sistemas de Gerenciamento de Informa��es</a></li>
											<li><a>5. Relat�rios de Desempenho</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Comunica��es do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>4. Atualiza��o nos aditivos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>10.3 Controlar as Comunica��es</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Comunica��es do Projeto</a></li>
											<li><a>3. Registro das Quest�es</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Sistemas de Gerenciamento de Informa��es</a></li>
											<li><a>2. Opini�es Especializadas</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>				
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg8 " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento das Comunica��es do Projeto</h1>
						<h2>Gerencamento das Comunica��es do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>11.1 Planejar o Gerenciamento dos Riscos</a>
								<ul>							
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">3. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Tool & Techniques</a>
										<ul>
											<li><a>1. Tecnicas Anal�ticas</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>11.2 Identificar os Riscos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">2. Plano de Gerenciamento dos Custos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">3. Plano de Gerenciamento do Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade">4. Plano de Gerenciamento da Qualidade</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">5. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>6. Lista de Base do Escopo</a></li>
											<li><a>7. Estimativas dos Custos das Atividades</a></li>
											<li><a>8. Estimativas das Dura��es das Atividades</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">9. Registros das Partes Interessadas</a></li>
											<li><a>10. Documentos do Projeto</a></li>
											<li><a>11. Documentos da Aquisi��o</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">12. Fatores Ambientais da Empresa</a></li>
											<li><a>13. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Revis�es de Documenta��o</a></li>
											<li><a>2. T�cnicas de Coleta de Informa��es</a></li>
											<li><a>3. An�lise de Listas de Verifica��o</a></li>
											<li><a>4. An�lise de Premissas</a></li>
											<li><a>5. T�cnicas de Diagrama</a></li>
											<li><a>6. An�lise de For�as, Fraquezas, Oportunidades e Ame�as (SWOT)</a></li>
											<li><a>7. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">1. Registro dos Riscos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.3 Realizar a An�lise Qualitativa dos Riscos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Avalia��o de Probabilidade e Impacto dos Riscos</a></li>
											<li><a>2. Matriz de Probabilidade e Impacto</a></li>
											<li><a>3. Avalia��o de Qualidade dos Dados sobre Riscos</a></li>
											<li><a>4. Categoriza��o de Riscos</a></li>
											<li><a>5. Avalia��o da Urg�ncia dos Riscos</a></li>
											<li><a>6. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.4 Realizar a An�lise Qualitativa dos Riscos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">2. Plano de Gerenciamento dos Custos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">3. Plano de Gerenciamento do Cornograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">4. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">5. Fatores Ambientais da Empresa</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. T�cnicas de Coleta e Apresenta��o de Dados</a></li>
											<li><a>2. T�cnicas de Modelagem e An�lise Quantitativa Especializada</a></li>	
											<li><a>3. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.5 Planejar as Respostas aos Riscos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">2. Registro dos Riscos</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Estrat�gias para Riscos Negativos ou Amea�as</a></li>
											<li><a>2. Estrat�gias para Riscos Positivos ou Oportunidades</a></li>
											<li><a>3. Estrat�gias de respostas de Contig�ncia</a></li>
											<li><a>4. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">1. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.6 Controlar os Riscos</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">2. Registro dos Riscos</a></li>
											<li><a>3. Dados de Desempenho do Trabalho</a></li>
											<li><a>4. Relat�rio de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Reavalia��o dos Riscos</a></li>
											<li><a>2. Auditoria dos Riscos</a></li>
											<li><a>3. An�lise de Avalia��o de Tend�ncia</a></li>
											<li><a>4. Medi��o de Desempenho T�cnico</a></li>
											<li><a>5. An�lise de Reservas</a></li>
											<li><a>6. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>			
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg9" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento das Aquisi��es do Projeto</h1>
						<h2>Gerencamento das Aquisi��es do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>12.1 Planejar o Gerenciamento das Aquisi��es</a>
								<ul>							
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Documenta��o dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a>4. Requisitos de Recursos das Atividades</a></li>
											<li><a>5. Cronograma do Projeto</a></li>
											<li><a>6. Estimativa dos Custos das Atividades</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">7. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">8. Fatores Ambientais da Empresa</a></li>
											<li><a>9. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. An�lise de fazer ou comprar</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Pesquisa de Mercado</a></li>
											<li><a>4. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisi��es</a></li>
											<li><a>2. Especifica��o do Trabalho das Aquisi��es</a></li>
											<li><a>3. Documentos de Aquisi��o</a></li>
											<li><a>4. Crit�rios para Sele��o de Fontes</a></li>
											<li><a>5. Decis�es de Fazer ou Comprar</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">6. Solicita��es de Mudan�as</a></li>
											<li><a>7. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>12.2 Conduzir as Aquisi��es</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisi��es</a></li>
											<li><a>2. Documentos das Aquisi��es</a></li>
											<li><a>3. Crit�rios para Sele��o de Fontes</a></li>
											<li><a>4. Propostas dos Fornecedores</a></li>
											<li><a>5. Documentos do Projeto</a></li>
											<li><a>6. Decis�es de Fazer ou Comprar</a></li>
											<li><a>7. Especifica��o do Trabalho das Aquisi��es</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Reuni�o com Licitantes</a></li>
											<li><a>2. T�cnicas de Avalia��o Propostas</a></li>
											<li><a>3. Estimativas Independentes</a></li>
											<li><a>4. Opini�o Especializada</a></li>
											<li><a>5. Publicidade</a></li>
											<li><a>6. T�cnicas An�liticas</a></li>
											<li><a>7. Negocia��es das Aquisi��es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarFornecedorQualificado">1. Fornecedores Selecionados</a></li>
											<li><a>2. Acordos</a></li>
											<li><a>3. Calend�rios dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>12.3 Controlar as Aquisi��es</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentos de aquisi��o</a></li>
											<li><a>3. Acordos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicita��o de Mudan�as Aprovadas</a></li>
											<li><a>5. Relat�rios Desempenho do Trabalho</a></li>
											<li><a>6. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Sistema de Controle de Mudan�a no Contrato</a></li>
											<li><a>2. An�lise de Desempenho das Aquisi��es</a></li>
											<li><a>3. Inspe��es e Auditorias</a></li>
											<li><a>4. Relat�rio de Desempenho</a></li>
											<li><a>5. Sistema de Pagamento</a></li>
											<li><a>6. Administra��o de Reivindica��es</a></li>
											<li><a>7. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>12.4 Encerrar as Aquisi��es</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Documentos de Aquisi��o</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Auditoria de Aquisi��es</a></li>
											<li><a>2. Negocia��es das Aquisi��es</a></li>	
											<li><a>3. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Aquisi��es Encerradas</a></li>
											<li><a>2. Atualiza��es nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>			
					</div>					
			    </div>
			  </div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-lg10" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			      <div class="table-responsive">
					<div class="sitemap">							
						<br><h1>Gerenciamento das Partes Interessadas do Projeto</h1>
						<h2>Gerencamento das Partes Interessadas do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>13.1 Identificar as Partes Interessadas</a>
								<ul>							
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>
											<li><a>2. Documentos das Aquisi��es</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas</a>
										<ul>
											<li><a>1. An�lise das Partes Interessadas</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">1. Registro das Partes Interessadas</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>13.2 Planejar o Gerenciamento das Partes Interessadas</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">2. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. Reuni�es</a></li>
											<li><a>3. T�cnicas An�liticas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">1. Plano de Gerenciamento das Partes Interessadas</a></li>
											<li><a>2. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>13.3 Gerenciar o Engajamento das Partes Interessadas</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">1. Plano de Gerenciamento das Partes Interessadas</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao">2. Plano de Gerenciamento das Comunica��es</a></li>
											<li><a>3. Registro das Mudan�as</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>
											<li><a>1. M�todo de Comunica��o</a></li>
											<li><a>2. Habilidade Interpessoais</a></li>
											<li><a>3. Habilidade de Gerenciamento</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">1. Registro das Quest�es</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>13.4 Controlar o Engajamento das Partes Interessadas</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">2. Registro das Quest�es</a></li>
											<li><a>3. Dados de Desempenho do Trabalho</a></li>
											<li><a>4. Documentos do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas</a>
										<ul>	
											<li><a>1. Sistema de Gerenciamento de Informa��o</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das</a>
										<ul>
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>			
					</div>					
			    </div>
			  </div>
			</div>
		</div>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>