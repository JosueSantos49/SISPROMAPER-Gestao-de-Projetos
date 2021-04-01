<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="#" type="image/x-icon"><!-- Icone na aba da página -->

<title>Gerenciamento de Integração do Projeto</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />

</head>

<body>

	<div class="sitemap">
		
		<h1>Gerenciamento de Integração do Projeto</h1>
		<h2>Visão Geral do Gerencamento da Integração do Projeto&mdash;</h2>
	
		<ul id="utilityNav">
			<li><a href="solicitacao_cadastro.jsp">Solicitação Acesso</a></li>
			<li><a href="testelogin.jsp">Acesso ao Sistema</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">4.1 Desenvolver o Termo de Abertura do Projeto</a>
				<ul>
					<li><a href="">Autor Projeto</a></li>
					<li><a href="">Data</a></li>
					<li><a href="">Título</a></li>
					<li><a href="">Descrição</a></li>					
					<li><a href="">Responsável</a></li>
					<li><a href="">Área</a>
						<ul>
							<li><a href="">Projeto Compulsório</a></li>
							<li><a href="">Projeto Qualitativo</a></li>
							<li><a href="">Projeto Quantitativo</a></li>							
							<li><a href="">Projeto Status</a></li>
						</ul>
				</ul>
			</li>			
			<li><a href="">Status</a>
				<ul>
					<li><a href="">Fase Projeto</a></li>
					<li><a href="">Percentual Evolução</a></li>
					<li><a href="">Percentual Planejado</a>
						<ul>
							<li><a href="">Data Status</a></li>
						</ul>
					</li>
					<li><a href="">Descrição</a></li>					
					<li><a href="">Ponto Positivo</a></li>
					<li><a href="">Ponto Negativo</a></li>
					<li><a href="">Tendência</a>
						<ul>
							<li><a href="">Data Inicio</a></li>
							<li><a href="">Data Fim</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Requerimento</a>
				<ul>
					<li><a href="">Requerimento Nome</a></li>
					<li><a href="">Descrição</a></li>
					<li><a href="">Resumo</a>
						<ul>
							<li><a href="">Requerimento Funcional</a></li>
							<li><a href="">Requerimento Tecnologico</a></li>
							<li><a href="">Requerimento Status</a></li>
						</ul>
					</li><!-- 
					<li><a href="/services/copywriting">Copywriting</a></li>
					<li><a href="/services/photography">Photography</a></li> -->
				</ul>
			</li>
			<li><a href="">RFP-Porjeto</a>
				<ul>
					<li><a href="">Código Projeto</a></li>
					<li><a href="">Código Item</a></li>
					<li><a href="">Nome RFP</a></li>
				</ul>
			</li>
			<li><a href="">RFP-Requerimento</a>
				<ul>
					<li><a href="">Iten Avaliação</a>
					<li><a href="">Avaliação RFP</a>
						<!-- <ul>
							<li><a href="contact/map">Map</a></li>
							<li><a href="contact/form">Contact Form</a></li>
						</ul> -->
					</li>
				</ul>
			</li>	
		</ul>

	</div>
	
	
	
	<div class="sitemap">
		
		<h1>Representação esquemática do processo</h1>
		<h2>Sistema Cadastro de Projeto - SCP &mdash; Version 1.0</h2>
	
		<ul id="utilityNav">
			<li><a href="solicitacao_cadastro.jsp">Solicitação Acesso</a></li>
			<li><a href="testelogin.jsp">Acesso ao Sistema</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Análise</a>
				<ul>
					<li><a href="">Tipo Análise</a></li>
					<li><a href="">Investimento</a></li>
				</ul>
			</li>			
			<li><a href="">Recursos Humanos</a>
				<ul>
					<li><a href="">ID R.H</a></li>
					<li><a href="">Nome</a></li>
					<li><a href="">Profissão</a>
					<li><a href="">Área</a></li>
					<li><a href="">Status</a>
				</ul>
			</li>
			<li><a href="">Métricas</a>
				<ul>
					<li><a href="">ID Métrica</a></li>
					<li><a href="">Índice</a>
						<ul>
							<li><a href="">Valor Referência - Hora</a></li>
							<li><a href="">Valor Hora Calculada - Dia</a></li>
						</ul>
					</li>
						
				</ul>				
			</li>
			<li><a href="">Alocação</a>
				<ul>
					<li><a href="">Projeto</a></li>
					<li><a href="">Recursos Humanos</a></li>
					<li><a href="">Profissão</a>
					<ul>
							<li><a href="">FY14/15</a></li>
							<li><a href="">FY15/16</a></li>
						</ul>
					</li>
				</ul>
			</li>
			
		</ul>

	</div>
	
	</body>
	
</html>
