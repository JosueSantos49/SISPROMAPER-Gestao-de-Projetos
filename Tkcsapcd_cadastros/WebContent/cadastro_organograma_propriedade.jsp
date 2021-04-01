<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.email.EnviaEmail"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.OrganogramaPropriedade"%>

<!DOCTYPE html>
<%@include file="httpservletrequest.jsp"%>
<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<title>Cadastrar Organograma Propriedade</title>
<meta name="description" content="An organization chart editor -- edit details and change relationships." />
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script src="orgcharteditor/js/go.js"></script>
<link href="orgcharteditor/css/goSamples.css" rel="stylesheet" type="text/css"/>  <!-- you don't need to use this -->
<script src="orgcharteditor/js/goSamples.js"></script>  <!-- this is only for the GoJS Samples framework -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$('#conteudo').hide();
	
	$('#mostrar').click(function(event){
		event.preventDefault();	
		$("#conteudo").show("slow");
	});
	
	$('#ocultar').click(function(event){
		event.preventDefault();	
		$("#conteudo").hide("slow");
	});
});
</script>

<!-- Calendário -->
<script>
	$(function() {
		$("#data").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#data").mask("99/99/9999"); //dataProjeto  
	});
</script>

<%@include file="configuracao_js_organograma_propriedade.jsp" %>

</head>

<body onload="init()">

<%@include file="menuperanteorganograma.jsp" %>

<br>

<div align="center"><h5><font color="grenn"> ${mensagem}</font></h5></div>
					
	<form action="TkcsapcdController" name="formulario" id="formulario">
	
		<input type="hidden" name="cmd" value="cadastrarOrganogramaPropriedade"></input>
		
		<div id="sample">
		
		  <div id="myPaletteDiv" style="border: solid 1px gray; width:100%; height:100px"></div>
		  <div id="myDiagramDiv" style="border: solid 1px gray; width:100%; height:400px;"></div>
		
		  <div class="container">	
		  
			  <br>
			  <div>
				  <button id="SaveButton" onclick="save()" class="btn btn-success">Escrever</button>
				  <button onclick="load()" class="btn btn-success">Ler</button>    
			  </div>
			  <br>  
		   		Código Projeto:
			    				<select id="codigoprojeto"	name="codigoprojeto" style="width: 379px" class="form-control" required="true">
										<option id="codigoprojeto"></option>
										<%
											ProjetoInicioDAO projetoInicio = new ProjetoInicioDAO();
											List <ProjetoInicio> resultado = projetoInicio.getProjetoInicios();
											for(ProjetoInicio pi: resultado){
										%>
										<option value=<%= pi.getCodigoprojeto() %>><%= pi.getCodigoprojeto() %></option>			
										<%} %>
								</select>
				<br>
				Data: 			<input id="data" name="data" value="00/00/0000" style="width: 379px" class="form-control"><br>	   
				Descrição: 		<input id="descricao" name="descricao" style="width: 379px" maxlength="300" class="form-control"><br>
				E-mail:			<input type="text"  name="para" style="width: 379px" autocomplete="off" placeholder="E-mail" class="form-control">	    
			    <br>Comentário: <br><textarea id="comentario" name="comentario" rows="10" cols="80" maxlength="5000" class="form-control"></textarea><br><br>
			    <a href="#" id="mostrar">Exibir conteúdo</a>
			    <a href="#" id="ocultar">Ocultar conteúdo</a>
			    <div id="conteudo">
			    
			  <textarea id="mySavedModel" name="mySavedModel" style="width:100%;height:300px">
				{ "class": "go.GraphLinksModel",
				  "nodeDataArray": [
					{"key":"Prop. 1", "text":"Prop. 1", "isGroup":true, "color":"0", "loc":"0 23.52284749830794", "size":"108 200"},
					{"key":"Prop. 2", "text":"Prop. 2", "isGroup":true, "color":"1", "loc":"109 23.52284749830794", "size":"124.60618337477278 200"},
					{"key":"Prop. 3", "text":"Prop. 3", "isGroup":true, "color":"2", "loc":"235 23.52284749830794", "size":"107 200"},
					{"key":"Prop. 4", "text":"Prop. 4", "isGroup":true, "color":"3", "loc":"343 23.52284749830794", "size":"107 200"},
					{"key":"Prop. 5", "text":"Prop. 5", "isGroup":true, "color":"4", "loc":"451 23.52284749830794", "size":"109.22284444655013 200"},
					{"key":"Prop. 6", "text":"Prop. 6", "isGroup":true, "color":"5", "loc":"562 23.52284749830794", "size":"108 200"},
					{"key":"Prop. 7", "text":"Prop. 7", "isGroup":true, "color":"6", "loc":"671 23.52284749830794", "size":"108 200"},
					{"key":"Prop. 8", "text":"Prop. 8", "isGroup":true, "color":"7", "loc":"671 23.52284749830794", "size":"108 200"}
				],
				  "linkDataArray": []
				}
			  </textarea>
		  </div>
	
	<br>
	
		<div class="btn-group">
			<input class="btn btn-info" type="submit" name="gravar" id="gravar" value="Gravar" onclick=""/>
			<input class="btn btn-info" type="reset" value="Limpar" onclick=""/>
		</div>
	</div><!-- container -->
</div>
</form>
<br>
</body>
</html>
