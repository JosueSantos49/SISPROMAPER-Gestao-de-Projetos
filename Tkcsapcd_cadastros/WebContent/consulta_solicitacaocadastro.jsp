<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page import="javax.naming.InitialContext,javax.sql.DataSource"%>
<%@ page import="br.com.tkcsapcd.model.helper.ConexaoHelper" %>
<%@ page import="java.io.PrintWriter" import="java.util.*, javax.rmi.*, javax.naming.*, java.io.*, java.lang.*" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Solicitação Cadastro</title>	

<!-- Bootstrap -->  
<link href="bootstrap/css/bootstrapPagination.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<script type="text/javascript" src="js/confirmaExclusaoAtualizacao.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorioSolicitacao.js"></script>
<script src="excellentexport-master/excellentexport.js"></script>
<script language="javascript" src="js/funcoes.js"></script>

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

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<%!
	Connection conn = null;
	Statement st =  null;
	ResultSet rs1 = null;
	String acesso;//sessao
	String ordenacao;
%>

<% Connection con = ConexaoHelper.conectar(); %>

<% acesso = (String) session.getAttribute("login");%>			

<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center> 

<center><font color="red">Consultar Solicitação Cadastro</font></center>

<div class="container">			
		<div align="left">
		
			<form id="formConsSolicitacao" name="formConsSolicitacao" method="post" action="pesquisar_solicitacao_cadastro.jsp" onSubmit="return validaPesquisarRelatorioSolicitacao(this)">
		
				<strong>ID (relatório)..:</strong> <input name="consSolicitacao" type="text" id="consSolicitacao" title="Digite o código para exibir" maxlength="14" required="true" Placeholder="Entre com ID!">
				<input class="button" name="pesqSolicitacao" type="submit" id="pesqSolicitacao" value="Exibir"	title="Digite o código para exibir" onclick="validaPesquisarRelatorioSolicitacao();">

			</form>
		</div>
		
		<a download="somedata.xls" href="#"	onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Click aqui para exportar para Excel." height="20" width="27" src="img/xls.jpg"></a> 
		<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
</div>
<div align="center">

<form method="post" id="frmDelClass" name="frmDelClass" onSubmit="javascript:return validar();"  action="checkboxdadofixo.jsp" >
		
		 <%
			int limite = 15;// quantidade de resultados por página
			String numPagina = request.getParameter("numpagina");
			
			if(numPagina == null)
				numPagina = "1";
			
			int offset = (Integer.parseInt(numPagina) * limite) - limite;
			//out.println("Limite = "+limite);
			//out.println("numPagina = "+numPagina);
			//out.println("Offset = "+offset+"<br><br>");
						
			String sql1 = "select * from solicitacaocadastro LIMIT 15 OFFSET 0"+offset;
			PreparedStatement ps = con.prepareStatement(sql1);
			System.out.println(sql1);
			ResultSet rs1 = ps.executeQuery();
			
			try{
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			//Deletar registro
			if(request.getParameter("acao") != null)
			{
				//executar uma atualização
				st.executeUpdate("delete from solicitacaocadastro where codigo  = "+request.getParameter("codigo"));	
				System.out.println(st);
				
				/*Alert com confirmação de cadastro*/
				PrintWriter oPrintWriter = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Usuário excluido com sucesso!');");  
				out.println("</script>");
			}		  
			out.println("<div class='table-responsive'>");
				out.println("<table border='0' width='60%' align='center'>");
				out.println("<tr>");
				out.println("<td>");
				
				out.println("<table id='tabela' border='1' cellspacing='5' cellspacing='5'> ");				   
				out.println("<thead>");
					out.println("<tr>");				
						out.println("<th><strong>NOME</strong></th>");
						out.println("<th><strong>8-ID</strong></th>");
						out.println("<th><strong>E-MAIL</strong></th>");
						out.println("<th><strong>ÁREA</strong></th>");
						out.println("<th><strong>FUNÇÃO</strong></th>");
						out.println("<th><strong>RESPONSÁVEL</strong></th>");
						out.println("<th><strong>TELEFONE</strong></th>");
						out.println("<th><strong>DATA</strong></th>");
						out.println("<th><strong>STATUS</strong></th>");
						out.println("<th><strong>EDITAR</strong></th>");
						out.println("<th><strong>EXCLUIR</strong></th>");
					out.println("</tr>");				    		    
				out.println("</thead>");						
				out.println("<tbody>");
				
				while(rs1.next()){
				out.println("<tr>");					
								String nome = rs1.getString("nome");
								String id = rs1.getString("id");
								String email = rs1.getString("email");
								String area = rs1.getString("area");	
								String funcao = rs1.getString("funcao");
								String responsavel = rs1.getString("responsavel");
								String telefone = rs1.getString("telefone");
								String data1 = rs1.getString("data");
								String status = rs1.getString("status");
															
								out.println("<td>"+nome+"</td>");
								out.println("<td>"+id+"</td>");
								out.println("<td>"+email+"</td>");
								out.println("<td>"+area+"</td>");
								out.println("<td>"+funcao+"</td>");
								out.println("<td>"+responsavel+"</td>");
								out.println("<td>"+telefone+"</td>");
								out.println("<td>"+data1+"</td>");	
								out.println("<td>"+status+"</td>");	
								
								out.println("<td><a class='link_atualizar' href='atualiza_solicitacaocadastro.jsp?pacao=alterar&codigo="+rs1.getString("codigo")+"&nome="+rs1.getString("nome")+"&id="+rs1.getString("id")+"&email="+rs1.getString("email")+"&area="+rs1.getString("area")+"&funcao="+rs1.getString("funcao")+"&responsavel="+rs1.getString("responsavel")+"&telefone="+rs1.getString("telefone")+"&obs="+rs1.getString("obs")+"&data="+rs1.getString("data")+"&status="+rs1.getString("status")+"'><img alt='' title='Atualizar' height='20' width='27' src='img/alterar.gif'></a></td>");//Por motivo de segurança, toda vez que for atualizar algum dado a senha e nivel de acesso apagado.
								out.println("<td><a class='link_delete' href='consulta_solicitacaocadastro.jsp?acao=excluir&codigo="+rs1.getString("codigo")+"'><img alt='' title='Excluir' height='20' width='27' src='img/delete.gif'></a></td>");
					out.println("</tr>");				
				}			
			    String sqlConta = "select count(*) AS contaRegistros from solicitacaocadastro";
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
					out.println("<li><a href=consulta_solicitacaocadastro.jsp?numpagina="+pagAnterior+"> Página Anterior </a></li>");
					out.println("</ul>");
				}			
				for(int i=1;i<=totalPaginas;i++){
					if(i == Integer.parseInt(numPagina))
						out.println();// aqui pode ser colocado o i, esta vazio porque fica mostrando na página
					else
						out.println("<a href=consulta_solicitacaocadastro.jsp?numpagina="+i+"></a>");
						out.println("<ul class='pagination'>");
						out.println("<li><a href=consulta_solicitacaocadastro.jsp?numpagina="+i+">"+ i +"</a></li>");
						out.println("</ul>");
				}
				
				int proximaPag;
				if(totalRegistros - (Integer.parseInt(numPagina) * limite) > 0){
					proximaPag = Integer.parseInt(numPagina) + 1;
					out.println("<ul class='pagination'>");
					out.println("<li><a href=consulta_solicitacaocadastro.jsp?numpagina="+proximaPag+"> Próxima Página</a></li>");
					out.println("</ul>");
				}					
				out.println("</tbody>");
				
				st.close();
				rsConta.close();				
				con.close();
				
				}
				
				catch(SQLException erroSQL)
				{
					out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
					
					/*Alert com confirmação de cadastro*/
					PrintWriter oPrintWriter = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Classe de conexão com o Banco de Dados!');");  
					out.println("</script>");
				}finally{
					 // fecha todos os recursos e devolve a conexao ao pool
			        if (rs1 != null && !rs1.isClosed() ) {
			            try { rs1.close(); } catch (SQLException e) { ; }
			            rs1 = null;
			        }
			        if (st != null && !st.isClosed() ) {
			            try { st.close(); } catch (SQLException e) { ; }
			            st = null;
			        }
			        if (con != null && !con.isClosed() ) {
			            try { con.close(); } catch (SQLException e) { ; }
			            con = null;
			        }
				}
				out.println("</table>");	
				
				out.println("</tr>");
				out.println("</td>");
				out.println("</table>");
			out.println("</div'>");
			
			ps.close();
			rs1.close();				
			con.close();
	        %>        
		</form>
		</div>
		<br><br><br>
		<%@include file="rodape.jsp" %>
	</body>
</html>