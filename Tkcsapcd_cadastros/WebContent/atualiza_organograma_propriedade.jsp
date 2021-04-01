<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.OrganogramaPropriedade"%>
<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<title>Atualizar Organograma Propriedade</title>
<meta name="description" content="" />
<!-- Copyright 1998-2015 by Northwoods Software Corporation. -->
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script language="javascript" src="js/funcoes.js"></script>
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

<%@include file="configuracao_js_organograma_propriedade.jsp" %>

</head>

<body onload="init()">

<%@include file="menuperanteorganograma.jsp" %>

<br>

<form class="rounded" name="formulario" id="formulario" action="TkcsapcdController">

	<input type="hidden" name="cmd" value="atualizarOrganogramaPropriedade"></input>
	<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação, codigo usado para modificar o registro -->

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
		    Código Projeto: <input id="codigoprojeto" name="codigoprojeto" value="${organogramaPropriedade.codigoprojeto }" required="true" onkeypress="return numbers(event);" style="width: 379px" class="form-control"><br>
		    Data: 			<input id="data" name="data" value="${organogramaPropriedade.data }" style="width: 379px" class="form-control"><br>	   
			Descrição: 		<input id="descricao" name="descricao" value="${organogramaPropriedade.descricao }" style="width: 379px" maxlength="300" style="width: 379px" class="form-control"><br>
			E-mail:			<input type="text"  name="para" style="width: 379px" autocomplete="off" placeholder="E-mail" class="form-control">		    
		    <br>Comentário: <br><textarea id="comentario" name="comentario" rows="10" cols="80" maxlength="5000" class="form-control">${organogramaPropriedade.comentario }</textarea><br><br>
		    
		    <a href="#" id="mostrar">Exibir conteúdo</a>
		    <a href="#" id="ocultar">Ocultar conteúdo</a>
		    <br>
			    <div id="conteudo">
				    <textarea name="mySavedModel" id="mySavedModel" style="width:100%;height:250px">${organogramaPropriedade.mySavedModel }</textarea>
		    	</div>	  
	
			<br>
			<input class="btn btn-info" type="submit" name="gravar" id="gravar" value="Atualizar" onclick=""></input>
		</div>
	</div>

</form>
<br>
</body>
</html>
