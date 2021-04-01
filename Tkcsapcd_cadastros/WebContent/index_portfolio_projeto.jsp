<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.dao.PortfolioProjetoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.PortfolioProjeto"%>
<jsp:include page="sessao.jsp" />
<html>
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Portfólio Projeto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <style type="text/css">
      
      body{margin:50px;}
      #accordion .glyphicon { margin-right:10px; }
      .panel-collapse>.list-group .list-group-item:first-child {border-top-right-radius: 0;border-top-left-radius: 0;}
      .panel-collapse>.list-group .list-group-item {border-width: 1px 0;}
      .panel-collapse>.list-group {margin-bottom: 0;}
      .panel-collapse .list-group-item {border-radius:0;}

      .panel-collapse .list-group .list-group {margin: 0;margin-top: 10px;}
      .panel-collapse .list-group-item li.list-group-item {margin: 0 -15px;border-top: 1px solid #ddd !important;border-bottom: 0;padding-left: 30px;}
      .panel-collapse .list-group-item li.list-group-item:last-child {padding-bottom: 0;}

      .panel-collapse div.list-group div.list-group{margin: 0;}
      .panel-collapse div.list-group .list-group a.list-group-item {border-top: 1px solid #ddd !important;border-bottom: 0;padding-left: 30px;}
      .panel-collapse .list-group-item li.list-group-item {border-top: 1px solid #DDD !important;}
      
      .navbar-nav>li>.dropdown-menu {
		  margin-top: 20px;
		  border-top-left-radius: 4px;
		  border-top-right-radius: 4px;
		}
		
		.navbar-default .navbar-nav>li>a {
		  width: 200px;
		  font-weight: bold;
		}
		
		.mega-dropdown {
		  position: static !important;
		  width: 100%;
		}
		
		.mega-dropdown-menu {
		  padding: 20px 0px;
		  width: 100%;
		  box-shadow: none;
		  -webkit-box-shadow: none;
		}
		
		.mega-dropdown-menu:before {
		  content: "";
		  border-bottom: 15px solid #fff;
		  border-right: 17px solid transparent;
		  border-left: 17px solid transparent;
		  position: absolute;
		  top: -15px;
		  left: 285px;
		  z-index: 10;
		}
		
		.mega-dropdown-menu:after {
		  content: "";
		  border-bottom: 17px solid #ccc;
		  border-right: 19px solid transparent;
		  border-left: 19px solid transparent;
		  position: absolute;
		  top: -17px;
		  left: 283px;
		  z-index: 8;
		}
		
		.mega-dropdown-menu > li > ul {
		  padding: 0;
		  margin: 0;
		}
		
		.mega-dropdown-menu > li > ul > li {
		  list-style: none;
		}
		
		.mega-dropdown-menu > li > ul > li > a {
		  display: block;
		  padding: 3px 20px;
		  clear: both;
		  font-weight: normal;
		  line-height: 1.428571429;
		  color: #999;
		  white-space: normal;
		}
		
		.mega-dropdown-menu > li ul > li > a:hover,
		.mega-dropdown-menu > li ul > li > a:focus {
		  text-decoration: none;
		  color: #444;
		  background-color: #f5f5f5;
		}
		
		.mega-dropdown-menu .dropdown-header {
		  color: #428bca;
		  font-size: 18px;
		  font-weight: bold;
		}
		
		.mega-dropdown-menu form {
		  margin: 3px 20px;
		}
		
		.mega-dropdown-menu .form-group {
		  margin-bottom: 3px;
		}
		
		      .custab{
		    border: 1px solid #ccc;
		    padding: 5px;
		    margin: 5% 0;
		    box-shadow: 3px 3px 2px #ccc;
		    transition: 0.5s;
		    }
			.custab:hover{
		    box-shadow: 3px 3px 0px transparent;
		    transition: 0.5s;
		    }
		    
		  .hero-unit {
		  padding: 1px;
		  margin-bottom: 30px;
		  font-size: 18px;
		  font-weight: 200;
		  line-height: 15px;
		  color: inherit;
		  background-color: #eeeeee;
		  -webkit-border-radius: 6px;
		     -moz-border-radius: 6px;
		          border-radius: 6px;
			}
		
			.hero-unit li {
			  line-height: 15px;
			}

    </style>
    
    <script src="js/jquery-1.9.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    
    <!-- datatable 1.10.0 -->
	<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
	<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
	<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
	<!-- / datatable 1.10.0 -->

	<script type="text/javascript">
	$(document).ready(function(){
		$('#tabela').dataTable();
	});
	</script>

</head>

<body>

	<div class="hero-unit"><h3>Portfólio de Projetos</h3></div>

	<%@include file="tabela_operacoes.jsp"%>

      <div class="row">
        <div class="col-sm-3 col-md-3">
          <div class="panel-group" id="accordion">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><span class="glyphicon glyphicon-folder-close">
                    </span>Menu Opções</a>
                </h4>
              </div>
              <div id="collapseOne" class="panel-collapse collapse in">
                <ul class="list-group">
                
                  <li class="list-group-item">
                                       
                    <ul class="list-group">
                                        
                      <li class="list-group-item"><span class="glyphicon glyphicon-file text-info"></span><a href="sair.jsp">Encerrar sessão</a>
                    
                      <li class="list-group-item"><span class="glyphicon glyphicon-pencil text-primary"></span><a href="TkcsapcdController?cmd=editarPortfolioProjeto">Novo Registro</a>
                    
                      <li class="list-group-item"><span class="glyphicon glyphicon-pencil text-primary"></span><a href="TkcsapcdController?cmd=consultarPortfolioProjeto">Listar Registro</a></li>
					  					  
					  <li class="list-group-item"><span class="glyphicon glyphicon-flash text-success"></span><a href="imprimir_portfolio_projeto.jsp">Relatório Coletivo</a></li>
                                            
                      <li class="list-group-item"><span class="glyphicon glyphicon-file text-info"></span><a href="upload.jsp">Upload</a></li>
                      
                      <li class="list-group-item"><span class="glyphicon glyphicon-file text-info"></span><a href="TkcsapcdController?cmd=consultarFilebeanArquivo">download</a></li>
                      
                      <li class="list-group-item"><span class="glyphicon glyphicon-file text-info"></span><a href="envia.jsp">E-mail</a></li>                                         

                    </ul>
                  </li>
                </ul>
              </div>
            </div>
            
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"><span class="glyphicon glyphicon-file">
                    </span>Projeto</a>
                </h4>
              </div>
              <div id="collapseFour" class="panel-collapse collapse">
                <div class="list-group">
                	<div class="list-group">
                  	<a href="TkcsapcdController?cmd=consultarProjetoInicio" class="list-group-item">Listar Projeto</a>                  
                    <a href="menu_sugerido_principal.jsp" class="list-group-item">Novo Projeto</a>
                    <a href="TkcsapcdController?cmd=consultarOrganograma" class="list-group-item">Listar EAP</a>                  
                    <a href="cadastro_organograma.jsp" class="list-group-item">Novo EAP</a>
                  </div>
                </div>
              </div>
            </div>
                        
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive"><span class="glyphicon glyphicon-folder-close">
                    </span>Ajuda!</a>
                </h4>
              </div>
              <div id="collapseFive" class="panel-collapse collapse">
                <div class="list-group">
                  <a href="menu_sugerido_ajuda.jsp" class="list-group-item">
                    <h4 class="list-group-item-heading">
					Olá, 
					<%=session.getAttribute("theName")%>
						<%  
						//verifica se a sessao do usuario é válida  
						if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
			    	%>, você esta precisando de ajuda?
					</h4>
					
                    <p class="list-group-item-text"> <font color="red">Clique aqui! </font></p>
                  
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-9 col-md-9">
          <div class="panel panel-success">
            <div class="panel-heading">
              <h5 class="panel-title">Olá, 
              <%=session.getAttribute("theName")%>
				<%  
				//verifica se a sessao do usuario é válida  
				if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
	    	  %>, seja bem vindo a etapa de protfólio de projetos. <strong><a href="index_principal.jsp" target="_parent">Home Page</a></strong> 
	    	  
	    	  <br><br>Outra transação <strong><a href="consulta_transacao.jsp" target="_parent">Clique aqui!</a></strong><br>
	    	  
              </h5>
            </div>
            <div class="panel-body">             
              
                <nav class="navbar navbar-default">				    			
				
				    <div class="collapse navbar-collapse js-navbar-collapse">
				      <ul class="nav navbar-nav">
				        <li class="dropdown mega-dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Ferramentas <span class="glyphicon glyphicon-chevron-down pull-right"></span></a>				
				          <ul class="dropdown-menu mega-dropdown-menu row">				            
				            <li class="col-sm-3">
				              <ul>
				                <li class="dropdown-header">Opção 1</li>
				                <li><a href="menu_sugerido_ajuda.jsp">Ajuda</a></li>
				                <li><a href="grupo_processos.jsp">Grupo</a></li>
				                <li><a href="consulta_guia_processos_2.jsp">Processos</a></li>
				                <li><a href="cadastro_rfq.jsp">Cotação</a></li>				                
				              </ul>
				            </li>
				            
				            <li class="col-sm-3">
				              <ul>
				                <li class="dropdown-header">Opção 2</li>
				                <li><a href="cadastro_organograma.jsp">Cad. Organograma</a></li>
				                <li><a href="TkcsapcdController?cmd=consultarOrganograma">Cons. Organograma</a></li>
				                <li><a href="cadastro_organograma_propriedade.jsp">Cad. Org. Propriedade</a></li>				                
				                <li><a href="TkcsapcdController?cmd=consultarOrganogramaPropriedade">Cons. Org. Propriedade</a></li>
				              </ul>
				            </li>	
				            
				            <li class="col-sm-3">
				              <ul>
				                <li class="dropdown-header">Opção 3</li>
								<li><a href="calendario.jsp">Calendário Evento</a></li>			               
				                <li><a href="upload.jsp">Upload</a></li>
				                <li><a href="TkcsapcdController?cmd=consultarFilebeanArquivo">download</a></li>
				                <li><a href="envia.jsp">E-mail</a></li>
				              </ul>
				            </li>
				            
				            <li class="col-sm-3">
				              <ul>
				                <li class="dropdown-header">Opção 4</li>
				                <li><a href="cadastro_organograma_mapa.jsp">Cad. Org. Mapa</a></li>
				                <li><a href="TkcsapcdController?cmd=consultarOrganogramaMapa">Con. Org. Mapa</a></li>
				                <li><a href="cadastro_organograma_editor.jsp">Cad. Org. Editor</a></li>
								<!-- <li><a href="cadastro_organograma_eap_automatico.jsp">Cad. Org. EAP Automático</a></li> -->
								<li><a href="upload_projeto.jsp">Upload Projeto</a></li>
								<li><a href="TkcsapcdController?cmd=consultarFilebeanProjeto">Con. Upload Projeto</a></li>
				              </ul>
				            </li>
				            
				            <li class="col-sm-3">
				              <ul>
				                <li class="dropdown-header">Opção 5</li>
								<li><a href="TkcsapcdController?cmd=editarDiagramaGantt">Cad. Gantt</a></li>
								<li><a href="TkcsapcdController?cmd=consultarDiagramaGantt">Con. Gantt</a></li>								
				              </ul>
				            </li>
				            			            
				          </ul>
				          </li>
				      </ul>
				
				    </div>
				    <!-- /.nav-collapse -->
				  </nav>
            </div>   
             
          	</div>
          
           <div class="table-responsive">				
					<table id="tabela" cellspacing="5" cellspacing="5" class="display">
							    <thead>
							        <tr>
							            <th>Código Projeto</th>
							            <th>Prioridade</th>
							            <th>Tipo Projeto</th>
							            <th>Unidade Negócio</th>
							            <th>Analista</th>
							            <th>Gerente</th>
							            <th>Parte Interessada</th>
							            <th>Plano Projeto</th>
							            <th>Declaração Escopo</th>
							            <th>Dicionário EAP</th>
							        </tr>
							    </thead>
								<tbody>
									<%
										PortfolioProjetoDAO portfolioProjeto1 = new PortfolioProjetoDAO();
										List<PortfolioProjeto> resultado = portfolioProjeto1.getPortfolioProjetos() ;
										for (PortfolioProjeto portfolioProjeto : resultado) {
									%>
								<tr>
										
									<td><%=portfolioProjeto.getCodigoprojeto()%></td>
									<td><%=portfolioProjeto.getPrioridade()%></td>
									<td><%=portfolioProjeto.getTipoprojeto()%></td>
									<td><%=portfolioProjeto.getUnidadenegocio()%></td>
									<td><%=portfolioProjeto.getAnalista()%></td>
									<td><%=portfolioProjeto.getGerente()%></td>
									<td><%=portfolioProjeto.getParteinteressada()%></td>
									<td><%=portfolioProjeto.getPlanoprojeto()%></td>
									<td><%=portfolioProjeto.getDeclaracaoescopo()%></td>
									<td><%=portfolioProjeto.getDicionarioeap()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
					</table>					
				</div>				
        </div>
      </div>
</body>
</html>
