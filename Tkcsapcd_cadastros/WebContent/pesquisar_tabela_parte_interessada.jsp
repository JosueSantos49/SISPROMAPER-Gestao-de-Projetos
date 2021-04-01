<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page language="java" import = "java.util.*" import = "java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
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

<title>Relatório Tabela Parte Interessada</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="bootstrap/css/prettify.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-modal-bs3patch.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-modal.css" rel="stylesheet" />
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
						sql = "select * from tbparteinteressada where codigoprojeto like '"+request.getParameter("consProjeto")+"'";
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta
						
						//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
												
						while(rs.next())
						{	
					%>
		
	<div class="container">	
	
		<div class="modal-header"><h3>RELATÓRIO PARTE INTERESSADA</h3></div>
										
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente de Portfólios</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
								<th>Código Projeto</th>
					    		<th>Nome</th>
					    		<th>E-mail</th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="codigoprojeto" name="codigoprojeto" value="<%=rs.getString("codigoprojeto")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);" required="true" disabled="disabled"disabled="disabled"/></td>			
									<td><input type="text" id="nomegrport" name="nomegrport" value="<%=rs.getString("nomegrport")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  disabled="disabled"/></td>
									<td><input type="text" id="emailgrport" name="emailgrport" value="<%=rs.getString("emailgrport")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" disabled="disabled"/></td>
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfgrport" name="cpfgrport" value="<%=rs.getString("cpfgrport")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"disabled="disabled"/></td>
									<td><input type="text" id="fonegrport" name="fonegrport" value="<%=rs.getString("fonegrport")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2"disabled="disabled"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>Outros dados:</th>
					    		<th></th>
					    		<th></th>
					    	</tr>
					    		<tr>
									<td>
										<div class="form-group">
										  <label for="comment">Descrever:</label>
										   <textarea id="outrosport" name="outrosport" disabled="disabled" rows="5" cols="50" onkeyup="mostrarResultadoEtapa1(this.value,700,'spcontando0');contarCaracteresEtapa1(this.value,700,'sprestante0')"><%=rs.getString("outrosport")%></textarea>
										
											<h5 align="left">
												<font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family: Arial;"></span></font>
											</h5>
											<h5 align="left">
												<font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family: Arial;"></span></font>
											</h5>
										</div>
									</td>
									<td></td>
									<td></td>
								</tr>	
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim gerente portifólio -->
	
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente de Programas</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th>Telefone</th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomegrprograma" name="nomegrprograma" value="<%=rs.getString("nomegrprograma")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  disabled="disabled"/></td>
									<td><input type="text" id="emailgrprograma" name="emailgrprograma" value="<%=rs.getString("emailgrprograma")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" disabled="disabled"/></td>										
							 		<td><input type="text" id="fonegrprograma" name="fonegrprograma" value="<%=rs.getString("fonegrprograma")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"disabled="disabled"/></td>								
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Gerente de Programas -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente de Projetos</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th>Telefone</th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomegrprojeto" name="nomegrprojeto" value="<%=rs.getString("nomegrprojeto")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  disabled="disabled"/></td>
									<td><input type="text" id="emailgrprojeto" name="emailgrprojeto" value="<%=rs.getString("emailgrprojeto")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" disabled="disabled"/></td>										
							 		<td><input type="text" id="fonegrprojeto" name="fonegrprojeto" value="<%=rs.getString("fonegrprojeto")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"disabled="disabled"/></td>								
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Gerente de Projetos -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Equipe de Gerenciamento do Projeto</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
								<th>Equipe Gerenciamento Projeto:</th>
					    		<th>E-mail:</th>
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" class="form-control" id="nomeegprojeto" name="nomeegprojeto" value="<%=rs.getString("nomeegprojeto")%>" style="height: 30px; width: 379px" autocomplete="off" placeholder=""disabled="disabled"/></td>
									<td><input type="text" id="emaileqprojeto" name="emaileqprojeto" value="<%=rs.getString("emaileqprojeto")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"disabled="disabled"/></td>
									<td></td>									
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Gerente de Programas -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente Funcional</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomegrfuncional" name="nomegrfuncional" value="<%=rs.getString("nomegrfuncional")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"disabled="disabled"/></td>
									<td><input type="text" id="emailgrfuncional" name="emailgrfuncional" value="<%=rs.getString("emailgrfuncional")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" disabled="disabled"/></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfgrfuncional" name="cpfgrfuncional" value="<%=rs.getString("cpfgrfuncional")%>"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"disabled="disabled"/></td>
									<td><input type="text" id="fonegrfuncional" name="fonegrfuncional" value="<%=rs.getString("fonegrfuncional")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"disabled="disabled"/></td>			
									<td></td>										
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim gerente funcional -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Patocinadores</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomepatrocinador" name="nomepatrocinador" value="<%=rs.getString("nomepatrocinador")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  disabled="disabled"/></td>
									<td><input type="text" id="emailpatrocinador" name="emailpatrocinador" value="<%=rs.getString("emailpatrocinador")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" disabled="disabled"/></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfpatrocinador" name="cpfpatrocinador" value="<%=rs.getString("cpfpatrocinador")%>"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"disabled="disabled"/></td>
									<td><input type="text" id="fonepatrocinador" name="fonepatrocinador" value="<%=rs.getString("fonepatrocinador")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"disabled="disabled"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>CNPJ</th>
					    		<th>Investimento</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cnpjpatrocinador" name="cnpjpatrocinador" value="<%=rs.getString("cnpjpatrocinador")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"disabled="disabled"/></td>
									<td><input type="text" id="investimento" name="investimento" value="<%=rs.getString("investimento")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"disabled="disabled"/></td>			
									<td></td>										
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim gerente funcional -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Fornecedores / Parceiros Comerciais</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomefornecedor" name="nomefornecedor" value="<%=rs.getString("nomefornecedor")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"disabled="disabled"/></td>
									<td><input type="text" id="emailfornecedor" name="emailfornecedor" value="<%=rs.getString("emailfornecedor")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" disabled="disabled"/></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpffornecedor" name="cpffornecedor" value="<%=rs.getString("cpffornecedor")%>"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"disabled="disabled"/></td>
									<td><input type="text" id="fonefornecedor" name="fonefornecedor" value="<%=rs.getString("fonefornecedor")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"disabled="disabled"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>CNPJ</th>
					    		<th>Investimento</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cnpjfornecedor" name="cnpjfornecedor" value="<%=rs.getString("cnpjfornecedor")%>" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"disabled="disabled"/></td>
									<td><input type="text" id="investimentoforne" name="investimentoforne" value="<%=rs.getString("investimentoforne")%>" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2"disabled="disabled"/></td>			
									<td></td>										
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Fornecedores / Parceiros Comerciais -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Equipe de Projeto</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
								<th>Nome:</th>
					    		<th>Setor da Empresa:</th>
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" class="form-control" id="nomeequipeproj" name="nomeequipeproj" value="<%=rs.getString("nomeequipeproj")%>" style="height: 30px; width: 379px" autocomplete="off" placeholder="" disabled="disabled"/></td>
									<td><input type="text" id="setorequipeproj" name="setorequipeproj" value="<%=rs.getString("setorequipeproj")%>" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"disabled="disabled"/></td>
									<td></td>									
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Equipe de Projeto -->
				         <br>

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
					
				<br>		
		</div>
	
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarTabelaParteInteressada'" title="Voltar página"></input>

		      </span></div></td>
		    </tr>
		  </table>
		</div>
	
</body>
</html>