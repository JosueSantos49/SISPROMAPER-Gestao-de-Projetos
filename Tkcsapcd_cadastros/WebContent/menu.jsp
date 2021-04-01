<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
</head>
<body>
<div class="container">			
			<div class="span9">
				<section id=btn-dropdown>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">HOME <span class="caret"></span></button>																							
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">USUÁRIO <span class="caret"></span></button>
							<ul class="dropdown-menu">
					        	<li><a href="cadastro_usuarios.jsp" target="_parent">Cad. Usuário</a></li>
					        	<li><a href="consulta_usuarios.jsp" target="_parent">Cons. Usuário</a></li>
					        	<li><a href="imprimir_usuarios.jsp" target="_parent">Rel. Usuário</a></li>
					        	<li class="divider"></li>
					        	<li><a href="consulta_solicitacaocadastro.jsp" target="_parent">Cons. Solicitação Acesso</a></li>
					        	<li><a href="imprimir_solicitacaocadastro.jsp" target="_parent">Rel. Solicitação Acesso</a></li>
					        	<li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarCliente" target="_parent">Cad. Cliente</a></li>					                      
					            <li><a href="TkcsapcdController?cmd=consultarCliente" target="_parent">Cons. Cliente</a></li>
					            <li><a href="imprimir_cliente.jsp" target="_parent">Rel. Cliente</a></li> 		                                       
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">TERMO PROJETO <span class="caret"></span></button>
						 	<ul class="dropdown-menu">
   								<li><a href="TkcsapcdController?cmd=editarProjeto" target="_parent">Cad. Termo Abertura</a></li>					                      
					            <li><a href="TkcsapcdController?cmd=consultarProjeto" target="_parent">Cons. Termo Abertura</a></li>
					            <li><a href="imprimir_projeto.jsp" target="_parent">Rel. Termo Abertura</a></li>
					            <li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=detalhareditarProjeto" target="_parent">Cad. Detalhes Termo Abertura</a></li>
					            <li><a href="TkcsapcdController?cmd=detalharconsultarProjeto" target="_parent">Cons. Detalhes Termo Abertura</a></li>
					            <li><a href="imprimir_detalharprojeto.jsp" target="_parent">Rel. Detalhes Termo Abertura</a></li>
					            <li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarProjetoTermoEncerramento" target="_parent">Cad. Termo Encerramento</a></li>					                      
					            <li><a href="TkcsapcdController?cmd=consultarProjetoTermoEncerramento" target="_parent">Cons. Termo Encerramento</a></li>
			                    <li><a href="imprimir_termoencerramentoprojeto.jsp" target="_parent">Rel. Termo Encerramento</a></li>					                                          
			                </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">STATUS / STAKEHOLDERS <span class="caret"></span></button>
							<ul class="dropdown-menu">
   								<li><a href="TkcsapcdController?cmd=editarStatuss" target="_parent">Cad. Status</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarStatuss" target="_parent">Cons. Status</a></li>
		                        <li><a href="imprimir_statuss.jsp" target="_parent">Rel. Status</a></li> 
		                        <li class="divider"></li>
   			                    <li><a href="TkcsapcdController?cmd=editarStakeholders" target="_parent">Cad. Stakeholders</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarStakeholders" target="_parent">Cons. Stakeholders</a></li>
		                        <li><a href="imprimir_stakeholders.jsp" target="_parent">Rel. Stakeholders</a></li>
		                        <li class="divider"></li>
    		                    <li><a href="TkcsapcdController?cmd=editarRiscos" target="_parent">Cad. Gerenciamento Riscos</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarRiscos" target="_parent">Cons. Gerenciamento Riscos</a></li>
					            <li><a href="imprimir_riscos.jsp" target="_parent">Rel. Gerenciamento Riscos</a></li>                    
					        </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">ESCOPO <span class="caret"></span></button>
							<ul class="dropdown-menu">
   								<li><a href="TkcsapcdController?cmd=editarDeclaracaoescopo" target="_parent">Cad. Declaração Escopo</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarDeclaracaoescopo" target="_parent">Cons. Declaração Escopo</a></li>
					            <li><a href="imprimir_declaracao_escopo.jsp" target="_parent">Rel. Declaração Escopo</a></li> 
					            <li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarGerenciamentoEscopo" target="_parent">Cad. P. G. Escopo</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarGerenciamentoEscopo" target="_parent">Cons. P. G. Escopo</a></li>
					            <li><a href="imprimir_gerenciamento_escopo.jsp" target="_parent">Rel. P. G. Escopo</a></li>
					            <li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarModificacaoEscopo" target="_parent">Cad. Mod Escopo</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarModificacaoEscopo" target="_parent">Cons. Mod Escopo</a></li>
					            <li><a href="imprimir_modificacao_escopo.jsp" target="_parent">Rel. Mod Escopo</a></li>  
					            <li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarLicoesAprendida" target="_parent">Cad. Lições Aprendidas</a></li> 
					            <li><a href="TkcsapcdController?cmd=consultarLicoesAprendida" target="_parent">Cons. Lições Aprendidas</a></li> 
					            <li><a href="imprimir_licoes_aprendida.jsp" target="_parent">Rel. Lições Aprendidas</a></li>              
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">REQUERIMENTO <span class="caret"></span></button>
							<ul class="dropdown-menu">
					        	<li><a href="TkcsapcdController?cmd=editarRequerimento" target="_parent">Cad. Requerimento</a></li>
					            <li><a href="TkcsapcdController?cmd=consultarRequerimento" target="_parent">Cons. Requerimento</a></li>
					            <li><a href="imprimir_requerimento.jsp" target="_parent">Rel. Requerimento</a></li>
					            <li class="divider"></li>
					            <li><a href="TkcsapcdController?cmd=editarRfpRequerimento" target="_parent">Cad. RFP Requerimento</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarRfpRequerimento" target="_parent">Cons. RFP Requerimento</a></li>
						   	    <li><a href="imprimir_rfprequerimento.jsp" target="_parent">Rel. RFP Requerimento</a></li>                   
					       </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">RFP-RFI/ANÁLISE <span class="caret"></span></button>
							<ul class="dropdown-menu">
						        <li><a href="TkcsapcdController?cmd=editarRfpProjeto" target="_parent">Cad. RFP</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarRfpProjeto" target="_parent">Cons. RFP</a></li>
						        <li><a href="imprimir_rfpprojeto.jsp" target="_parent">Rel. RFP</a></li>
						        <li class="divider"></li>
						        <li><a href="TkcsapcdController?cmd=editarRfiProjeto" target="_parent">Cad. RFI</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarRfiProjeto" target="_parent">Cons. RFI</a></li> 
						        <li><a href="imprimir_rfiprojeto.jsp" target="_parent">Rel. RFI</a></li>
						        <li class="divider"></li>
						        <li><a href="TkcsapcdController?cmd=editarAnalise" target="_parent">Cad. Análise</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarAnalise" target="_parent">Cons. Análise</a></li>
						     	<li><a href="imprimir_analise.jsp" target="_parent">Rel. Análise</a></li>                    
						     </ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">ALOCAÇÃO <span class="caret"></span></button>
							<ul class="dropdown-menu">
						    	<li><a href="TkcsapcdController?cmd=editarRecursosHumanos" target="_parent">Cad. Recursos Humanos</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarRecursosHumanos" target="_parent">Cons. Recursos Humanos</a></li>
						        <li><a href="imprimir_recursoshumanos.jsp" target="_parent">Rel. Recursos Humanos</a></li>
						        <li class="divider"></li>
						        <li><a href="TkcsapcdController?cmd=editarMetricas" target="_parent">Cad. Métrica</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarMetricas" target="_parent">Cons. Métrica</a></li>
						        <li><a href="imprimir_metrica.jsp" target="_parent">Rel. Métrica</a></li>
						        <li class="divider"></li>
						        <li><a href="TkcsapcdController?cmd=editarAlocacao" target="_parent">Cad. Alocação</a></li>
						        <li><a href="TkcsapcdController?cmd=consultarAlocacao" target="_parent">Cons. Alocação</a></li>
						        <li><a href="imprimir_alocacao.jsp" target="_parent">Rel. Alocação</a></li>                   
						    </ul>
					</div>
				</section>	
			</div>

			
			
		</div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>