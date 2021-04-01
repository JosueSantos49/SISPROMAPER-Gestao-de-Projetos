<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Metricas"%>
<%@page import="br.com.tkcsapcd.model.bean.Metricas"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>		

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Métrica</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css"></link>
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/validaPesquisarRelatorioMetrica.js"></script>
<script language="javascript" src="js/funcoes.js"></script>

<script>
$(document).ready(function() {
    $('#tabela').dataTable();
} );
</script>

<script type="text/javascript">
	$(document).ready(function(){			
		$("#consProjeto1").mask("99/99/9999");  
	});
</script>

<script src="excellentexport-master/excellentexport.js"></script>
        <style>
            table, tr, td {
                border: 0px black solid;
            }
        </style>	
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();"> 

<div id="preloader"><h1><img src="img/loader.gif" height="70px"></h1></div>

<div id="conteudo">

	<%@include file="menuperantecssadm.jsp" %>

			<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center> 		

				<br><center><p><font color="red">Consultar Métrica</font></p></center><br>	

					<div align="left">

						<form id="formConsMetrica" name="formConsMetrica" method="post" action="pesquisar_metricas.jsp" onSubmit="validaPesquisarRelatorioMetrica()">
							
							<strong>Relatório..:</strong>

							<input name="consMetricas" type="text" id="consMetricas" title="Digite o ID da Métrica para pesquisar" required="true" Placeholder="ID Métrica">

							<input class="button" name="pesqMetricas" type="submit" id="pesqMetricas" value="Exibir"  title="Digite o ID da Métrica para pesquisar" onclick="validaPesquisarRelatorioMetrica();">
												
						</form>				
					</div>
					<br>
		<br/>

        <a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>        
        <a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to CSV" height="20" width="27" src="img/csv.jpg"></a>
        <br/>
        <div class="table-responsive">
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
					  <tr>
					  	<th>ID</th>
					    <th>Nome Métrica</th>
						<th>Indice da Métrica</th>
						<th>Valor Referência - Hora</th>					
						<th>Valor Hora Calculada - Dia</th>
						<th>Editar</th>
						<th>Excluir</th>																			
					  </tr>
					</thead>			
				<tbody>
					<%							
						List<Metricas> metricass = (List<Metricas>) request.getAttribute("metricass");
						for(Metricas metricas: metricass){
					%>  
				  <tr>				  	
				    <td><%=metricas.getIdMetricas() %></td>
				    <td><%=metricas.getNomeMetrica() %></td>
					<td><%=metricas.getIndiceMetrica() %></td>
					<td><%=metricas.getValorReferenciaHora() %></td>				
					<td><%=metricas.getValorHoraCalculadaDia() %></td>										
					<td><a 	class="link_atualizar" href='TkcsapcdController?cmd=editarMetricas&codigo=<%=metricas.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td ><a class="link_delete" href='TkcsapcdController?cmd=excluirMetricas&codigo=<%=metricas.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
				  </tr>
				  <%			
				 	}
				 %>
				</tbody>
			</table>
		</div>	
	</div>	
	<%@include file="rodape.jsp" %>			
</body>
</html>