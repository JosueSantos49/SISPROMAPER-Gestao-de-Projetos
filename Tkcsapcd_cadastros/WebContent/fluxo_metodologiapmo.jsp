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

<title>Metodologia</title>

<%@include file="css_js_configuracao.jsp" %><!-- Configuracao da formatacao da pagina, configurando modal dialog -->

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecsslivre.jsp"%>

<div id="main" class="container">
	<div class="wow slideInLeft" data-wow-duration="1s">
		<%@include file="indice_paleativo.jsp"%>
	</div>
</div>

<div id="main" class="container">
 	<div class="wow fadeInDown top__element" data-wow-delay="1s">
	<div class="sitemap">		
		<h1>Termo de Abertura do Projeto</h1>	
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sess�o</a></li>
		</ul>

		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Termo de Abertura do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto" target="_parent">Cad. Termo Abertura</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarTermoAberturaProjeto" target="_parent">Cons. Termo Abertura</a></li>
					        <li><a href="imprimir_termo_abertura_projeto.jsp" target="_parent">Rel. Termo Abertura</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">4 - integra��o</a>
				<ul>
					<li><a href="">Inicia��o</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Processo de autoriza��o formal do projeto. Termo de notifica��o de conhecimento de projeto para a empresa.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Registro das partes interessadas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Registro das partes interessadas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada" target="_parent">Cad. Registro Parte Interessada</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarRegistroParteInteressada" target="_parent">Cons. Registro Parte Interessada</a></li>
					        <li><a href="imprimir_registro_parte_interessada.jsp" target="_parent">Rel. Registro Parte Interessada</a></li>
					        <li><a href="TkcsapcdController?cmd=editarRegistroParteInteressadaFornecedor" target="_parent">Cad. Registro Parte Interessada Fornecedor</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarRegistroParteInteressadaFornecedor" target="_parent">Cons. Registro Parte Interessada Fornecedor</a></li>
					        <li><a href="imprimir_registro_parte_interessada_fornecedor.jsp" target="_parent">Rel. Registro Parte Interessada Fornecedor</a></li>
							<li><a href="TkcsapcdController?cmd=editarStakeholders" target="_parent">Cad. Stakeholders</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarStakeholders" target="_parent">Cons. Stakeholders</a></li>
					        <li><a href="imprimir_stakeholders.jsp" target="_parent">Rel. Stakeholders</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">I</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Registro das partes interessadas e Estrat�gia para gerenciamento das partes interessadas</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Plano de Gerenciamento do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto" target="_parent">Cad. Plano G. Projeto</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto" target="_parent">Cons. Plano. G. Projeto</a></li>
					        <li><a href="imprimir_plano_gerenciamento_projeto.jsp" target="_parent">Rel. Plano. G. Projeto</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">4 - integra��o</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O plano de projeto guia a execu��o, controle e encerramento do projeto. � complementado por v�rios planos auxiliares.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Declara��o do escopo do projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Declara��o do escopo do projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDeclaracaoescopo" target="_parent">Cad. Declara��o Escopo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarDeclaracaoescopo" target="_parent">Cons. Declara��o Escopo</a></li>
					        <li><a href="imprimir_declaracao_escopo.jsp" target="_parent">Rel. Declara��o Escopo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">5 - escopo</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Determina qual trabalho ser� realizado e quais entregas produzidas.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>

	<div class="sitemap">		
		<h1>Dicion�rio da EAP - Planilha</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Dicion�rio da EAP - Planilha</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDicionarioEAP" target="_parent">Cad. Dic. da EAP - Planilha</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarDicionarioEAP" target="_parent">Cons. Dic. da EAP - Planilha</a></li>
					        <li><a href="imprimir_dicionario_eap.jsp" target="_parent">Rel. Dic. da EAP - Planilha</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">5 - escopo</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Informa��es consolidadas no formato de tabela de cada elemento da EAP de modo a orientar a equipe do projeto (Planilha). Informa��es mais detalhadas devem ser inclu�das no Word abaixo.</a></li>	
					<li><a href="">Detalha cada elemento da EAP de modo a orientar a equipe do projeto. Informa��es mais detalhadas como hist�rico, imagens auxiliares, etc...</a></li>									
				</ul>
			</li>				
		</ul>
	</div>
	
	<!--<div class="sitemap">		
		<h1>Dicion�rio da EAP - Complementar a Planilha</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Dicion�rio da EAP - Complementar a Planilha</a></li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">P</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Detalha cada elemento da EAP de modo a orientar a equipe do projeto. Informa��es mais detalhadas como hist�rico, imagens auxiliares, etc...</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Cronograma do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Cronograma do Projeto</a></li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">P</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Determina as datas de in�cio e t�rmino das atividades do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>-->
	
	<div class="sitemap">		
		<h1>Registro dos riscos e dos problemas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Registro dos riscos e dos problemas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRiscos" target="_parent">Cad. Gerenciamento Riscos</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarRiscos" target="_parent">Cons. Gerenciamento Riscos</a></li>
					        <li><a href="imprimir_riscos.jsp" target="_parent">Rel. Gerenciamento Riscos</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">11 - riscos</a>
				<ul>
					<li><a href="">Planejamento</a></li>		
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Identifica os riscos associados ao projeto e descreve como ser�o tratados. Plano auxiliar do plano de projeto. (Planejamento).</a></li>					
					<li><a href="">Usado tamb�m para descrever problemas / situa��es n�o previstas enfrentados no projeto e como foram solucionadas (Controle).</a></li>
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Registro das solicita��es de mudancas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Registro das solicitacoes de mudancas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca" target="_parent">Cad. Reg. Sol. Mudancas</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarRegistroSolicitacaoMudanca" target="_parent">Cons. Reg. Sol. Mudancas</a></li>
					        <li><a href="imprimir_registro_solicitacao_mudanca.jsp" target="_parent">Rel. Reg. Sol. Mudancas</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">C</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Registra cada mudan�a solicitada e controla seu status.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Status Report</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Status Report</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarStatusReport" target="_parent">Cad. Status Report</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarStatusReport" target="_parent">Cons. Status Report</a></li>
					        <li><a href="imprimir_status_report.jsp" target="_parent">Rel. Status Report</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">C</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Divulga informa��es pertinentes ao projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Ata de Reuni�o</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Ata de Reuni�o</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAtaReuniao" target="_parent">Cad. Ata de Reuni�o</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarAtaReuniao" target="_parent">Cons. Ata de Reuni�o</a></li>
					        <li><a href="imprimir_ata_reuniao.jsp" target="_parent">Rel. Ata de Reuni�o</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">C</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Descreve as decis�es importantes tomadas durante a reuni�o.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Solicitacao de mudanca</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Solicitacao de mudanca</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Cad. Solicita��o Mudan�a</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca" target="_parent">Cons. Solicita��o Mudan�a</a></li>
					        <li><a href="imprimir_solicitacao_mudanca.jsp" target="_parent">Rel. Solicita��o Mudan�a</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">C</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Documentar as mudan�as solicitadas e aprova-las conforme workflow definido no Plano de Gerenciamento do Projeto</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Termo de Aceite da Entrega</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Termo de Aceite da Entrega</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarTermoAceiteEntrega" target="_parent">Cad. Aceite da Entrega</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarTermoAceiteEntrega" target="_parent">Cons. Aceite da Entrega</a></li> 
					        <li><a href="imprimir_termo_aceite_entrega.jsp" target="_parent">Rel. Aceite da Entrega</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">E</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Documento de aceita��o formal de entrega pelo cliente. A entrega pode ser qualquer produto gerado pelo projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Avalia��o do Desempenho da Equipe</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Avalia��o do Desempenho da Equipe</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe" target="_parent">Cad. Aval. Des. Equipe</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarAvaliacaoDesempenhoEquipe" target="_parent">Cons. Aval. Des. Equipe</a></li> 
					        <li><a href="imprimir_avaliacao_desempenho_equipe.jsp" target="_parent">Rel. Aval. Des. Equipe</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">9 - recursos humanos</a>
				<ul>
					<li><a href="">Execu��o</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">A avalia��o da efic�cia de uma equipe pode incluir indicadores como:Melhorias em habilidades que permitam que as pessoas realizem as tarefas com mais efic�cia; Melhorias em compet�ncias que ajudam a equipe a ter melhor desempenho como equipe; Redu��o na taxa de rotatividade do pessoal e Aumento na coes�o da equipe em que os membros da equipe compartilham informa��es e experi�ncias abertamente e se ajudam para melhorar o desempenho geral do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de gerenciamento das comunica��es</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Plano de gerenciamento das comunica��es</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarIssuesLog" target="_parent">Cad. ISSUES LOG</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarIssuesLog" target="_parent">Cons. ISSUES LOG</a></li> 
					        <li><a href="imprimir_issues_log.jsp" target="_parent">Rel. ISSUES LOG</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">13 - partes interessadas</a>
				<ul>
					<li><a href="">Execu��o</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">ISSUES LOG (Registro das quest�es), registra todas as quest�es e problemas ocorridos no projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>	
	
	<div class="sitemap">		
		<h1>Decis�es de Comprar ou Mapa das aquisi��es</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Decis�es de Comprar ou Mapa das aquisi��es</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDecisoesComprar" target="_parent">Cad. Decis�es de Comprar</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarDecisoesComprar" target="_parent">Cons. Decis�es de Comprar</a></li> 
					        <li><a href="imprimir_decisoes-comprar.jsp" target="_parent">Rel. Decis�es de Comprar</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Decis�es de Comprar ou Mapa das aquisi��es. Saiba mais em Decis�es de fazer ou comprar.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Diagn�stico e Plano de A��o</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Diagn�stico e Plano de A��o</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDiagnosticoPlanoAcao" target="_parent">Cad. Diagn�stico e Plano de A��o</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarDiagnosticoPlanoAcao" target="_parent">Cons. Diagn�stico e Plano de A��o</a></li> 
					        <li><a href="imprimir_diagnostico_plano_acao.jsp" target="_parent">Rel. Diagn�stico e Plano de A��o</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Esse documento tem como objetivo apresentar os pontos e problemas levantados, suas principais causas e um plano de a��o para a solu��o dos mesmos.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Lista dos Marcos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Lista dos Marcos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaMarcos" target="_parent">Cad. Lista dos Marcos</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarListaMarcos" target="_parent">Cons. Lista dos Marcos</a></li> 
					        <li><a href="imprimir_lista_marcos.jsp" target="_parent">Rel. Lista dos Marcos</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Um marco no projeto � um momento muito importante, quando se conclu� uma entrega ou fase do seu projeto, e funciona, com sua previs�o, como uma meta para a equipe do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Or�amento do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Or�amento do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarOrcamentoProjeto" target="_parent">Cad. Or�amento do Projeto</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarOrcamentoProjeto" target="_parent">Cons. Or�amento do Projeto</a></li> 
					        <li><a href="imprimir_orcamento_projeto.jsp" target="_parent">Rel. Or�amento do Projeto</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Um marco no projeto � um momento muito importante, quando se conclu� uma entrega ou fase do seu projeto, e funciona, com sua previs�o, como uma meta para a equipe do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Status do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Status do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarStatuss" target="_parent">Cad. Status</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarStatuss" target="_parent">Cons. Status</a></li>
		                    <li><a href="imprimir_statuss.jsp" target="_parent">Rel. Status</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Status do Projeto</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Modifica��o do Escopo do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Modifica��o do Escopo do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarModificacaoEscopo" target="_parent">Cad. Mod Escopo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarModificacaoEscopo" target="_parent">Cons. Mod Escopo</a></li>
					        <li><a href="imprimir_modificacao_escopo.jsp" target="_parent">Rel. Mod Escopo</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Modifica��o do Escopo do Projeto</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Requerimento</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Requerimento</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRequerimento" target="_parent">Cad. Requerimento</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarRequerimento" target="_parent">Cons. Requerimento</a></li>
					        <li><a href="imprimir_requerimento.jsp" target="_parent">Rel. Requerimento</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Requerimento</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Acompanhamento Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Acompanhamento Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAcompanhamentoProjeto" target="_parent">Cad. Acompanhamento Projeto</a></li>
						    <li><a href="TkcsapcdController?cmd=consultarAcompanhamentoProjeto" target="_parent">Cons. Acompanhamento Projeto</a></li>
						    <li><a href="imprimir_acompanhamento_projeto.jsp" target="_parent">Rel. Acompanhamento Projeto</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Acompanhamento Projeto</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Lista de Ocorr�ncia</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Lista de Ocorr�ncia</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaOcorrencia" target="_parent">Cad. Lista Ocorrencia</a></li>
						    <li><a href="TkcsapcdController?cmd=consultarListaOcorrencia" target="_parent">Cons. Lista Ocorrencia</a></li>
						    <li><a href="imprimir_lista_ocorrencia.jsp" target="_parent">Rel. Lista Ocorrencia</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Este documento tem como objetivo listar todos os problemas ou situa��es n�o previstas enfrentados durante o projeto e como foram solucionadas.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
		<div class="sitemap">		
		<h1>Matriz de Responsabilidade</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Matriz de Responsabilidade</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarMatrizResponsabilidade" target="_parent">Cad. Matriz de Responsabilidade</a></li>
						    <li><a href="TkcsapcdController?cmd=consultarMatrizResponsabilidade" target="_parent">Cons. Matriz de Responsabilidade</a></li>
						    <li><a href="imprimir_matriz_responsabilidade.jsp" target="_parent">Rel. Matriz de Responsabilidade</a></li><!-- So falta imprimir -->
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Este documento tem como objetivo aloca a responsabilidade de cada integrante da equipe do projeto (recursos humanos) sobre cada entrega e seus respectivos pacotes de trabalho.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Li��es aprendidas</h1>
		<br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Li��es aprendidas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarLicoesAprendida" target="_parent">Cad. Li��es Aprendidas</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarLicoesAprendida" target="_parent">Cons. Li��es Aprendidas</a></li> 
					        <li><a href="imprimir_licoes_aprendida.jsp" target="_parent">Rel. Li��es Aprendidas</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Pr.</a>
				<ul>
					<li><a href="">E</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Descreve de forma sint�tica os principais problemas enfrentados como foram solucionados de modo a evitar ocorr�ncias em futuros projetos.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Registro das partes interessadas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Registro das partes interessadas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRegistroParteInteressada" target="_parent">Cad. Registro Parte Interessada</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarRegistroParteInteressada" target="_parent">Cons. Registro Parte Interessada</a></li>
					        <li><a href="imprimir_registro_parte_interessada.jsp" target="_parent">Rel. Registro Parte Interessada</a></li>
					        <li><a href="TkcsapcdController?cmd=editarRegistroParteInteressadaFornecedor" target="_parent">Cad. Registro Parte Interessada Fornecedor</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarRegistroParteInteressadaFornecedor" target="_parent">Cons. Registro Parte Interessada Fornecedor</a></li>
					        <li><a href="imprimir_registro_parte_interessada_fornecedor.jsp" target="_parent">Rel. Registro Parte Interessada Fornecedor</a></li>
					        <li><a href="TkcsapcdController?cmd=editarStakeholders" target="_parent">Cad. Stakeholders</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarStakeholders" target="_parent">Cons. Stakeholders</a></li>
					        <li><a href="imprimir_stakeholders.jsp" target="_parent">Rel. Stakeholders</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Registro das partes interessadas e Estrat�gia para gerenciamento das partes interessadas Sa�das do Processo PMBOK 10.1 Identificar as partes interessadas Documento estrat�gico para a gest�o do projeto e deve ser de conhecimento do GP e pessoas de sua confian�a.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">10 - comunica��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Business Case</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Business Case</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarBusinessCase" target="_parent">Cad. Business Case</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarBusinessCase" target="_parent">Cons. Business Case</a></li>
					        <li><a href="imprimir_business_case.jsp" target="_parent">Rel. Business Case</a></li>
						</ul>	
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Business Case: Determina a viabilidade econ�mica do projeto e d� subs�dios para classifica-lo no portf�lio de projetos</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Business Plan ou Plano de neg�cios</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Business Plan ou Plano de neg�cios</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarBusinessPlan" target="_parent">Cad. Business Plan</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarBusinessPlan" target="_parent">Cons. Business Plan</a></li>
					        <li><a href="imprimir_business_plan.jsp" target="_parent">Rel. Business Plan</a></li>
					        <li><a href="TkcsapcdController?cmd=editarBusinessPlanDetalhe" target="_parent">Cad. Business Plan Detalhes</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarBusinessPlanDetalhe" target="_parent">Cons. Business Plan Detalhes</a></li>
					        <li><a href="imprimir_business_plan_detalhe.jsp" target="_parent">Rel. Business Plan Detalhes</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Business Plan ou Plano de neg�cio:Descreve em detalhes toda a estrat�gia para a implanta��o do seu neg�cio dividido nas seguintes se��es:
					Sum�rio Executivo<br>
					An�lise da Situa��o Atual<br>
					An�lise SWOT<br>
					Objetivos Financeiros e de Marketing<br>
					Estrat�gia de Marketing<br>
					Programas de A��o<br>
					Proje��o dos resultados Financeiros

					</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Solicita��o do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Solicita��o do Projeto</a></li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Solicita��o do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarSolicitacaoProjeto" target="_parent">Cad. Solicita��o do Projeto</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoProjeto" target="_parent">Cons. Solicita��o do Projeto</a></li>
					        <li><a href="imprimir_solicitacao_projeto.jsp" target="_parent">Rel. Solicita��o do Projeto</a></li>
						</ul>        
					</li>					
				</ul>
			</li>
			<!-- <li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href=""></a></li>					
				</ul>
			</li> -->				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Solicita��o do Projeto vBSC</h1>
		<br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Solicita��o do Projeto vBSC</a></li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Solicita��o do Projeto vBSC</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarSolicitacaoProjetovBSC" target="_parent">Cad. Solicita��o do Projeto vBSC</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoProjetovBSC" target="_parent">Cons. Solicita��o do Projeto vBSC</a></li>
					        <li><a href="imprimir_solicitacao_projeto_vbsc.jsp" target="_parent">Rel. Solicita��o do Projeto vBSC</a></li>
						</ul>        
					</li>					
				</ul>
			</li>						
		</ul>
	</div><!--Fim Inicia��o -->
	
	<h1>Plano de Gerenciamento do Projeto</h1><!-- Planejamento -->
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Plano de Gerenciamento do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto" target="_parent">Cad. Plano G. Projeto</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto" target="_parent">Cons. Plano. G. Projeto</a></li>
					        <li><a href="imprimir_plano_gerenciamento_projeto.jsp" target="_parent">Rel. Plano. G. Projeto</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">4 - integra��o</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O plano de projeto guia a execu��o, controle e encerramento do projeto. � complementado por v�rios planos auxiliares.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de gerenciamento do escopo</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento do escopo</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo" target="_parent">Cad. P. G. Escopo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarGerenciamentoEscopo" target="_parent">Cons. P. G. Escopo</a></li>
					        <li><a href="imprimir_gerenciamento_escopo.jsp" target="_parent">Rel. P. G. Escopo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Descreve como o escopo do projeto ser� definido, desenvolvido e verificado e como a estrutura anal�tica do projeto ser� criada e definida, fornecendo orienta��o sobre como o escopo do projeto ser� gerenciado e controlado pela equipe de gerenciamento de projetos. Ele faz parte ou � um plano auxiliar do plano de gerenciamento do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">5 - escopo</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Matriz de rastreabilidade dos requisitos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Matriz de rastreabilidade dos requisitos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito" target="_parent">Cad. Matriz Rastreabilidade Requisito</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarMatrizRastreabilidadeRequisito" target="_parent">Cons. Matriz Rastreabilidade Requisito</a></li>
					        <li><a href="imprimir_matriz_rastreabilidade_requisito.jsp" target="_parent">Rel. Matriz Rastreabilidade Requisito</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Liga os requisitos �s suas origens e os rastreia durante todo o ciclo de vida do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">5 - Gerenciamento do escopo do projeto</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Declara��o do escopo do projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Declara��o do escopo do projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDeclaracaoescopo" target="_parent">Cad. Declara��o Escopo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarDeclaracaoescopo" target="_parent">Cons. Declara��o Escopo</a></li>
					        <li><a href="imprimir_declaracao_escopo.jsp" target="_parent">Rel. Declara��o Escopo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">5 - escopo</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Determina qual trabalho ser� realizado e quais entregas produzidas.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Estrutura anal�tica do projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">EAP</a>
						<ul>
							<li><a href="cadastro_organograma.jsp" target="_parent">Cad. EAP</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarOrganograma" target="_parent">Cons. EAP</a></li>
					        <!-- <li><a href="imprimir_organograma.jsp" target="_parent">Rel. EAP</a></li>-->
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">5. Gerenciamento do escopo do projeto</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Define as entregas do projeto e sua decomposi��o em pacotes de trabalho.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Plano de gerenciamento do cronograma</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento do cronograma</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma" target="_parent">Cad. Plano G. Cronograma</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoCronograma" target="_parent">Cons. Plano. G. Cronograma</a></li>
					        <li><a href="imprimir_plano_gerenciamento_cronograma.jsp" target="_parent">Rel. Plano. G. Cronograma</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Descreve como o cronograma do projeto ser� desenvolvido, gerenciado e controlado pela equipe de gerenciamento de projetos. Ele faz parte ou � um plano auxiliar do plano de gerenciamento do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">6 - tempo</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Lista das atividades</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Lista das atividades</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaAtividade" target="_parent">Cad. Lista das atividades</a></li>
							<li><a href="TkcsapcdController?cmd=consultarListaAtividade" target="_parent">Cons. Lista das atividades</a></li>
					        <li><a href="imprimir_lista_atividade.jsp" target="_parent">Rel. Lista das atividades</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">A lista das atividades cont�m todas as atividades do projeto. � criada no processo Definir as atividades, dividindo-se o pacote de trabalho da EAP em componentes menores, que s�o as atividades necess�rias para executar o pacote de trabalho.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">6. Gerenciamento do tempo do projeto</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Lista dos Marcos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Lista dos Marcos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaMarcos" target="_parent">Cad. Lista dos Marcos</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarListaMarcos" target="_parent">Cons. Lista dos Marcos</a></li> 
					        <li><a href="imprimir_lista_marcos.jsp" target="_parent">Rel. Lista dos Marcos</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Um marco no projeto � um momento muito importante, quando se conclu� uma entrega ou fase do seu projeto, e funciona, com sua previs�o, como uma meta para a equipe do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<!-- Aqui entrar o Cronograma do Projeto.mpp -->
	
	<div class="sitemap">		
		<h1>Dicion�rio da EAP - Planilha</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Dicion�rio da EAP - Planilha</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDicionarioEAP" target="_parent">Cad. Dic. da EAP - Planilha</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarDicionarioEAP" target="_parent">Cons. Dic. da EAP - Planilha</a></li>
					        <li><a href="imprimir_dicionario_eap.jsp" target="_parent">Rel. Dic. da EAP - Planilha</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">5 - escopo</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Informa��es consolidadas no formato de tabela de cada elemento da EAP de modo a orientar a equipe do projeto (Planilha). Informa��es mais detalhadas devem ser inclu�das no Word abaixo.</a></li>	
					<li><a href="">Detalha cada elemento da EAP de modo a orientar a equipe do projeto. Informa��es mais detalhadas como hist�rico, imagens auxiliares, etc...</a></li>									
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Plano de gerenciamento dos custos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento dos custos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto" target="_parent">Cad. P. G. Custos</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoCusto" target="_parent">Cons. P. G. Custos</a></li>
					        <li><a href="imprimir_plano_gerenciamento_custo.jsp" target="_parent">Rel. P. G. Custos</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Descreve como os custos do projeto ser�o estimados, gerenciados e controlados pela equipe de gerenciamento de projetos. Ele faz parte ou � um plano auxiliar do plano de gerenciamento do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">7 - custo</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Or�amento do Projeto</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Or�amento do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarOrcamentoProjeto" target="_parent">Cad. Or�amento do Projeto</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarOrcamentoProjeto" target="_parent">Cons. Or�amento do Projeto</a></li> 
					        <li><a href="imprimir_orcamento_projeto.jsp" target="_parent">Rel. Or�amento do Projeto</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Um marco no projeto � um momento muito importante, quando se conclu� uma entrega ou fase do seu projeto, e funciona, com sua previs�o, como uma meta para a equipe do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>	
	
	<!-- aqui pode ser executado Previsoes do Orcamento.xlsx -->
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento da Qualidade</h1>		
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento da qualidade</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade" target="_parent">Cad. Plano G. Qualidade</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoQualidade" target="_parent">Cons. Plano. G. Qualidade</a></li>
					        <li><a href="imprimir_plano_gerenciamento_qualidade.jsp" target="_parent">Rel. Plano. G. Qualidade</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Plano de gerenciamento da qualidade</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">8 - qualidade</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento dos recursos humanos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento dos recursos humanos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH" target="_parent">Cad. P. G. RH</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRH" target="_parent">Cons. P. G. RH</a></li>
					        <li><a href="imprimir_plano_gerenciamento_rh.jsp" target="_parent">Rel. P. G. RH</a></li>					        
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O Plano de recursos humanos, tamb�m chamado de plano de gerenciamento dos recursos humanos, fornece orienta��o sobre como os recursos humanos do projeto devem ser definidos, mobilizados, gerenciados, controlados e, por fim, liberados. </a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">9 - recursos humanos</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Recursos Humanos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Recursos Humanos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRecursosHumanos" target="_parent">Cad. Recursos Humanos</a></li>
						    <li><a href="TkcsapcdController?cmd=consultarRecursosHumanos" target="_parent">Cons. Recursos Humanos</a></li>
						    <li><a href="imprimir_recursoshumanos.jsp" target="_parent">Rel. Recursos Humanos</a></li>					        
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Recursos Humanos </a></li>					
				</ul>
			</li>			
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento das Comunica��es</h1>		
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento das Comunica��es</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao" target="_parent">Cad. Plano G. Comunica��o</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao" target="_parent">Cons. Plano. G. Comunica��o</a></li>
					        <li><a href="imprimir_plano_gerenciamento_comunicacao.jsp" target="_parent">Rel. Plano. G. Comunica��o</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O Plano de Gerenciamento das Comunica��es � um componente do plano de gerenciamento do projeto baseado nas necessidades de comunica��o do projeto.
									Deve ser de f�cil entendimento e pode incluir, entre outros:<br>
									-Requisitos de comunica��o dos stakeholders<br>
									-Relat�rio/Informa��o (formato, conte�do, n�vel de detalhe, modelo)<br>
									-Prop�sito<br>
									-Respons�vel<br>
									-Destinat�rios<br>
									-Meios de comunica��o ou tecnologia<br>
									-Frequ�ncia<br>
									-Crit�rio para escala��o<br>
									-M�todo para atualiza��o do plano<br>
									-Gloss�rio do projeto<br>
									-Modelos e diretrizes para reuni�es, e-mail, etc.
					   </a>
					</li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">10 - comunica��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>	
		
	<div class="sitemap">		
		<h1>Plano de Gerenciamento dos riscos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento dos riscos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco" target="_parent">Cad. P. G. Risco</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRisco" target="_parent">Cons. P. G. Risco</a></li>
					        <li><a href="imprimir_plano_gerenciamento_risco.jsp" target="_parent">Rel. P. G. Risco</a></li>
					        
					        <li><a href="TkcsapcdController?cmd=editarRegistroRisco" target="_parent">Cad. Registro dos Risco</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarRegistroRisco" target="_parent">Cons. Registro dos Risco</a></li>
					        <li><a href="imprimir_registro_risco.jsp" target="_parent">Rel. Registro dos Risco</a></li>
					        
					        <li><a href="TkcsapcdController?cmd=editarRegistroRiscoAcoes" target="_parent">Cad. Registro dos Risco A��es</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarRegistroRiscoAcoes" target="_parent">Cons. Registro dos Risco A��es</a></li>
					        <li><a href="imprimir_registro_risco_acoes.jsp" target="_parent">Rel. Registro dos Risco A��es</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O Plano de Gerenciamento dos riscos tem como objetivo aumentar a probabilidade e o impacto dos eventos positivos, reduzir a probabilidade e o impacto dos eventos negativos no projeto e orientar a equipe do projeto sobre como os processos de riscos ser�o executados.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">11 - riscos</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento das Aquisi��es</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento das Aquisi��es</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao" target="_parent">Cad. Plano G. Aquisi��es</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoAquisicao" target="_parent">Cons. Plano. G. Aquisi��es</a></li>
						    <li><a href="imprimir_plano_gerenciamento_aquisicao.jsp" target="_parent">Rel. Plano. G. Aquisi��es</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O Plano de Gerenciamento das Aquisi��es tem como objetivo descrever como os processos de aquisi��o ser�o gerenciados desde o desenvolvimento dos documentos de aquisi��es at� o fechamento do contrato.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">12 - aquisi��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
		
	<div class="sitemap">		
		<h1>Plano de gerenciamento das partes interessadas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento das partes interessadas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada" target="_parent">Cad. Plano G. Partes Interessadas</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoParteInteressada" target="_parent">Cons. Plano. G. Partes Interessadas</a></li>
					        <li><a href="imprimir_plano_gerenciamento_parte_interessada.jsp" target="_parent">Rel. Plano. G. Partes Interessadas</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Plano de gerenciamento das partes interessadas. Sa�da do Processo 13.2 Planejar o gerenciamento das partes interessadas.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">13 - partes interessadas</a></li>					
				</ul>
			</li>				
		</ul>
	</div>	
	
	<!-- <div class="sitemap">		
		<h1>Plano de gerenciamento do escopo</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento do projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo" target="_parent">Cad. P. G. Escopo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarGerenciamentoEscopo" target="_parent">Cons. P. G. Escopo</a></li>
					        <li><a href="imprimir_gerenciamento_escopo.jsp" target="_parent">Rel. P. G. Escopo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Plano de gerenciamento do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>-->
	
	<div class="sitemap">		
		<h1>M�trica</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">M�trica</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarMetricas" target="_parent">Cad. M�trica</a></li>
						    <li><a href="TkcsapcdController?cmd=consultarMetricas" target="_parent">Cons. M�trica</a></li>
						    <li><a href="imprimir_metrica.jsp" target="_parent">Rel. M�trica</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">M�trica</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Aloca��o</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Aloca��o</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAlocacao" target="_parent">Cad. Aloca��o</a></li>
						    <li><a href="TkcsapcdController?cmd=consultarAlocacao" target="_parent">Cons. Aloca��o</a></li>
						    <li><a href="imprimir_alocacao.jsp" target="_parent">Rel. Aloca��o</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Aloca��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento do Pessoal</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento do Pessoal</a>
						<ul>					        
					        <li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoPessoal" target="_parent">Cad. P. G. Pessoal</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoPessoal" target="_parent">Cons. P. G. Pessoal</a></li>
					        <li><a href="imprimir_plano_gerenciamento_pessoal.jsp" target="_parent">Rel. P. G. Pessoal</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O plano de gerenciamento de pessoal, um subconjunto do plano de gerenciamento do projeto, descreve quando e como ser�o atendidos os requisitos de recursos humanos.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de gerenciamento dos requisitos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de gerenciamento dos requisitos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito" target="_parent">Cad. P. G. Requisito</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRequisito" target="_parent">Cons. P. G. Requisito</a></li>
					        <li><a href="imprimir_plano_gerenciamento_requisito.jsp" target="_parent">Rel. P. G. Requisito</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O plano de gerenciamento dos requisitos � desenvolvido e aprovado durante a fase de planejamento do projeto e � um plano auxiliar do Plano de Gerenciamento de Projetos. Tem como objetivo documentar como os requisitos ser�o analisados, documentados e gerenciados do in�cio ao fim do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">5 - escopo</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Plano de melhorias de processo</h1>
		<br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de melhorias de processo</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoMelhoriaProcesso" target="_parent">Cad. P. M. Processo</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPlanoMelhoriaProcesso" target="_parent">Cons. P. M. Processo</a></li>
					        <li><a href="imprimir_plano_melhoria_processo.jsp" target="_parent">Rel. P. M. Processo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O plano de melhorias no processo � um plano auxiliar do plano de gerenciamento do projeto. O plano de melhorias no processo detalha as etapas de an�lise de processos para identificar as atividades que aumentam o seu valor. Sa�da 4 do Processo 8.1 Planejar a Qualidade.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">5 - escopo</a></li>					
				</ul>
			</li>				
		</ul><!-- Fim Planejamento -->
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<div class="sitemap"><!-- Execu��o -->		
		<h1>Solicita��o de Mudan�a</h1>		
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Solicita��o de Mudan�a</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Cad. Solicita��o Mudan�a</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca" target="_parent">Cons. Solicita��o Mudan�a</a></li>
					        <li><a href="imprimir_solicitacao_mudanca.jsp" target="_parent">Rel. Solicita��o Mudan�a</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Documentar as mudan�as solicitadas e aprova-las conforme workflow definido no Plano de Gerenciamento do Projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Li��es aprendidas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Li��es aprendidas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarLicoesAprendida" target="_parent">Cad. Li��es Aprendidas</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarLicoesAprendida" target="_parent">Cons. Li��es Aprendidas</a></li> 
					        <li><a href="imprimir_licoes_aprendida.jsp" target="_parent">Rel. Li��es Aprendidas</a></li> 
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Descreve de forma sint�tica os principais problemas enfrentados como foram solucionados de modo a evitar ocorr�ncias em futuros projetos.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Avalia��o do Desempenho da Equipe</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Avalia��o do Desempenho da Equipe</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe" target="_parent">Cad. Aval. Des. Equipe</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarAvaliacaoDesempenhoEquipe" target="_parent">Cons. Aval. Des. Equipe</a></li> 
					        <li><a href="imprimir_avaliacao_desempenho_equipe.jsp" target="_parent">Rel. Aval. Des. Equipe</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">9 - recursos humanos</a>
				<ul>
					<li><a href="">Execu��o</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">A avalia��o da efic�cia de uma equipe pode incluir indicadores como:Melhorias em habilidades que permitam que as pessoas realizem as tarefas com mais efic�cia; Melhorias em compet�ncias que ajudam a equipe a ter melhor desempenho como equipe; Redu��o na taxa de rotatividade do pessoal e Aumento na coes�o da equipe em que os membros da equipe compartilham informa��es e experi�ncias abertamente e se ajudam para melhorar o desempenho geral do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<!-- Analisar processo 12 e 13 -->
	
	<div class="sitemap">		
		<h1>Plano de Gerenciamento das Comunica��es</h1>		
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Plano de Gerenciamento das Comunica��es</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao" target="_parent">Cad. Plano G. Comunica��o</a></li>
							<li><a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao" target="_parent">Cons. Plano. G. Comunica��o</a></li>
					        <li><a href="imprimir_plano_gerenciamento_comunicacao.jsp" target="_parent">Rel. Plano. G. Comunica��o</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O Plano de Gerenciamento das Comunica��es � um componente do plano de gerenciamento do projeto baseado nas necessidades de comunica��o do projeto.
									Deve ser de f�cil entendimento e pode incluir, entre outros:<br>
									-Requisitos de comunica��o dos stakeholders<br>
									-Relat�rio/Informa��o (formato, conte�do, n�vel de detalhe, modelo)<br>
									-Prop�sito<br>
									-Respons�vel<br>
									-Destinat�rios<br>
									-Meios de comunica��o ou tecnologia<br>
									-Frequ�ncia<br>
									-Crit�rio para escala��o<br>
									-M�todo para atualiza��o do plano<br>
									-Gloss�rio do projeto<br>
									-Modelos e diretrizes para reuni�es, e-mail, etc.
					   </a>
					</li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">10 - comunica��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Adjudica��o do contrato de aquisi��o</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Adjudica��o do contrato de aquisi��o</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarModeloContrato" target="_parent">Cad. Adj. Contrato Aquisi��o</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarModeloContrato" target="_parent">Cons. Adj. Contrato Aquisi��o</a></li>
					        <li><a href="imprimir_modelo_contrato.jsp" target="_parent">Rel. Adj. Contrato Aquisi��o</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">acordo legal que gera obriga��es entre as partes e que obriga o fornecedor a oferecer os produtos, servi�os ou resultados especificados e obriga o comprador a remunerar o fornecedor. O contrato � uma rela��o legal sujeita a a��es corretivas nos tribunais.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Issues Log - Registro das Quest�es</h1>		
		<br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Issues Log - Registro das Quest�es</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarIssuesLog" target="_parent">Cad. Issues Log (Registro das Quest�es)</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarIssuesLog" target="_parent">Cons. Issues Log (Registro das Quest�es)</a></li> 
					        <li><a href="imprimir_issues_log.jsp" target="_parent">Rel. Issues Log (Registro das Quest�es)</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Issues Log - Registro das Quest�es</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">13 - partes interessadas</a></li>					
				</ul>
			</li>				
		</ul>
	</div><!-- Fim Execu��o -->
	
	<div class="sitemap">
	<h1>Ata de Reuni�o</h1>
	<br><br><br>
	<ul id="primaryNav" class="col4"><!-- Monitoramento e Controle -->
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Ata de Reuni�o</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAtaReuniao" target="_parent">Cad. Ata de Reuni�o</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarAtaReuniao" target="_parent">Cons. Ata de Reuni�o</a></li>
					        <li><a href="imprimir_ata_reuniao.jsp" target="_parent">Rel. Ata de Reuni�o</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Ata de Reuni�o</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">10 - comunica��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>CheckList ou Lista de Verifica��o de Qualidade </h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">CheckList ou Lista de Verifica��o de Qualidade </a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaQualidade" target="_parent">Cad. Lista Verifica��o Qualidade</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarListaQualidade" target="_parent">Cons. Lista Verifica��o Qualidade</a></li> 
					        <li><a href="imprimir_lista_qualidade.jsp" target="_parent">Rel. Lista Verifica��o Qualidade</a></li>
						</ul>        
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">CheckList ou Lista de Verifica��o de Qualidade para os processos de planejamento da Metodologia da Escrit�rio de Projetos</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">8 - qualidade</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Pauta de Reuni�o</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Pauta de Reuni�o</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarPautaReuniao" target="_parent">Cad. Pauta de Reuni�o</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarPautaReuniao" target="_parent">Cons. Pauta de Reuni�o</a></li>
					        <li><a href="imprimir_pauta_reuniao.jsp" target="_parent">Rel. Pauta de Reuni�o</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Convoca os participantes deixando claro objetivo da reuni�o e t�picos a serem discutidos</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">10 - comunica��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Registro das solicita��es de mudancas</h1>		
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Registro das solicita��es de mudancas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca" target="_parent">Cad. Reg. Sol. Mudancas</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarRegistroSolicitacaoMudanca" target="_parent">Cons. Reg. Sol. Mudancas</a></li>
					        <li><a href="imprimir_registro_solicitacao_mudanca.jsp" target="_parent">Rel. Reg. Sol. Mudancas</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O Plano de Gerenciamento das Comunica��es � um componente do plano de gerenciamento do projeto baseado nas necessidades de comunica��o do projeto.
									Para usar no Processo do PMBOK 4.5.3-Realizar o controle integrado de mudan�as
									Tamb�m conhecido como Log de Mudan�as
									Sa�da: Atualiza��es do andamento das solicita��es de mudan�a
					   </a>
					</li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Solicita��o de mudan�a</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Solicita��o de mudan�a</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Cad. Solicita��o Mudan�a</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarSolicitacaoMudanca" target="_parent">Cons. Solicita��o Mudan�a</a></li>
					        <li><a href="imprimir_solicitacao_mudanca.jsp" target="_parent">Rel. Solicita��o Mudan�a</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Solicita��o de mudan�a: Documentar as mudan�as solicitadas e aprova-las conforme workflow definido no Plano de Gerenciamento do Projeto</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>	
	<!-- Fim Monitoramento e Controle -->
	
	<div class="sitemap">		
		<h1>Aceite da Entrega</h1>
		<br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Aceite da Entrega</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarProjetoTermoEncerramento" target="_parent">Cad. Termo Encerramento</a></li>					                      
					        <li><a href="TkcsapcdController?cmd=consultarProjetoTermoEncerramento" target="_parent">Cons. Termo Encerramento</a></li>
					        <li><a href="imprimir_termoencerramentoprojeto.jsp" target="_parent">Rel. Termo Encerramento</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Formaliza��o ou Aceite da Entrega do Projeto. Pode ser usada tanto para entregas parciais ou a entrega final do projeto.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Li��es Aprendidas</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Li��es Aprendidas</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarLicoesAprendida" target="_parent">Cad. Li��es Aprendidas</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarLicoesAprendida" target="_parent">Cons. Li��es Aprendidas</a></li> 
					        <li><a href="imprimir_licoes_aprendida.jsp" target="_parent">Rel. Li��es Aprendidas</a></li> 					       
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Li��es Aprendidas</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Relat�rio de encerramento do contrato</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Relat�rio de encerramento do contrato</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRelatorioEncerramentoContrato" target="_parent">Cad. Rel. Enc. Contrato</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarRelatorioEncerramentoContrato" target="_parent">Cons. Rel. Enc. Contrato</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Relat�rio de encerramento do contrato</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Transi��o do Produto</h1>		
		<br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Transi��o do Produto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarTransicaoProduto" target="_parent">Cad. Transi��o do Produto</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarTransicaoProduto" target="_parent">Cons. Transi��o do Produto</a></li> 
					        <li><a href="imprimir_transicao_produto.jsp" target="_parent">Rel. Transi��o do Produto</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Transi��o do Produto</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">4 - integra��o</a></li>					
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
	<%@include file="configuracao_wow.jsp" %>
	<script src="js/modal_dialog.js"></script>
	<%@include file="gif_load_page.jsp" %> 
</body>	
</html>
