<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="#" type="image/x-icon"><!-- Icone na aba da p�gina -->

<title>Gerenciamento de Integra��o do Projeto</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />

</head>

<body>

	<div class="sitemap">
		
		<h1>Gerenciamento de Integra��o do Projeto</h1>
		<h2>Vis�o Geral do Gerencamento da Integra��o do Projeto&mdash;</h2>
	
		<ul id="utilityNav">
			<li><a href="solicitacao_cadastro.jsp">Solicita��o Acesso</a></li>
			<li><a href="testelogin.jsp">Acesso ao Sistema</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">4.1 Desenvolver o Termo de Abertura do Projeto</a>
				<ul>
					<li><a href="">Autor Projeto</a></li>
					<li><a href="">Data</a></li>
					<li><a href="">T�tulo</a></li>
					<li><a href="">Descri��o</a></li>					
					<li><a href="">Respons�vel</a></li>
					<li><a href="">�rea</a>
						<ul>
							<li><a href="">Projeto Compuls�rio</a></li>
							<li><a href="">Projeto Qualitativo</a></li>
							<li><a href="">Projeto Quantitativo</a></li>							
							<li><a href="">Projeto Status</a></li>
						</ul>
				</ul>
			</li>			
			<li><a href="">Status</a>
				<ul>
					<li><a href="">Fase Projeto</a></li>
					<li><a href="">Percentual Evolu��o</a></li>
					<li><a href="">Percentual Planejado</a>
						<ul>
							<li><a href="">Data Status</a></li>
						</ul>
					</li>
					<li><a href="">Descri��o</a></li>					
					<li><a href="">Ponto Positivo</a></li>
					<li><a href="">Ponto Negativo</a></li>
					<li><a href="">Tend�ncia</a>
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
					<li><a href="">Descri��o</a></li>
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
					<li><a href="">C�digo Projeto</a></li>
					<li><a href="">C�digo Item</a></li>
					<li><a href="">Nome RFP</a></li>
				</ul>
			</li>
			<li><a href="">RFP-Requerimento</a>
				<ul>
					<li><a href="">Iten Avalia��o</a>
					<li><a href="">Avalia��o RFP</a>
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
		
		<h1>Representa��o esquem�tica do processo</h1>
		<h2>Sistema Cadastro de Projeto - SCP &mdash; Version 1.0</h2>
	
		<ul id="utilityNav">
			<li><a href="solicitacao_cadastro.jsp">Solicita��o Acesso</a></li>
			<li><a href="testelogin.jsp">Acesso ao Sistema</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">An�lise</a>
				<ul>
					<li><a href="">Tipo An�lise</a></li>
					<li><a href="">Investimento</a></li>
				</ul>
			</li>			
			<li><a href="">Recursos Humanos</a>
				<ul>
					<li><a href="">ID R.H</a></li>
					<li><a href="">Nome</a></li>
					<li><a href="">Profiss�o</a>
					<li><a href="">�rea</a></li>
					<li><a href="">Status</a>
				</ul>
			</li>
			<li><a href="">M�tricas</a>
				<ul>
					<li><a href="">ID M�trica</a></li>
					<li><a href="">�ndice</a>
						<ul>
							<li><a href="">Valor Refer�ncia - Hora</a></li>
							<li><a href="">Valor Hora Calculada - Dia</a></li>
						</ul>
					</li>
						
				</ul>				
			</li>
			<li><a href="">Aloca��o</a>
				<ul>
					<li><a href="">Projeto</a></li>
					<li><a href="">Recursos Humanos</a></li>
					<li><a href="">Profiss�o</a>
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
