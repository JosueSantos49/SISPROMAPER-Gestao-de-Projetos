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

<title>Encerramento</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />

</head>

<body>
	
	<div class="sitemap">		
		<h2>Exemplo - Requisitos de recursos das atividades / Estrutura analítica dos recursos</h2>
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Projeto</a></li>
			<li><a href="">Mão-de-obra</a>
				<ul>
					<li><a href="">Gerente de Projetos</a>
						<ul>
							<li><a href="">Apoio GP</a></li>					       
						</ul>
					</li>
					<li><a href="">PMO</a></li>
					<li><a href="">Analista 1</a></li>
					<li><a href="">Analista 2</a></li>
				</ul>
			</li>			
			<li><a href="">Equipamentos</a>
				<ul>
					<li><a href="">Computador</a></li>
					<li><a href="">Projetor</a></li>
					<li><a href="">Impressora</a></li>					
				</ul>
			</li>
			<li><a href="">Imóveis</a>
				<ul>
					<li><a href="">Sala</a></li>					
				</ul>
			</li>
			<li><a href="">Suprimentos</a>
				<ul>
					<li><a href="">Folhas</a></li>
					<li><a href="">Toner / Impressora</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
</body>	
</html>
