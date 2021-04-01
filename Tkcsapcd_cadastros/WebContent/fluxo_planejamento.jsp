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

<title>Planejamento</title>

<%@include file="css_js_configuracao.jsp" %><!-- Configuracao da formatacao da pagina, configurando modal dialog -->

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<div id="main">
	<div class="wow slideInLeft" data-wow-duration="1s">
		<%@include file="indice_paleativo.jsp"%>
	</div>
</div>

<div id="main">
 	<div class="wow fadeInDown top__element" data-wow-delay="1s">
 	
	<div class="sitemap">		
		<h1>Crit�rios para Sele��o de Fontes</h1>
		<h2>Sispromaper &mdash; Version 1.0</h2>	
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sess�o</a></li>
		</ul>
		
		
		<!-- Planejamento -->
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Crit�rios para Sele��o de Fontes</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarCriterioPreQualificacao" target="_parent">Cad. Sele��o Fonte (Pr�-qualifica��o)</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarCriterioPreQualificacao" target="_parent">Cons. Sele��o Fonte (Pr�-qualifica��o)</a></li>
					        <li><a href="imprimir_criterio_pre_qualificacao.jsp" target="_parent">Rel. Sele��o Fonte (Pr�-qualifica��o)</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Planilha com Crit�rios para Sele��o de Fontes. Para medir, comparar  e/ou pontuar as propostas dos fornecedores. Possuem crit�rios Eliminat�rios e Classificat�rios</a></li>					
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
		<h1>Declara��o de trabalho ou Statement of Work (SOW)</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Declara��o de trabalho ou Statement of Work (SOW)</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDeclaracaoTrabalho" target="_parent">Cad. Declara��o Trabalho</a></li>
							<li><a href="TkcsapcdController?cmd=consultarDeclaracaoTrabalho" target="_parent">Cons. Declara��o Trabalho</a></li>
							<li><a href="imprimir_declaracao_trabalho.jsp" target="_parent">Rel. Declara��o Trabalho</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Declara��o de trabalho ou Statement of Work (SOW). Descri��o de um produto ou servi�o para ser adquirido sob um contrato; Declara��o de requisitos. Desenvolvida a partir da linha de base do escopo. Deve fornecer informa��o suficiente para o vendedor criar e precificar uma proposta aderente a necessidade do projeto.</a></li>					
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
		<h1>Declara��o do escopo do Projeto</h1>		
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Declara��o do escopo do Projeto</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDeclaracaoescopo" target="_parent">Cad. Declara��o Escopo</a></li>
							<li><a href="TkcsapcdController?cmd=consultarDeclaracaoescopo" target="_parent">Cons. Declara��o Escopo</a></li>
							<li><a href="imprimir_declaracao_escopo.jsp" target="_parent">Rel. Declara��o Escopo</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Declara��o do escopo do Projeto: Descreve detalhadamente as entregas do projeto e o trabalho necess�rio para criar as mesmas.
								   Fornece tamb�m um entendimento comum do escopo do projeto entre as partes interessadas. Pode conter exclus�es expl�citas do escopo que podem auxiliar o gerenciamento das expectativas das partes interessadas. Possibilita que a equipe desempenhe um planejamento mais detalhado, direciona o trabalho da mesma durante a execu��o e fornece a linha de base para avaliar se as solicita��es de mudan�a ou trabalho adicional est�o contidos no escopo ou s�o externos aos limites do projeto. [PMBOK Quinta Edi��o-5.3.3.1]
					   </a>
					</li>					
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
		<h1>Dicionario da EAP</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Dicionario da EAP</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarDicionarioEAP" target="_parent">Cad. Dic. da EAP - Planilha</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarDicionarioEAP" target="_parent">Cons. Dic. da EAP - Planilha</a></li>
					        <li><a href="imprimir_dicionario_eap.jsp" target="_parent">Rel. Dic. da EAP - Planilha</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">O dicion�rio da EAP serve como parte de um sistema de autoriza��o de trabalho descrevendo para os integrantes da equipe cada componente da estrutura anal�tica do projeto (EAP). Voc� pode us�-lo para controlar quando um trabalho espec�fico � realizado, para evitar aumento do escopo e aumentar a compreens�o das partes interessadas sobre o esfor�o necess�rio para cada pacote de trabalho. O dicion�rio da EAP, essencialmente, define limites do que � inclu�do no pacote de trabalho. Sa�da do processo 5.4 Criar a EAP do PMBOK Quinta Edi��o.</a></li>					
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
		<h1>Matriz das Comunicacoes versao 5W2H</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Matriz das Comunicacoes versao 5W2H</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarMatrizComunicacao" target="_parent">Cad. Matriz Comunica��es</a></li>
					        <li><a href="TkcsapcdController?cmd=consultarMatrizComunicacao" target="_parent">Cons. Matriz Comunica��es</a></li>
					        <!-- <li><a href="imprimir_matriz_comunicacao.jsp" target="_parent">Rel. Matriz Comunica��es</a></li> -->
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Matriz das comunica��es usando como base ferramenta de qualidade 5W2H.
					What? Qual informa��o
					Why? Qual prop�sito
					Who? Quem � o respons�vel
					Who? Quem precisa da informa��o
					When? Quando e Qual periodicidade
					Where? Onde ocorrer�o ou ser�o armazenadas
					How? Template, Procedimento, Best Practice
					</a></li>					
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
		<h1>RFP - Request for Proposal / Solicita��o de Proposta</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">RFP - Request for Proposal / Solicita��o de Proposta</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=consultarRfpProjeto">Cons. RFP</a></li>
							<li><a href="imprimir_rfpprojeto.jsp">Rel. RFP</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">RFP - Request for Proposal / Solicita��o de Proposta
								Solicita��o de Proposta T�cnica/Comercial
								Escopo deve estar claro, bem definido e mensur�vel
								Exige proposta mais elaborada e crit�rios mais complexos
								Necess�rio adapt�-la para sua necessidade
					</a></li>					
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
		<h1>RFI</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">RFI</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarRfiProjeto" target="_parent">Cad. RFI</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarRfiProjeto" target="_parent">Cons. RFI</a></li> 
						        <li><a href="imprimir_rfiprojeto.jsp" target="_parent">Rel. RFI</a></li>
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">RFI</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Matriz de Rastreabilidade dos Requisitos</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Matriz de Rastreabilidade dos Requisitos</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito" target="_parent">Cad. Matriz Rastre. Requisitos</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarMatrizRastreabilidadeRequisito" target="_parent">Cons. Matriz Rastre. Requisitos</a></li> 
					        <li><a href="imprimir_matriz_rastreabilidade_requisito.jsp" target="_parent">Rel. Matriz Rastre. Requisitos</a></li> 
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
					<li><a href="">A matriz de rastreabilidade dos requisitos liga os requisitos �s suas origens e os rastreia durante todo o ciclo de vida do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Lista das Atividades</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Lista das Atividades</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarListaAtividade" target="_parent">Cad. Lista das Atividades</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarListaAtividade" target="_parent">Cons. Lista das Atividades</a></li> 
					        <li><a href="imprimir_lista_atividade.jsp" target="_parent">Rel. Lista das Atividades</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">6 - tempo</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">A lista das atividades cont�m todas as atividades do projeto.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Atributo das Atividades</h1>
		<br><br><br><br>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Documento</a>
				<ul>
					<li><a href="">Lista das Atividades</a>
						<ul>
							<li><a href="TkcsapcdController?cmd=editarAtributoAtividade" target="_parent">Cad. Atributo das Atividades</a></li> 
					        <li><a href="TkcsapcdController?cmd=consultarAtributoAtividade" target="_parent">Cons. Atributo das Atividades</a></li> 
					        <li><a href="imprimir_atributo_atividade.jsp" target="_parent">Rel. Atributo das Atividades</a></li> 
						</ul>
					</li>
				</ul>
			</li>			
			<li><a href="">6 - tempo</a>
				<ul>
					<li><a href="">Planejamento</a></li>					
				</ul>
			</li>
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Os atributos das atividades descrevem as particularidades de cada atividade.</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<div class="sitemap">		
		<h1>Pedido de Cota��o / Request for Quotation-RFQ</h1>
		<ul id="utilityNav">
			<li><a href="index_principal.jsp">Home Page</a></li>
			<li><a href="sair.jsp">Encerrar Sess�o</a></li>
			<li><a href="#" id="subir">Topo</a></li>
		</ul>
		<ul id="primaryNav" class="col4">
			<li id="home"><a href="">Processo</a></li>
			<li><a href="">Nome do Arquivo</a>
				<ul>
					<li><a href="">Pedido de Cota��o / Request for Quotation-RFQ</a>
						<!-- <ul>
							<li><a href="cadastro_rfq.jsp" target="_parent">Cad. RFQ</a></li>
							<li><a href="imprimir_rfq.jsp" target="_parent">Rel. RFQ</a></li>
						</ul> -->	
					</li>
				</ul>
			</li>			
			<li><a href="">Descri��o</a>
				<ul>
					<li><a href="">Pedido de Cota��o / Request for Quotation-RFQ: Usado para fazer cota��o dos itens de aquisi��o quando discuss�es entre os concorrentes n�o s�o necess�rias e o pre�o � o fator principal na negocia��o.</a></li>					
				</ul>
			</li>
			<li><a href="">�rea de Conhecimento</a>
				<ul>
					<li><a href="">12 - aquisi��es</a></li>					
				</ul>
			</li>				
		</ul>
	</div>
	
	<!-- Fim Planejamento -->
</div>
</div>
	<%@include file="configuracao_wow.jsp" %>
	<script src="js/modal_dialog.js"></script>
	</body>	
</html>
