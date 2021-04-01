<!-- 
	Autor: Josu� da Concei��o Santos
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
<link rel="shortcut icon" href="#" type="image/x-icon"><!-- Icone na aba da p�gina -->

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
 			
			<div class="alert alert-success">Integra��o - Grupo de processo de Monitoramento e Controle</div>			
								
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
											<li><a>2. Previs�es de Cronograma</a></li>
											<li><a>3. Previs�es de Custos</a></li>
											<li><a>4. Mudan�as Validadas</a></li>
											<li><a>5. Informa��es Sobre o Desenpenho do Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo1">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. T�cnicas Anal�ticas</a></li>
											<li><a>3. Sistema de Informa��o do Gerenciamento do Projeto</a></li>
											<li><a>4. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo4">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�as</a></li>
											<li><a>2. Relat�rio de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerencimaento do Projeto</a></li>
											<li><a>4. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>4.5 Realizar o Controle Integrado de Mudan�as<br>
								<font id="mostrar2" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar2" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo2">
									<li><a>1. Entradas<br>
										<font id="mostrar6" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar6" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo6">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Relat�rio de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��es de Mudan�as</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo3">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. Reuni�es</a></li>
											<li><a>3. Ferramentas de Controle de Mudan�as</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo5">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�a Aprovada</a></li>
											<li><a>2. Registro de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��o nos Documentos do Projeto</a></li>
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
											<li><a>2. Documenta��o dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matriz de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Entregas Verificadas</a></li>
											<li><a>5. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar9" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar9" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo9">
											<li><a>1. Inspe��o</a></li>
											<li><a>2. T�cnicas de Tomada de Decis�o em grupo</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar13" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar13" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo13">
											<li><a>1. Entregas Aceitas</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a>3. Informa��es sobre o Desempenho do Trabalho</a></li>
											<li><a>4. Atualiza��o nos Documentos do Projeto</a></li>
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
											<li><a>2. Documenta��o dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">3. Matr�s de Rastreabilidade dos Requisitos</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar11" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar11" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo11">
											<li><a>1. An�lise de Varia��o</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar12" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar12" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo12">
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>										
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��o de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es do Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos Ativos de Processos Organizacionais</a></li>
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
											<li><a>4. Calend�rio do Projeto</a></li>
											<li><a>5. Dados do Cronograma</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar17" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar17" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo17">
											<li><a>1. An�lise de Dempenho</a></li>
											<li><a>2. Software de Gerenciamento de Projeto</a></li>
											<li><a>3. T�cnicas de Otimiza��o de Recursos</a></li>
											<li><a>4. T�cnicas de Desenvolvimento de Modelos</a></li>
											<li><a>5. Antecipa��es e Esperas</a></li>
											<li><a>6. Compress�o de Cronograma</a></li>
											<li><a>7. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar18" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar18" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo18">
											<li><a>1. Informa��es sobre o Desenvolvimento do Trabalho</a></li>										
											<li><a>2. Previs�o de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��es de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>6. Atualiza��es nos Ativos de Processos Organizacionais</a></li>
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
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar21" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar21" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo21">
											<li><a>1. Gerenciamento do Valor Agregado</a></li>
											<li><a>2. Previs�o</a></li>
											<li><a>3. �ndice de Desempenho para T�rmino (IDPT)</a></li>
											<li><a>4. An�lise de Desempenho</a></li>
											<li><a>5. Software de Gerenciamento de Projetos</a></li>
											<li><a>6. An�lise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar22" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar22" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo22">
											<li><a>1. Informa��es sobre o desempenho do Trabalho</a></li>
											<li><a>2. Previs�es de Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualiza��o no Planode gerenciamento do Projeto</a></li>
											<li><a>5. Atualiza��o nos documentos do Projeto</a></li>
											<li><a>6. atualiza��es nos Ativos de Processos Organizacionais</a></li>											
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
											<li><a>2. M�tricas da Qualidade</a></li>
											<li><a>3. Lista de Verifica��o da Qualidade</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicita��es de Mudan�as Aprovadas</a></li>
											<li><a>6. Entregas</a></li>
											<li><a>7. Documentos do Projeto</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar25" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar25" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo25">
											<li><a>1. Sete Ferramentas de Qualidade B�sicas</a></li>
											<li><a>2. Amostragem Estat�sticas</a></li>
											<li><a>3. Inspe��o</a></li>
											<li><a>4. An�lise das Solicita��es de Mudan�as Aprovadas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar26" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar26" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo26">
											<li><a>1. Medi��es do Controle de Qualidade</a></li>
											<li><a>2. Altera��es validas</a></li>
											<li><a>3. Entregas Verificadas</a></li>
											<li><a>4. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">5. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">6. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>7. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>8. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Comunica��o - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>10.3 Controlar as Comunica��es<br>
								<font id="mostrar27" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar27" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo27">
									<li><a>1. Entradas<br>
										<font id="mostrar28" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar28" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo28">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Comunica��es do Projeto</a></li>
											<li><a>3. Registro das Quest�es</a></li>
											<li><a>4. Dados de Desempenho do Trabalho</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar29" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar29" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo29">
											<li><a>1. Sistemas de Gerenciamento de Informa��es</a></li>
											<li><a>2. Opini�es Especializadas</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar30" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar30" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo30">
											<li><a>1. Informa��es sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			
			<div class="alert alert-success">Aquisi��o - Grupo de processo de Monitoramento e Controle</div>			
			
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>12.3 Controlar as Aquisi��es<br>
								<font id="mostrar31" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar31" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo31">
									<li><a>1. Entradas<br>
										<font id="mostrar39" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar39" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo39">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a>2. Documentos de aquisi��o</a></li>
											<li><a>3. Acordos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicita��o de Mudan�as Aprovadas</a></li>
											<li><a>5. Relat�rios Desempenho do Trabalho</a></li>
											<li><a>6. Dados de Desempenho do Trabalho</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
									<font id="mostrar32" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar32" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo32">
											<li><a>1. Sistema de Controle de Mudan�a no Contrato</a></li>
											<li><a>2. An�lise de Desempenho das Aquisi��es</a></li>
											<li><a>3. Inspe��es e Auditorias</a></li>
											<li><a>4. Relat�rio de Desempenho</a></li>
											<li><a>5. Sistema de Pagamento</a></li>
											<li><a>6. Administra��o de Reivindica��es</a></li>
											<li><a>7. Sistema de Gerenciamento de Registros</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar33" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar33" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo33">
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
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
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">2. Registro das Quest�es</a></li>
											<li><a>3. Dados de Desempenho do Trabalho</a></li>
											<li><a>4. Documentos do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar37" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar37" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo37">	
											<li><a>1. Sistema de Gerenciamento de Informa��o</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar38" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar38" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo38">
											<li><a>1. Informa��es Sobre o Desempenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>5. Atualiza��es nos ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
							<ul id="utilityNav">
								<li><a href="index_principal.jsp">Home Page</a></li>
								<li><a href="sair.jsp">Encerrar Sess�o</a></li>			
								<li><a href="#" id="subir">Topo</a></li>
							</ul>
		</div>
									
	</div>
</div>
	<%@include file="configuracao_wow.jsp" %>
	<script src="js/modal_dialog.js"></script><!-- Configura��o de anima��o de carregamento da p�gina -->
	<%@include file="gif_load_page.jsp" %> 
</body>	
</html>
