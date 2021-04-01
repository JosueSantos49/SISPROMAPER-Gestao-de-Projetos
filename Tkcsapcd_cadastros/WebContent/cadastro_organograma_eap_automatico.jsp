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
<%@include file="httpservletrequest.jsp"%>
<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<title>Organograma EAP Automático</title>
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

<script id="code">
    function init() {
      if (window.goSamples) goSamples();  // init for these samples -- you don't need to call this
      var $ = go.GraphObject.make;  // for conciseness in defining templates

      myDiagram =
        $(go.Diagram, "myDiagramDiv",  // Diagram refers to its DIV HTML element by id
          {
            _widthFactor: 1,        // a scale for the nodes' positions and widths
            isReadOnly: true,       // deny the user permission to alter the diagram or zoom in or out
            allowZoom: false,
            "grid.visible": true,  // display a grid in the background of the diagram
            "grid.gridCellSize": new go.Size(30, 150)
          });

      // create the template for the standard nodes
      myDiagram.nodeTemplateMap.add("",
        $(go.Node, "Auto",
          // links come from the right and go to the left side of the top of the node
          { fromSpot: go.Spot.Right, toSpot: new go.Spot(0.001, 0, 11, 0) },
          $(go.Shape, "Rectangle",
            { height: 15 },
            new go.Binding("fill", "color"),
            new go.Binding("width", "width", function (w) { return scaleWidth(w); })),
          $(go.TextBlock,
            { margin: 2, alignment: go.Spot.Left },
            new go.Binding("text", "key")),
          // using a function in the Binding allows the value to
          // change when Diagram.updateAllTargetBindings is called
          new go.Binding("location", "loc",
                         function (l) { return new go.Point(scaleWidth(l.x), l.y); })
        ));

      // create the template for the start node
      myDiagram.nodeTemplateMap.add("start",
        $(go.Node,
          { fromSpot: go.Spot.Right, toSpot: go.Spot.Top, selectable: false },
          $(go.Shape, "Diamond",
            { height: 15, width: 15 }),
          // make the location of the start node is not scalable
          new go.Binding("location", "loc")
        ));

      // create the template for the end node
      myDiagram.nodeTemplateMap.add("end",
        $(go.Node,
          { fromSpot: go.Spot.Right, toSpot: go.Spot.Top, selectable: false },
          $(go.Shape, "Diamond",
            { height: 15, width: 15 }),
          // make the location of the end node (with location.x < 0) scalable
          new go.Binding("location", "loc",
                         function(l) {
                           if (l.x >= 0) return new go.Point(scaleWidth(l.x), l.y);
                           else return l;
                         })
        ));

      // create the template for the nodes displaying dates
      // no shape, only a TextBlock
      myDiagram.nodeTemplateMap.add("date",
        $(go.Part,
          { selectable: false },
          new go.Binding("location", "loc",
                         function (l) { return new go.Point(scaleWidth(l.x), l.y); }),
          $(go.TextBlock,
            new go.Binding("text", "key"))
        ));

      //create the link template
      myDiagram.linkTemplate =
        $(go.Link,
          {
            routing: go.Link.Orthogonal,
            corner: 3, toShortLength: 2,
            selectable: false
          },
          $(go.Shape,
            { strokeWidth: 2 }),
          $(go.Shape,
            { toArrow: "OpenTriangle" })
        );

      // add aos nós e links para o modelo
      myDiagram.model = new go.GraphLinksModel(
      [ // node data
        { key: "a", color: "coral", width: 120, loc: new go.Point(scaleWidth(0), 40) },
        { key: "b", color: "turquoise", width: 160, loc: new go.Point(scaleWidth(0), 60) },
        { key: "c", color: "coral", width: 150, loc: new go.Point(scaleWidth(120), 80) },
        { key: "d", color: "turquoise", width: 190, loc: new go.Point(scaleWidth(120), 100) },
        { key: "e", color: "coral", width: 150, loc: new go.Point(scaleWidth(270), 120) },
        { key: "f", color: "turquoise", width: 130, loc: new go.Point(scaleWidth(310), 140) },
        { key: "g", color: "coral", width: 155, loc: new go.Point(scaleWidth(420), 160) },
        { key: "begin", category: "start", loc: new go.Point(-15,20) },
        { key: "end", category: "end", loc: new go.Point(scaleWidth(575), 180) },
        
        { key: "23Jul", category: "date", loc: new go.Point(scaleWidth(0), 0) },
        { key: "30Jul", category: "date", loc: new go.Point(scaleWidth(150), 0) },
        { key: "6Aug", category: "date", loc: new go.Point(scaleWidth(300), 0) },
        { key: "13Aug", category: "date", loc: new go.Point(scaleWidth(450), 0) }
      ],
      [ // link data
        { from: "begin", to: "a" },
        { from: "begin", to: "b" },
        { from: "a", to: "c" },
        { from: "a", to: "d" },
        { from: "b", to: "e" },
        { from: "c", to: "e" },
        { from: "d", to: "f" },
        { from: "e", to: "g" },
        { from: "f", to: "end" },
        { from: "g", to: "end" }
      ]);
    }

    // scale the number according to the current widthFactor
    function scaleWidth(num) {
      return num * myDiagram._widthFactor;
    }

    // change the grid's cell size and the widthFactor,
    // then update Bindings to scale the widths and positions of nodes
    function rescale() {
      var val = parseFloat(document.getElementById("widthSlider").value);
      myDiagram.startTransaction("rescale");
      myDiagram.grid.gridCellSize = new go.Size(val, 150);
      myDiagram._widthFactor = val / 30;
      myDiagram.updateAllTargetBindings();
      myDiagram.commitTransaction("rescale");
    }
  </script>

</head>
<body onload="init()">

<div id="sample">

  <b>Gantt chart</b>
  <div class="table-responsive">
				         						<!-- 20 linhas com codigoitem, decricao, qtd, puitem.  -->
												<table id="tabela" cellspacing="5" cellspacing="5" class="table" style="border: 0px solid;">
													<thead>
														<tr class="success">
															<th>EAP</th>
															<th>Projeto</th>
															<th>Duração</th>
															<th>Início</th>
															<th>Fím</th>
														</tr>
													</thead>
													<tbody>
														<!-- 1 linha -->
														<tr class="">		
															<td>
																<input type="text" value="" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="" disabled="disabled" size="1" class="form-control" />
															</td>
														</tr>	
														<!-- fim 1 linha -->
													</tbody>
												</table>
														
  <div id="myDiagramDiv" style="height:600px;width:100%;border:1px solid black"></div>
  <div id="slider">
    <label>Spacing:</label>
    <input id="widthSlider" type="range" min="2" max="90" value="30" onchange="rescale()"/>
  </div>

</div>
</body>
</html>
