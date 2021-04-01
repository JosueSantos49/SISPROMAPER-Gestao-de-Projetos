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

<title>Execu��o</title>

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
 			
			<div class="alert alert-success">Qualidade - Grupo de processo de Execu��o</div>			
								
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
											<li><a>3. M�tricas da Qualidade</a></li>
											<li><a>4. Medi��es do Controle de Qualidade</a></li>
											<li><a>5. Documenta��o do Projeto</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo1">
											<li><a>1. Ferramenta de Gerenciamento e Controle da Qualidade</a></li>
											<li><a>2. Auditoria de Qualidade</a></li>
											<li><a>3. An�lise de Processo</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo4">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>4. Atualiza��o nos Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap">
			<div class="alert alert-success">Integra��o - Grupo de processo de Execu��o</div>			
				
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
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">2. Solicita��o de Mudan�as Aprovadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo3">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. Sistema de Informa��o de Gerenciamento de Projetos</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo5">
											<li><a>1. Entregas</a></li>
											<li><a>2. Dados de Desenpenho do Trabalho</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">3. Solicita��o de Mudan�a</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">4. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>5. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap">
			<div class="alert alert-success">RH - Grupo de processo de Execu��o</div>			
									
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
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar9" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar9" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo9">
											<li><a>1. Pr�-designa��o</a></li>
											<li><a>2. Negocia��o</a></li>
											<li><a>3. Contrata��o</a></li>
											<li><a>4. Equipes Virtuais</a></li>
											<li><a>5. An�lise de Decis�o Envolvendo Crit�rios M�ltiplos</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar13" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar13" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo13">
											<li><a>1. Designa��es do Pessoal do Projeto</a></li>
											<li><a>2. Calend�rio dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">3. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
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
											<li><a>2. Desgna��o do Pessoal do Projeto</a></li>
											<li><a>3. Calend�rios dos Recursos</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar11" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar11" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo11">
											<li><a>1. Habilidades Interpessoais</a></li>
											<li><a>2. Treinamento</a></li>
											<li><a>3. Atividades de Constru��o da Equipe</a></li>
											<li><a>4. Regr�s B�sicas</a></li>
											<li><a>5. Agrupamento</a></li>
											<li><a>6. Reconhecimento e Recompensas</a></li>
											<li><a>7. Ferramentas de Avalia��o dos Funcion�rios</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar12" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar12" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo12">
											<li><a>1. Avalia��es de Desempenho da Equipe</a></li>
											<li><a>2. Atualiza��es nos Fatores Ambientais da Empresa</a></li>
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
											<li><a>2. Desgna��o do Pessoal do Projeto</a></li>
											<li><a>3. Avalia��es de Desempenho da Equipe</a></li>
											<li><a href="TkcsapcdController?cmd=editarIssuesLog">4. Registro das Quest�es</a></li>
											<li><a>5. Relat�rios do Desempenho do Trabalho</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar17" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar17" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo17">
											<li><a>1. Observa��es e Conversas</a></li>
											<li><a>2. Avalia��es de Desempenho do Projeto</a></li>
											<li><a>3. Gerenciamento de Conflitos</a></li>
											<li><a>4. Habilidades Interpessoais</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar18" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar18" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo18">
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">1. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Avalia��es nos Documentos do Projeto</a></li>
											<li><a>4. Atualiza��es nos Fatores Ambientais da Empresa</a></li>
											<li><a>5. Atualiza��es nos Ativos de Processos Organizacionais</a></li>	
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap"> 			
			<div class="alert alert-success">Aquisi��o - Grupo de processo de Execu��o</div>			
						
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>12.2 Conduzir as Aquisi��es<br>
								<font id="mostrar19" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar19" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo19">
									<li><a>1. Entradas<br>
										<font id="mostrar20" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar20" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo20">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisi��es</a></li>
											<li><a>2. Documentos das Aquisi��es</a></li>
											<li><a>3. Crit�rios para Sele��o de Fontes</a></li>
											<li><a>4. Propostas dos Fornecedores</a></li>
											<li><a>5. Documentos do Projeto</a></li>
											<li><a>6. Decis�es de Fazer ou Comprar</a></li>
											<li><a>7. Especifica��o do Trabalho das Aquisi��es</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar21" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar21" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo21">
											<li><a>1. Reuni�o com Licitantes</a></li>
											<li><a>2. T�cnicas de Avalia��o Propostas</a></li>
											<li><a>3. Estimativas Independentes</a></li>
											<li><a>4. Opini�o Especializada</a></li>
											<li><a>5. Publicidade</a></li>
											<li><a>6. T�cnicas An�liticas</a></li>
											<li><a>7. Negocia��es das Aquisi��es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar22" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar22" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo22">
											<li><a href="TkcsapcdController?cmd=editarFornecedorQualificado">1. Fornecedores Selecionados</a></li>
											<li><a>2. Acordos</a></li>
											<li><a>3. Calend�rios dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">4. Solicita��es de Mudan�as</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
	</div>
	
	<div class="sitemap"> 			
			<div class="alert alert-success">Comunica��o - Grupo de processo de Execu��o</div>			
						
			<br><br>											
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>10.2 Gerenciar as Comunica��es<br>
									<font id="mostrar23" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar23" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo23">
									<li><a>1. Entradas<br>
										<font id="mostrar24" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar24" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo24">
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunica��es</a></li>					
											<li><a>2. Relat�rio de Desempenho de Trabalho</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar25" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar25" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo25">
											<li><a>1. Tecnologias de Comunica��es</a></li>
											<li><a>2. Modelos de Comunica��es</a></li>
											<li><a>3. M�todos de Comunica��es</a></li>
											<li><a>4. Sistemas de Gerenciamento de Informa��es</a></li>
											<li><a>5. Relat�rios de Desempenho</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar26" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar26" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo26">
											<li><a>1. Comunica��es do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">2. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>3. Atualiza��es nos Documentos do Projeto</a></li>
											<li><a>4. Atualiza��o nos aditivos de Processos Organizacionais</a></li>
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
	<script src="js/modal_dialog.js"></script>
	<%@include file="gif_load_page.jsp" %> 
</body>	
</html>
