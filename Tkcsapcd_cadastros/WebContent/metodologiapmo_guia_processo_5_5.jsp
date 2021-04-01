<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->	
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="#" type="image/x-icon"><!-- Icone na aba da página -->

<title>Metodologia</title>

<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap.css" />

</head>

<body>

	<div class="sitemap">		
		<h1>Aceite da Entrega</h1>
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sessão</a></li>
		</ul>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Aceite da Entrega</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarTermoAceiteEntrega" target="_blank">Cad. Aceite da Entrega</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarTermoAceiteEntrega" target="_blank">Cons. Aceite da Entrega</a></li> 
					        <li><a href="imprimir_termo_aceite_entrega.jsp" target="_blank">Rel. Aceite da Entrega</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">E</a></li>					
				</ul>
			</li>
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">Documento de aceitação formal de entrega pelo cliente. A entrega pode ser qualquer produto gerado pelo projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Solicitação de mudança</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Solicitação de mudança</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_blank">Cad. Solicitação Mudança</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca" target="_blank">Cons. Solicitação Mudança</a></li>
					        <li><a href="imprimir_solicitacao_mudanca.jsp" target="_blank">Rel. Solicitação Mudança</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descrição</a>
				<ul>
					<li><a href="">Solicitação de mudança: Documentar as mudanças solicitadas e aprova-las conforme workflow definido no Plano de Gerenciamento do Projeto</a></li>					
				</ul>
			</li>
			<li><a href="">Área de Conhecimento</a>
				<ul>
					<li><a href="">4 - integração</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
</body>	
</html>
