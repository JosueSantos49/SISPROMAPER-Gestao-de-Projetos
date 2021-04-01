  <link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />

<!-- Função Zoom da página. Deve ser adicionado um id na div e chamar a função no body da página -->
<script type="text/javascript">
var tamanhotexto = new Number();
var tamanhotexto = 13;
	function tamanhooriginal(){
		document.getElementById("conteudo").style.fontSize=tamanhotexto+'px';
	}
	function fonte(e){
		var elemento=document.getElementById("conteudo");
		var atual=elemento.style.fontSize;
		if(e == 'a'){
			atual = parseInt(atual)+2+'px';
		}else if(e == 'b'){
			atual = parseInt(atual)-2+'px';
		}else if(e == 'c'){
			atual = 13+'px';
		}
		elemento.style.fontSize=atual;
	}
</script>
<!-- Função Zoom da página. Deve ser adicionado um id na div e chamar a função no body da página -->

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
                            
                            <li>
								<a>
								<!-- Zoon da página-->
								<input type="button" value="+" onclick="fonte('a');" title="Aumentar o tamanho da fonte">
								<input type="button" value="-" onclick="fonte('b');" title="Diminuir o tamanho da fonte">
								<input type="button" value="100%" onclick="fonte('c');" title="Fonte com tamanho padrão">
								<!-- Fim Zoon da página-->
								</a>	
							</li>
							
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- <div id="body-container">
            <div id="body-content"> Removido devido a dar erro na página de novo projeto-->
                
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
                                    <a href="envia.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-folder-open"></i> Email
                                    </a>
                                </li>
                                <li>
                                    <a href="cadastro_rfq.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> Cotação
                                    </a>
                                </li>
                                <li>
                                    <a href="index_portfolio_projeto.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> Portfólio
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
<br>	    