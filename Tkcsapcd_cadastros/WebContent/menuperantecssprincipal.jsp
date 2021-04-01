<link rel="stylesheet" href="wow/css/animate.css">
<style>.wow:first-child { visibility: hidden; } </style>

  <link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
  <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button class="btn btn-navbar" data-toggle="collapse" data-target="#app-nav-top-bar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="index_principal.jsp" class="brand"><i class="">SISPROMAPER</i></a>
                    <div id="app-nav-top-bar" class="nav-collapse">
                        <ul class="nav">
                            
                                <!-- <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">TRY ME!
                                        <b class="caret hidden-phone"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="dashboard.html">Dashboard</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">CHANGE NAV BAR
                                        <b class="caret hidden-phone"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="demo-horizontal-nav.html">Horizontal</a>
                                        </li>
                                    </ul>
                                </li>-->
                            
                        </ul>
                        <ul class="nav pull-right">
                            <li><a href="sair.jsp">Logout</a></li>
							<li><a href="index_principal.jsp">Home</a></li>	                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div id="body-container">
            <div id="body-content">                
                    <div class="body-nav body-nav-horizontal body-nav-fixed">
                        <div class="container">
                            <ul>
                            	<li>
                                    <a href="menu_sugerido_ajuda.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-floppy-save"></i> Ajuda
                                    </a>
                                </li>
                                <li>
                                    <a href="grupo_processos.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-cog" ></i> Grupo
                                    </a>
                                </li>
                                <li>
                                    <a href="TkcsapcdController?cmd=consultarCliente" target="_parent">
                                        <i class="glyphicon glyphicon-user"></i> Cliente
                                    </a>
                                </li>
                                <li>
                                    <a href="TkcsapcdController?cmd=consultarFilebeanArquivo" target="_parent">
                                        <i class="glyphicon glyphicon-folder-open"></i> Arquivo
                                    </a>
                                </li>
                                <li>
                                    <a href="upload.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-paperclip"></i> Upload
                                    </a>
                                </li>
                                <li>
                                    <a href="transacao.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-zoom-in"></i> Procurar
                                    </a>
                                </li>
                                <li>
                                    <a href="TkcsapcdController?cmd=consultarSolicitacaoServicoTI" target="_parent">
                                        <i class="glyphicon glyphicon-ok-circle"></i> SSTI
                                    </a>
                                </li>
                                <li>
                                    <a href="consulta_guia_processos_2.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-check"></i> Processos
                                    </a>
                                </li>
                                <li>
                                    <a href="consulta_solicitacaocadastro.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-user"></i> Acesso
                                    </a>
                                </li>
                                <li>
                                    <a href="menu_sugerido_principal.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-book"></i> Projeto
                                    </a>
                                </li>
                                <li>
                                    <a href="" target="_parent" data-toggle="modal" data-target="#myModal0">
                                        <i class="glyphicon glyphicon-folder-open"></i> Transação
                                    </a>
                                </li>
                                <li>
                                    <a href="envia.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-folder-open"></i> Email
                                    </a>
                                </li>
                                <li>
                                    <a href="index_portfolio_projeto.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-level-up"></i> Portfólio
                                    </a>
                                </li> 
                                 <li>
                                    <a href="consulta_transacao.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-zoom-in"></i> Buscar
                                    </a>
                                </li> 
                            </ul>
                        </div>
                    </div>
					<section class="nav nav-page">
				        <div class="container">
				            <div class="row">
				                <div class="span7">
				                    <header class="page-header">
				                        <h3>Usuário: 
				                        <%=session.getAttribute("theName")%>
											<%  
											//verifica se a sessao do usuario é válida  
											if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
										%>	
				                        <br/>
				                            <small>Bem vindo</small>
				                        </h3>
				                    </header>
				                </div>
				                <div class="page-nav-options">
				                    <div class=""><!-- span9 -->
				                        <ul class="nav nav-pills">
				                            <li>
				                                <a href="index_principal.jsp"><i class="icon-home"></i></a>		
				                            </li>
				                        </ul>
				                        <ul class="nav nav-tabs">
				                            <li class="active">
				                                <a href="index_principal.jsp"><i class="icon-home"></i>Home</a>
				                            </li>	
				                        </ul>
				                    </div>
				                </div>
				            </div>
				        </div>				        
				    </section>
				    
		<div class="container" align="center">
				<section id=btn-dropdown>
					<!-- <div class="btn-group" align="center">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Home <span class="caret"></span></button>
							<ul class="dropdown-menu">
					        	<li><a href="index_principal.jsp" target="_parent">Home</a></li>
					      	</ul>																						
					</div>-->
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Usuário <span class="caret"></span></button>
							<ul class="dropdown-menu">
					        	<li><a href="cadastro_usuarios.jsp" target="_parent">Cad. Usuário</a></li>
					        	<li><a href="TkcsapcdController?cmd=consultarUsuario" target="_parent">Cons. Usuário</a></li>
					        	<li><a href="imprimir_usuarios.jsp" target="_parent">Rel. Usuário</a></li>
					        	<li class="divider"></li>
					        	<li><a href="consulta_solicitacaocadastro.jsp" target="_parent">Cons. Solicitação Acesso</a></li>
					        	<li><a href="imprimir_solicitacaocadastro.jsp" target="_parent">Rel. Solicitação Acesso</a></li>
					        	<li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarCliente" target="_parent">Cad. Cliente</a></li>					                      
					            <li><a href="TkcsapcdController?cmd=consultarCliente" target="_parent">Cons. Cliente</a></li>
					            <li><a href="imprimir_cliente.jsp" target="_parent">Rel. Cliente</a></li> 
					            <li class="divider"></li>
					            <!-- <li><a href="cadastro_questionario.jsp" target="_parent">Cad. Quest Iniciação</a></li>	
					            <li><a href="quizeApplication.jsp" target="_parent">Questão Iniciação</a></li>
					            <li><a href="consulta_questionario.jsp" target="_parent">Questão Iniciação</a></li> -->	
					            <li><a href="home.jsp" target="_parent">Quiz</a></li>
					            <li><a href="relatorio.jsp" target="_parent">Teste Relatório</a></li>
					            <!-- <li><a href="primeface.xhtml" target="_parent">Teste Primeface</a></li> -->	
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Grupo <span class="caret"></span></button>
							<ul class="dropdown-menu">
						    	<li><a href="fluxogramasgp.jsp" target="_parent">Áreas Conhecimento</a></li>
						        <li class="divider"></li>
						        <li><a href="transacao.jsp" target="_parent">Transação Processo</a></li> 
						        <li class="divider"></li>
						         <li><a href="consulta_transacao.jsp" target="_parent">Cons. Transação Processo</a></li> 
						        <li class="divider"></li>
						        <li><a href="consulta_guia_processos.jsp" target="_parent">Guia Processo</a></li>
						        <li class="divider"></li>
						        <li><a href="consulta_guia_processos_2.jsp" target="_parent">Visão Geral Processos</a></li>						        
						        <li class="divider"></li>
						        <li><a href="upload.jsp" target="_parent">Upload File</a></li>   
						        <li class="divider"></li>
						        <li><a href="upload_ajuda.jsp" target="_parent">Upload File Ajuda</a></li>
						        <li class="divider"></li>
						        <li><a href="TkcsapcdController?cmd=consultarFilebean" target="_parent">Cons. File</a></li> 
						        <li class="divider"></li>							        
						        <li><a href="TkcsapcdController?cmd=consultarFilebeanAjuda" target="_parent">Cons. File Ajuda</a></li>
						        <li class="divider"></li>
						        <li><a href="cadastro_organograma.jsp" target="_parent">Cad. Organograma</a></li>
						        <li class="divider"></li>		
					            <li><a href="consulta_organograma.jsp" target="_parent">Cons. Organograma</a></li> 		         
					       </ul>
					</div>
					<!-- 
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Metodologia <span class="caret"></span></button>
						 	<ul class="dropdown-menu">
						 		<li><a href="fluxo_metodologiapmo.jsp" target="_parent">Processar</a></li>				                    		                    				                                          
			                </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Iniciação <span class="caret"></span></button>
							<ul class="dropdown-menu">		                        
    		                    <li><a href="fluxo_iniciacao.jsp" target="_parent">Processar</a></li>            
					        </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Plano Gerenciamento Projeto <span class="caret"></span></button>
							<ul class="dropdown-menu">					             
					            <li><a href="fluxo_planogerprojeto.jsp" target="_parent">Processar</a></li>  
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Monitoramento e Controle <span class="caret"></span></button>
							<ul class="dropdown-menu">						   	    
						   	    <li><a href="fluxo_monitoramentocontrole.jsp" target="_parent">Processar</a></li> 
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Encerramento <span class="caret"></span></button>
							<ul class="dropdown-menu">						        
						        <li><a href="fluxo_encerramento.jsp" target="_parent">Processar</a></li>	      
						     </ul>
					</div>	
					 -->				
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">SSTI <span class="caret"></span></button>
							<ul class="dropdown-menu">						        
						        <li><a href="TkcsapcdController?cmd=editarSolicitacaoServicoTI" target="_parent">Cad. SSTI</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoServicoTI" target="_parent">Cons. SSTI</a></li>   
						        <li><a href="imprimir_solicitacaoservicoti.jsp" target="_parent">Rel. SSTI</a></li> 				                           
						     </ul>
					</div>
				</section>					
 			</div>
 			<br>
			
<!-- Início Formação WOW em todas as páginas que possuem cabeçalho e rodapé. Esta fechando com a div no rodapé-->
<div class="wow fadeInDown top__element" data-wow-delay="1s">
