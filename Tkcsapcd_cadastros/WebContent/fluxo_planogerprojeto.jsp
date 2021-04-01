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

<title>Plano de Gerenciamento de Projetos</title>

<%@include file="css_js_configuracao.jsp" %><!-- Configuracao da formatacao da pagina, configurando modal dialog -->

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
 		
			<div class="alert alert-success">Escopo - Grupo de processo de Planejamento</div>			
						
			<br><br>	
									
				<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>5.1 Planejar o Gerenciamento do Escopo do Projeto<br>
								<font id="mostrar0" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar0" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
								</a>
								<ul id="conteudo0">								
									<li><a>1. Entradas<br>
										<font id="mostrar00" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar00" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo00">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas<br>
										<font id="mostrar1" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar1" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo1">
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar4" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar4" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo4">
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito">2. Plano de Gerenciamento dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>5.2 Controlar os Requisitos<br>
								<font id="mostrar2" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar2" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
								</a>
								<ul id="conteudo2">
									<li><a>1. Entradas<br>
										<font id="mostrar6" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar6" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo6">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito">2. Plano de Gerenciamento dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">3. Plano de Gerenciamento das Partes Interessadas</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">4. Termo de Abertura do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">5. Registro das Partes Interessadas</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar3" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar3" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo3">
											<li><a>1. Entrevistas</a></li>
											<li><a>2. Grupo de Discuss�o</a></li>
											<li><a>3. Oficinas Facilitadas</a></li>
											<li><a>4. T�cnicos de Criatividades em Grupo</a></li>
											<li><a>5. T�cnicas de Tomadas de Decis�o em Grupo</a></li>
											<li><a>6. Question�rios e Pesquisas</a></li>
											<li><a>7. observa��es</a></li>
											<li><a>8. Prot�tipos</a></li>
											<li><a>9. Benchmarking</a></li>
											<li><a>10. Diagrama de Contexto</a></li>
											<li><a>11. An�lise dos Documentos</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar5" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar5" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo5">
											<li><a>1. Documentos dos Requesitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">2. Matriz de Rastreabilidade dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.3 Definir o Escopo<br>
								<font id="mostrar7" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar7" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
								</a>
								<ul id="conteudo7">
									<li><a>1. Entradas<br>
										<font id="mostrar8" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar8" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo8">
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>					
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>
											<li><a>3. Documento dos Requisitos</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar9" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar9" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo9">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. An�lise de Produto</a></li>
											<li><a>3. Gera��o de Alternativas</a></li>
											<li><a>4. Oficinas Facilitadoras</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar13" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar13" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo13">
											<li><a>1. Documentos dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito">2. Matriz de Rastreabilidade dos Requisitos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>5.4 Criar a Estrutura Anal�tica do Projeto (EAP)<br>
								<font id="mostrar10" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar10" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
								</a>
								<ul id="conteudo10">
									<li><a>1. Entradas<br>
										<font id="mostrar14" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar14" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo14">
											<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo">1. Plano de Gerenciamento do Escopo</a></li>					
											<li><a>2. Especializa��o do Escopo do Projeto</a></li>
											<li><a>3. Documenta��o dos Requisitos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar11" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar11" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo11">
											<li><a>1. Decomposi��o</a></li>
											<li><a>2. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar12" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar12" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
										</a>
										<ul id="conteudo12">
											<li><a>1. Linha de Base do Escopo</a></li>
											<li><a>2. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul><!-- Fim escopo -->						
		</div>
		
 		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Tempo - Grupo de processo de Planejamento</div>			
							
			<br><br>
							
				<ul id="primaryNav" class="col4">
							<li id="home"><a>Processo</a></li>
							<li><a>6.1 Planejar o Gerenciamento do Cronograma do Projeto<br>
								<font id="mostrar15" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar15" class="glyphicon glyphicon-minus" color="#FFFFFF"></font>
								</a>
								<ul id="conteudo15">								
									<li><a>1. Entradas<br>
										<font id="mostrar16" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar16" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo16">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas<br>
										<font id="mostrar17" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar17" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo17">
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. T�cnicas Anal�ticas</a></li>
											<li><a>3. Reuni�ess</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar18" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar18" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo18"> 
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.2 Definir as Atividades<br>
								<font id="mostrar19" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar19" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo19">
									<li><a>1. Entradas<br>
										<font id="mostrar20" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar20" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo20">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas<br>
										<font id="mostrar21" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar21" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo21">
											<li><a>1. Decomposi��o</a></li>
											<li><a>2. Planejamento em Ondas Sucessivas</a></li>
											<li><a>3. Opini�o especializada</a></li>											
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar22" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar22" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo22">
											<li><a>1. Lista de Atividades</a></li>
											<li><a>2. Atributos das Atividades</a></li>
											<li><a>3. Lista de Atividades</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.3 Sequ�nciar as Atividades<br>
									<font id="mostrar23" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar23" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
									<ul id="conteudo23">
									<li><a>1. Entradas<br>
										<font id="mostrar24" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar24" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo24">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a>2. Lista de Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Lista de Marcos</a></li>
											<li><a>5. Especializa��o do Escopo do Projeto</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar25" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar25" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo25">
											<li><a>1. M�todo do Diagrama de Preced�ncia (MDP)</a></li>
											<li><a>2. Determina��o de Depend�ncia</a></li>
											<li><a>3. Antecipa��es e Esperas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar26" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar26" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo26">
											<li><a>1. Diagrama de Rede do Cronograma do Projeto</a></li>
											<li><a>3. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.4 Estimar os Recursos das Atividades<br>
								<font id="mostrar27" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar27" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo27">
									<li><a>1. Entradas<br>
										<font id="mostrar28" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar28" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo28">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista de Atividade</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Calend�rios dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">5. Registro dos Riscos</a></li>
											<li><a>6. Estimativas de Custo das Atividades</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">7. Fatores Ambientais da Empresa</a></li>
											<li><a>8. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar29" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar29" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo29">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. An�lise de Alternativas</a></li>
											<li><a>3. Dados publicados sobre estimativas</a></li>
											<li><a>4. Estimativa de Bottom-up</a></li>
											<li><a>5. Software de Gerenciamento de Projeto</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar30" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar30" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo30">
											<li><a>1. Requisitos de Recursos das Atividades</a></li>
											<li><a>2. Estrutura Anal�tica dos Recursos</a></li>
											<li><a>3. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.5 Estimar as Dura��es das Atividades<br>
								<font id="mostrar31" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar31" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo31">
									<li><a>1. Entradas<br>
									<font id="mostrar32" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
									<font id="ocultar32" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo32">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista das Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Requisitos de Recursos das Atividades</a></li>
											<li><a>5. Calend�rios dos Recursos</a></li>
											<li><a>6. Especifica��o do Escopo do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">7. Registro do Riscos</a></li>
											<li><a>8. Estrutura Anal�tica dos Recursos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">9. Fatores Ambientais da Empresa</a></li>
											<li><a>10. Ativos de Processo Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar15" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar15" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo33">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. Estimativa An�loga</a></li>
											<li><a>3. Estimativa Param�trica</a></li>
											<li><a>4. Estimativa de 3 pontos</a></li>
											<li><a>5. T�cnica de Tomada de Decis�o em Grupo</a></li>
											<li><a>6. An�lise de Reservas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar34" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar34" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo34">
											<li><a>1. Estimativas das dura��es das Atividades</a></li>
											<li><a>2. Atualiza��o nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>6.6 Desenvolver o Cronograma<br>
								<font id="mostrar35" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar35" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo35">
									<li><a>1. Entradas<br>
										<font id="mostrar36" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar36" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo36">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">1. Plano de Gerenciamento do Cronograma</a></li>					
											<li><a href="TkcsapcdController?cmd=editarListaAtividade">2. Lista de Atividades</a></li>
											<li><a>3. Atributos das Atividades</a></li>
											<li><a>4. Diagrama de Rede do Cronograma do Projeto</a></li>
											<li><a>5. Requisitos de Recursos das Atividades</a></li>
											<li><a>6. Calend�rios dos Recursos</a></li>
											<li><a>7. Estimativa de Dura��o das Atividades</a></li>
											<li><a>8. Especifica��o do Escopo do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">9. Registro do Riscos</a></li>
											<li><a>10. Desgna��es do Pessoal do Projeto</a></li>
											<li><a>11. Estrutura Anal�tica dos Recursos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">12. Fatores Ambientais da Empresa</a></li>
											<li><a>13. Ativos de Processos Organizacionais</a></li>											
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar37" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar37" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo37">
											<li><a>1. An�lise de Rede do Cronograma</a></li>
											<li><a>2. M�todo do Caminho Cr�tico</a></li>
											<li><a>3. M�todo da Corrente Cr�tica</a></li>
											<li><a>4. T�cnica de Otimiza��es de Recursos</a></li>
											<li><a>5. T�cnicas de Desenvolvimento de Modelos</a></li>
											<li><a>6. Antecipa��o e Espera</a></li>
											<li><a>7. Compress�o de Cronograma</a></li>
											<li><a>8. Ferramenta de Cronograma</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar38" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar38" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo38">
											<li><a>1. Linha de Base do Cronograma</a></li>										
											<li><a>2. Cronograma do Projeto</a></li>
											<li><a>3. Dados do Cronograma</a></li>
											<li><a>4. Calend�rio do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">5. Atualiza��o no Plano de Gerenciamento do Projeto</a></li>
											<li><a>6. Atualiza��o nos Documentos do projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					</div>
		
		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Custo - Grupo de processo de Planejamento</div>			
						
			<br><br>
						
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
							<li><a>7.1 Planejar o Gerenciamento do Custo<br>
								<font id="mostrar39" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar39" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo39">								
									<li><a>1. Entradas<br>
										<font id="mostrar40" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar40" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo40">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>							
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas<br>
										<font id="mostrar41" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar41" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo41">
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. T�cnicas An�liticas</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar42" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar42" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo42">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>7.2 Estimar os Custos<br>
								<font id="mostrar43" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar43" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo43">
									<li><a>1. Entradas<br>
										<font id="mostrar44" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar44" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo44">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">2. Plano de Gerenciamento dos Recursos Humanos</a></li>
											<li><a>3. Linha de Base do Escopo</a></li>
											<li><a>4. Cronograma do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">5. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">6. Fatores Ambientais da Empresa</a></li>
											<li><a>7. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar45" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar45" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo45">
											<li><a>1. Opini�es Especializadas</a></li>
											<li><a>2. Estimativa An�loga</a></li>
											<li><a>3. Estimativa Param�trica</a></li>
											<li><a>4. Estimativa "Bottom-up"</a></li>
											<li><a>5. Estimativa de 3 Pontos</a></li>
											<li><a>6. An�lise de Reservas</a></li>
											<li><a>7. Custo de Qualidade</a></li>
											<li><a>8. Software de Gerenciamento de Projetos</a></li>
											<li><a>9. An�lise de Proposta de Fornecedor</a></li>
											<li><a>10. T�cnicas de Tomada de Decis�o em Grupo</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar46" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar46" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo46">
											<li><a>1. Estimativa de Custos das Atividades</a></li>
											<li><a>2. Base das Estimativas</a></li>
											<li><a>3. Atualiza��es nos Documentos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>7.3 Determinar o Or�amento<br>
								<font id="mostrar47" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar47" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo47">
									<li><a>1. Entradas<br>
										<font id="mostrar48" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar48" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo48">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">1. Plano de Gerenciamento dos Custos</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a>3. Estimativas dos Custos das Atividades</a></li>
											<li><a>4. Base das Estimativas</a></li>
											<li><a>5. Cronograma do Projeto</a></li>
											<li><a>6. Calend�rio dos Recursos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">7. Registro dos Riscos</a></li>
											<li><a>8. Acordos</a></li>
											<li><a>9. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar49" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar49" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo49">
											<li><a>1. Agraga��o de Custos</a></li>
											<li><a>2. An�lise de Reservas</a></li>
											<li><a>3. Opini�o Especializada</a></li>
											<li><a>4. Rela��es Hist�ricas</a></li>
											<li><a>Reconcilia��o dos Limites de Recursos Financeiros</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar50" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar50" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo50">
											<li><a>1. Linha de Base dos Documentos</a></li>
											<li><a>2. Requisitos de Recursos</a></li>
											<li><a>3. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>		
		
		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Integra��o - Grupo de processo de Planejamento</div>			
								
			<br><br>
							
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>4.2 Desenvolver o Plano de Gerenciamento do Projeto<br>
								<font id="mostrar51" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar51" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo51">
									<li><a>1. Entradas<br>
										<font id="mostrar52" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar52" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo52">
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">1. Termo de Abertura do Projeto</a></li>					
											<li><a>2. Sa�das de Outros Processos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar53" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar53" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo53">
											<li><a>1. Opini�o especializada</a></li>
											<li><a>2. T�cnicas de facilita��o</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar54" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar54" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo54">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
		
		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Aquisi��o - Grupo de processo de Planejamento</div>			
						
			<br><br>
							
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
							<li><a>12.1 Planejar o Gerenciamento das Aquisi��es<br>
								<font id="mostrar55" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar55" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo55">							
									<li><a>1. Entradas<br>
										<font id="mostrar56" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar56" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo56">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Documenta��o dos Requisitos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a>4. Requisitos de Recursos das Atividades</a></li>
											<li><a>5. Cronograma do Projeto</a></li>
											<li><a>6. Estimativa dos Custos das Atividades</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">7. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">8. Fatores Ambientais da Empresa</a></li>
											<li><a>9. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas<br>
										<font id="mostrar57" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar57" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo57">
											<li><a>1. An�lise de fazer ou comprar</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Pesquisa de Mercado</a></li>
											<li><a>4. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar58" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar58" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo58">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao">1. Plano de Gerenciamento das Aquisi��es</a></li>
											<li><a>2. Especifica��o do Trabalho das Aquisi��es</a></li>
											<li><a>3. Documentos de Aquisi��o</a></li>
											<li><a>4. Crit�rios para Sele��o de Fontes</a></li>
											<li><a>5. Decis�es de Fazer ou Comprar</a></li>
											<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca">6. Solicita��es de Mudan�as</a></li>
											<li><a>7. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>			
				</ul>
		</div>
		
		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Riscos - Grupo de processo de Planejamento</div>			
							
			<br><br>		
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
							<li><a>11.1 Planejar o Gerenciamento dos Riscos<br>
								<font id="mostrar59" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar59" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo59">							
									<li><a>1. Entradas<br>
										<font id="mostrar60" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar60" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo60">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto">2. Termo de Abertura do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">3. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Tool & Techniques<br>
										<font id="mostrar61" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar61" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo61">
											<li><a>1. Tecnicas Anal�ticas</a></li>
											<li><a>2. Opini�o Especializada</a></li>
											<li><a>3. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar62" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar62" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo62">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>
										</ul>
									</li>
								</ul>
							</li>			
							<li><a>11.2 Identificar os Riscos<br>
								<font id="mostrar63" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar63" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo63">
									<li><a>1. Entradas<br>
										<font id="mostrar87" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar87" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo87">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">2. Plano de Gerenciamento dos Custos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">3. Plano de Gerenciamento do Cronograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade">4. Plano de Gerenciamento da Qualidade</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH">5. Plano de Gerenciamento dos Recursos Humanos</a></li>					
											<li><a>6. Lista de Base do Escopo</a></li>
											<li><a>7. Estimativas dos Custos das Atividades</a></li>
											<li><a>8. Estimativas das Dura��es das Atividades</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">9. Registros das Partes Interessadas</a></li>
											<li><a>10. Documentos do Projeto</a></li>
											<li><a>11. Documentos da Aquisi��o</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">12. Fatores Ambientais da Empresa</a></li>
											<li><a>13. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar64" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar64" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo64">
											<li><a>1. Revis�es de Documenta��o</a></li>
											<li><a>2. T�cnicas de Coleta de successrma��es</a></li>
											<li><a>3. An�lise de Listas de Verifica��o</a></li>
											<li><a>4. An�lise de Premissas</a></li>
											<li><a>5. T�cnicas de Diagrama</a></li>
											<li><a>6. An�lise de For�as, Fraquezas, Oportunidades e Ame�as (SWOT)</a></li>
											<li><a>7. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar65" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar65" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo65">
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">1. Registro dos Riscos</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.3 Realizar a An�lise Qualitativa dos Riscos<br>
								<font id="mostrar66" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar66" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo66">
									<li><a>1. Entradas<br>
										<font id="mostrar68" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar68" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo68">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>					
											<li><a>2. Linha de Base do Escopo</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">3. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">4. Fatores Ambientais da Empresa</a></li>
											<li><a>5. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar69" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar69" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo69">
											<li><a>1. Avalia��o de Probabilidade e Impacto dos Riscos</a></li>
											<li><a>2. Matriz de Probabilidade e Impacto</a></li>
											<li><a>3. Avalia��o de Qualidade dos Dados sobre Riscos</a></li>
											<li><a>4. Categoriza��o de Riscos</a></li>
											<li><a>5. Avalia��o da Urg�ncia dos Riscos</a></li>
											<li><a>6. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar70" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar70" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo70">
											<li><a>1. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.4 Realizar a An�lise Qualitativa dos Riscos<br>
								<font id="mostrar71" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar71" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo71">
									<li><a>1. Entradas<br>
										<font id="mostrar72" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar72" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo72">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>					
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto">2. Plano de Gerenciamento dos Custos</a></li>
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma">3. Plano de Gerenciamento do Cornograma</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">4. Registro dos Riscos</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">5. Fatores Ambientais da Empresa</a></li>
											<li><a>6. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar73" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar73" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo73">
											<li><a>1. T�cnicas de Coleta e Apresenta��o de Dados</a></li>
											<li><a>2. T�cnicas de Modelagem e An�lise Quantitativa Especializada</a></li>	
											<li><a>3. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar74" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar74" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo74">
											<li><a>4. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a>11.5 Planejar as Respostas aos Riscos<br>
								<font id="mostrar75" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar75" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo75">
									<li><a>1. Entradas<br>
										<font id="mostrar76" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar76" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo76">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco">1. Plano de Gerenciamento dos Riscos</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroRisco">2. Registro dos Riscos</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar77" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar77" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo77">
											<li><a>1. Estrat�gias para Riscos Negativos ou Amea�as</a></li>
											<li><a>2. Estrat�gias para Riscos Positivos ou Oportunidades</a></li>
											<li><a>3. Estrat�gias de respostas de Contig�ncia</a></li>
											<li><a>4. Opini�o Especializada</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar78" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar78" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo78">
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto">1. Atualiza��es no Plano de Gerenciamento do Projeto</a></li>
											<li><a>2. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
				
		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Partes Interessadas - Grupo de processo de Planejamento</div>			
						
			<br><br>			
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
					<li><a>13.2 Planejar o Gerenciamento das Partes Interessadas<br>
								<font id="mostrar79" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar79" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
								<ul id="conteudo79">
									<li><a>1. Entradas<br>
										<font id="mostrar80" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar80" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo80">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">2. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e t�cnicas<br>
										<font id="mostrar81" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar81" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo81">
											<li><a>1. Opini�o Especializada</a></li>
											<li><a>2. Reuni�es</a></li>
											<li><a>3. T�cnicas An�liticas</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar82" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar82" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo82">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada">1. Plano de Gerenciamento das Partes Interessadas</a></li>
											<li><a>2. Atualiza��es nos Documentos do Projeto</a></li>
										</ul>
									</li>
								</ul>
							</li>
				</ul>
		</div>
				
		<div class="sitemap">
 			<br><br>
			<div class="alert alert-success">Comunica��o - Grupo de processo de Planejamento</div>			
							
			<br><br>									
				<ul id="primaryNav" class="col4">
					<li id="home"><a>Processo</a></li>
							<li><a>10.1 Planejar o Gerenciamento das Comunica��es<br>
								<font id="mostrar83" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
								<font id="ocultar83" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>							
								<ul id="conteudo83">								
									<li><a>1. Entradas<br>
										<font id="mostrar84" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar84" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo84">
											<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">1. Plano de Gerenciamento do Projeto</a></li>
											<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada">2. Registro das Partes Interessadas</a></li>
											<li><a href="cadastro_fatores_ambientais.jsp">3. Fatores Ambientais da Empresa</a></li>
											<li><a>4. Ativos de Processos Organizacionais</a></li>
										</ul>
									</li>
									<li><a>2. Ferramentas e T�cnicas<br>
										<font id="mostrar85" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar85" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo85">
											<li><a>1. An�lise de Requisitos das Comunica��es</a></li>
											<li><a>2. Tecnologias de Comunica��es</a></li>
											<li><a>3. Modelos de Comunica��es</a></li>
											<li><a>4. M�todos de Comunica��es</a></li>
											<li><a>5. Projeto de Experimentos</a></li>
											<li><a>6. Reuni�es</a></li>
										</ul>
									</li>
									<li><a>3. Sa�das<br>
										<font id="mostrar86" class="glyphicon glyphicon-plus" color="#FFFFFF"></font> 
										<font id="ocultar86" class="glyphicon glyphicon-minus" color="#FFFFFF"></font></a>
										<ul id="conteudo86">
											<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao">1. Plano de Gerenciamento das Comunica��es</a></li>
											<li><a>2. Atualiza��o nos Documentos do Projeto</a></li>
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
