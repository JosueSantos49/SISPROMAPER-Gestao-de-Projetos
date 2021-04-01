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

<title>Planejamento</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />

</head>

<body>

	<div class="sitemap">		
		<h1>Plano de Gerenciamento das Aquisições</h1>
		<h2>Sistema Cadastro de Projeto - SCP &mdash; Version 1.0</h2>	
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento das Aquisições</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao" target="_parent">Cad. Plano G. Aquisições</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoAquisicao" target="_parent">Cons. Plano. G. Aquisições</a></li>
						    <li><a href="imprimir_plano_gerenciamento_aquisicao.jsp" target="_parent">Rel. Plano. G. Aquisições</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">O Plano de Gerenciamento das Aquisições tem como objetivo descrever como os processos de aquisição serão gerenciados desde o desenvolvimento dos documentos de aquisições até o fechamento do contrato.</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">12 - aquisições</a></li>					
				</ul>
			</li>				
		</ul>		
	</div>
	
	<div class="sitemap">		
		<h1>Declaração de trabalho ou Statement of Work (SOW)</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Declaração de trabalho ou Statement of Work (SOW)</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDeclaracaoTrabalho" target="_parent">Cad. Declaração Trabalho</a></li>
							<li><a href="TkcsapcdController?cmd=consultarDeclaracaoTrabalho" target="_parent">Cons. Declaração Trabalho</a></li>
							<li><a href="imprimir_declaracao_trabalho.jsp" target="_parent">Rel. Declaração Trabalho</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">Declaração de trabalho ou Statement of Work (SOW). Descrição de um produto ou serviço para ser adquirido sob um contrato; Declaração de requisitos. Desenvolvida a partir da linha de base do escopo. Deve fornecer informação suficiente para o vendedor criar e precificar uma proposta aderente a necessidade do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">12 - aquisições</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Critérios para Seleção de Fontes</h1>
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Critérios para Seleção de Fontes</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarCriterioPreQualificacao" target="_parent">Cad. Seleção Fonte (Pré-qualificação)</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarCriterioPreQualificacao" target="_parent">Cons. Seleção Fonte (Pré-qualificação)</a></li>
					        <li><a href="imprimir_criterio_pre_qualificacao.jsp" target="_parent">Rel. Seleção Fonte (Pré-qualificação)</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">Planilha com Critérios para Seleção de Fontes. Para medir, comparar  e/ou pontuar as propostas dos fornecedores. Possuem critérios Eliminatórios e Classificatórios</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">12 - aquisições</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
		
	