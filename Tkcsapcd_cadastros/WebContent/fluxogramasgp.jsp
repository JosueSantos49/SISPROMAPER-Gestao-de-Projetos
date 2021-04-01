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

<title>Grupo de Processo de Gerenciamento de Projetos</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap_gp.css" />

</head>

<body>

	<div class="sitemap">
		
		<h1>Grupo de Processos de Gerenciamento de Projetos e mapeamento da Áreas do Conhecimento</h1>
		<h2>Sispromaper &mdash; Version 1.0</h2>
							
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a>Grupo de Processos de Gerenciamento de Projetos</a></li>
			<li><a>Áreas do Conhecimento do Grupo de Processos</a>
				<ul>
					<li><a><br>4. Gerenciamento da Interação do Projeto <br><br></a></li>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent"><br><br><br>5. Gerenciamento do Escopo do Projeto <br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br>6. Gerenciamento do Tempo de Projeto <br><br><br><br><br><br><br></a></li>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent"><br><br><br>7. Gerenciamento dos Custos do Projeto<br><br><br><br></a></li>					
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent">8. Gerenciamento da Qualidade do Projeto<br><br></a></li>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent"><br><br>9. Gerenciamento dos Recursos Humanos do Projeto<br><br><br><br></a>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent">10. Gerenciamento das Comunicações do Projeto<br><br></a>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent"><br><br><br><br><br>11. Gerenciamento dos Riscos do Projeto<br><br><br><br><br><br><br></a>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent">12. Gerenciamento das Aquisições do Projeto<br><br></a>
					<li><a href="fluxo_planogerprojeto.jsp" target="_parent">13. Gerenciamento das Partes Interresadas<br></a>			
				</ul>
			</li>			
			<li><a>Grupo de Processo de Iniciação</a>
				<ul id="GrupoIniciacao">
					<li><a href="TkcsapcdController?cmd=editarProjeto" target="_parent">4.1 Desenvolver o Termo de Abertura do Projeto<br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br></a></li>	
					<li><a><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br></a></li>	
					<li><a href="TkcsapcdController?cmd=editarStakeholders" target="_parent">13.1 Identificar as Partes Interresadas</a></li>
				</ul>
			</li>
			<li><a>Grupo de Processo de Planejamento</a>
				<ul>
					<li><a href="fluxo_metodologiapmo.jsp" target="_parent"><br>4.2 Desenvolver Plano de Gerenciamento do Projeto <br><br></a></li>
					<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo" target="_parent">5.1 Planejar o Gerenciamento do Escopo;<br><br>5.2 Coletar os Requisitos;<br>5.3 Definir o escopo;<br>5.4 Criar a Estrutura Analítica do Projeto <br><br></a></li>
					<li><a><br><br>6.1 Planejar Gerenciamento do Escopo; <br><br>6.2 Definir as Atividades; <br><br>6.3 Sequenciar as Atividades; <br><br>6.4 Estimar os Recursos Atividades;<br>6.5 Estimar as durações das Atividades; <br><br>6.6 Desenvolver o cronograma<br><br></a></li>
					<li><a><br>7.1 Planejar Gerenciamento dos Custos; <br><br>7.2 Estimar os custos;<br><br>7.3 Determinar o Orçamento <br><br></a></li>
					<li><a><br>8.1 Planejar o gerenciamento da Qualidade</a></li>
					<li><a><br><br>9.1 Planejar o gerenciamento dos Recursos Humanos<br><br><br><br></a></li>
					<li><a><br>10.1 Planejar o gerenciamento das comunicações</a></li>
					<li><a href="TkcsapcdController?cmd=editarRiscos" target="_parent">11.1 Planejar o gerenciamento dos riscos; <br><br>11.2 Identificar os riscos;<br><br>11.3 Realizar as análises quanlitativas dos riscos<br><br>11.4 Realizar a análise qualitativa dos riscos<br><br>11.5 Planejar as respostas aos riscos</a></li>
					<li><a>12.1 Planejar o gerenciamento das aquisições</a></li>
					<li><a>13.2 Planejar o gerenciamento das partes interessadas</a></li>				
				</ul>
			</li>
			<li><a>Grupo de Processo de Execução</a>
				<ul>
					<li><a><br>4.3 Orientar e Gerenciar o Trabalho do Projeto<br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br></a></li>
					<li><a>8.2 Realizar a garantia da qualidade<br><br></a></li>
					<li><a>9.2 Mobilizar a equipe do projeto<br><br>9.3Desenvolver a equipe do projeto;<br><br>9.4Gerenciar a equipe do projeto</a></li>
					<li><a>10.2 Gerenciar as comunicações<br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a>12.2 Conduzir as aquisições<br><br></a></li>
					<li><a>12.3 Planejar o engajamento das partes interessadas</a></li>
				</ul>
			</li>
			<li><a>Grupo de Processo de Monitoramento e Controle</a>
				<ul>
					<li><a>4.4 Monitorar e Controlar o Trabalho do Projeto; <br><br> 4.5 Realizar o Controle Integrado de Mudanças</a>
					<li><a><br><br><br>5.5 Validar o Escopo;<br><br> 5.6 Controlar o Escopo<br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br>6.7 Controlar o  Cronograma<br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br>7.4 Controlar os custos<br><br><br><br><br></a></li>
					<li><a>8.3 Controlar qualidade<br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br></a>
					<li><a>10.3 Controlar as comunicações<br><br></a></li>
					<li><a><br><br><br><br><br><br>11.6 Controlar os riscos<br><br><br><br><br><br><br><br></a></li>
					<li><a>12.3 Controlar as aquisições<br><br></a></li>
					<li><a>13.4 Controlar o engajamento das partes interessadas</a></li>
					
				</ul>
			</li>	
			<li><a>Grupo de Processo de Encerramento</a>
				<ul>
					<li><a href="TkcsapcdController?cmd=editarProjetoTermoEncerramento" target="_parent">4.6 Encerrar a fase ou o Projeto<br><br></a>
					<li><a><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br></a></li>
					<li><a><br><br><br></a></li>
					<li><a><br><br><br><br><br><br><br><br><br><br><br><br><br><br></a></li>
					<li><a><br>12.4 Encerrar as aquisições<br></a></li>
					<li><a><br><br></a></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
	
</html>
