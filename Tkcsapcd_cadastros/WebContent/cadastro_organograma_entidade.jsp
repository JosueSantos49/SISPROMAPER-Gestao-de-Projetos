<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.email.EnviaEmail"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.PrintWriter"	import="java.sql.*" import="java.sql.*"%>
<%@page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<!DOCTYPE html>
<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<title>Organograma Entidade</title>

<meta name="description" content="" />
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script src="orgcharteditor/js/go.js"></script>
<link href="orgcharteditor/css/goSamples.css" rel="stylesheet" type="text/css"/>  <!-- you don't need to use this -->
<script src="orgcharteditor/js/goSamples.js"></script>  <!-- this is only for the GoJS Samples framework -->
<script src="orgcharteditor/js/PolylineLinkingTool.js"></script>
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

<script id="code">
  function init() {
    if (window.goSamples) goSamples();  // init for these samples -- you don't need to call this
    var $ = go.GraphObject.make;

    myDiagram =
      $(go.Diagram, "myDiagramDiv",
        { initialContentAlignment: go.Spot.Center });

    // install custom linking tool, defined in PolylineLinkingTool.js
    var tool = new PolylineLinkingTool();
    //tool.temporaryLink.routing = go.Link.Orthogonal;  // optional, but need to keep link template in sync, below
    myDiagram.toolManager.linkingTool = tool;

    myDiagram.nodeTemplate =
      $(go.Node, "Spot",
        { locationSpot: go.Spot.Center },
        new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
        $(go.Shape,
          {
            width: 100, height: 100, fill: "lightgray",
            portId: "", cursor: "pointer",
            fromLinkable: true,
            fromLinkableSelfNode: true, fromLinkableDuplicates: true,  // optional
            toLinkable: true,
            toLinkableSelfNode: true, toLinkableDuplicates: true  // optional
          },
          new go.Binding("fill")),
        $(go.Shape, { width: 70, height: 70, fill: "transparent", stroke: null }),
        $(go.TextBlock,
          new go.Binding("text")));

    myDiagram.linkTemplate =
      $(go.Link,
        { reshapable: true, resegmentable: true },
        //{ routing: go.Link.Orthogonal },  // optional, but need to keep LinkingTool.temporaryLink in sync, above
        { adjusting: go.Link.Stretch },  // optional
        new go.Binding("points", "points").makeTwoWay(),
        $(go.Shape, { strokeWidth: 1.5 }),
        $(go.Shape, { toArrow: "OpenTriangle" }));

    load();  // load a simple diagram from the textarea
  }

  // save a model to and load a model from Json text, displayed below the Diagram
  function save() {
    var str = myDiagram.model.toJson();
    document.getElementById("mySavedModel").value = str;
  }
  function load() {
    var str = document.getElementById("mySavedModel").value;
    myDiagram.model = go.Model.fromJson(str);
    myDiagram.model.undoManager.isEnabled = true;
  }
</script>

</head>

<body onload="init()">

<%@include file="menuperanteorganograma.jsp" %>

<br>
	<input type="hidden" name="cmd" value="cadastrarOrganograma"></input>
	
	<div id="sample">	  
	  
	  <div id="myDiagramDiv" style="border: solid 1px black; width: 100%; height: 600px"></div>
	  	  
	  <div class="container">		  
	  	
		    <!-- <div>
		      <button class="btn btn-info" id="SaveButton" onclick="save()">Escrever</button>
		      <button class="btn btn-info" onclick="load()">Ler</button>	      
		    </div> -->
		    
		    <br>	    
		    
			    <a href="#" id="mostrar">Exibir conteúdo</a>
			    <a href="#" id="ocultar">Ocultar conteúdo</a>
			    
			    <div id="conteudo">		    
				    <textarea name="mySavedModel" id="mySavedModel" style="width:100%;height:250px" required="true" class="form-control">	    
					    { "class": "go.GraphLinksModel",
						  "nodeDataArray": [
						    { "key": 1, "text": "Node 1", "fill": "blueviolet", "loc": "100 100" },
						    { "key": 2, "text": "Node 2", "fill": "orange", "loc": "400 100" }
						  ],
						  "linkDataArray": [  ]
						}
				    </textarea>	
		    	</div>
	
			</div>
		</div>
	<br>
</body>
</html>
