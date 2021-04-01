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

<title>Monitoramento e Controle</title>

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
 			
			<div class="alert alert-success">Integração - Grupo de processo de Monitoramento e Controle</div>			
								
			<br><br>										
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>4.4 Monitorar e Controlar o Trabalho do Projeto<br>
								<font id="mostrar0" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar0" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo0">
									<li><a>1. Entradas<br>
										<font id="mostrar00" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar00" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo00">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Previsões de Cronograma</a></li>
											<li><a>3. Previsões de Custos</a></li>
											<li><a>4. Mudanças Validadas</a></li>
											<li><a>5. Informações Sobre o Desenpenho do Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo1">
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Técnicas Analíticas</a></li>
											<li><a>3. Sistema de Informação do Gerenciamento do Projeto</a></li>
											<li><a>4. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo4">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudanças</a></li>
											<li><a>2. Relatório de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerencimaento do Projeto</a></li>
											<li><a>4. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.5 Realizar o Controle Integrado de Mudanças<br>
								<font id="mostrar2" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar2" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo2">
									<li><a>1. Entradas<br>
										<font id="mostrar6" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar6" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo6">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Relatório de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitações de Mudanças</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo3">
											<li><a>1. Opinião especializada</a></li>
											<li><a>2. Reuniões</a></li>
											<li><a>3. Ferramentas de Controle de Mudanças</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo5">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicitações de Mudança Aprovada</a></li>
											<li><a>2. Registro de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualização no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
 	
		<div class="sitemap">
 			
			<div class="alert alert-success">Escopo - Grupo de processo de Monitoramento e Controle</div>			
												
			<br><br>										
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>5.5 Validar o Escopo<br>
								<font id="mostrar7" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar7" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo7">
									<li><a>1. Entradas<br>
										<font id="mostrar8" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar8" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo8">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentação dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matriz de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Entregas Verificadas</a></li>
											<li><a>5. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar9" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar9" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo9">
											<li><a>1. Inspeção</a></li>
											<li><a>2. Técnicas de Tomada de Decisão em grupo</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar13" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar13" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo13">
											<li><a>1. Entregas Aceitas</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a>3. Informações sobre o Desempenho do Trabalho</a></li>
											<li><a>4. Atualização nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.6 Controlar o Escopo<br>
								<font id="mostrar10" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar10" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo10">
									<li><a>1. Entradas<br>
										<font id="mostrar14" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar14" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo14">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentação dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matrís de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar11" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar11" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo11">
											<li><a>1. Análise de Variação</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar12" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar12" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo12">
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>										
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitação de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações do Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>			
				</ul>			
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Tempo - Grupo de processo de Monitoramento e Controle</div>
									
			<br><br>										
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>6.7 Controlar o Cronograma<br>
								<font id="mostrar15" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar15" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo15">
									<li><a>1. Entradas<br>
										<font id="mostrar16" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar16" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo16">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Cronograma do Projeto</a></li>
											<li><a>3. Dados de Desempenho do Projeto</a></li>
											<li><a>4. Calendário do Projeto</a></li>
											<li><a>5. Dados do Cronograma</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar17" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar17" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo17">
											<li><a>1. Análise de Dempenho</a></li>
											<li><a>2. Software de Gerenciamento de Projeto</a></li>
											<li><a>3. Técnicas de Otimização de Recursos</a></li>
											<li><a>4. Técnicas de Desenvolvimento de Modelos</a></li>
											<li><a>5. Antecipações e Esperas</a></li>
											<li><a>6. Compressão de Cronograma</a></li>
											<li><a>7. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar18" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar18" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo18">
											<li><a>1. Informações sobre o Desenvolvimento do Trabalho</a></li>										
											<li><a>2. Previsão de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitações de Mudança</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualizações nos Documentos do Projeto</a></li>
											<li><a>6. Atualizações nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Custo - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>7.4 Controlar os Custos<br>
								<font id="mostrar19" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar19" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo19">
									<li><a>1. Entradas<br>
										<font id="mostrar20" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar20" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo20">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do projeto</a></li>					
											<li><a>2. Requisitos de Recursos Financeiros do Projeto</a></li>
											<li><a>3. Dados do Desempenho do Projeto</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar21" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar21" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo21">
											<li><a>1. Gerenciamento do Valor Agregado</a></li>
											<li><a>2. Previsão</a></li>
											<li><a>3. Índice de Desempenho para Término (IDPT)</a></li>
											<li><a>4. Análise de Desempenho</a></li>
											<li><a>5. Software de Gerenciamento de Projetos</a></li>
											<li><a>6. Análise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar22" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar22" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo22">
											<li><a>1. Informações sobre o desempenho do Trabalho</a></li>
											<li><a>2. Previsões de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualização no Planode gerenciamento do Projeto</a></li>
											<li><a>5. Atualização nos documentos do Projeto</a></li>
											<li><a>6. atualizações nos Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
								</ul>
							</li>	
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Qualidade - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>8.3 Controlar a Qualidade<br>
									<font id="mostrar23" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar23" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo23">
									<li><a>1. Entradas<br>
										<font id="mostrar24" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar24" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo24">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Métricas da Qualidade</a></li>
											<li><a>3. Lista de Verificação da Qualidade</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicitações de Mudanças Aprovadas</a></li>
											<li><a>6. Entregas</a></li>
											<li><a>7. Documentos do Projeto</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar25" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar25" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo25">
											<li><a>1. Sete Ferramentas de Qualidade Básicas</a></li>
											<li><a>2. Amostragem Estatísticas</a></li>
											<li><a>3. Inspeção</a></li>
											<li><a>4. Análise das Solicitações de Mudanças Aprovadas</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar26" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar26" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo26">
											<li><a>1. Medições do Controle de Qualidade</a></li>
											<li><a>2. Alterações validas</a></li>
											<li><a>3. Entregas Verificadas</a></li>
											<li><a>4. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">6. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>7. Atualizações nos Documentos do Projeto</a></li>
											<li><a>8. Atualizações nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Comunicação - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>10.3 Controlar as Comunicações<br>
								<font id="mostrar27" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar27" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo27">
									<li><a>1. Entradas<br>
										<font id="mostrar28" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar28" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo28">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Comunicações do Projeto</a></li>
											<li><a>3. Registro das Questões</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar29" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar29" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo29">
											<li><a>1. Sistemas de Gerenciamento de Informações</a></li>
											<li><a>2. Opiniões Especializadas</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar30" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar30" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo30">
											<li><a>1. Informações sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Aquisição - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>12.3 Controlar as Aquisições<br>
								<font id="mostrar31" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar31" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo31">
									<li><a>1. Entradas<br>
										<font id="mostrar39" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar39" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo39">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentos de aquisição</a></li>
											<li><a>3. Acordos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicitação de Mudanças Aprovadas</a></li>
											<li><a>5. Relatórios Desempenho do Trabalho</a></li>
											<li><a>6. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
									<font id="mostrar32" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar32" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo32">
											<li><a>1. Sistema de Controle de Mudança no Contrato</a></li>
											<li><a>2. Análise de Desempenho das Aquisições</a></li>
											<li><a>3. Inspeções e Auditorias</a></li>
											<li><a>4. Relatório de Desempenho</a></li>
											<li><a>5. Sistema de Pagamento</a></li>
											<li><a>6. Administração de Reivindicações</a></li>
											<li><a>7. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar33" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar33" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo33">
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Partes Interessadas - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>13.4 Controlar o Engajamento das Partes Interessadas<br>
										<font id="mostrar34" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar34" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo34">
									<li><a>1. Entradas<br>
								<font id="mostrar35" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar35" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo35">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">2. Registro das Questões</a></li>
											<li><a>3. Dados de Desempenho do Trabalho</a></li>
											<li><a>4. Documentos do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e técnicas<br>
										<font id="mostrar37" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar37" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo37">	
											<li><a>1. Sistema de Gerenciamento de Informação</a></li>
											<li><a>2. Opinião Especializada</a></li>
											<li><a>3. Reuniões</a></li>
										</ul>
									</li>
									<li><a>3. Saídas<br>
										<font id="mostrar38" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar38" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo38">
											<li><a>1. Informações Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicitações de Mudanças</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">3. Atualizações no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualizações nos Documentos do Projeto</a></li>
											<li><a>5. Atualizações nos ativos de Processos Organizacionais</a></li>
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
	<script src="js/modal_dialog.js"></script><!-- Configuração de animação de carregamento da página -->
	<%@include file="gif_load_page.jsp" %> 
</body>	
</html>
