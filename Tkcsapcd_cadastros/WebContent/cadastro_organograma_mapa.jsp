<!-- 
	Autor: Josu� da Concei��o Santos
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
<title>Cadastrar Organograma Mapa</title>

<meta name="description" content="" />
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
<!-- Calend�rio -->
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
        {
          // when the user drags a node, also move/copy/delete the whole subtree starting with that node
          "commandHandler.copiesTree": true,
          "commandHandler.deletesTree": true,
          "draggingTool.dragsTree": true,
          initialContentAlignment: go.Spot.Center,  // center the whole graph
          "undoManager.isEnabled": true
        });

    // when the document is modified, add a "*" to the title and enable the "Save" button
    myDiagram.addDiagramListener("Modified", function(e) {
      var button = document.getElementById("SaveButton");
      if (button) button.disabled = !myDiagram.isModified;
      var idx = document.title.indexOf("*");
      if (myDiagram.isModified) {
        if (idx < 0) document.title += "*";
      } else {
        if (idx >= 0) document.title = document.title.substr(0, idx);
      }
    });

    // a node consists of some text with a line shape underneath
    myDiagram.nodeTemplate =
      $(go.Node, "Vertical",
        { selectionObjectName: "TEXT" },
        $(go.TextBlock,
          {
            name: "TEXT",
            minSize: new go.Size(30, 15),
            editable: true
          },
          // remember not only the text string but the scale and the font in the node data
          new go.Binding("text", "text").makeTwoWay(),
          new go.Binding("scale", "scale").makeTwoWay(),
          new go.Binding("font", "font").makeTwoWay()),
        $(go.Shape, "LineH",
          {
            stretch: go.GraphObject.Horizontal,
            strokeWidth: 3, height: 3,
            // this line shape is the port -- what links connect with
            portId: "", fromSpot: go.Spot.LeftRightSides, toSpot: go.Spot.LeftRightSides
          },
          new go.Binding("stroke", "brush"),
          // make sure links come in from the proper direction and go out appropriately
          new go.Binding("fromSpot", "dir", function(d) { return spotConverter(d, true); }),
          new go.Binding("toSpot", "dir", function(d) { return spotConverter(d, false); })),
        // remember the locations of each node in the node data
        new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
        // make sure text "grows" in the desired direction
        new go.Binding("locationSpot", "dir", function(d) { return spotConverter(d, false); })
      );

    // selected nodes show a button for adding children
    myDiagram.nodeTemplate.selectionAdornmentTemplate =
      $(go.Adornment, "Spot",
        $(go.Panel, "Auto",
          // this Adornment has a rectangular blue Shape around the selected node
          $(go.Shape, { fill: null, stroke: "dodgerblue", strokeWidth: 3 }),
          $(go.Placeholder, { margin: new go.Margin(4, 4, 0, 4) })
        ),
        // and this Adornment has a Button to the right of the selected node
        $("Button",
          {
            alignment: go.Spot.Right,
            alignmentFocus: go.Spot.Left,
            click: addNodeAndLink  // define click behavior for this Button in the Adornment
          },
          $(go.TextBlock, "+",  // the Button content
            { font: "bold 8pt sans-serif" })
        )
      );

    // the context menu allows users to change the font size and weight,
    // and to perform a limited tree layout starting at that node
    myDiagram.nodeTemplate.contextMenu =
      $(go.Adornment, "Vertical",
        $("ContextMenuButton",
          $(go.TextBlock, "Bigger"),
          { click: function(e, obj) { changeTextSize(obj, 1.1); } }),
        $("ContextMenuButton",
          $(go.TextBlock, "Smaller"),
          { click: function(e, obj) { changeTextSize(obj, 1/1.1); } }),
        $("ContextMenuButton",
          $(go.TextBlock, "Bold/Normal"),
          { click: function(e, obj) { toggleTextWeight(obj); } }),
        $("ContextMenuButton",
          $(go.TextBlock, "Layout"),
          {
            click: function(e, obj) {
                var adorn = obj.part;
                adorn.diagram.startTransaction("Subtree Layout");
                layoutTree(adorn.adornedPart);
                adorn.diagram.commitTransaction("Subtree Layout");
              }
          }
        )
      );

    // a link is just a Bezier-curved line of the same color as the node to which it is connected
    myDiagram.linkTemplate =
      $(go.Link,
        {
          curve: go.Link.Bezier,
          fromShortLength: -2,
          toShortLength: -2,
          selectable: false
        },
        $(go.Shape,
          { strokeWidth: 3 },
          new go.Binding("stroke", "toNode", function(n) {
            if (n.data.brush) return n.data.brush;
            return "black";
          }).ofObject())
      );

    // the Diagram's context menu just displays commands for general functionality
    myDiagram.contextMenu =
      $(go.Adornment, "Vertical",
        $("ContextMenuButton",
          $(go.TextBlock, "Undo"),
          { click: function(e, obj) { e.diagram.commandHandler.undo(); } },
          new go.Binding("visible", "", function(o) { return o.diagram.commandHandler.canUndo(); }).ofObject()),
        $("ContextMenuButton",
          $(go.TextBlock, "Redo"),
          { click: function(e, obj) { e.diagram.commandHandler.redo(); } },
          new go.Binding("visible", "", function(o) { return o.diagram.commandHandler.canRedo(); }).ofObject()),
        $("ContextMenuButton",
          $(go.TextBlock, "Save"),
          { click: function(e, obj) { save(); } }),
        $("ContextMenuButton",
          $(go.TextBlock, "Load"),
          { click: function(e, obj) { load(); } })
      );


    myDiagram.addDiagramListener("SelectionMoved", function(e) {
      var rootX = myDiagram.findNodeForKey(0).location.x;
      myDiagram.selection.each(function(node) {
          if (node.data.parent !== 0) return; // Only consider nodes connected to the root
          var nodeX = node.location.x;
          if (rootX < nodeX && node.data.dir !== "right") {
            node.data.dir = 'right';
            myDiagram.model.updateTargetBindings(node.data);
            layoutTree(node);
          } else if (rootX > nodeX && node.data.dir !== "left") {
            node.data.dir = 'left';
            myDiagram.model.updateTargetBindings(node.data);
            layoutTree(node);
          }
        });
    });

    // read in the predefined graph using the JSON format data held in the "mySavedModel" textarea
    load();
  }

  function spotConverter(dir, from) {
    if (dir === "left") {
      return (from ? go.Spot.Left : go.Spot.Right);
    } else {
      return (from ? go.Spot.Right : go.Spot.Left);
    }
  }

  function changeTextSize(obj, factor) {
    var adorn = obj.part;
    adorn.diagram.startTransaction("Change Text Size");
    var node = adorn.adornedPart;
    var tb = node.findObject("TEXT");
    tb.scale *= factor;
    adorn.diagram.commitTransaction("Change Text Size");
  }

  function toggleTextWeight(obj) {
    var adorn = obj.part;
    adorn.diagram.startTransaction("Change Text Weight");
    var node = adorn.adornedPart;
    var tb = node.findObject("TEXT");
    // assume "bold" is at the start of the font specifier
    var idx = tb.font.indexOf("bold");
    if (idx < 0) {
      tb.font = "bold " + tb.font;
    } else {
      tb.font = tb.font.substr(idx + 5);
    }
    adorn.diagram.commitTransaction("Change Text Weight");
  }

  /*Dentro da aspas duplas � poss�vel adicionar coment�rio na linha do mapa que aparece dentro do conteiner. 
  Tamb�m em cada linha do mapa � poss�vel adicionar texto autom�tico.  	
  */
  function addNodeAndLink(e, obj) {
    var adorn = obj.part;
    var diagram = adorn.diagram;
    diagram.startTransaction("Add Node");
    var oldnode = adorn.adornedPart;
    var olddata = oldnode.data;
    // copy the brush and direction to the new node data
    var newdata = { text: " ", brush: olddata.brush, dir: olddata.dir, parent: olddata.key }; 
    diagram.model.addNodeData(newdata);
    layoutTree(oldnode);
    diagram.commitTransaction("Add Node");
  }

  function layoutTree(node) {
    if (node.data.key === 0) {  // adding to the root?
      layoutAll();  // lay out everything
    } else {  // otherwise lay out only the subtree starting at this parent node
      var parts = node.findTreeParts();
      layoutAngle(parts, node.data.dir === "left" ? 180 : 0);
    }
  }

  function layoutAngle(parts, angle) {
    var layout = go.GraphObject.make(go.TreeLayout,
        { angle: angle,
          arrangement: go.TreeLayout.ArrangementFixedRoots,
          nodeSpacing: 5,
          layerSpacing: 20 });
    layout.doLayout(parts);
  }

  function layoutAll() {
    var root = myDiagram.findNodeForKey(0);
    if (root === null) return;
    myDiagram.startTransaction("Layout");
    // split the nodes and links into two collections
    var rightward = new go.Set(go.Part);
    var leftward = new go.Set(go.Part);
    root.findLinksConnected().each(function(link) {
        var child = link.toNode;
        if (child.data.dir === "left") {
          leftward.add(root);  // the root node is in both collections
          leftward.add(link);
          leftward.addAll(child.findTreeParts());
        } else {
          rightward.add(root);  // the root node is in both collections
          rightward.add(link);
          rightward.addAll(child.findTreeParts());
        }
      });
    // do one layout and then the other without moving the shared root node
    layoutAngle(rightward, 0);
    layoutAngle(leftward, 180);
    myDiagram.commitTransaction("Layout");
  }

  // Show the diagram's model in JSON format
  function save() {
    document.getElementById("mySavedModel").value = myDiagram.model.toJson();
    myDiagram.isModified = false;
  }
  function load() {
    myDiagram.model = go.Model.fromJson(document.getElementById("mySavedModel").value);
  }
</script>


</head>

<body onload="init()">

<%@include file="menuperanteorganograma.jsp" %>

<br>

<div align="center"><h5><font color="grenn"> ${mensagem}</font></h5></div>
			
<form action="TkcsapcdController" name="formulario" id="formulario" onsubmit="">

	<input type="hidden" name="cmd" value="cadastrarOrganogramaMapa"></input>
	
	<div id="sample">
	  
  		<div id="myDiagramDiv" style="border: solid 1px blue; width:100%; height:500px;"></div>  
    
	  		<div class="container">	
	  
	  		<br>
	  	
	    <div>	   
	      <button class="btn btn-info" id="SaveButton" onclick="save()">Escrever</button>
	      <button class="btn btn-info" onclick="load()">Ler</button>	
	      <button class="btn btn-info" onclick="layoutAll()">Layout</button>      
	    </div><br>	    
	    	    
	    C�digo Projeto:
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
						
	    
		<br>Data: 		<input id="data" name="data" style="width: 379px" value="00/00/0000" class="form-control"><br>	   
		Descri��o: 		<input id="descricao" name="descricao" style="width: 379px" maxlength="300" class="form-control"><br>	
		E-mail:			<br><input type="text" name="para" style="height: 30px; width: 379px" maxlength="150" placeholder="Destinat�rio" class="form-control">
	    <br>Coment�rio: <br><textarea id="comentario" name="comentario" rows="10" cols="80" maxlength="5000"></textarea><br><br>
	    <a href="#" id="mostrar">Exibir conte�do</a>
	    <a href="#" id="ocultar">Ocultar conte�do</a>
	    <div id="conteudo">
	    
	    <textarea name="mySavedModel" id="mySavedModel" style="width:100%;height:250px" required="true" class="form-control">	    
		    { "class": "go.TreeModel",
			  "nodeDataArray": [ 
			{"key":0, "text":"", "loc":"0 0"},
			{"key":1, "parent":0, "text":"", "brush":"skyblue", "dir":"right", "loc":"77 -22"},
			{"key":2, "parent":0, "text":"", "brush":"darkseagreen", "dir":"right", "loc":"77 43"},
			{"key":3, "parent":0, "text":"", "brush":"palevioletred", "dir":"left", "loc":"-20 -31.75"},
			{"key":4, "parent":0, "text":"", "brush":"coral", "dir":"left", "loc":"-20 52.75"}
			 ]}
	    </textarea>	    
	    </div>
	
			<br>
	
				<div class="btn-group">
					<input class="btn btn-success" type="submit" name="gravar" id="gravar" value="Gravar" onclick=""></input>
					<input class="btn btn-success" type="reset" value="Limpar" onclick=""></input>
				</div>
			</div>
		</div>
	</form>
	<br>
</body>
</html>
