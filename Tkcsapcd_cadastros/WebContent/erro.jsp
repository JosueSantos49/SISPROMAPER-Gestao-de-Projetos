<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<title>Status Acesso Negado</title>

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
								<!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
									CIC's <span class="caret"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="http://www.internetcomunitaria.rj.gov.br/modulo_senior.asp">Treinamentos</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/servicos.asp?categ=1">Serviços Cidadão</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/onde_CIC.asp">Centros Comunitários</a></li>
								</ul> -->
							</li>
							<!-- <li><a href="parceiro.jsp">Parcerias</a></li>
							<li><a href="contato.jsp">Contato</a></li> -->
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
						
						<!-- Filtro de  Busca 
						<form action="" class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="buscar">
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>-->
					</div>
				</div>
		</nav>
		
		<%
				//Implementando Data e Hora
				Date data = new Date();//criando objeto tipo Date e inicializando 
				SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
				String mostra_data = data_formatada.format(data); //Variável para armazenar a data
				
				System.out.print(mostra_data);
			
				SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
				String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
			%>
			
	</header>

	<br><div align="center"><h3><font color="red">STATUS ACESSO NEGADO!</font></h3></div>	

<!-- Modal Relatório -->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog modal-lg">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">${mensagem}</h4>
								          <h5>Status: Acesso Negado!</h5>
								        </div>
								        <div class="modal-body">
								        
								        <div class="container">	
								        
								         <div class="container">
											<div class="alert alert-success">
												<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br><br>
												Atenção! Verificar credenciais de acesso de acordo com nível estabelecido pela equipe de suporte. O sistema somente permite acesso por autenticação, onde, é de total responsabilidade do usuário guardar o usuário e a senha.
												<strong><a href="index_principal.jsp" target="_parent"> Clique aqui - Home</a></strong>
											</div>
																	        
									        <div class="alert alert-danger" role="alert" align="left">
											  <a href="#" class="alert-link">Aviso. Sr. usuário, este tipo de mensagem pode surgir por não autorização a efetuar a transação!</a>
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
								</div>
	<div class="container">								
		<div class="alert alert-danger" role="alert" align="center">
		  <a href="#" class="alert-link">Aviso. Sr. usuário, este tipo de mensagem pode surgir por não autorização a efetuar a transação!</a>
		</div>
	</div>
	
	
	<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<%@include file="rodape.jsp" %>
</body>
</html>