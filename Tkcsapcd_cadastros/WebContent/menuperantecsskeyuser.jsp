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
					<a href="sobre_scp.jsp" class="navbar-brand">SisproMaper</a>
				</div>	
					<!-- Inicia Menu -->
					<div class="collapse navbar-collapse" id="navegacion-fm">
						<ul class="nav navbar-nav">
							<!-- <li class="active"><a href="index.jsp">Inicio</a></li> -->
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
							<!-- <li><a href="solicitacao_cadastro.jsp">Solicitação Acesso</a></li> -->
							<li><a href="sair.jsp">Sair</a></li>
						</ul>
					</div>
				</div>
		</nav>
	</header>
	
	<!-- Aqui vai um jum botron -->
	
	<section class="alert alert-success">
		<div class="container">
			<h1>SisproMaper</h1>
			<p></p>
			<font color="black"><strong>Usuário:</strong>						
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {  
				request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
			%>						
		</font>	
		<div align="right">
			<div id="google_translate_element"></div>
				<script type="text/javascript">
						function googleTranslateElementInit() {
			   			new google.translate.TranslateElement({pageLanguage: 'pt', includedLanguages: 'en,pt', multilanguagePage: true}, 'google_translate_element');
				}
				</script>
				<script type="text/javascript" src="js/translate.google.txt"></script>        
		</div>
		</div>								
	</section>
	
<div class="container">			
			<div class="span9">
				<section id=btn-dropdown>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">HOME <span class="caret"></span></button>
							<ul class="dropdown-menu">
					        	<li><a href="index_principal.jsp" target="_parent">HOME</a></li>
					      	</ul>																							
					</div>
					<!-- <div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">USUÁRIO <span class="caret"></span></button>
							<ul class="dropdown-menu">
					        	<li><a href="cadastro_usuarios.jsp" target="_parent">Cad. Usuário</a></li>
					        	<li><a href="consulta_usuarios.jsp" target="_parent">Cons. Usuário</a></li>
					        	<li><a href="imprimir_usuarios.jsp" target="_parent">Rel. Usuário</a></li>
					        	<li class="divider"></li>
					        	<li><a href="consulta_solicitacaocadastro.jsp" target="_parent">Cons. Solicitação Acesso</a></li>
					        	<li><a href="imprimir_solicitacaocadastro.jsp" target="_parent">Rel. Solicitação Acesso</a></li>
					        	<li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarCliente" target="_parent">Cad. Cliente</a></li>					                      
					            <li><a href="TkcsapcdController?cmd=consultarCliente" target="_parent">Cons. Cliente</a></li>
					            <li><a href="imprimir_cliente.jsp" target="_parent">Rel. Cliente</a></li> 		                                       
					       </ul>
					</div>-->
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Grupo <span class="caret"></span></button>
							<ul class="dropdown-menu">
						    	<li><a href="fluxogramasgp.jsp" target="_blank">Áreas Conhecimento</a></li>
						        <li class="divider"></li>
						        <li><a href="transacao.jsp" target="_blank">Transação Processo</a></li> 
						        <li class="divider"></li>
						         <li><a href="consulta_transacao.jsp" target="_blank">Cons. Transação Processo</a></li>
						        <li class="divider"></li>
						        <li><a href="consulta_guia_processos.jsp" target="_blank">Guia Processo</a></li>
						        <li class="divider"></li>
						        <li><a href="consulta_guia_processos_2.jsp" target="_blank">Visão Geral Processos</a></li>						        
						        <li class="divider"></li>
						        <li><a href="upload.jsp" target="_blank">Upload File</a></li>   
						         <li class="divider"></li>
						        <li><a href="TkcsapcdController?cmd=consultarFilebean" target="_blank">Cons. File</a></li> 	
						        <li class="divider"></li>	
						        <li><a href="cadastro_organograma.jsp" target="_blank">Cad. Organograma</a></li>
						        <li class="divider"></li>		
					            <li><a href="consulta_organograma.jsp" target="_blank">Cons. Organograma</a></li> 		         
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Metodologia <span class="caret"></span></button>
						 	<ul class="dropdown-menu">
						 		<li><a href="fluxo_metodologiapmo.jsp" target="_blank">Processar</a></li>	
			                    <li class="divider"></li>			                    				                                          
			                </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Iniciação <span class="caret"></span></button>
							<ul class="dropdown-menu">		                        
    		                    <li><a href="fluxo_iniciacao.jsp" target="_blank">Processar</a></li>     
    		                    <li class="divider"></li>              
					        </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Plano Gerenciamento Projeto <span class="caret"></span></button>
							<ul class="dropdown-menu">					             
					            <li><a href="fluxo_planogerprojeto.jsp" target="_blank">Processar</a></li>   
					             <li class="divider"></li>        
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Monitoramento e Controle <span class="caret"></span></button>
							<ul class="dropdown-menu">						   	    
						   	    <li><a href="fluxo_monitoramentocontrole.jsp" target="_blank">Processar</a></li>   
						   	    <li class="divider"></li>             
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Encerramento <span class="caret"></span></button>
							<ul class="dropdown-menu">						        
						        <li><a href="fluxo_encerramento.jsp" target="_blank">Processar</a></li>	
						        <li class="divider"></li> 						                           
						     </ul>
					</div>					
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">SSTI <span class="caret"></span></button>
							<ul class="dropdown-menu">						        
						        <li><a href="TkcsapcdController?cmd=editarSolicitacaoServicoTI" target="_blank">Cad. SSTI</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoServicoTI" target="_blank">Cons. SSTI</a></li>   
						        <li><a href="imprimir_solicitacaoservicoti.jsp" target="_blank">Rel. SSTI</a></li> 
						        <li class="divider"></li>						                           
						     </ul>
					</div>
						
					
				</section>	
			</div>

</div>
		