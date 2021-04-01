 <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index_principal.jsp">SISPROMAPER</a>
                
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li> -->
                <!-- 
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li> -->
                <li class="dropdown">
                    <a href="index_principal.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>Home<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="index_principal.jsp"><i class="fa fa-fw fa-user"></i> Home</a>
                            <a href="sair.jsp"><i class="fa fa-fw fa-user"></i> Sair</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
            
            
            
                <ul class="nav navbar-nav side-nav">
                    
                    <li  class="active">
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo0"><i class="fa fa-fw fa-arrows-v"></i><span class="glyphicon glyphicon-menu-right"></span> Principal<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo0" class="collapse">
                            <li>
                                <a href="index_principal.jsp"><span class="glyphicon glyphicon-home"></span> Home</a>
                                <a href="menu_sugerido_ajuda.jsp"><span class="glyphicon glyphicon-floppy-save"></span> Ajuda</a> 
                                <a href="grupo_processos.jsp" target="_parent"><i class="glyphicon glyphicon-cog" ></i> Grupo</a>
                                <a href="upload.jsp" target="_parent"><i class="glyphicon glyphicon-paperclip"></i> Upload</a>
                                <a href="upload_projeto.jsp" target="_parent"><i class="glyphicon glyphicon-paperclip"></i> Upl. Projeto</a>
                                <a href="transacao.jsp" target="_parent"><i class="glyphicon glyphicon-zoom-in"></i> Procurar</a>
                                <a href="consulta_guia_processos_2.jsp" target="_parent"><i class="glyphicon glyphicon-check"></i> Processos</a>
                                <a href="envia.jsp" target="_parent"><i class="glyphicon glyphicon-folder-open"></i> Email</a> 
                                <a href="cadastro_rfq.jsp" target="_parent"><i class="glyphicon glyphicon-list-alt"></i> Cotação</a>
                                <a href="index_portfolio_projeto.jsp" target="_parent"><i class="glyphicon glyphicon-level-up"></i> Portfólio</a>
                                <a href="consulta_transacao.jsp" target="_parent"><span class="glyphicon glyphicon-zoom-in"></span> Buscar</a>
                                                       	
                            </li>
                        </ul>
                    </li>
                                
                	<li>
                	
                	<!-- <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search"> -->
                	
                	    <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i>
                	    <span class="glyphicon glyphicon-pushpin"></span> Iniciação<i class="fa fa-fw fa-caret-down"></i></a>
                        
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="menu_sugerido_principal.jsp"><span class="glyphicon glyphicon-plus"></span> Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarProjetoInicio"><span class="glyphicon glyphicon-search"></span> Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarTermoAberturaProjeto"><span class="glyphicon glyphicon-plus"></span> Termo de Abertura do Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarTermoAberturaProjeto"><span class="glyphicon glyphicon-search"></span> Termo de Abertura do Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarRegistroParteInteressada"><span class="glyphicon glyphicon-plus"></span> Partes Interessadas V.1</a>
                                <a href="TkcsapcdController?cmd=consultarRegistroParteInteressada"><span class="glyphicon glyphicon-search"></span> Partes Interessadas V.1</a>
                            </li>
                        	<li>
                                <a href="TkcsapcdController?cmd=editarTabelaParteInteressada"><span class="glyphicon glyphicon-plus"></span> Partes Interessadas V.2</a>
                                <a href="TkcsapcdController?cmd=consultarTabelaParteInteressada"><span class="glyphicon glyphicon-search"></span> Partes Interessadas V.2</a> 
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarEnvolvimentoPessoaProjetoInicio"><span class="glyphicon glyphicon-plus"></span> Pessoa</a>
                                <a href="TkcsapcdController?cmd=consultarEnvolvimentoPessoaProjetoInicio"><span class="glyphicon glyphicon-search"></span> Pessoa</a>
                            </li>
                             <li>
                                <a href="calendario.jsp">Calendário Evento</a>
                            </li>
                        </ul>
                    </li>
                    
                	<li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo1"><i class="fa fa-fw fa-arrows-v"></i><span class="glyphicon glyphicon-copy"></span> Planejamento<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo1" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento do Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento do Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarGerenciamentoEscopo"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento do Escopo</a>
                                <a href="TkcsapcdController?cmd=consultarGerenciamentoEscopo"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento do Escopo</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento dos Requisitos</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRequisito"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento dos Requisitos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito"><span class="glyphicon glyphicon-plus"></span> Matriz de Ratreabilidade dos Requisitos</a>
                                <a href="TkcsapcdController?cmd=consultarMatrizRastreabilidadeRequisito"><span class="glyphicon glyphicon-search"></span> Matriz de Ratreabilidade dos Requisitos</a>
                            </li>   
                            <li>
                                <a href="TkcsapcdController?cmd=editarDeclaracaoescopo"><span class="glyphicon glyphicon-plus"></span> Declaração do Escopo</a>
                                <a href="TkcsapcdController?cmd=consultarDeclaracaoescopo"><span class="glyphicon glyphicon-search"></span> Declaração do Escopo</a>
                            </li>                         
                            <li>
                                <a href="cadastro_organograma.jsp"><span class="glyphicon glyphicon-plus"></span> Estrutura Analítica do Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarOrganograma"><span class="glyphicon glyphicon-search"></span> Estrutura Analítica do Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarDicionarioEAP"><span class="glyphicon glyphicon-plus"></span> Dicionário da Estrutura Analítica do Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarDicionarioEAP"><span class="glyphicon glyphicon-search"></span> Dicionário da Estrutura Analítica do Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento do Cronograma</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoCronograma"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento do Cronograma</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento dos Custos</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoCusto"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento dos Custos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento da Qualidade</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoQualidade"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento da Qualidade</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento dos Recursos Humanos</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRH"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento dos Recursos Humanos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarRecursosHumanos"><span class="glyphicon glyphicon-plus"></span> Recursos Humanos</a>
                                <a href="TkcsapcdController?cmd=consultarRecursosHumanos"><span class="glyphicon glyphicon-search"></span> Recursos Humanos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento das Comunicações</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento das Comunicações</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento dos Riscos</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRisco"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento dos Riscos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarRiscos"><span class="glyphicon glyphicon-plus"></span> Gerenciamento dos Riscos</a>
                                <a href="TkcsapcdController?cmd=consultarRiscos"><span class="glyphicon glyphicon-search"></span> Gerenciamento dos Riscos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarRegistroRisco"><span class="glyphicon glyphicon-plus"></span> Registro dos Riscos</a>
                                <a href="TkcsapcdController?cmd=consultarRegistroRisco"><span class="glyphicon glyphicon-search"></span> Registro dos Riscos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarRegistroAcoes"><span class="glyphicon glyphicon-plus"></span> Registro dos Riscos Ações</a>
                                <a href="TkcsapcdController?cmd=consultarRegistroAcoes"><span class="glyphicon glyphicon-search"></span> Registro dos Riscos Ações</a>
                            </li>  
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento das Aquisições</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoAquisicao"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento das Aquisições</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada"><span class="glyphicon glyphicon-plus"></span> Plano de Gerenciamento das Partes Interessadas</a>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoParteInteressada"><span class="glyphicon glyphicon-search"></span> Plano de Gerenciamento das Partes Interessadas</a>
                            </li> 
                            <li>
                                <a href="TkcsapcdController?cmd=editarAtributoAtividade"><span class="glyphicon glyphicon-plus"></span> Atributo das Atividades</a>
                                <a href="TkcsapcdController?cmd=consultarAtributoAtividade"><span class="glyphicon glyphicon-search"></span> Atributo das Atividades</a>
                            </li>                         
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2"><i class="fa fa-fw fa-arrows-v"></i><span class="glyphicon glyphicon-cog"></span> Execução<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse">
                        	<li>
                            	<a href="TkcsapcdController?cmd=editarSolicitacaoMudanca"><span class="glyphicon glyphicon-plus"></span> Solicitação de Mudança</a>
                                <a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca"><span class="glyphicon glyphicon-search"></span> Solicitação de Mudança</a>    
                            </li>
                            <li>
                            	<a href="TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe"><span class="glyphicon glyphicon-plus"></span> Avaliação do Desempenho da Equipe</a>
                                <a href="TkcsapcdController?cmd=consultarAvaliacaoDesempenhoEquipe"><span class="glyphicon glyphicon-search"></span> Avaliação do Desempenho da Equipe</a>    
                            </li>
                            <li>
                            	<a href="TkcsapcdController?cmd=editarIssuesLog"><span class="glyphicon glyphicon-plus"></span> Issues Log (Registro das Questões)</a>
                                <a href="TkcsapcdController?cmd=consultarIssuesLog"><span class="glyphicon glyphicon-search"></span> Issues Log (Registro das Questões)</a>    
                            </li>                         
                        </ul>
                    </li>
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo3"><i class="fa fa-fw fa-arrows-v"></i><span class="glyphicon glyphicon-search"></span> Monitoramento e Controle<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo3" class="collapse">
                            <li>
                            	<a href="TkcsapcdController?cmd=editarTermoAceiteEntrega"><span class="glyphicon glyphicon-plus"></span> Termo de Aceite da Entrega</a>
                                <a href="TkcsapcdController?cmd=consultarTermoAceiteEntrega"><span class="glyphicon glyphicon-search"></span> Termo de Aceite da Entrega</a>    
                            </li>
                            <li>
                            	<a href="TkcsapcdController?cmd=editarSolicitacaoMudanca"><span class="glyphicon glyphicon-plus"></span> Solicitação de Mudança</a>
                                <a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca"><span class="glyphicon glyphicon-search"></span> Solicitação de Mudança</a>    
                            </li>    
                            <li>
                                <a href="TkcsapcdController?cmd=editarRegistroRisco"><span class="glyphicon glyphicon-plus"></span> Registro dos Riscos</a>
                                <a href="TkcsapcdController?cmd=consultarRegistroRisco"><span class="glyphicon glyphicon-search"></span> Registro dos Riscos</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarStatusReport"><span class="glyphicon glyphicon-plus"></span> Status Report (Relatório de Situação)</a>
                                <a href="TkcsapcdController?cmd=consultarStatusReport"><span class="glyphicon glyphicon-search"></span> Status Report (Relatório de Situação)</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarAtaReuniao"><span class="glyphicon glyphicon-plus"></span> Ata de Reunião</a>
                                <a href="TkcsapcdController?cmd=consultarAtaReuniao"><span class="glyphicon glyphicon-search"></span> Ata de Reunião</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarAcompanhamentoProjeto"><span class="glyphicon glyphicon-plus"></span> Acompanhamento do Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarAcompanhamentoProjeto"><span class="glyphicon glyphicon-search"></span> Acompanhamento do Projeto</a>
                            </li>                         
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo4"><i class="fa fa-fw fa-arrows-v"></i><span class="glyphicon glyphicon-ok"></span> Encerramento<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo4" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarTransicaoProduto"><span class="glyphicon glyphicon-plus"></span> Transição do Produto</a>
                                <a href="TkcsapcdController?cmd=consultarTransicaoProduto"><span class="glyphicon glyphicon-search"></span> Transição do Produto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarProjetoTermoEncerramento"><span class="glyphicon glyphicon-plus"></span> Termo de Encerramento do Projeto</a>
                                <a href="TkcsapcdController?cmd=consultarProjetoTermoEncerramento"><span class="glyphicon glyphicon-search"></span> Termo de Encerramento do Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarLicoesAprendida"><span class="glyphicon glyphicon-plus"></span> Lições Aprendidas</a>
                                <a href="TkcsapcdController?cmd=consultarLicoesAprendida"><span class="glyphicon glyphicon-search"></span> Lições Aprendidas</a>
                            </li>
                        </ul>
                    </li>
                    
                    <!-- 
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo5"><i class="fa fa-fw fa-arrows-v"></i>Solicitação de Mudança<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo5" class="collapse">
                            <li>
                                
                            </li>
                            <li>
                                
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo6"><i class="fa fa-fw fa-arrows-v"></i>EAP<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo6" class="collapse">
                            <li>
                                <a href="cadastro_organograma.jsp">Inserir EAP</a>
                                <a href="TkcsapcdController?cmd=consultarOrganograma"><span class="glyphicon glyphicon-search"></span> EAP</a>
                            </li>
                            <li>
                                
                            </li>
                        </ul>
                    </li>
                    -->
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo7"><i class="fa fa-fw fa-arrows-v"></i>Fornecedor<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo7" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarFornecedorQualificado">Inserir Fornecedor</a>
                                <a href="TkcsapcdController?cmd=consultarFornecedorQualificado"><span class="glyphicon glyphicon-search"></span> Fornecedor</a>
                            </li>
                        </ul>
                    </li>
                    
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>