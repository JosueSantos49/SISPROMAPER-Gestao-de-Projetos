<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page import="java.io.PrintWriter" import="java.util.*, javax.rmi.*, javax.naming.*, java.io.*, java.lang.*" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FileBeanAjuda"%>
<%@page import="br.com.tkcsapcd.model.dao.FileAjudaDAO"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="wow/css/animate.css">
<title>Ajuda</title>

<style> .modal-body { max-height: 800px; } </style>
<!-- Conexão -->
<%!
	Connection connection = null;
	Statement statement =  null;
	ResultSet rsConta = null;
	String acesso;//sessao
	String ordenacao;
%>

<% Connection con = ConexaoHelper.conectar(); %>
</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h5>Consultar Arquivo Ajuda!</h5>
	</div>
	
	<form action="TkcsapcdController"> <!-- Inicio form -->
	<input type="hidden" name="cmd" value="cadastrarProjetoInicio"></input>
	
	<div class="modal-body">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab1" data-toggle="tab" class="glyphicon glyphicon-hand-right"></a></li>												
		</ul>
		
		<div class="alert alert-success">
			Olá, 
				<%=session.getAttribute("theName")%>
					<%  
					//verifica se a sessao do usuario é válida  
					if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
				%>
				seja bem-vindo a etapa de listar arquivo de ajuda. Você poderá executar download para seu dispositivo e disfrutar de todas informações, onde, nenhum arquivo<br> poderá ser utilizado para outros fins conforme descrito no contrato e política de uso da ferramenta. Qualquer violação do arquivo, reprodução a empresa se responsabiliza podendo sofrer penas judiciais do órgão competente.   
			</div>
		
					<div class="container">
						<div class="panel panel-primary">
						  <div class="panel-heading">
						    <h3 class="panel-title">ESC - Fechar</h3>
						  </div>											
						  	<div class="panel-body">
							   	<div class="table-responsive">	
							   	<%
								int limite = 20;// quantidade de resultados por página
								String numPagina = request.getParameter("numpagina");
								
								if(numPagina == null)
									numPagina = "1";
								
								int offset = (Integer.parseInt(numPagina) * limite) - limite;
								//out.println("Limite = "+limite);
								//out.println("numPagina = "+numPagina);
								//out.println("Offset = "+offset+"<br><br>");			
								
								String sql1 = "select * from fileajuda LIMIT 20 OFFSET 0"+offset;
								PreparedStatement ps = con.prepareStatement(sql1);
								System.out.println(sql1);
								ResultSet rs1 = ps.executeQuery();
								
								try{
								%>
		                               <table id="tabela" cellspacing="5" cellspacing="5" class="table">
											<thead>
												<tr>
													<th>ID</th>
													<th>Nome do Arquivo (Extensão)</th>
													<th>Descrição</th>
													<th>Download</th>
												</tr>
											</thead>
											<%
												 		
												FileAjudaDAO fileBeanAjuda = new FileAjudaDAO();
												List <FileBeanAjuda> resultado = fileBeanAjuda.getFileBeanAjudas();
												for (FileBeanAjuda fileAjuda : resultado) {
											%>
											<tr>
												<td><%=fileAjuda.getId()%></td>
												<td><%=fileAjuda.getName()%></td>
												<td><%=fileAjuda.getDescription()%></td>
												<td><a href="downloadAjuda.do?id=<%=fileAjuda.getId()%>">Baixar</a></td>
											</tr>
											<%
												}
											%>
									</table>
									<%
									 String sqlConta = "select count(*) AS contaRegistros from fileajuda";
									PreparedStatement psConta = con.prepareStatement(sqlConta);
									System.out.println(sqlConta);
									ResultSet rsConta = psConta.executeQuery();
									rsConta.next();
									
									int totalRegistros = Integer.parseInt(rsConta.getString("contaRegistros"));
									int totalPaginas = totalRegistros / limite;
									
									if(totalRegistros % limite != 0)
										totalPaginas++; 
									//out.println("Quantidade de registros: "+totalRegistros);
									//out.println("Total de páginas a serem mostradas: "+totalPaginas);
						out.println("<br>");
	
									int pagAnterior;
									if(Integer.parseInt(numPagina) > 1){
										pagAnterior = Integer.parseInt(numPagina) -1;
										out.println("<ul class='pagination'>");
										out.println("<li><a href=menu_sugerido_ajuda.jsp?numpagina="+pagAnterior+"> << Anterior </a></li>");
										out.println("</ul>");
									}			
									for(int i=1;i<=totalPaginas;i++){
										if(i == Integer.parseInt(numPagina))
											out.println();// aqui pode ser colocado o i, esta vazio porque fica mostrando na página
										else
											out.println("<a href=menu_sugerido_ajuda.jsp?numpagina="+i+"></a>");
											out.println("<ul class='pagination'>");
											out.println("<li><a href=menu_sugerido_ajuda.jsp?numpagina="+i+">"+ i +"</a></li>");
											out.println("</ul>");
									}											
									int proximaPag;
									if(totalRegistros - (Integer.parseInt(numPagina) * limite) > 0){
										proximaPag = Integer.parseInt(numPagina) + 1;
										out.println("<ul class='pagination'>");
										out.println("<li><a href=menu_sugerido_ajuda.jsp?numpagina="+proximaPag+"> Próxima >> </a></li>");
										out.println("</ul>");
									}										
									
									rsConta.close();
									con.close();
								}
									catch (SQLException e) {
							            //tratar erro
							        	e.printStackTrace();
							        	System.out.println("Erro ao tentar inserir file Ajuda: "+e);
							        	
							        }finally{
										  // fecha todos os recursos e devolve a conexao ao pool
									      if (rsConta != null && !rsConta.isClosed() ) {
									          try { rsConta.close(); } catch (SQLException e) { ; }
									          rsConta = null;
									      }
									      /*if (st != null && !st.isClosed() ) {
									          try { st.close(); } catch (SQLException e) { ; }
									          st = null;
									      }*/
									      if (con != null && !con.isClosed() ) {
									          try { con.close(); } catch (SQLException e) { ; }
									          con = null;
									      }
									}
									%>
								</div>	
							</div>				   
						</div>
					</div>
				</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn">Fechar</button>
	</div>
	
	</form><!-- fim form -->
</body>
</html>