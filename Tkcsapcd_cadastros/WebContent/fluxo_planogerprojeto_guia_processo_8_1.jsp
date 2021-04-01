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

<title>Plano de Gerenciamento de Projetos</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />

</head>

<body>

	<div class="sitemap">		
		<h1>Plano de Gerenciamento da Qualidade</h1>
		<h2>Sistema Cadastro de Projeto - SCP &mdash; Version 1.0</h2>	
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento da qualidade</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade" target="_parent">Cad. Plano G. Qualidade</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoQualidade" target="_parent">Cons. Plano. G. Qualidade</a></li>
					        <li><a href="imprimir_plano_gerenciamento_qualidade.jsp" target="_parent">Rel. Plano. G. Qualidade</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">Plano de gerenciamento da qualidade</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">8 - qualidade</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>CheckList ou Lista de Verificação de Qualidade </h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">CheckList ou Lista de Verificação de Qualidade </a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaQualidade" target="_parent">Cad. Lista Verificação Qualidade</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarListaQualidade" target="_parent">Cons. Lista Verificação Qualidade</a></li> 
					        <li><a href="imprimir_lista_qualidade.jsp" target="_parent">Rel. Lista Verificação Qualidade</a></li>
						</ul>        
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">CheckList ou Lista de Verificação de Qualidade para os processos de planejamento da Metodologia da Escritório de Projetos</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">8 - qualidade</a></li>					
				</ul>
			</li>				
		</ul>
	</div><div class="sitemap">		
		<h1>Plano de melhorias de processo</h1>
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de melhorias de processo</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso" target="_parent">Cad. P. M. Processo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoMelhoriaProcesso" target="_parent">Cons. P. M. Processo</a></li>
					        <li><a href="imprimir_plano_melhoria_processo.jsp" target="_parent">Rel. P. M. Processo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">O plano de melhorias no processo é um plano auxiliar do plano de gerenciamento do projeto. O plano de melhorias no processo detalha as etapas de análise de processos para identificar as atividades que aumentam o seu valor. Saída 4 do Processo 8.1 Planejar a Qualidade.</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">5 - escopo</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
</body>	
</html>
