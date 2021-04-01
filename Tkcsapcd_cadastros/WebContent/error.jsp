<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.util.HoraData"%>
<%@page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<title>Status!</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css"> 
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script> 
<script type="text/javascript" src="js/ajax.js"></script><!-- / LOADER PAGE -->

<!-- Configuração para exibir modal automaticamente -->
 <script type="text/javascript">
	  $(document).ready(function () {
		  $('#myModal').modal('show');
	  });
</script>

</head>
<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000);">

<div id="preloader"><h1><img src="img/loader.gif" height="70px"></h1></div>

	<!-- Cabeçalho da página -->
	<header>
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion-fm">
						<span class="sr-only">Desplegar / Ocultar Menu</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="index_principal.jsp" class="navbar-brand">Sispromaper</a>
				</div>	
					<!-- Inicia Menu -->
					<div class="collapse navbar-collapse" id="navegacion-fm">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp">Sair</a></li>
							<li class="dropdown">						
							<li><a href="index_principal.jsp">Home</a></li>
						</ul>
						
						<!-- <div align="right">
							<div id="google_translate_element"></div>
								<script type="text/javascript">
										function googleTranslateElementInit() {
							   			new google.translate.TranslateElement({pageLanguage: 'pt', includedLanguages: 'en,pt', multilanguagePage: true}, 'google_translate_element');
										}
										</script>
								<script type="text/javascript" src="js/translate.google.txt"></script>        
						</div> -->
						
					</div>
				</div>
		</nav>
	</header>

	<br>
	<div align="center">
		<h3>
			<font color="blue">
			<%
				//Implementando Data e Hora
				Date data = new Date();//criando objeto tipo Date e inicializando 
				SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
				String mostra_data = data_formatada.format(data); //Variável para armazenar a data
				
				System.out.print(mostra_data);
			
				SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
				String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
			%>			
			</font>
		</h3>
	</div>	
							
	<br>				
							<!-- Modal Relatório -->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog modal-lg">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title"></h4>
								          <h5></h5>
								        </div>
								        <div class="modal-body">
								        
								        <div class="container">
											<div class="alert alert-success">
												<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br><br>
												<p>Olá,
												<%=session.getAttribute("theName")%><%if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}  
												%>, seja bem-vindo ao sistema, é um prazer telo conosco. Estamos quase prontos basta somente alguns passos.<strong><a href="index_principal.jsp" target="_parent"> Clique aqui - Home</a></strong></p>
										</div>
																
										<div class="alert alert-info" role="alert" align="left">
										  	<a href="#" class="alert-link">	  
											Oops, algo aconteceu:  Código de status: ${pageContext.errorData.statusCode}<br><br>
											</a>
											Não, se preocupe basta somente observar o código de status e seguir algum passo sugerido pelo sistema, conforme descrito acima. Se ainda estiver ocorrendo alguma mensagem de status contate-se a equipe de suporte.
											
										</div>	
												<div class="table-responsive">	
													<table class="table table-bordered table-hover">				
														  <tr>
														    <td>Atualize a página e tente novamente executar, a página do sistema (Botão F5 do teclado)</td>	
														  </tr>
														  <tr>
														    <td>Status: HTTP 400 Bad request (Solicitação Imprópria), problema com o fluxo de dados</td>						
														  </tr>
														  <tr>
														   <td>Status: HTTP 401 Unauthorized (Não autorizado a efetuar a transação). Verificar credenciais de acesso de acordo com nível estabelecido pela equipe de suporte. </td>
														  </tr>
														  <tr>
														    <td>Status: HTTP 404 NOT FOUND (Endereço chamado não foi encontrado), Certifique se a URL foi digitada corretamente</td>
														  </tr>		  
														  <tr>	
														   <tr>
														    <td>Status: HTTP 500 Internal server error pode ocorrer por usuário deslogar do sistema, tentativa de invasão por pessoa não autorizada, conexão interna do sistema desativada, após, um período de inatividade.</td>
														  </tr>	  
													</table>
												</div>	
										</div>
								        
								        <div class="table-responsive">
													<div class="modal-footer">								        	
										          	<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
										        </div>
																					
											</div>
								        </div>								        							        
								        
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Relatório -->	
								
	<div class="container">
		<div class="alert alert-success">
			<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br><br>
			<p>Olá, seja bem-vindo ao sistema, é um prazer telo conosco. Estamos quase prontos basta somente alguns passos.<strong><a href="index_principal.jsp" target="_parent"> Clique aqui - Home</a></strong></p><br>
		<p><strong><a href="menu_sugerido_principal.jsp" target="_parent">Clique aqui!</a></strong> Iniciar projeto ou proposta de projeto de forma fácil e prática.</p>		
	</div>
	
								
	<div class="alert alert-info" role="alert" align="left">
	  	<a href="#" class="alert-link">	  
		Oops, algo aconteceu:  Código de status: ${pageContext.errorData.statusCode}<br><br>
		</a>
		Não, se preocupe basta somente observar o código de status e seguir algum passo sugerido pelo sistema, conforme descrito acima. Se ainda estiver ocorrendo alguma mensagem de status contate-se a equipe de suporte.
		
	</div>	
			<div class="table-responsive">	
				<table class="table table-bordered table-hover">				
					  <tr>
					    <td>Atualize a página e tente novamente executar, a página do sistema (Botão F5 do teclado)</td>	
					  </tr>
					  <tr>
					    <td>Status: HTTP 400 Bad request (Solicitação Imprópria), problema com o fluxo de dados</td>						
					  </tr>
					  <tr>
					   <td>Status: HTTP 401 Unauthorized (Não autorizado a efetuar a transação). Verificar credenciais de acesso de acordo com nível estabelecido pela equipe de suporte. </td>
					  </tr>
					  <tr>
					    <td>Status: HTTP 404 NOT FOUND (Endereço chamado não foi encontrado), Certifique se a URL foi digitada corretamente</td>
					  </tr>		  
					  <tr>	
					   <tr>
					    <td>Status: HTTP 500 Internal server error pode ocorrer por usuário deslogar do sistema, tentativa de invasão por pessoa não autorizada, conexão interna do sistema desativada, após, um período de inatividade.</td>
					  </tr>	  
				</table>
			</div>	
	</div>
	
	<%@include file="rodape.jsp" %>
</body>
</html>
