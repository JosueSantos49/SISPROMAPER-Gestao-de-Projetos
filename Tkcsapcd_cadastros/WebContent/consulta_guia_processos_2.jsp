<!-- 
	Autor: Josué da Conceição Santos
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
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
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
					Olá, 
					<%=session.getAttribute("theName")%>
						<%  
						//verifica se a sessao do usuario é válida  
						if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
					%>
					seja bem-vindo a etapa de consultar processo. Você poderá verificar a visão geral de cada processo, basta somente clicar no link de cada linha da tabela, que será aberta a visão geral de cada processo em forma de WBS.  
				</div>
			</div>
		</div>
		
			<div class="table-responsive">	
				<table class="table table-bordered table-hover">
				<caption></caption>
					<caption></caption>
					<thead>
						<tr>
							<th>TABELA DE GUIA VISÃO GERAL DE PROCESSOS</th>
							<th>Link</th>		
						</tr>
					</thead>
					  <tr>
					    <td>Gerenciamento da Integração do Projeto</td>
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
					    <td>Gerenciamento das Comunicações do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg7">Verificar</button></td>
					  </tr>	
					  <tr>
					    <td>Gerenciamento das Comunicações do Projeto</td>
						<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg8">Verificar</button></td>
					  </tr>	
					  <tr>
					    <td>Gerenciamento das Aquisições do Projeto</td>
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
						<br><h1>Gerenciamento de Integração do Projeto</h1>
						<h2>Gerencamento da Integração do Projeto - Digitar ESC Fechar</h2>
					
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
											<li><a>1. Especificação do Trabalho do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarBusinessCase">2. Business Case</a></li>
											<li><a>3. Acordos</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
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
							<li><a>4.2 Desenvolver o Plano de Gerenciamento do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>					
											<li><a>2. Saídas de Outros Processos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Técnicas de facilitação</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitação de Mudanças Aprovadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Sistema de Informação de Gerenciamento de Projetos</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Entregas</a></li>
											<li><a>2. Dados de Desenpenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitação de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.4 Monitorar e Controlar o Trabalho do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Previsões de Cronograma</a></li>
											<li><a>3. Previsões de Custos</a></li>
											<li><a>4. Mudanças Validadas</a></li>
											<li><a>5. Informações Sobre o Desenpenho do Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Técnicas Analíticas</a></li>
											<li><a>3. Sistema de Informação do Gerenciamento do Projeto</a></li>
											<li><a>4. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudanças</a></li>
											<li><a>2. Relatório de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerencimaento do Projeto</a></li>
											<li><a>4. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.5 Realizar o Controle Integrado de Mudanças</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Relatório de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitações de Mudanças</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Reuniões</a></li>
											<li><a>3. Ferramentas de Controle de Mudanças</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudança Aprovada</a></li>
											<li><a>2. Registro de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualização nos Documentos do Projeto</a></li>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Técnicas Analíticas</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Transição do Produto, Serviço ou Resultado Final</a></li>										
											<li><a>2. Atualização nos Ativos de Processos Organizacionais</a></li>
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
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Opinião Especializada</a></li>
											<li><a>2. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Entrevistas</a></li>
											<li><a>2. Grupo de Discussão</a></li>
											<li><a>3. Oficinas Facilitadas</a></li>
											<li><a>4. Técnicos de Criatividades em Grupo</a></li>
											<li><a>5. Técnicas de Tomadas de Decisão em Grupo</a></li>
											<li><a>6. Questionários e Pesquisas</a></li>
											<li><a>7. observações</a></li>
											<li><a>8. Protótipos</a></li>
											<li><a>9. Benchmarking</a></li>
											<li><a>10. Diagrama de Contexto</a></li>
											<li><a>11. Análise dos Documentos</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Análise de Produto</a></li>
											<li><a>3. Geração de Alternativas</a></li>
											<li><a>4. Oficinas Facilitadoras</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Documentos dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">2. Matriz de Rastreabilidade dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.4 Criar a Estrutura Analítica do Projeto (EAP)</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>					
											<li><a>2. Especialização do Escopo do Projeto</a></li>
											<li><a>3. Documentação dos Requisitos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Decomposição</a></li>
											<li><a>2. Opinião Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Linha de Base do Escopo</a></li>
											<li><a>2. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.5 Validar o Escopo</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentação dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matriz de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Entregas Verificadas</a></li>
											<li><a>5. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Inspeção</a></li>
											<li><a>2. Técnicas de Tomada de Decisão em grupo</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Entregas Aceitas</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a>3. Informações sobre o Desempenho do Trabalho</a></li>
											<li><a>4. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.6 Controlar o Escopo</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentação dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matrís de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Análise de Variação</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>										
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitação de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações do Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos Ativos de Processos Organizacionais</a></li>
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
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Opinião Especializada</a></li>
											<li><a>2. Técnicas Analíticas</a></li>
											<li><a>3. Reuniõess</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Decomposição</a></li>
											<li><a>2. Planejamento em Ondas Sucessivas</a></li>
											<li><a>3. Opinião especializada</a></li>											
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Lista de Atividades</a></li>
											<li><a>2. Atributos das Atividades</a></li>
											<li><a>3. Lista de Atividades</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.3 Sequênciar as Atividades</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a>2. Lista de Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Lista de Marcos</a></li>
											<li><a>5. Especialização do Escopo do Projeto</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Método do Diagrama de Precedência (MDP)</a></li>
											<li><a>2. Determinação de Dependência</a></li>
											<li><a>3. Antecipações e Esperas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Diagrama de Rede do Cronograma do Projeto</a></li>
											<li><a>3. Atualização nos Documentos do Projeto</a></li>
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
											<li><a>4. Calendários dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">5. Registro dos Riscos</a></li>
											<li><a>6. Estimativas de Custo das Atividades</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">7. Fatores Ambientais da Empresa</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Análise de Alternativas</a></li>
											<li><a>3. Dados publicados sobre estimativas</a></li>
											<li><a>4. Estimativa de Bottom-up</a></li>
											<li><a>5. Software de Gerenciamento de Projeto</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Requisitos de Recursos das Atividades</a></li>
											<li><a>2. Estrutura Analítica dos Recursos</a></li>
											<li><a>3. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.5 Estimar as Durações das Atividades</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista das Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Requisitos de Recursos das Atividades</a></li>
											<li><a>5. Calendários dos Recursos</a></li>
											<li><a>6. Especificação do Escopo do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">7. Registro do Riscos</a></li>
											<li><a>8. Estrutura Analítica dos Recursos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">9. Fatores Ambientais da Empresa</a></li>
											<li><a>10. Ativos de Processo Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Estimativa Análoga</a></li>
											<li><a>3. Estimativa Paramétrica</a></li>
											<li><a>4. Estimativa de 3 pontos</a></li>
											<li><a>5. Técnica de Tomada de Decisão em Grupo</a></li>
											<li><a>6. Análise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Estimativas das durações das Atividades</a></li>
											<li><a>2. Atualização nos Documentos do Projeto</a></li>
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
											<li><a>6. Calendários dos Recursos</a></li>
											<li><a>7. Estimativa de Duração das Atividades</a></li>
											<li><a>8. Especificação do Escopo do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">9. Registro do Riscos</a></li>
											<li><a>10. Desgnações do Pessoal do Projeto</a></li>
											<li><a>11. Estrutura Analítica dos Recursos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">12. Fatores Ambientais da Empresa</a></li>
											<li><a>13. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Análise de Rede do Cronograma</a></li>
											<li><a>2. Método do Caminho Crítico</a></li>
											<li><a>3. Método da Corrente Crítica</a></li>
											<li><a>4. Técnica de Otimizações de Recursos</a></li>
											<li><a>5. Técnicas de Desenvolvimento de Modelos</a></li>
											<li><a>6. Antecipação e Espera</a></li>
											<li><a>7. Compressão de Cronograma</a></li>
											<li><a>8. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Linha de Base do Cronograma</a></li>										
											<li><a>2. Cronograma do Projeto</a></li>
											<li><a>3. Dados do Cronograma</a></li>
											<li><a>4. Calendário do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualização nos Documentos do projeto</a></li>
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
											<li><a>4. Calendário do Projeto</a></li>
											<li><a>5. Dados do Cronograma</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Análise de Dempenho</a></li>
											<li><a>2. Software de Gerenciamento de Projeto</a></li>
											<li><a>3. Técnicas de Otimização de Recursos</a></li>
											<li><a>4. Técnicas de Desenvolvimento de Modelos</a></li>
											<li><a>5. Antecipações e Esperas</a></li>
											<li><a>6. Compressão de Cronograma</a></li>
											<li><a>7. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações sobre o Desenvolvimento do Trabalho</a></li>										
											<li><a>2. Previsão de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitações de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualizações nos Documentos do Projeto</a></li>
											<li><a>6. Atualizações nos Ativos de Processos Organizacionais</a></li>
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
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Opinião Especializada</a></li>
											<li><a>2. Técnicas Análiticas</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opiniões Especializadas</a></li>
											<li><a>2. Estimativa Análoga</a></li>
											<li><a>3. Estimativa Paramétrica</a></li>
											<li><a>4. Estimativa "Bottom-up"</a></li>
											<li><a>5. Estimativa de 3 Pontos</a></li>
											<li><a>6. Análise de Reservas</a></li>
											<li><a>7. Custo de Qualidade</a></li>
											<li><a>8. Software de Gerenciamento de Projetos</a></li>
											<li><a>9. Análise de Proposta de Fornecedor</a></li>
											<li><a>10. Técnicas de Tomada de Decisão em Grupo</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Estimativa de Custos das Atividades</a></li>
											<li><a>2. Base das Estimativas</a></li>
											<li><a>3. Atualizações nos Documentos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>7.3 Determinar o Orçamento</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a>3. Estimativas dos Custos das Atividades</a></li>
											<li><a>4. Base das Estimativas</a></li>
											<li><a>5. Cronograma do Projeto</a></li>
											<li><a>6. Calendário dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">7. Registro dos Riscos</a></li>
											<li><a>8. Acordos</a></li>
											<li><a>9. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Agragação de Custos</a></li>
											<li><a>2. Análise de Reservas</a></li>
											<li><a>3. Opinião Especializada</a></li>
											<li><a>4. Relações Históricas</a></li>
											<li><a>Reconciliação dos Limites de Recursos Financeiros</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Linha de Base dos Documentos</a></li>
											<li><a>2. Requisitos de Recursos</a></li>
											<li><a>3. Atualizações nos Documentos do Projeto</a></li>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Gerenciamento do Valor Agregado</a></li>
											<li><a>2. Previsão</a></li>
											<li><a>3. Índice de Desempenho para Término (IDPT)</a></li>
											<li><a>4. Análise de Desempenho</a></li>
											<li><a>5. Software de Gerenciamento de Projetos</a></li>
											<li><a>6. Análise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações sobre o desempenho do Trabalho</a></li>
											<li><a>2. Previsões de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualização no Planode gerenciamento do Projeto</a></li>
											<li><a>5. Atualização nos documentos do Projeto</a></li>
											<li><a>6. atualizações nos Ativos de Processos Organizacionais</a></li>											
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
											<li><a>4. Documentação dos Requisitos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">5. Fatores Ambientais da Empresa</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Análise Custo-Benefício</a></li>
											<li><a>2. Custo de Qualidade</a></li>
											<li><a>3. Sete Ferramentas de Qualidade Básicas</a></li>
											<li><a>4. Benchmarking</a></li>
											<li><a>5. Projeto de Experimentos</a></li>
											<li><a>6. Amostra Artística</a></li>
											<li><a>7. Ferramentas Adicionais de Planejamento da Qualidade</a></li>
											<li><a>8. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade">1. Plano de Gerenciamento da Qualidade</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso">2. Plano de Melhorias no Processo</a></li>
											<li><a>3. Métricas da Qualidade</a></li>
											<li><a>4. Lista de Verificação da Qualidade</a></li>
											<li><a>5. Atualização nos Documentos do Projeto</a></li>
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
											<li><a>3. Métricas da Qualidade</a></li>
											<li><a>4. Medições do Controle de Qualidade</a></li>
											<li><a>5. Documentação do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Ferramenta de Gerenciamento e Controle da Qualidade</a></li>
											<li><a>2. Auditoria de Qualidade</a></li>
											<li><a>3. Análise de Processo</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualizações nos Documentos do Projeto</a></li>
											<li><a>4. Atualização nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>8.3 Controlar a Qualidade</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Métricas da Qualidade</a></li>
											<li><a>3. Lista de Verificação da Qualidade</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicitações de Mudanças Aprovadas</a></li>
											<li><a>6. Entregas</a></li>
											<li><a>7. Documentos do Projeto</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Sete Ferramentas de Qualidade Básicas</a></li>
											<li><a>2. Amostragem Estatísticas</a></li>
											<li><a>3. Inspeção</a></li>
											<li><a>4. Análise das Solicitações de Mudanças Aprovadas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Medições do Controle de Qualidade</a></li>
											<li><a>2. Alterações validas</a></li>
											<li><a>3. Entregas Verificadas</a></li>
											<li><a>4. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">6. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>7. Atualizações nos Documentos do Projeto</a></li>
											<li><a>8. Atualizações nos ativos de Processos Organizacionais</a></li>
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
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Organograma e Descrições de Cargos</a></li>
											<li><a>2. Networking</a></li>
											<li><a>3. Teoria Organizacional</a></li>
											<li><a>4. Opinião Especializada</a></li>
											<li><a>5. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Pré-designação</a></li>
											<li><a>2. Negociação</a></li>
											<li><a>3. Contratação</a></li>
											<li><a>4. Equipes Virtuais</a></li>
											<li><a>5. Análise de Decisão Envolvendo Critérios Múltiplos</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Designações do Pessoal do Projeto</a></li>
											<li><a>2. Calendário dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>9.3 Desenvolver a Equipe do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>2. Desgnação do Pessoal do Projeto</a></li>
											<li><a>3. Calendários dos Recursos</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Habilidades Interpessoais</a></li>
											<li><a>2. Treinamento</a></li>
											<li><a>3. Atividades de Construção da Equipe</a></li>
											<li><a>4. Regrás Básicas</a></li>
											<li><a>5. Agrupamento</a></li>
											<li><a>6. Reconhecimento e Recompensas</a></li>
											<li><a>7. Ferramentas de Avaliação dos Funcionários</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Avaliações de Desempenho da Equipe</a></li>
											<li><a>2. Atualizações nos Fatores Ambientais da Empresa</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>9.4 Gerenciar a Equipe do Projeto</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>2. Desgnação do Pessoal do Projeto</a></li>
											<li><a>3. Avaliações de Desempenho da Equipe</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">4. Registro das Questões</a></li>
											<li><a>5. Relatórios do Desempenho do Trabalho</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Observações e Conversas</a></li>
											<li><a>2. Avaliações de Desempenho do Projeto</a></li>
											<li><a>3. Gerenciamento de Conflitos</a></li>
											<li><a>4. Habilidades Interpessoais</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Avaliações nos Documentos do Projeto</a></li>
											<li><a>4. Atualizações nos Fatores Ambientais da Empresa</a></li>
											<li><a>5. Atualizações nos Ativos de Processos Organizacionais</a></li>	
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
						<br><h1>Gerenciamento das Comunicações do Projeto</h1>
						<h2>Gerencamento das Comunicações do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>10.1 Planejar o Gerenciamento das Comunicações</a>
								<ul>								
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">2. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Análise de Requisitos das Comunicações</a></li>
											<li><a>2. Tecnologias de Comunicações</a></li>
											<li><a>3. Modelos de Comunicações</a></li>
											<li><a>4. Métodos de Comunicações</a></li>
											<li><a>5. Projeto de Experimentos</a></li>
											<li><a>6. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunicações</a></li>
											<li><a>2. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>10.2 Gerenciar as Comunicações</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunicações</a></li>					
											<li><a>2. Relatório de Desempenho de Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Tecnologias de Comunicações</a></li>
											<li><a>2. Modelos de Comunicações</a></li>
											<li><a>3. Métodos de Comunicações</a></li>
											<li><a>4. Sistemas de Gerenciamento de Informações</a></li>
											<li><a>5. Relatórios de Desempenho</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Comunicações do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualizações nos Documentos do Projeto</a></li>
											<li><a>4. Atualização nos aditivos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>10.3 Controlar as Comunicações</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Comunicações do Projeto</a></li>
											<li><a>3. Registro das Questões</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Sistemas de Gerenciamento de Informações</a></li>
											<li><a>2. Opiniões Especializadas</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
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
						<br><h1>Gerenciamento das Comunicações do Projeto</h1>
						<h2>Gerencamento das Comunicações do Projeto - Digitar ESC Fechar</h2>
					
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
											<li><a>1. Tecnicas Analíticas</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
											<li><a>8. Estimativas das Durações das Atividades</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">9. Registros das Partes Interessadas</a></li>
											<li><a>10. Documentos do Projeto</a></li>
											<li><a>11. Documentos da Aquisição</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">12. Fatores Ambientais da Empresa</a></li>
											<li><a>13. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Revisões de Documentação</a></li>
											<li><a>2. Técnicas de Coleta de Informações</a></li>
											<li><a>3. Análise de Listas de Verificação</a></li>
											<li><a>4. Análise de Premissas</a></li>
											<li><a>5. Técnicas de Diagrama</a></li>
											<li><a>6. Análise de Forças, Fraquezas, Oportunidades e Ameças (SWOT)</a></li>
											<li><a>7. Opinião Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">1. Registro dos Riscos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.3 Realizar a Análise Qualitativa dos Riscos</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Avaliação de Probabilidade e Impacto dos Riscos</a></li>
											<li><a>2. Matriz de Probabilidade e Impacto</a></li>
											<li><a>3. Avaliação de Qualidade dos Dados sobre Riscos</a></li>
											<li><a>4. Categorização de Riscos</a></li>
											<li><a>5. Avaliação da Urgência dos Riscos</a></li>
											<li><a>6. Opinião Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Atualizações nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.4 Realizar a Análise Qualitativa dos Riscos</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Técnicas de Coleta e Apresentação de Dados</a></li>
											<li><a>2. Técnicas de Modelagem e Análise Quantitativa Especializada</a></li>	
											<li><a>3. Opinião Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Estratégias para Riscos Negativos ou Ameaças</a></li>
											<li><a>2. Estratégias para Riscos Positivos ou Oportunidades</a></li>
											<li><a>3. Estratégias de respostas de Contigência</a></li>
											<li><a>4. Opinião Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">1. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Atualizações nos Documentos do Projeto</a></li>
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
											<li><a>4. Relatório de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Reavaliação dos Riscos</a></li>
											<li><a>2. Auditoria dos Riscos</a></li>
											<li><a>3. Análise de Avaliação de Tendência</a></li>
											<li><a>4. Medição de Desempenho Técnico</a></li>
											<li><a>5. Análise de Reservas</a></li>
											<li><a>6. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos Ativos de Processos Organizacionais</a></li>
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
						<br><h1>Gerenciamento das Aquisições do Projeto</h1>
						<h2>Gerencamento das Aquisições do Projeto - Digitar ESC Fechar</h2>
					
						<ul id="utilityNav">
							<li><a href="consulta_guia_processos_2.jsp" target="_parent">Voltar</a></li>
							<li><a href="index_principal.jsp" target="_parent">Home</a></li>							
						</ul>
				
						<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>12.1 Planejar o Gerenciamento das Aquisições</a>
								<ul>							
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Documentação dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a>4. Requisitos de Recursos das Atividades</a></li>
											<li><a>5. Cronograma do Projeto</a></li>
											<li><a>6. Estimativa dos Custos das Atividades</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">7. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">8. Fatores Ambientais da Empresa</a></li>
											<li><a>9. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Análise de fazer ou comprar</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Pesquisa de Mercado</a></li>
											<li><a>4. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisições</a></li>
											<li><a>2. Especificação do Trabalho das Aquisições</a></li>
											<li><a>3. Documentos de Aquisição</a></li>
											<li><a>4. Critérios para Seleção de Fontes</a></li>
											<li><a>5. Decisões de Fazer ou Comprar</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">6. Solicitações de Mudanças</a></li>
											<li><a>7. Atualizações nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>12.2 Conduzir as Aquisições</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisições</a></li>
											<li><a>2. Documentos das Aquisições</a></li>
											<li><a>3. Critérios para Seleção de Fontes</a></li>
											<li><a>4. Propostas dos Fornecedores</a></li>
											<li><a>5. Documentos do Projeto</a></li>
											<li><a>6. Decisões de Fazer ou Comprar</a></li>
											<li><a>7. Especificação do Trabalho das Aquisições</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Reunião com Licitantes</a></li>
											<li><a>2. Técnicas de Avaliação Propostas</a></li>
											<li><a>3. Estimativas Independentes</a></li>
											<li><a>4. Opinião Especializada</a></li>
											<li><a>5. Publicidade</a></li>
											<li><a>6. Técnicas Análiticas</a></li>
											<li><a>7. Negociações das Aquisições</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarFornecedorQualificado">1. Fornecedores Selecionados</a></li>
											<li><a>2. Acordos</a></li>
											<li><a>3. Calendários dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualizações nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>12.3 Controlar as Aquisições</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentos de aquisição</a></li>
											<li><a>3. Acordos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicitação de Mudanças Aprovadas</a></li>
											<li><a>5. Relatórios Desempenho do Trabalho</a></li>
											<li><a>6. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Sistema de Controle de Mudança no Contrato</a></li>
											<li><a>2. Análise de Desempenho das Aquisições</a></li>
											<li><a>3. Inspeções e Auditorias</a></li>
											<li><a>4. Relatório de Desempenho</a></li>
											<li><a>5. Sistema de Pagamento</a></li>
											<li><a>6. Administração de Reivindicações</a></li>
											<li><a>7. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>12.4 Encerrar as Aquisições</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Documentos de Aquisição</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Auditoria de Aquisições</a></li>
											<li><a>2. Negociações das Aquisições</a></li>	
											<li><a>3. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Aquisições Encerradas</a></li>
											<li><a>2. Atualizações nos Ativos de Processos Organizacionais</a></li>
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
											<li><a>2. Documentos das Aquisições</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e Técnicas</a>
										<ul>
											<li><a>1. Análise das Partes Interessadas</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
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
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Opinião Especializada</a></li>
											<li><a>2. Reuniões</a></li>
											<li><a>3. Técnicas Análiticas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">1. Plano de Gerenciamento das Partes Interessadas</a></li>
											<li><a>2. Atualizações nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>13.3 Gerenciar o Engajamento das Partes Interessadas</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">1. Plano de Gerenciamento das Partes Interessadas</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao">2. Plano de Gerenciamento das Comunicações</a></li>
											<li><a>3. Registro das Mudanças</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>
											<li><a>1. Método de Comunicação</a></li>
											<li><a>2. Habilidade Interpessoais</a></li>
											<li><a>3. Habilidade de Gerenciamento</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">1. Registro das Questões</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>13.4 Controlar o Engajamento das Partes Interessadas</a>
								<ul>
									<li><a>1. Entradas</a>
										<ul>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">2. Registro das Questões</a></li>
											<li><a>3. Dados de Desempenho do Trabalho</a></li>
											<li><a>4. Documentos do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas</a>
										<ul>	
											<li><a>1. Sistema de Gerenciamento de Informação</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas</a>
										<ul>
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
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