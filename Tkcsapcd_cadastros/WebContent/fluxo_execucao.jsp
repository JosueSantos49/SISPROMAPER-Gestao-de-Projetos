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

<title>Execução</title>

<%@include file="css_js_configuracao.jsp" %><!-- Configuracao da formatacao da pagina, configurando modal dialog -->
<script type="text/javascript" src="js/conteudo_mostrar_ocultar.js"></script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

<div id="main" class="container">
	<div class="wow slideInLeft" data-wow-duration="1s">
		<%@include file="indice_paleativo.jsp"%>
	</div>
</div>

<div id="main" class="container"><!-- class="container" -->
 	<div class="wow fadeInDown top__element" data-wow-delay="1s">	
 	
	<div class="sitemap">
 			
			<div class="alert alert-success">Qualidade - Grupo de processo de Execução</div>			
								
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>8.2 Realizar a Garantia da Qualidade<br>
								<font id="mostrar0" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar0" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo0">
									<li><a>1. Entradas<br>
										<font id="mostrar00" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar00" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo00">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade">1. Plano de Gerenciamento da Qualidade</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso">2. Plano de Melhorias no Processo</a></li>
											<li><a>3. Métricas da Qualidade</a></li>
											<li><a>4. Medições do Controle de Qualidade</a></li>
											<li><a>5. Documentação do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo1">
											<li><a>1. Ferramenta de Gerenciamento e Controle da Qualidade</a></li>
											<li><a>2. Auditoria de Qualidade</a></li>
											<li><a>3. Análise de Processo</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo4">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualizações nos Documentos do Projeto</a></li>
											<li><a>4. Atualização nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap">
			<div class="alert alert-success">Integração - Grupo de processo de Execução</div>			
				
			<br><br>										
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>4.3 Orientar e Gerenciar o Trabalho do Projeto<br>
								<font id="mostrar2" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar2" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo2">
									<li><a>1. Entradas<br>
										<font id="mostrar6" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar6" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo6">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitação de Mudanças Aprovadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo3">
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Sistema de Informação de Gerenciamento de Projetos</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo5">
											<li><a>1. Entregas</a></li>
											<li><a>2. Dados de Desenpenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitação de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap">
			<div class="alert alert-success">RH - Grupo de processo de Execução</div>			
									
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>9.2 Mobilizar a Equipe do Projetoo<br>
								<font id="mostrar7" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar7" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo7">
									<li><a>1. Entradas<br>
										<font id="mostrar8" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar8" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo8">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a href="cadastro_fatores_ambientais.jsp">2. Fatores Ambientais da Empresa</a></li>
											<li><a>3. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar9" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar9" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo9">
											<li><a>1. Pré-designação</a></li>
											<li><a>2. Negociação</a></li>
											<li><a>3. Contratação</a></li>
											<li><a>4. Equipes Virtuais</a></li>
											<li><a>5. Análise de Decisão Envolvendo Critérios Múltiplos</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar13" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar13" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo13">
											<li><a>1. Designações do Pessoal do Projeto</a></li>
											<li><a>2. Calendário dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>9.3 Desenvolver a Equipe do Projeto<br>
								<font id="mostrar10" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar10" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo10">
									<li><a>1. Entradas<br>
										<font id="mostrar14" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar14" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo14">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>2. Desgnação do Pessoal do Projeto</a></li>
											<li><a>3. Calendários dos Recursos</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar11" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar11" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo11">
											<li><a>1. Habilidades Interpessoais</a></li>
											<li><a>2. Treinamento</a></li>
											<li><a>3. Atividades de Construção da Equipe</a></li>
											<li><a>4. Regrás Básicas</a></li>
											<li><a>5. Agrupamento</a></li>
											<li><a>6. Reconhecimento e Recompensas</a></li>
											<li><a>7. Ferramentas de Avaliação dos Funcionários</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar12" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar12" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo12">
											<li><a>1. Avaliações de Desempenho da Equipe</a></li>
											<li><a>2. Atualizações nos Fatores Ambientais da Empresa</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>9.4 Gerenciar a Equipe do Projeto<br>
								<font id="mostrar15" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar15" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo15">
									<li><a>1. Entradas<br>
										<font id="mostrar16" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar16" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo16">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">1. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>2. Desgnação do Pessoal do Projeto</a></li>
											<li><a>3. Avaliações de Desempenho da Equipe</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">4. Registro das Questões</a></li>
											<li><a>5. Relatórios do Desempenho do Trabalho</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar17" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar17" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo17">
											<li><a>1. Observações e Conversas</a></li>
											<li><a>2. Avaliações de Desempenho do Projeto</a></li>
											<li><a>3. Gerenciamento de Conflitos</a></li>
											<li><a>4. Habilidades Interpessoais</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar18" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar18" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo18">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Avaliações nos Documentos do Projeto</a></li>
											<li><a>4. Atualizações nos Fatores Ambientais da Empresa</a></li>
											<li><a>5. Atualizações nos Ativos de Processos Organizacionais</a></li>	
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap"> 			
			<div class="alert alert-success">Aquisição - Grupo de processo de Execução</div>			
						
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>12.2 Conduzir as Aquisições<br>
								<font id="mostrar19" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar19" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo19">
									<li><a>1. Entradas<br>
										<font id="mostrar20" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar20" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo20">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisições</a></li>
											<li><a>2. Documentos das Aquisições</a></li>
											<li><a>3. Critérios para Seleção de Fontes</a></li>
											<li><a>4. Propostas dos Fornecedores</a></li>
											<li><a>5. Documentos do Projeto</a></li>
											<li><a>6. Decisões de Fazer ou Comprar</a></li>
											<li><a>7. Especificação do Trabalho das Aquisições</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar21" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar21" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo21">
											<li><a>1. Reunião com Licitantes</a></li>
											<li><a>2. Técnicas de Avaliação Propostas</a></li>
											<li><a>3. Estimativas Independentes</a></li>
											<li><a>4. Opinião Especializada</a></li>
											<li><a>5. Publicidade</a></li>
											<li><a>6. Técnicas Análiticas</a></li>
											<li><a>7. Negociações das Aquisições</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar22" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar22" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo22">
											<li><a href="TkcsapcdController?cmd=editarFornecedorQualificado">1. Fornecedores Selecionados</a></li>
											<li><a>2. Acordos</a></li>
											<li><a>3. Calendários dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualizações nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap"> 			
			<div class="alert alert-success">Comunicação - Grupo de processo de Execução</div>			
						
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>10.2 Gerenciar as Comunicações<br>
									<font id="mostrar23" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar23" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo23">
									<li><a>1. Entradas<br>
										<font id="mostrar24" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar24" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo24">
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunicações</a></li>					
											<li><a>2. Relatório de Desempenho de Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar25" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar25" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo25">
											<li><a>1. Tecnologias de Comunicações</a></li>
											<li><a>2. Modelos de Comunicações</a></li>
											<li><a>3. Métodos de Comunicações</a></li>
											<li><a>4. Sistemas de Gerenciamento de Informações</a></li>
											<li><a>5. Relatórios de Desempenho</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar26" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar26" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo26">
											<li><a>1. Comunicações do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualizações nos Documentos do Projeto</a></li>
											<li><a>4. Atualização nos aditivos de Processos Organizacionais</a></li>
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
