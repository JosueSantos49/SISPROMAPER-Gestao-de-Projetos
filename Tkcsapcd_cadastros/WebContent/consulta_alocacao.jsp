<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List, br.com.tkcsapcd.model.bean.Alocacao"%>
<%@page import="br.com.tkcsapcd.model.bean.Alocacao"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>
<%@page import="br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>
<%@page import="java.util.List, br.com.tkcsapcd.model.bean.RecursosHumanos"%>
<%@page import="br.com.tkcsapcd.model.bean.RecursosHumanos"%>

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>	

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->	

<title>Consultar Alocação</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<!-- <link rel="stylesheet" href="css/menuperante.css" type="text/css"> -->
<script type="text/javascript" src="js/ajax.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/validaPesquisarRelatorioAlocacao.js"></script>
<script language="javascript" src="js/funcoes.js"></script>
<script>$(document).ready(function() {    $('#tabela').dataTable();} );</script>

<script type="text/javascript">	$(document).ready(function(){	$("#consProjeto1").mask("99/99/9999"); 	});</script>

<script src="excellentexport-master/excellentexport.js"></script>
<style>   table, tr, td {   border: 0px black solid;  }	</style>	

</head>

<body bgcolor="#ededed" onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<div id="preloader"><h1><img src="img/ajax-loaderazul.gif" height="30px"></h1></div>

<div id="conteudo">

	<%@include file="menuperantecssadm.jsp" %>
		
			<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center> 
					
				<br><center><p><font color="red">Consultar Alocação</font></p></center><br>	
				
					<div align="left">
					
						<form id="formConsAlocacao" name="formConsAlocacao" method="post" action="pesquisar_alocacao.jsp" onSubmit="validaPesquisarRelatorioAlocacao()">
							
							<strong>Relatório..:</strong>
							<input name="consAlocacao" type="text" id="consAlocacao" title="Digite o código do projeto para pesquisar" required="true" Placeholder="Recursos humanos">
							<input class="button" name="pesqAlocacao" type="submit" id="pesqAlocacao" value="Exibir"  title="Digite o código do projeto para pesquisar" onclick="validaPesquisarRelatorioAlocacao();">
												
						</form>				
					</div>
					<br>

        <a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>
        <a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
        <br/>
        	<div class="table-responsive">
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
					  <tr>
					  	<th>Código Projeto</th>
					    <th>Recursos Humanos</th>
						<th>Profissão</th>
						<th>Período Inicial</th>
						<th>Período Final</th>
						<th>Apr</th>
						<th>May</th>
						<th>Jun</th>
						<th>Jul</th>
						<th>Aug</th>
						<th>Sep</th>
						<th>Oct</th>
						<th>Nov</th>
						<th>Dec</th>
						<th>Jan</th>
						<th>Feb</th>
						<th>Mar</th>
						<th>Apr</th>
						<th>May</th>
						<th>Jun</th>
						<th>Jul</th>					
						<th>Editar</th>
						<th>Excluir</th>																			
					  </tr>
					</thead>			
				<tbody>  
				  	<%						
						List<Alocacao> alocacaos = (List<Alocacao>) request.getAttribute("alocacaos");
						for(Alocacao alocacao: alocacaos){
					%>
				  <tr>
					<td><%=alocacao.getProjeto_codigo() %></td><!-- tabela projeto alocacao.getProjeto_codigo()-->
					<td><%=alocacao.getRecursoshumanos_codigo() %></td><!-- tabela recursoshumanos alocacao.getRecursoshumanos_codigo()-->
					<td><%=alocacao.getProfissao_codigo() %>
				    <td><%=alocacao.getData() %></td>
				    <td><%=alocacao.getData0() %></td>
				    <td><%=alocacao.getMetrica1() %></td>
				    <td><%=alocacao.getMetrica2() %></td>
				    <td><%=alocacao.getMetrica3() %></td>
				    <td><%=alocacao.getMetrica4() %></td>
				    <td><%=alocacao.getMetrica5() %></td>
				    <td><%=alocacao.getMetrica6() %></td>
				    <td><%=alocacao.getMetrica7() %></td>
				    <td><%=alocacao.getMetrica8() %></td>
				    <td><%=alocacao.getMetrica9() %></td>
				    <td><%=alocacao.getMetrica10() %></td>
				    <td><%=alocacao.getMetrica11() %></td>
				    <td><%=alocacao.getMetrica12() %></td>
				    <td><%=alocacao.getMetrica13() %></td>
				    <td><%=alocacao.getMetrica14() %></td>
				    <td><%=alocacao.getMetrica15() %></td>
				    <td><%=alocacao.getMetrica16() %></td>										
					<td><a 	class="link_atualizar" href='TkcsapcdController?cmd=editarAlocacao&codigo=<%=alocacao.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td ><a class="link_delete" href='TkcsapcdController?cmd=excluirAlocacao&codigo=<%=alocacao.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
				  </tr>
				  <%			
				 	}
				 %>
				</tbody>
			</table>
		</td>
</div>	

<%@include file="rodape.jsp" %>				
</body>
</html>