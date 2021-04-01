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
<title>Cadastrar Organograma</title>

<meta name="description" content="" />
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script src="orgcharteditor/js/go.js"></script>
<link href="orgcharteditor/css/goSamples.css" rel="stylesheet" type="text/css"/>  <!-- you don't need to use this -->
<script src="orgcharteditor/js/goSamples.js"></script>  <!-- this is only for the GoJS Samples framework -->
<script src="orgcharteditor/js/FreehandDrawingTool.js"></script>
<script src="orgcharteditor/js/GeometryReshapingTool.js"></script>
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
      $(go.Diagram, "myDiagramDiv");

    myDiagram.toolManager.mouseDownTools.insertAt(3, new GeometryReshapingTool());

    myDiagram.nodeTemplate =
      $(go.Part,
        { locationSpot: go.Spot.Center },
        new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
        {
          selectionAdorned: true, selectionObjectName: "SHAPE",
          selectionAdornmentTemplate:  // custom selection adornment: a blue rectangle
            $(go.Adornment, "Auto",
              $(go.Shape, { stroke: "dodgerblue", fill: null }),
              $(go.Placeholder, { margin: -1 }))
        },
        { resizable: true, resizeObjectName: "SHAPE" },
        { rotatable: true, rotateObjectName: "SHAPE" },
        { reshapable: true },  // GeometryReshapingTool assumes nonexistent Part.reshapeObjectName would be "SHAPE"
        $(go.Shape,
          { name: "SHAPE", fill: null, strokeWidth: 1.5 },
          new go.Binding("desiredSize", "size", go.Size.parse).makeTwoWay(go.Size.stringify),
          new go.Binding("angle").makeTwoWay(),
          new go.Binding("geometryString", "geo").makeTwoWay(),
          new go.Binding("fill"),
          new go.Binding("stroke"),
          new go.Binding("strokeWidth")));

    // create drawing tool for myDiagram, defined in FreehandDrawingTool.js
    var tool = new FreehandDrawingTool();
    // provide the default JavaScript object for a new polygon in the model
    tool.archetypePartData =
      { stroke: "green", strokeWidth: 3 };
    // install as first mouse-down-tool
    myDiagram.toolManager.mouseDownTools.insertAt(0, tool);

    load();  // load a simple diagram from the textarea
  }

  function mode(draw) {
    // assume FreehandDrawingTool is the first tool in the mouse-down-tools list
    var tool = myDiagram.toolManager.mouseDownTools.elt(0);
    tool.isEnabled = draw;
  }

  function updateAllAdornments() {  // called after checkboxes change Diagram.allow...
    myDiagram.selection.each(function(p) { p.updateAdornments(); });
  }

  // save a model to and load a model from Json text, displayed below the Diagram
  function save() {
    var str = '{ "position": "' + go.Point.stringify(myDiagram.position) + '",\n  "model": ' + myDiagram.model.toJson() + ' }';
    document.getElementById("mySavedDiagram").value = str;
  }
  function load() {
    var str = document.getElementById("mySavedDiagram").value;
    try {
      var json = JSON.parse(str);
      myDiagram.initialPosition = go.Point.parse(json.position || "0 0");
      myDiagram.model = go.Model.fromJson(json.model);
      myDiagram.model.undoManager.isEnabled = true;
    } catch (ex) {
      alert(ex);
    }
  }
  </script>


</head>

<body onload="init()">

<%@include file="menuperanteorganograma.jsp" %>

<br>
	
	<div id="sample">	 
	 <div id="myDiagramDiv" style="border: solid 1px black; width: 100%; height: 600px"></div>
	  	  
	  <div class="container">
	  
	  	  <div id="buttons">
		    <button onclick="mode(false)">Selecionar</button>
		    <button onclick="mode(true)">Editar</button>
		    <!--<button onclick="save()">Salvar</button>
		    <button onclick="load()">carregar</button>-->
	  	</div>	
	  	    
	    <a href="#" id="mostrar">Exibir conteúdo</a>
	    <a href="#" id="ocultar">Ocultar conteúdo</a>
	    
			    <div id="conteudo">
			    
			    <textarea name="mySavedDiagram" id="mySavedDiagram" style="width:100%;height:200px" required="true" class="form-control">	    
				    { "position": "0 0",
					  "model": { "class": "go.GraphLinksModel",
					  "nodeDataArray": [  ],
					  "linkDataArray": [  ]
					} }
		
			    </textarea>	    
			    </div>	
			</div>
		</div>
	<br>
</body>
</html>
