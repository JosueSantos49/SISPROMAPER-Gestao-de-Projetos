<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.RecursosHumanos"%>
<%@page import="br.com.tkcsapcd.model.bean.RecursosHumanos"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>		

<title>Consultar Recursos Humanos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css"></link> 
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


<script type="text/javascript" src="js/validaPesquisarRelatorioRecursosHumanos.js"></script>
<script language="javascript" src="js/funcoes.js"></script>

<script type='text/javascript'>//<![CDATA[ 
window.onload=function(){

/*
var data = [
    ["UpdateBootProfile","PASS","00:00:00",[]] ,
    ["NRB Boot","PASS","00:00:50.5000000",[{"TestName":"TOTAL_TURN_ON_TIME","Result":"PASS","Value":"50.5","LowerLimit":"NaN","UpperLimit":"NaN","ComparisonType":"nctLOG","Units":"SECONDS"}]] ,
    ["NvMgrCommit","PASS","00:00:00",[]] ,
    ["SyncNvToEFS","PASS","00:00:01.2500000",[]]
];*/

$(function() {
        var testsTable = $('#tabela').dataTable({
                bJQueryUI: true,
                aaData: data,
                aoColumns: [
                        { mData: '8-ID' },
                        { mData: 'Nome' },
                        { mData: 'Profissão' },
                        { mData: 'Área' },
                        { mData: 'Status' },
                        { mData: 'Editar' },
                        { mData: 'Excluir' }
                ]
        });
});

}//]]>  

</script>

<style type="text/css">
	/*.ui-progressbar-value {background-image:url(img/ajax-loader.gif);}*/
</style>

<script type="text/javascript">
	$(document).ready(function(){			
		$("#consProjeto1").mask("99/99/9999");  
	});
</script>
<script src="excellentexport-master/excellentexport.js"></script>
<style>table, tr, td { border: 0px black solid;  } </style>	
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();"> 

<div id="preloader"><h1><img src="img/ajax-loaderazul.gif" height="30px"></h1></div>

<div id="conteudo">

	<%@include file="menuperantecssadm.jsp" %>
		
			<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center> 		
				<br><center><p><font color="red">Consultar Recursos Humanos</font></p></center><br>	
					<div align="left">
						<form id="formConsRH" name="formConsRH" method="post" action="pesquisar_recursoshumanos.jsp" onSubmit="validaPesquisarRelatorioRecursosHumanos()">
							
							<strong>Relatório..:</strong>
							<input name="consRH" type="text" id="consRH" title="Digite o código para exibir" required="true" Placeholder="ID Recurso Humano">
							<input class="button" name="pesqRH" type="submit" id="pesqRH" value="Exibir"  title="Digite o código para exibir" onclick="validaPesquisarRelatorioRecursosHumanos();">
												
						</form>				
					</div>
					<br>
		<br/>
       <a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>
       <a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
       <br/>
       <div class="table-responsive"> 
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
					  <tr>
					    <th>ID</th>
					    <th>Nome</th>
						<th>Profissão</th>
						<th>Área</th>					
						<th>Status</th>
						<th>Editar</th>
						<th>Excluir</th> 																		
					  </tr>
					</thead>			
				<tbody>
					<%							
						List<RecursosHumanos> recursosHumanoss = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
						for(RecursosHumanos recursosHumanos: recursosHumanoss){
					%>  
				  <tr>
					<td><%=recursosHumanos.getIdRecursosHumanos() %></td>
				    <td><%=recursosHumanos.getNome() %></td>
					<td><%=recursosHumanos.getProfissao() %></td>
					<td><%=recursosHumanos.getArea() %></td>				
					<td><%=recursosHumanos.getStatus() %></td>
											
					<td><a 	class="link_atualizar" href='TkcsapcdController?cmd=editarRecursosHumanos&codigo=<%=recursosHumanos.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td ><a class="link_delete" href='TkcsapcdController?cmd=excluirRecursosHumanos&codigo=<%=recursosHumanos.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
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