<!-- <button type="button" class="glyphicon glyphicon-folder-open" data-toggle="modal" data-target="#myModal0"> Transação</button> -->

<!-- Modal Relatório -->
<div class="container">

	<!-- Modal -->
	<div class="modal fade" id="myModal0" role="dialog">
		<div class="modal-dialog modal-mini">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Transações do Sistema (saída)</h4>					
							
				<div class="modal-body">
					<div class="alert alert-warning">
						  <strong>Nota:</strong> Você pode consultar transação clicando sobre o icone que representa a descrição de cada transação.<br> 
						  <a class="glyphicon glyphicon-floppy-disk"> Inserir</a><br>
						  <a class="glyphicon glyphicon-search"> Listar</a><br>
						  <a class="glyphicon glyphicon-folder-open"> Relatório</a><br>						  
					</div>
										
					<ul>					        
					        <li class="header">
								<a href="TkcsapcdController?cmd=editarTermoAceiteEntrega" id="conf_operacao" class="glyphicon glyphicon-floppy-disk"></a>
								<a href="TkcsapcdController?cmd=consultarTermoAceiteEntrega" id="conf_operacao" class="glyphicon glyphicon-search"></a> 
								<a href="imprimir_termo_aceite_entrega.jsp" id="conf_operacao" class="glyphicon glyphicon-folder-open"> Termo de Aceite da Entrega</a>
								<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarTermoAberturaProjeto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
						        <a href="TkcsapcdController?cmd=consultarTermoAberturaProjeto" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_termo_abertura_projeto.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Termo de Abertura do Projeto</a>
						        <br>
					        </li>
					        <li>
								<a href="TkcsapcdController?cmd=editarStakeholders" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						        <a href="TkcsapcdController?cmd=consultarStakeholders" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_stakeholders.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Stakeholders</a>
								<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							<a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_projeto.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Plano de Gerenciamento do Projeto</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarDeclaracaoescopo" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarDeclaracaoescopo" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_declaracao_escopo.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Declaração do Escopo</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarDicionarioEAP" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarDicionarioEAP" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_dicionario_eap.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Dicionário da EAP - Planilha</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarRiscos" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarRiscos" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_riscos.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Gerenciamento dos Riscos</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarRegistroSolicitacaoMudanca" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_registro_solicitacao_mudanca.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Registro de Solicitação de Mudancas</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarStatusReport" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarStatusReport" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_status_report.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Status Report</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarAtaReuniao" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarAtaReuniao" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_ata_reuniao.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Ata de Reunião</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_solicitacao_mudanca.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Solicitação de Mudança</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarTermoAceiteEntrega" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarTermoAceiteEntrega" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_termo_aceite_entrega.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Aceite da Entrega</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarAvaliacaoDesempenhoEquipe" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_avaliacao_desempenho_equipe.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Avaliação de Desempenho da Equipe</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarIssuesLog" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarIssuesLog" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_issues_log.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	ISSUES LOG</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarDecisoesComprar" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarDecisoesComprar" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_decisoes-comprar.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Decisões de Comprar</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarDiagnosticoPlanoAcao" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarDiagnosticoPlanoAcao" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_diagnostico_plano_acao.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Diagnóstico dee Plano de Ação</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarListaMarcos" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarListaMarcos" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_lista_marcos.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Lista dos Marcos</a> 
							<br>
							</li>
							<li>	
							<a href="TkcsapcdController?cmd=editarOrcamentoProjeto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarOrcamentoProjeto" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_orcamento_projeto.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Orçamento do Projeto</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarStatuss" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarStatuss" target="_parent" class="glyphicon glyphicon-search"></a>
		                    <a href="imprimir_statuss.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Status</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarModificacaoEscopo" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarModificacaoEscopo" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_modificacao_escopo.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Modificação do Escopo</a> 
							<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarRequerimento" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						        <a href="TkcsapcdController?cmd=consultarRequerimento" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_requerimento.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Requerimento</a> 
								<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarAcompanhamentoProjeto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							    <a href="TkcsapcdController?cmd=consultarAcompanhamentoProjeto" target="_parent" class="glyphicon glyphicon-search"></a>
							    <a href="imprimir_acompanhamento_projeto.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Acompanhamento do Projeto</a>
								<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarLicoesAprendida" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
						        <a href="TkcsapcdController?cmd=consultarLicoesAprendida" target="_parent" class="glyphicon glyphicon-search"></a> 
						        <a href="imprimir_licoes_aprendida.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Lições Aprendidas</a> 
								<br>
							</li>	
							<li>						
								<a href="TkcsapcdController?cmd=editarBusinessCase" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
						        <a href="TkcsapcdController?cmd=consultarBusinessCase" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_business_case.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Business Case</a>
								<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarBusinessPlan" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
					        <a href="TkcsapcdController?cmd=consultarBusinessPlan" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_business_plan.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Business Plan</a>
					        <br>
					        </li>
					        <li>
					        <a href="TkcsapcdController?cmd=editarBusinessPlanDetalhe" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
					        <a href="TkcsapcdController?cmd=consultarBusinessPlanDetalhe" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_business_plan_detalhe.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Business Plan Detalhes</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarRegistroParteInteressada" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
					        <a href="TkcsapcdController?cmd=consultarRegistroParteInteressada" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_registro_parte_interessada.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Registro da Parte Interessada</a>
							<br> 
							</li>
							<li>       
					        <a href="TkcsapcdController?cmd=editarRegistroParteInteressadaFornecedor" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
					        <a href="TkcsapcdController?cmd=consultarRegistroParteInteressadaFornecedor" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_registro_parte_interessada_fornecedor.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Registro Parte Interessada Fornecedor</a>
							<br>							
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarSolicitacaoProjeto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
					        <a href="TkcsapcdController?cmd=consultarSolicitacaoProjeto" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_solicitacao_projeto.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Solicitação do Projeto</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarSolicitacaoProjetovBSC" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
					        <a href="TkcsapcdController?cmd=consultarSolicitacaoProjetovBSC" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_solicitacao_projeto_vbsc.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Solicitação do Projeto vBSC</a>
					        <br>
					        </li>
					        <li>					        
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							<a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoQualidade" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_qualidade.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento da Qualidade</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							<a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoAquisicao" target="_parent" class="glyphicon glyphicon-search"></a>
						    <a href="imprimir_plano_gerenciamento_aquisicao.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento das Aquisições</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							<a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_comunicacao.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento da Comunicação</a>
						 	<br>
						 	</li>
						 	<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							<a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoParteInteressada" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_parte_interessada.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento das Partes Interessadas</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							<a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoCronograma" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_cronograma.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento do Cronograma</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarGerenciamentoEscopo" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarGerenciamentoEscopo" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_gerenciamento_escopo.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento do Escopo</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoCusto" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_custo.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento dos Custos</a>
							<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						        <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRH" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_plano_gerenciamento_rh.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento do RH</a>					        
								<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarRecursosHumanos" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						    <a href="TkcsapcdController?cmd=consultarRecursosHumanos" target="_parent" class="glyphicon glyphicon-search"></a>
						    <a href="imprimir_recursoshumanos.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Recursos Humanos</a>					        
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarMetricas" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						    <a href="TkcsapcdController?cmd=consultarMetricas" target="_parent" class="glyphicon glyphicon-search"></a>
						    <a href="imprimir_metrica.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Métrica</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarAlocacao" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						    <a href="TkcsapcdController?cmd=consultarAlocacao" target="_parent" class="glyphicon glyphicon-search"></a>
						    <a href="imprimir_alocacao.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Alocação</a>
							<br>
							</li>
							<li>				        
					        <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoPessoal" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoPessoal" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_pessoal.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento do Pessoal</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRequisito" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_requisito.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento do Requisito</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRisco" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_gerenciamento_risco.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Gerenciamento dos Riscos</a>
					        <br>
					        </li>
					        <li>
					        <a href="TkcsapcdController?cmd=editarRegistroRisco" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarRegistroRisco" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_registro_risco.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Registro dos Riscos</a>
					        <br>
					        </li>
					        <li>
					        <a href="TkcsapcdController?cmd=editarRegistroRiscoAcoes" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarRegistroRiscoAcoes" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_registro_risco_acoes.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Registro dos Riscos Ações</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarPlanoMelhoriaProcesso" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_plano_melhoria_processo.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Plano de Melhoria do Processo</a>					        
					        <br>
					        </li>
					        <li>					        
							<a href="cadastro_organograma.jsp" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarOrganograma" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="TkcsapcdController?cmd=consultarOrganograma" target="_parent" class="glyphicon glyphicon-folder-open"> Estrutura Analítica do Projeto (EAP)</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarListaQualidade" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
					        <a href="TkcsapcdController?cmd=consultarListaQualidade" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a> 
					        <a href="imprimir_lista_qualidade.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Lista de Verificação da Qualidade</a>
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarPautaReuniao" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarPautaReuniao" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_pauta_reuniao.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Pauta de Reunião</a> 
							<br>
							</li>
							<li>
							<a href="TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
					        <a href="TkcsapcdController?cmd=consultarRegistroSolicitacaoMudanca" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a>
					        <a href="imprimir_registro_solicitacao_mudanca.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Registro de Solicitação das Mudancas</a>
							<br>
							<li>
								<a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						        <a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_solicitacao_mudanca.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Solicitação da Mudança</a> 
								<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarStatusReport" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
						        <a href="TkcsapcdController?cmd=consultarStatusReport" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_status_report.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Status Report</a> 
								<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarProjetoTermoEncerramento" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>					                      
						        <a href="TkcsapcdController?cmd=consultarProjetoTermoEncerramento" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a>
						        <a href="imprimir_termoencerramentoprojeto.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Termo de Encerramento</a>
								<br>
							</li>
							<li>		
								<a href="TkcsapcdController?cmd=editarLicoesAprendida" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
						        <a href="TkcsapcdController?cmd=consultarLicoesAprendida" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a> 
						        <a href="imprimir_licoes_aprendida.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Lições Aprendidas</a> 					       
								<br>
							</li>	
							<li>
								<a href="TkcsapcdController?cmd=editarRelatorioEncerramentoContrato" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
						        <a href="TkcsapcdController?cmd=consultarRelatorioEncerramentoContrato" target="_parent" target="_parent" class="glyphicon glyphicon-search">	Cons.  Enc. Contrato</a> 
								<br>
							</li>
							<li>
								<a href="TkcsapcdController?cmd=editarTransicaoProduto" target="_parent" class="glyphicon glyphicon-floppy-disk"></a> 
						        <a href="TkcsapcdController?cmd=consultarTransicaoProduto" target="_parent" target="_parent" class="glyphicon glyphicon-search"></a> 
						        <a href="imprimir_transicao_produto.jsp" target="_parent" class="glyphicon glyphicon-folder-open"> Transição do Produto</a> 
						        <br>
					        <li>					        
						        <a href="TkcsapcdController?cmd=editarListaOcorrencia" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							    <a href="TkcsapcdController?cmd=consultarListaOcorrencia" target="_parent" class="glyphicon glyphicon-search"></a>
							    <a href="imprimir_lista_ocorrencia.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Lista de Ocorrencia</a>
						    	<br>
						    </li>
						    <li>
							    <a href="TkcsapcdController?cmd=editarMatrizResponsabilidade" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							    <a href="TkcsapcdController?cmd=consultarMatrizResponsabilidade" target="_parent" class="glyphicon glyphicon-search"></a>
							    <a href="imprimir_matriz_responsabilidade.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Matriz de Responsabilidade</a>
						    <br>
						    </li>
						    <li>
							    <a href="TkcsapcdController?cmd=editarTabelaParteInteressada" target="_parent" class="glyphicon glyphicon-floppy-disk"></a>
							    <a href="TkcsapcdController?cmd=consultarTabelaParteInteressada" target="_parent" class="glyphicon glyphicon-search"></a>
							    <a href="imprimir_tabela_parte_interessada.jsp" target="_parent" class="glyphicon glyphicon-folder-open">	Tabela da Parte Interessada</a>
						     </li>
						</ul>
										
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
<!-- Fim Modal Relatório -->
