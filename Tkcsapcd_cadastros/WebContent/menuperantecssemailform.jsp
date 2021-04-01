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
					<a href="sobre_scp.jsp" class="navbar-brand">SCP</a>
				</div>	
					<!-- Inicia Menu -->
					<div class="collapse navbar-collapse" id="navegacion-fm">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp">Inicio</a></li>
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
							<li><a href="index_principal.jsp">Home</a></li>
							<li><a href="sair.jsp">Sair</a></li>
						</ul>
						<!-- Filtro de  Busca -->
						<form action="" class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="buscar">
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>
					</div>
				</div>
		</nav>
	</header>
	
	<!-- Aqui vai um jum botron -->
	
	<section class="alert alert-success">
		<div class="container">
			<h1>SCP</h1>
			<p>Sistema de Cadastro de Projeto (RFP-RPI) / Solicitação de Serviço de T.I</p>
			<font color="black"><strong>Usuário:</strong>						
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {  
				request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
			%>						
		</font>	
		</div>								
	</section>