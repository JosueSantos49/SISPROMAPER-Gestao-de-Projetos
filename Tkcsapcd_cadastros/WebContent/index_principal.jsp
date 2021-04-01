<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@ page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@page import="br.com.tkcsapcd.model.util.Conexao"%>
<html>

<jsp:include page="sessao.jsp" />

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Início</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css"> <!---->
<link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap_consultar_processos.css" />
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script> 
<script type="text/javascript" src="js/ajax.js"></script>

	<link rel="stylesheet" href="wow/css/animate.css"><!-- wow -->
	<style>.wow:first-child { visibility: hidden; } </style>
    <script type="text/javascript" src="js/zoom_fonte_configuracao.js"></script>
    <link href="css/formatacao_type_button.css" type="text/css" media="screen, projection" rel="stylesheet" /> 

	<%@include  file="data_hora_formatada.jsp" %>
	
<!-- Conexão -->
<%!
	Connection connection = null;
	Statement statement =  null;
	ResultSet resultset = null;
	String acesso;//sessao
	String ordenacao;
	
	public void jspInit(){
		try{
			connection = Conexao.getConnection();
			statement = connection.createStatement();			
		} catch (Exception e){
			System.out.println("Falha na conexao index_principal: " + e);
		}	
	}	
	public void jspDestroy(){
		try{
			//statement.close();
			//connection.close();
			if (resultset != null && !resultset.isClosed() ) {
	          try { resultset.close(); } catch (SQLException e) { ; }
	          resultset = null;
	      }
			if (statement != null && !statement.isClosed() ) {
	          try { statement.close(); } catch (SQLException e) { ; }
	          statement = null;
	      }
	      	if (connection != null && !connection.isClosed() ) {
	          try { connection.close(); } catch (SQLException e) { ; }
	          connection = null;
	      }
		} catch (Exception e){
			System.out.println("Nao consegui fechar a conexao index_principal: " + e);
		}
	}
%>
<% acesso = (String) session.getAttribute("login");%>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal();" >

<div id="conteudo"><!-- tratando o zoo da página -->

  <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button class="btn btn-navbar" data-toggle="collapse" data-target="#app-nav-top-bar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="brand"><i class="">SISPROMAPER</i></a>
                    <div id="app-nav-top-bar" class="nav-collapse">
                        <ul class="nav">                            
                                <!-- <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">TRY ME!
                                        <b class="caret hidden-phone"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="dashboard.html">Dashboard</a>
                                        </li>
                                        <li>
                                            <a href="form.html">Form</a>
                                        </li>
                                        <li>
                                            <a href="custom-view.html">Custom View</a>
                                        </li>
                                        <li>
                                            <a href="login.html">Login Page</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">CHANGE NAV BAR
                                        <b class="caret hidden-phone"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="demo-horizontal-nav.html">Horizontal</a>
                                        </li>
                                        <li>
                                            <a href="demo-horizontal-fixed-nav.html">Horizontal Fixed</a>
                                        </li>
                                        <li>
                                            <a href="demo-vertical-nav.html">Vertical</a>
                                        </li>
                                        <li>
                                            <a href="demo-vertical-fixed-nav.html">Vertical Fixed</a>
                                        </li>
                                    </ul>
                                </li>-->
                            
                        </ul>
                        <ul class="nav pull-right">
                            <li><a href="sair.jsp">Logout</a></li>
                            <li><a href="index_principal.jsp">Home</a></li>
                            
                            <li>
								<a>
								<!-- Zoon da página-->
								<input type="button" value="+" onclick="fonte('a');" title="Aumentar o tamanho da fonte">
								<input type="button" value="-" onclick="fonte('b');" title="Diminuir o tamanho da fonte">
								<input type="button" value="100%" onclick="fonte('c');" title="Fonte com tamanho padrão">
								<!-- Fim Zoon da página-->
								</a>	
							</li> 
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div id="body-container">
            <div id="body-content">
                
                    <div class="body-nav body-nav-horizontal body-nav-fixed">
                        <div class="container">
                            <ul>
                            	<li>
                                    <a href="menu_sugerido_ajuda.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-floppy-save"></i> Ajuda
                                    </a>
                                </li>
                                 <li>
                                    <a href="grupo_processos.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-cog" ></i> Grupo
                                    </a>
                                </li>
                                <li>
                                    <a href="upload.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-paperclip"></i> Upload
                                    </a>
                                </li>
                                 <li>
                                    <a href="upload_projeto.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-paperclip"></i> Upl. Projeto
                                    </a>
                                </li>
                                <li>
                                    <a href="transacao.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-zoom-in"></i> Procurar
                                    </a>
                                </li>
                                <li>
                                    <a href="consulta_guia_processos_2.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-check"></i> Processos
                                    </a>
                                </li>
                                <li>
                                    <a href="consulta_solicitacaocadastro.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-user"></i> Acesso
                                    </a>
                                </li>
                                <li>
                                    <a href="menu_sugerido_principal.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-book"></i> Projeto
                                    </a>
                                </li>
                                <li>
                                    <a href="envia.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-folder-open"></i> Email
                                    </a>
                                </li>
                                <li>
                                    <a href="cadastro_rfq.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> Cotação
                                    </a>
                                </li>
                                <li>
                                    <a href="index_portfolio_projeto.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-level-up"></i> Portfólio
                                    </a>
                                </li> 
                                 <li>
                                    <a href="consulta_transacao.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-zoom-in"></i> Buscar
                                    </a>
                                </li> 
                                 <li>
                                    <a href="fluxo_metodologiapmo.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> All
                                    </a>
                                </li> 
                                <!--<li>
                                    <a href="manutencaopagina3.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> Completar
                                    </a>
                                </li>                               
                                 <li>
                                    <a href="cadastro_organograma_propriedade.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> Ordenado
                                    </a>
                                </li>
                                <li>
                                    <a href="consulta_organograma_propriedade.jsp" target="_parent">
                                        <i class="glyphicon glyphicon-list-alt"></i> C.Ordenado
                                    </a>
                                </li>-->
                            </ul>
                        </div>
                    </div>
                    
					<section class="nav nav-page">
				        <div class="container">
				            <div class="row">
				                <div class="span7">
				                	<div id="main">							
								<div class="wow slideInLeft" data-wow-duration="6s">    
				                    <header class="page-header">
				                        <h3>Usuário: 
				                        <%=session.getAttribute("theName")%>
											<%  
											//verifica se a sessao do usuario é válida  
											if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
										%>	
				                        <br/>
				                            <small>Bem vindo</small>
				                        </h3>
				                    </header>
				                    </div>
				                    </div>
				                
				                </div>
				                <div class="page-nav-options">
				                    <div class=""><!-- span9 -->
				                        <ul class="nav nav-pills">
				                            <li>
				                                <a href="index_principal.jsp"><i class="icon-home"></i></a>
				                            </li>
				                        </ul>
				                        <ul class="nav nav-tabs">
				                            <li class="active">
				                                <a href="index_principal.jsp"><i class="icon-home"></i>Home</a>
				                            </li>
				                            <%	
													if(acesso == null)acesso = "00";
														
														String sqlmenus =  "select * from menus where men_nivelacesso = '"+acesso+"' order by men_ordenacao";																	
														resultset = statement.executeQuery(sqlmenus);
													
													while(resultset.next()){
												%>	
													<li><a href="<%= resultset.getString("men_linkacessar")%>"><%= resultset.getString("men_descricao")%></a></li>																		
												<%	
													//System.out.println("Resultset menu dinamico: "+resultset);
													}
												
												%>	
				                        </ul>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </section>
			<div class="container">	
				
					<div id="main">
	 					<div class="wow slideInLeft" data-wow-duration="3s">	
						    <div class="alert alert-success">
									  <strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br>
									  <p><strong><a href="menu_sugerido_principal.jsp" target="_parent">Clique aqui!</a></strong> Iniciar projeto ou proposta de projeto de forma fácil e prática. 
									  
									  <strong><a href="modal_informativo.jsp" target="_parent">Dica!</a></strong></p>
									  
									  <p>
									  Olá,
									  	<%=session.getAttribute("theName")%>
											<%  
											//verifica se a sessao do usuario é válida  
											if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}  
							    		%>
									  você já criou o projeto? Caso, sim, siga nosso mapa. Para começar clique <strong><a href="mapa.jsp" target="_parent">aqui!</a></strong>!
									  </p>
									  
									  <p>
									  <strong><a href="home.jsp" target="_parent">Questionário</a></strong> preparatório para o mercado de trabalho e certificação PMP!
									  </p> 
							</div>
						</div>						
					
		      		 	<div class="row small center wow fadeInDown top__element" data-wow-delay="2s">	
		      				<%@include file="tabela_operacoes.jsp" %>		      				
						</div>							
					</div>
					<!-- <div align="center">
						<a href="mapa.jsp"><img src="img/mapa.gif" width="73%"></a>
					</div>-->
			</div>								
					<%@include file="configuracao_wow.jsp" %>			
					<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
					<script src="bootstrap/js/bootstrap.min.js"></script>
					<br><%@ include file="rodape.jsp" %> 
			</div>	 	
		</div>  
	</div>	
</body>
</html> 