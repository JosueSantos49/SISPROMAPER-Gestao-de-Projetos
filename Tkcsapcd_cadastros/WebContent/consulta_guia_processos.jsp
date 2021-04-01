<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page import="br.com.tkcsapcd.model.helper.Config"%>
<%@ page import="javax.naming.InitialContext,javax.sql.DataSource"%>
<%@page import="java.io.PrintWriter" import="java.util.*, javax.rmi.*, javax.naming.*, java.io.*, java.lang.*" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />
<jsp:include page="conexao.jsp" />
<jsp:include page="httpservletrequest.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Guia de Processo</title>	

<!-- Bootstrap -->  
<link href="bootstrap/css/bootstrapPagination.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<script type="text/javascript" src="js/confirmaExclusaoAtualizacao.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorioUsuario.js"></script>
<script src="excellentexport-master/excellentexport.js"></script>
<script language="javascript" src="js/funcoes.js"></script>	

<link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css">      
<link rel="stylesheet" type="text/css" href="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.2/css/jquery.dataTables_themeroller.css">      
<script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>      
<script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>      
<script type='text/javascript' src="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.2/jquery.dataTables.min.js"></script>

<script type='text/javascript'>//<![CDATA[ 
window.onload=function(){					
$(function() {
        var testsTable = $('#tabela').dataTable({
                bJQueryUI: true,
                //aaData: data,
                aoColumns: [
                        { mData: 'PROCESSO' },
                        { mData: 'ÁREA' },
                        { mData: 'GRUPO' },
                        { mData: 'DETALHE' }
                ]
        });
});
}//]]>  

</script>

</head>	

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<!-- <center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center>--> 

<br><center><p><h4><font color="red">TABELA GUIA DE PROCESSOS</font></h4></center><br>

<div align="center" class="table-responsive">

	<table  border="1" cellspacing="3" cellpadding="5" width="95%"	bgcolor="#FFFFFF">
		<thead>
			<tr>
				<th>Guia Processo</th>
				<th>Área de Conhecimento</th>
				<th>Grupo de Processo</th>
				<th>Detalhe da saída (link)</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>4.1 Desenvolver o termo de abertura do projeto</td>
				<td>4 - integração</td>
				<td>Iniciação</td>
				<td><a href="TkcsapcdController?cmd=editarTermoAberturaProjeto" target="_parent">Termo de abertura do projeto</a></td>
			</tr>
			<tr>
				<td>4.2 Desenvolver o plano de gerenciamento do projeto</td>
				<td>4 - integração</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto" target="_parent">Plano de gerenciamento do projeto</a></td>
			</tr>
			<tr>
				<td>4.3 Orientar e gerenciar o trabalho do projeto</td>
				<td>4 - integração</td>
				<td>Execução</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>4.4 Monitorar e controlar o trabalho do projeto</td>
				<td>4 - integração</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>4.5 Realizar o controle integrado de mudanças</td>
				<td>4 - integração</td>
				<td>Monitoramento e Controle</td>
				<td><a href="fluxo_metodologiapmo.jsp" target="_parent">Atualizações do andamento das solicitações de mudança</a></td>
			</tr>
			<tr>
				<td>4.6 Encerrar o projeto ou fase</td>
				<td>4 - integração</td>
				<td>Encerramento</td>
				<td><a href="fluxo_encerramento.jsp" target="_parent"> Transição do produto, serviço ou resultado final</a></td>
			</tr>
			<tr>
				<td>5.1 Planejar o gerenciamento do escopo</td>
				<td>5 - escopo</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito" target="_parent">Plano de gerenciamento dos requisitos</a></td>
			</tr>
			<tr>
				<td>5.2 Coletar os requisitos</td>
				<td>5 - escopo</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito" target="_parent">Matriz de rastreabilidade dos requisitos</a></td>
			</tr>
			<tr>
				<td>5.3 Definir o escopo</td>
				<td>5 - escopo</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarDeclaracaoescopo" target="_parent">Declaração do escopo do projeto</a></td>
			</tr>
			<tr>
				<td>5.4 Criar a EAP</td>
				<td>5 - escopo</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarDicionarioEAP" target="_parent">EAP / Dicionário da EAP</a></td>
			</tr>
			<tr>
				<td>5.5 Validar o escopo</td>
				<td>5 - escopo</td>
				<td>Monitoramento e Controle</td>
				<td><a href="metodologiapmo_guia_processo_5_5.jsp" target="_parent">Entregas aceitas / Solicitações de mudança</a></td>
			</tr>
			<tr>
				<td>5.6 Controlar o escopo</td>
				<td>5 - escopo</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>6.1 Planejar o gerenciamento do cronograma</td>
				<td>6 - tempo</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma" target="_parent">Plano de gerenciamento do cronograma</a></td>
			</tr>
			<tr>
				<td>6.2 Definir as atividades</td>
				<td>6 - tempo</td>
				<td>Planejamento</td>
				<td><a href="fluxo_planejamento.jsp" target="_parent">Lista das atividades / Atributos das atividades</a></td>
			</tr>
			<tr>
				<td>6.3 Sequenciar as atividades</td>
				<td>6 - tempo</td>
				<td>Planejamento</td>
				<td><font color="red">Diagramas de rede do cronograma do projeto</font></td>
			</tr>
			<tr>
				<td>6.4 Estimar os recursos da atividade</td>
				<td>6 - tempo</td>
				<td>Planejamento</td>
				<td><a href="fluxo_guia_processo_6_4.jsp" target="_parent">Requisitos de recursos das atividades / Estrutura analítica dos recursos</a></td>
			</tr>
			<tr>
				<td>6.5 Estimar a duração da atividade</td>
				<td>6 - tempo</td>
				<td>Planejamento</td>
				<td><font color="red">Estimativas de duração das atividades</font></td>
			</tr>
			<tr>
				<td>6.6 Desenvolver o cronograma</td>
				<td>6 - tempo</td>
				<td>Planejamento</td>
				<td><font color="red">Cronograma do projeto / Linha de base do cronograma / Dados do cronograma</font></td>
			</tr>
			<tr>
				<td>6.7 Controlar o cronograma</td>
				<td>6 - tempo</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>7.1 Planejar o gerenciamento dos custos</td>
				<td>7 - custos</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoCusto" target="_parent">Plano de gerenciamento dos custos</a></td>
			</tr>
			<tr>
				<td>7.2 Estimar os custos</td>
				<td>7 - custos</td>
				<td>Planejamento</td>
				<td><font color="red">Estimativas de custos das atividades / Bases das estimativas</font></td>
			</tr>
			<tr>
				<td>7.3 Determinar o orçamento</td>
				<td>7 - custos</td>
				<td>Planejamento</td>
				<td><font color="red">Linha de base dos custos / Requisitos de recursos financeiros do projeto</font></td>
			</tr>
			<tr>
				<td>7.4 Controlar os custos</td>
				<td>7 - custos</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Previsões do orçamento / Solicitações de mudança</a></td>
			</tr>			
			<tr>
				<td>8.1 Planejar o gerenciamento da qualidade</td>
				<td>8 - qualidade</td>
				<td>Planejamento</td>
				<td><a href="fluxo_planogerprojeto_guia_processo_8_1.jsp" target="_parent">Pla. Ger Qualidade / Métr. qualidade / List. Ver. Qualidade / Pla. Melh. Processo</a></td>
			</tr>
			<tr>
				<td>8.2 Realizar a garantia da qualidade</td>
				<td>8 - qualidade</td>
				<td>Execução</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>8.3 Controlar a qualidade</td>
				<td>8 - qualidade</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarTermoAceiteEntrega" target="_parent">Entregas validadas</a></td>
			</tr>
			<tr>
				<td>9.1 Planejar o gerenciamento dos recursos humanos</td>
				<td>9 - recursos humanos</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRH" target="_parent">Plano de recursos humanos</a></td>
			</tr>
			<tr>
				<td>9.2 Mobilizar a equipe do projeto</td>
				<td>9 - recursos humanos</td>
				<td>Execução</td>
				<td><font color="red">Designações do pessoal do projeto / Calendários dos recursos</font></td>
			</tr>
			<tr>
				<td>9.3 Desenvolver a equipe do projeto</td>
				<td>9 - recursos humanos</td>
				<td>Execução</td>
				<td><a href="TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe" target="_parent">Avaliações do desempenho da equipe</a></td>
			</tr>
			<tr>
				<td>9.4 Gerenciar a equipe do projeto</td>
				<td>9 - recursos humanos</td>
				<td>Execução</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>10.1 Planejar o gerenciamento das comunicações</td>
				<td>10 - comunicações</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao" target="_parent">Plano de gerenciamento das comunicações</a></td>
			</tr>
			<tr>
				<td>10.2 Gerenciar as comunicações</td>
				<td>10 - comunicações</td>
				<td>Execução</td>
				<td>-</td>
			</tr>
			<tr>
				<td>10.3 Controlar as comunicações</td>
				<td>10 - comunicações</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>11.1 Planejar o gerenciamento dos riscos</td>
				<td>11 - riscos</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoRisco" target="_parent">Plano de gerenciamento dos riscos</a></td>
			</tr>
			<tr>
				<td>11.2 Identificar os riscos</td>
				<td>11 - riscos</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarRegistroRisco" target="_parent">Registro dos riscos</a></td>
			</tr>
			<tr>
				<td>11.3 Realizar a análise qualitativa dos riscos</td>
				<td>11 - riscos</td>
				<td>Planejamento</td>
				<td><a href="fluxo_planogerprojeto.jsp" target="_parent"> Atualizações do Registro dos riscos</a></td>
			</tr>
			<tr>
				<td>11.4 Realizar a análise quantitativa dos riscos</td>
				<td>11 - riscos</td>
				<td>Planejamento</td>
				<td><a href="fluxo_planogerprojeto.jsp" target="_parent"> Atualizações do Registro dos riscos</a></td>
			</tr>
			<tr>
				<td>11.5 Planejar as respostas aos riscos</td>
				<td>11 - riscos</td>
				<td>Planejamento</td>
				<td><a href="fluxo_planogerprojeto.jsp" target="_parent"> Atualizações do Registro dos riscos</a></td>
			</tr>
			<tr>
				<td>11.6 Controlar os riscos</td>
				<td>11 - riscos</td>
				<td>Monitoramento e Controle</td>
				<td><a href="fluxo_planogerprojeto.jsp" target="_parent"> Atualizações do Registro dos riscos</a></td>
			</tr>
			<tr>
				<td>12.1 Planejar o gerenciamento das aquisições</td>
				<td>12 - aquisições</td>
				<td>Planejamento</td>
				<td><a href="fluxo_planejamento_guia_processo_12_1.jsp" target="_parent">Plano Gere Aquisições / Decl. Trab. Aquisições / Dec. Comprar / Doc Aquisição / Cri. Sel. Fonte</a></td>
			</tr>
			<tr>
				<td>12.2 Conduzir as aquisições</td>
				<td>12 - aquisições</td>
				<td>Execução</td>
				<td><a href="TkcsapcdController?cmd=editarModeloContrato" target="_parent">Adjudicação do contrato de aquisição</a></td>
			</tr>
			<tr>
				<td>12.3 Controlar as aquisições</td>
				<td>12 - aquisições</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
			<tr>
				<td>12.4 Encerrar as aquisições</td>
				<td>12 - aquisições</td>
				<td>Encerramento</td>
				<td><font color="red">Aquisições encerradas</font></td>
			</tr>
			<tr>
				<td>13.1 Identificar as partes interessadas</td>
				<td>13 - partes interessadas</td>
				<td>Iniciação</td>
				<td><a href="TkcsapcdController?cmd=editarStakeholders" target="_parent">Registro das partes interessadas</a></td>
			</tr>
			<tr>
				<td>13.2 Planejar o gerenciamento das partes interessadas</td>
				<td>13 - partes interessadas</td>
				<td>Planejamento</td>
				<td><a href="TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada" target="_parent">Plano de gerenciamento das partes interessadas</a></td>
			</tr>
			<tr>
				<td>13.3 Gerenciar o engajamento das partes interessadas</td>
				<td>13 - partes interessadas</td>
				<td>Execução</td>
				<td><a href="TkcsapcdController?cmd=editarIssuesLog" target="_parent">Registro das questões</a></td>
			</tr>
			<tr>
				<td>13.4 Controlar o engajamento das partes interessadas</td>
				<td>13 - partes interessadas</td>
				<td>Monitoramento e Controle</td>
				<td><a href="TkcsapcdController?cmd=editarSolicitacaoMudanca" target="_parent">Solicitação de mudança</a></td>
			</tr>
		</tbody>
	</table>	       

</div>
<br><br>
<%@include file="rodape.jsp" %>
</body>	
</html>