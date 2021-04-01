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

<%@include file="css_js_configuracao.jsp" %><!-- Configuracao da formatacao da pagina, configurando modal dialog -->

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

<div id="main" class="container">
	<div class="wow slideInLeft" data-wow-duration="1s">
		<%@include file="indice_paleativo.jsp"%>
	</div>
</div>

<div id="main" class="container">
 	<div class="wow fadeInDown top__element" data-wow-delay="1s">
 	
		<div class="sitemap">
			
			<div class="alert alert-success">Integração - Grupo de processo de Encerramento</div>			
			
			<br><br>	
			<ul id="primaryNav" class="col4">
				<li id="home"><a href="">Processo</a></li>
				<li><a>4.6 Encerrar o Projeto ou fase<br>
								<font id="mostrar0" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar0" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo0">
									<li><a>1. Entradas<br>
										<font id="mostrar00" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar00" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo00">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Entregas Aceitas</a></li>
											<li><a>3. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo1">
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Técnicas Analíticas</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo4">
											<li><a>1. Transição do Produto, Serviço ou Resultado Final</a></li>										
											<li><a>2. Atualização nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>	
			</ul>	
		</div>
		
		<div class="sitemap">
			
			<div class="alert alert-success">Aquisição - Grupo de processo de Encerramento</div>			
			
			<br><br>	
			<ul id="primaryNav" class="col4">
				<li id="home"><a href="">Processo</a></li>
				<li><a>12.4 Encerrar as Aquisições<br>
								<font id="mostrar2" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar2" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo2">
									<li><a>1. Entradas<br>
										<font id="mostrar6" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar6" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo6">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Documentos de Aquisição</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo3">
											<li><a>1. Auditoria de Aquisições</a></li>
											<li><a>2. Negociações das Aquisições</a></li>	
											<li><a>3. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo5">
											<li><a>1. Aquisições Encerradas</a></li>
											<li><a>2. Atualizações nos Ativos de Processos Organizacionais</a></li>
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

	<%@include file="configuracao_wow.jsp" %>
	<script src="js/modal_dialog.js"></script>
	<%@include file="gif_load_page.jsp" %> 
</body>	
</html>
