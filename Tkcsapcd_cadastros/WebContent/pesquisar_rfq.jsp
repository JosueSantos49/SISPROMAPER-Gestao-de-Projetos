<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" import = "java.util.*" import = "java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Relatório Pedido de Cotação</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/validaPesquisarRelatorioProjeto.js"></script>

</head>

<body>

		<br><br>		

		<div align="center">
			  <%Connection con = null;
			    Statement st = null;  // Ou PreparedStatement
			    ResultSet rs = null;
					try
					{
						//Implementando Data e Hora
						Date data = new Date();//criando objeto tipo Date e inicializando 
						SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
						String mostra_data = data_formatada.format(data); //Variável para armazenar a data
						
						SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
						String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
						
						con = ConexaoHelper.conectar();						
						st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						
						//Implementando função ordenação de orden Crescente e Alfabetica
						//ResultSet rs = null;
						
						String sql;
						sql = "select * from rfq where numerorfq like '"+request.getParameter("consProjeto")+"'";
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta
						
						//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
												
						while(rs.next())
						{	
					%>
				    	<!--Vai preencher a tabela com os registros nesta linha-->
						
						<div class="container">	  								
							<table class="table" style="border: 0px solid;"	align="center"	border="0" bordercolor="gray" cellpadding="2" width="700px">
							
							<tr>
					        	<td align="center" colspan="0" bordercolor="gray"><center><strong><h2>RELATÓRIO PEDIDO DE COTAÇÃO</h2></strong><hr></center></td>
					        	<td></td>					        				        						        				        	
					        </tr> 	
					        <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Numero RFQ..:</strong> <%=rs.getString("numerorfq")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Prazo Entrega..:</strong> <%=rs.getString("prazoentrega")%></td>
					         </tr>
					        <tr>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Data Emissão..:</strong> <%=rs.getString("data")%></td>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Data Limite..:</strong> <%=rs.getString("datalimite")%></td>	
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Contato Comercial..:</strong> <%=rs.getString("contatocomercial")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Contato Técnico..:</strong> <%=rs.getString("contatotecnico")%></td>						  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Termo Pagamento..:</strong> <%=rs.getString("termopagamento")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Tempo de Garantia..:</strong> <%=rs.getString("tempogarantia")%></td>						  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Empresa..:</strong> <%=rs.getString("empresa")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Endereço..:</strong> <%=rs.getString("endereco")%></td>						  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Estado..:</strong> <%=rs.getString("estado")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Cidade..:</strong> <%=rs.getString("cidade")%></td>						  				
					         </tr>	
					         <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Telefone..:</strong> <%=rs.getString("telefone")%></td>	
					        	<td></td>					  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Valor Total..:</strong> <%=rs.getString("total")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Frete..:</strong> <%=rs.getString("frete")%></td>						  				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	
					         <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Outras Condições..:</strong><br><%=rs.getString("outracondicao")%></td>					        					        	
					        </tr>					        
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data de Relatório Gerado..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora de Relatório Gerado..:</strong> <%=mostra_hora %></td>
					        </tr>					       					      					         
				         </table>
				         
				         					<div class="table-responsive">
				         						<!-- 20 linhas com codigoitem, decricao, qtd, puitem.  -->
												<table id="tabela" cellspacing="5" cellspacing="5" class="table" style="border: 0px solid;">
													<thead>
														<tr class="success">
															<th>Item</th>
															<th>Descrição</th>
															<th>Quantidade</th>
															<th>Preço Unitário</th>
														</tr>
													</thead>
													<tbody>
														<!-- 1 linha -->
														<tr class="">		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem1")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao1")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd1")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem1")%>" disabled="disabled" size="1" class="form-control" />
															</td>
														</tr>	
														<!-- fim 1 linha -->	
														
														<!-- 2 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem2")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
																
															<td>
																<input type="text" value="<%=rs.getString("descricao2")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd2")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem2")%>" disabled="disabled" size="1" class="form-control" />
															</td>
														</tr>
														<!-- fim 2 linha -->	
														
														<!-- 3 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem3")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao3")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd3")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem3")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 3 linha -->
														
														<!-- 4 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem4")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao4")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd4")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem4")%>" disabled="disabled" size="1" class="form-control" />
															</td>													
														</tr>
														<!-- fim 4 linha -->
														
														<!-- 5 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem5")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao5")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd5")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem5")%>" disabled="disabled" size="1" class="form-control" />
															</td>															
														</tr>
														<!-- fim 5 linha -->
														
														<!-- 6 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem6")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao6")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd6")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem6")%>" disabled="disabled" size="1" class="form-control" />
															</td>															
														</tr>
														<!-- fim 6 linha -->
														
														<!-- 7 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem7")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao7")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd7")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem7")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 7 linha -->
														
														<!-- 8 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem8")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao8")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd8")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem8")%>" disabled="disabled" size="1" class="form-control" />
															</td>												
														</tr>
														<!-- fim 8 linha -->
														
														<!-- 9 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem9")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao9")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd9")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem9")%>" disabled="disabled" size="1" class="form-control" />
															</td>													
														</tr>
														<!-- fim 9 linha -->
														
														<!-- 10 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem10")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao10")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd10")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem10")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 10 linha -->
														
														<!-- 11 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem11")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao11")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd11")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem11")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 11 linha -->
														
														<!-- 12 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem12")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao12")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd12")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem12")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 12 linha -->
														
														<!-- 13 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem13")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao13")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd13")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem13")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 13 linha -->
														
														<!-- 14 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem14")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao14")%>" disabled="disabled" size="1" class="form-control" />
															</td>
															<td>
																<input type="text" value="<%=rs.getString("qtd14")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem14")%>" disabled="disabled" size="1" class="form-control" />
															</td>																													
														</tr>
														<!-- fim 14 linha -->
														
														<!-- 15 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem15")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao15")%>" disabled="disabled" size="1" class="form-control" />
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("qtd15")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem15")%>" disabled="disabled" size="1" class="form-control" />
															</td>													
														</tr>
														<!-- fim 15 linha -->
														
														<!-- 16 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem16")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao16")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd16")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem16")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 16 linha -->
														
														<!-- 17 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem17")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao17")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd17")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem17")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 17 linha -->
														
														<!-- 18 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem18")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao18")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd18")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem18")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 18 linha -->
														
														<!-- 19 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem19")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao19")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd19")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem19")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 19 linha -->
														
														<!-- 20 linha -->
														<tr>		
															<td>
																<input type="text" value="<%=rs.getString("codigoitem20")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("descricao20")%>" disabled="disabled" size="1" class="form-control" />
															</td>	
															<td>
																<input type="text" value="<%=rs.getString("qtd20")%>" disabled="disabled" size="1" class="form-control" />	
															</td>		
															<td>
																<input type="text" value="<%=rs.getString("puitem20")%>" disabled="disabled" size="1" class="form-control" />
															</td>														
														</tr>
														<!-- fim 20 linha -->
														
													</tbody>
												</table>
											</div>
				         		</div>

					<%
					 		}
						rs.close();
						st.close();
						con.close();
						}
						 
							catch(SQLException erroSQL)
							{
								out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
						}finally{
							 // fecha todos os recursos e devolve a conexao ao pool
						      if (rs != null && !rs.isClosed() ) {
						          try { rs.close(); } catch (SQLException e) { ; }
						          rs = null;
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
					%>				
		</div>	
	
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarRfq'" title="Voltar página"></input>

		      </span></div></td>
		    </tr>
		  </table>
		</div>
	<%@include file="gif_load_page.jsp" %> 
</body>
</html>