<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<jsp:include page="sessao.jsp" />
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">

    <title>Ramifica��o Projeto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
 
	 <style type="text/css">
	 .tree, .tree ul {
	    margin:0;
	    padding:0;
	    list-style:none
		}
	.tree ul {
		    margin-left:1em;
		    position:relative
		}
	.tree ul ul {
		    margin-left:.5em
		}
	.tree ul:before {
	    content:"";
	    display:block;
	    width:0;
	    position:absolute;
	    top:0;
	    bottom:0;
	    left:0;
	    border-left:1px solid
	}
	.tree li {
	    margin:0;
	    padding:0 1em;
	    line-height:2em;
	    color:#369;
	    font-weight:700;
	    position:relative
	}
	.tree ul li:before {
	    content:"";
	    display:block;
	    width:10px;
	    height:0;
	    border-top:1px solid;
	    margin-top:-1px;
	    position:absolute;
	    top:1em;
	    left:0
	}
	.tree ul li:last-child:before {
	    background:#fff;
	    height:auto;
	    top:1em;
	    bottom:0
	}
	.indicator {
	    margin-right:5px;
	}
	.tree li a {
	    text-decoration: none;
	    color:#369;
	}
	.tree li button, .tree li button:active, .tree li button:focus {
	    text-decoration: none;
	    color:#369;
	    border:none;
	    background:transparent;
	    margin:0px 0px 0px 0px;
	    padding:0px 0px 0px 0px;
	    outline: 0;
	}
	</style>
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>
</head>
<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">
	
	<div class="container" style="margin-top:20px; width: 103%">
	
	<%@include file="menuperantecsslivre.jsp"%>
	
	<div class="container">	
	
    <div class="row">
        <div class="col-md-4">
            <ul id="tree1">                
                <%
					List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
					for (ProjetoInicio projetoInicio : projetoInicios) {
				%>
                 <li>                 		
                 		<a href="#"><font color="#000">PROJETO - </font></a> <%=projetoInicio.getProjeto()%>												
                    <ul>
                        <li><font color="#000">C�DIGO</font> - <%=projetoInicio.getCodigoprojeto()%></li>
                        <li><font color="red">ATRIBUI��O</font> - <%=projetoInicio.getAtribuiprojeto()%>
                            <ul>
                                <li><font color="#000">DADOS</font>
                                    <ul>
                                        <li><font color="#000">DATA</font> - <%=projetoInicio.getData()%></li>
                                        <li><font color="#000">TIPO PROJETO</font> - <%=projetoInicio.getTipoprojeto()%></li>
                                        <li><font color="#000">CLIENTE</font> - <%=projetoInicio.getCliente()%></li>
                                        <li><font color="#000">PROGRAMA</font> - <%=projetoInicio.getPrograma()%></li>
                                        <li><font color="#000">�REA</font> - <%=projetoInicio.getArea()%></li>
                                        <li><font color="#000">ROI</font> - <%=projetoInicio.getRoi()%></li>
                                    </ul>
                                </li>
                                <li><font color="red">FIM ATRIUI��O</font></li>
                            </ul>
                        </li>
                        <li><font color="#000">FIM PROJETO</font></li>
                    </ul>
                </li>
                
            <%
				}
			%>                
         </ul>
        </div>
    </div>
    </div>
</div>


	<script type="text/javascript">
	$.fn.extend({
    treed: function (o) {
      
      var openedClass = 'glyphicon-minus-sign';
      var closedClass = 'glyphicon-plus-sign';
      
      if (typeof o != 'undefined'){
        if (typeof o.openedClass != 'undefined'){
        openedClass = o.openedClass;
        }
        if (typeof o.closedClass != 'undefined'){
        closedClass = o.closedClass;
        }
      };
      
        //initialize each of the top levels
        var tree = $(this);
        tree.addClass("tree");
        tree.find('li').has("ul").each(function () {
            var branch = $(this); //li with children ul
            branch.prepend("<i class='indicator glyphicon " + closedClass + "'></i>");
            branch.addClass('branch');
            branch.on('click', function (e) {
                if (this == e.target) {
                    var icon = $(this).children('i:first');
                    icon.toggleClass(openedClass + " " + closedClass);
                    $(this).children().children().toggle();
                }
            })
            branch.children().children().toggle();
        });
        //fire event from the dynamically added icon
      tree.find('.branch .indicator').each(function(){
        $(this).on('click', function () {
            $(this).closest('li').click();
        });
      });
        //fire event to open branch if the li contains an anchor instead of text
        tree.find('.branch>a').each(function () {
            $(this).on('click', function (e) {
                $(this).closest('li').click();
                e.preventDefault();
            });
        });
        //fire event to open branch if the li contains a button instead of text
        tree.find('.branch>button').each(function () {
            $(this).on('click', function (e) {
                $(this).closest('li').click();
                e.preventDefault();
            });
        });
    }
});

//Initialization of treeviews

$('#tree1').treed();

$('#tree2').treed({openedClass:'glyphicon-folder-open', closedClass:'glyphicon-folder-close'});

$('#tree3').treed({openedClass:'glyphicon-chevron-right', closedClass:'glyphicon-chevron-down'});

	</script>
	<%@ include file="rodape.jsp" %>	
</body>
</html>
