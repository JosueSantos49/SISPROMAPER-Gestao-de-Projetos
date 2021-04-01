<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
 <%@ page import="br.com.tkcsapcd.model.helper.ConexaoHelper" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*" import="java.util.Date" import="java.util.*" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Cliente"%>

<html>

<jsp:include page="sessao.jsp" />
<% 

	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
		
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Pesquisar SSTI</title>

</head>

<body>

		<br>		
			  <%
			    Connection con = null;
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
						sql = "select * from solicitacaoservicoti where codigosolicitaoservico like '"+request.getParameter("consSSTI")+"'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
						
						while(rs.next())
						{	
					%>
				    	<br>
						<div align="center" >    								
							<table style="border: 1px solid;" width="900px"	align="center"	border="0" bordercolor="gray" cellpadding="3">
							<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
							<tr>
					        	<td align="center" colspan="0" bordercolor="gray"><center><strong><font color="#0404B4"><h2>RELATÓRIO SOLICITAÇÃO SERVIÇO DE TECNOLOGIA DA INFORMAÇÃO</h2></font></strong><hr></center></td>					        				        	
					        	<!-- <td bgcolor="#FFFFFF">&nbsp;<img align="left" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/logorelatorio.gif"> </td> -->
					        </tr> 
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Código do Projeto..:</strong> <%=rs.getString("codigoprojeto")%></td>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Código SSTI..:</strong> <%=rs.getString("codigosolicitaoservico")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Área..:</strong> <%=rs.getString("area")%></td>
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Responsável pela demanda..:</strong> <%=rs.getString("responsaveldemanda")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>					  							  
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Telefone..:</strong> <%=rs.getString("telefonecontato")%></td>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Data de Solicitação ..:</strong> <%=rs.getString("datasolicitacao")%></td>		        				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>					        	
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>ID..:</strong> <%=rs.getString("id")%></td>
							  	<td bgcolor="#FFFFFF">&nbsp;<strong>Email..:</strong> <%=rs.getString("email")%></td>
							  				
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>	
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Principais Usuários..:</strong> <%=rs.getString("principaisusuarios")%></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>
					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Nome da demanda..:</strong><br><br><font >&nbsp;<%=rs.getString("nomedemanda")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Objetivo da demanda..:</strong><br><br><font >&nbsp;<%=rs.getString("objetivodemanda")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Decrição do Problema..:</strong><br><br><font >&nbsp;<%=rs.getString("decricaoproblema")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Desenho do Processo..:</strong><br><br><font >&nbsp;<%=rs.getString("desenhoprocesso")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Funcionalidade..:</strong><br><br><font >&nbsp;<%=rs.getString("funcionalidade")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Partes Envolvidas..:</strong><br><br><font >&nbsp;<%=rs.getString("parteenvolvida")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Parte Envolvida Representante..:</strong><br><br><font >&nbsp;<%=rs.getString("parteenvolvidarepresentante")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Parte Envolvida/Forma Contato..:</strong><br><br><font >&nbsp;<%=rs.getString("parteenvolvidaformacontato")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Recursos..:</strong> <%=rs.getString("recursos")%></td>		        				
					         </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Estimativa de Custo Global..:</strong><br><br><font >&nbsp;<%=rs.getString("estimativacustoglobal")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Fonte de Finaciamento ..:</strong><br><br><font >&nbsp;<%=rs.getString("fontefinanciamento")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Método Levantamento de Custo..:</strong><br><br><font >&nbsp;<%=rs.getString("metodolevantamentocusto")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Numero de Usuário Previsto..:</strong><br><br><font >&nbsp;<%=rs.getString("numerousuarioprevisto")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Treinamento do Pessoal..:</strong> <%=rs.getString("treinamentopessoal")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Material de Apoio..:</strong> <%=rs.getString("materialapoio")%></td>		        				
					         </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Restrição do Projeto..:</strong><br><br><font >&nbsp;<%=rs.getString("restricaoprojeto")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Necessidade dos Usuários ..:</strong><br><br><font >&nbsp;<%=rs.getString("necessidadeusuario")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Prioridade..:</strong> <%=rs.getString("prioridade")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Solucao Atual ..:</strong> <%=rs.getString("solucaoatual")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Problema c/ solucao atual..:</strong> <%=rs.getString("problemasolucaoatual")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>					       
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Solucao Proposta..:</strong> <%=rs.getString("solucaoproposta")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="justify" bgcolor="#FFFFFF">&nbsp;<strong>Status..:</strong> <%=rs.getString("status")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>					        
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data de Relatório Gerado..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora de Relatório Gerado..:</strong> <%=mostra_hora %></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>				      					         
				         </table>
				         </div>
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
			
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarSolicitacaoServicoTI'" title="Voltar página"></input>
		      </span></div></td>
		    </tr>
		  </table>
		</div>
</body>
</html>