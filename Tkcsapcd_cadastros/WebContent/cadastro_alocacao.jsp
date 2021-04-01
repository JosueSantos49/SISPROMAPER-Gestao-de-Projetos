<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page import="br.com.tkcsapcd.model.util.Valida"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Alocacao"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.RecursosHumanos"%>
<%@ page import="br.com.tkcsapcd.model.bean.RecursosHumanos"%>

<%@include file="include.jsp" %><!-- Depois que coloquei o include, a cor do tratamento de erro funcionou. -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Cadastrar Alocação</title> 

<link rel="stylesheet" href="css/formatarformulariobutomelegante.css" type="text/css">
<%@include file="includedialogo.jsp" %>
<%@include file="includemascara.jsp" %>

<!-- datatable 1.10.0-->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<!-- <script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script> -->
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/validaFormularioAlocacao.js"></script>
		
<!-- Calendário -->
<script>
			$(function() {
				$("#data").datepicker({
					dateFormat: 'dd/mm/yy',
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>
<script>
			$(function() {
				$("#data0").datepicker({
					dateFormat: 'dd/mm/yy',
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>

<!-- Dialogo -->		
<script type="text/javascript">		
		$(function(){
			$("#dialog").dialog({
				height: 150,
				modal:true,
				buttons: {
					"Ok":function(){
						$(this).dialog("close");
					}
				}
			});			
		});	
</script>

<script type="text/javascript" ></script>

<script type="text/javascript">
	$(document).ready(function(){			
		$("#dataProjeto").mask("99/99/9999"); //dataProjeto  
	});
</script>	 

<script>
	$(function() {
	$("#").datepicker({//dataProjeto
		showOn : "button",
		buttonImage : "/Tkcsapcd_cadastros/img/calendar.gif",
		buttonImageOnly : true
	});
});
</script>

<script>
	function show_confirm()
	{
		
		var r=confirm("Click em OK, para continuar!");
		if(r==true)
			{
			alert("Continuando...");
			return true;
			}
		else
			{
				alert("Click em OK, para cancelar!");
				location.href="TkcsapcdController?cmd=consultarProjeto";
				
			}		
	}
</script>

<script type="text/javascript">	function setFocus() {  	document.getElementById("autorProjeto").focus(); }</script>

<!-- Função p/ exportar para Excell -->
<script src="excellentexport-master/excellentexport.js"></script>
<style>table, tr, td {border: 0px black solid;}</style>

</head>

<%	Valida valida = new Valida();	valida.validasessao(); %>

<script type="text/javascript">
	function carregarProfissao(){
		var recursosHumanos = new Object();
		recursosHumanos.codigo = document.getElementById("recursoshumanos_codigo").value;		
	}
</script>

<body bgcolor="#ededed" onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssalocacao.jsp" %>

<div align="center">	
	
	<div align="center"><p><font color="red">Cadastrar Alocação - Campos de (*) obrigatório!</font></p></div>
	
		<form action="TkcsapcdController" id="formularioAlocacao"	name="formularioAlocacao" onsubmit="validaalocacao();">
			
			<center><h3><font color="green"> ${mensagem}</font></h3></center>
					
			<div id="dialog"><p><font color="red">Campos de (*) obrigatório!</font></p></div>
			<br>
			
			<input type="hidden" name="cmd" value="cadastrarAlocacao"></input>
			<div class="table-responsive">
			<table>
				<thead>
					<tr>
						<th>						
			
						
						</th>
						<th></th>
					</tr>
				</thead>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
				</tr>
				<tr>
					<td><br></td>
					<td>
						<div align="left">
							<!-- <input id="data" name="data" style="height: 12px; width: 100px"	value="${alocacao.data}" class="input"></input> ---- <input id="data" name="data" style="height: 12px; width: 100px"	value="${alocacao.data}" class="input"></input>	 -->					
						</div>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><br></td>
					<td>
						
					</td>
					<td colspan="20">
						<div align="center">
							<input id="data" name="data" style="height: 12px; width: 100px"	value="${alocacao.data}" class="input"></input><font color="red">*</font> ----------- <input id="data0" name="data0" style="height: 12px; width: 100px"	value="${alocacao.data0}" class="input"></input><font color="red">*</font>						
						</div>
					</td>
				</tr>				
				<tr>
					<td align="left">Projeto <font color="red">*</font></td>					
					<td>
							
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><br>
					<div align="left">		
						<select id="projeto_codigo"	name="projeto_codigo">
						<option id="projeto_codigo">Selecione</option>
								<%
									List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
									for(ProjetoInicio ProjetoInicio: projetoInicios){
										out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
												                      + ProjetoInicio.getCodigoprojeto());
									}
								%>
						</select>							
					</div>						
					<br></td>
					<td></td>
					<td colspan="20"><center><font color="#A9E2F3">FY14/15 *</font> ------------------------------------------------------- <font color="#FA8258">FY15/16 *</font></center></td>
				</tr>
				<tr>
					<td><br></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>				
				<tr>
					<td align="left">Recursos Humanso <font color="red">*</font></td>
					<td align="left">Profissão <font color="red">*</font></td>
					<td width="80px" bgcolor="#A9E2F3">Apr</td>
					<td width="80px" bgcolor="#A9E2F3">May</td>
					<td width="80px" bgcolor="#A9E2F3">Jun</td>
					<td width="80px" bgcolor="#A9E2F3">Jul</td>
					<td width="80px" bgcolor="#A9E2F3">Aug</td>
					<td width="80px" bgcolor="#A9E2F3">Sep</td>
					<td width="80px" bgcolor="#FA8258">Oct</td>
					<td width="80px" bgcolor="#FA8258">Nov</td>
					<td width="80px" bgcolor="#FA8258">Dec</td>
					<td width="80px" bgcolor="#FA8258">Jan</td>
					<td width="80px" bgcolor="#FA8258">Feb</td>
					<td width="80px" bgcolor="#FA8258">Mar</td>
					<td width="80px" bgcolor="#FA8258">Apr</td>
					<td width="80px" bgcolor="#FA8258">May</td>
					<td width="80px" bgcolor="#FA8258">Jun</td>
					<td width="80px" bgcolor="#FA8258">Jul</td>
				</tr>
				<tr>
					<td><br>
						<div align="left">
							<select id="recursoshumanos_codigo"	name="recursoshumanos_codigo">
								<option id="recursoshumanos_codigo">Selecione</option>
									<%
									List<RecursosHumanos> recursosHumanoss = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
									for(RecursosHumanos recursosHumanos: recursosHumanoss){
											out.println("<option value='" + recursosHumanos.getNome() + "'>"
													                      + recursosHumanos.getNome());
										}
									%>
							</select>
						</div>
						<br>
					</td>
					<td><br>
						<div align="left">
							<select id="profissao_codigo"	name="profissao_codigo">
								<option id="profissao_codigo">Selecione</option>
									<%
									List<RecursosHumanos> recursosHumanossProfissao = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
									for(RecursosHumanos recursosHumanos: recursosHumanoss){
											out.println("<option value='" + recursosHumanos.getProfissao() + "'>"
													                      + recursosHumanos.getProfissao());
										}
									%>
							</select>
						</div>
						<br>
					</td>
					<td><input id="metrica1" name="metrica1" style="height: 12px; width: 30px"	value="${alocacao.metrica1}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica2" name="metrica2" style="height: 12px; width: 30px"	value="${alocacao.metrica2}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica3" name="metrica3" style="height: 12px; width: 30px"	value="${alocacao.metrica3}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica4" name="metrica4" style="height: 12px; width: 30px"	value="${alocacao.metrica4}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica5" name="metrica5" style="height: 12px; width: 30px"	value="${alocacao.metrica5}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica6" name="metrica6" style="height: 12px; width: 30px"	value="${alocacao.metrica6}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica7" name="metrica7" style="height: 12px; width: 30px"	value="${alocacao.metrica7}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica8" name="metrica8" style="height: 12px; width: 30px"	value="${alocacao.metrica8}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica9" name="metrica9" style="height: 12px; width: 30px"	value="${alocacao.metrica9}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica10" name="metrica10" style="height: 12px; width: 30px"	value="${alocacao.metrica10}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica11" name="metrica11" style="height: 12px; width: 30px"	value="${alocacao.metrica11}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica12" name="metrica12" style="height: 12px; width: 30px"	value="${alocacao.metrica12}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica13" name="metrica13" style="height: 12px; width: 30px"	value="${alocacao.metrica13}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica14" name="metrica14" style="height: 12px; width: 30px"	value="${alocacao.metrica14}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica15" name="metrica15" style="height: 12px; width: 30px"	value="${alocacao.metrica15}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica16" name="metrica16" style="height: 12px; width: 30px"	value="${alocacao.metrica16}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
				</tr>	
			</table>
			</div>
  			<input class="button" type="submit" value="Cadastrar" onclick="show_confirm();" onchange="validaalocacao;" ></input>
			<input class="button" type="reset" value="Limpar" ></input>	
			<input class="button" type="button" name="cancelar" onclick="document.location.href='sair.jsp'" value="Sair" title="Encerrar sessão" />				
		</form>		
	</div>
	
	<hr>
	
	<div align="center">
	<br>
	<div class="table-responsive">
	<table id="tabela" cellspacing="5" cellspacing="5" class="display">	    
	    <thead>
	    <tr bgcolor="#CCCCCC">
	      <td><strong>Cód. Projeto</strong></td>
	      <td><strong>RH</strong></td>
	      <td><strong>Profissão</strong></td>
	      <td><strong>Dt Início</strong></td>
	      <td><strong>Dt Término</strong></td>
	      <td><strong>May</strong></td>
	      <td><strong>Jun</strong></td>
	      <td><strong>Jul</strong></td>
	      <td><strong>Aug</strong></td>
	      <td><strong>Sep</strong></td>
	      <td><strong>Oct</strong></td>
	      <td><strong>Nov</strong></td>
	      <td><strong>Dec</strong></td>
	      <td><strong>Jan</strong></td>
	      <td><strong>Feb</strong></td>
	      <td><strong>Mar</strong></td>
	      <td><strong>Apr</strong></td>
	      <td><strong>May</strong></td>
	      <td><strong>Jun</strong></td>
	      <td><strong>Jul</strong></td>	      												
	    </tr>
	    </thead>
	    <%
			try
			{
				Connection con = ConexaoHelper.conectar();	
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				//Deletar registro
				//Perguntar se teve ação(usuario.jsp?acao=excluir&codigo=<rs.getString("codigo")) de exclusão.
				if(request.getParameter("acao") != null)
				{
					//executar uma atualização
					st.executeUpdate("delete from alocacao where codigo = "+request.getParameter("codigo"));
				}
				
				//Implementando função ordenação de orden Crescente e Alfabetica
				ResultSet rs = null;
				
				if(request.getParameter("ordenacao") == null)
					{
						rs = st.executeQuery("select * from alocacao order by codigo");
					}
				else if(request.getParameter("ordenacao").equals("crescente"))
					{
						rs = st.executeQuery("select * from alocacao");
					}		
				else if(request.getParameter("ordenacao").equals("alfabetica"))
					{
						rs = st.executeQuery("select * from alocacao order by codigo");
					}
				
				//executeQuery é usado para retorna uma consulta
				//ResultSet rs = st.executeQuery("select * from login");
				
				while(rs.next())
				{	
			%>
	   	<tbody>	    	
	    
			<tr bgcolor="#FFFFFF"><!--Vai preencher a tabela com os registros nesta linha-->		
	          <td><%=rs.getString("projeto_codigo")%></td>          
	          <td><%=rs.getString("recursoshumanos_codigo")%></td>
	          <td><%=rs.getString("profissao_codigo")%></td>
	          <td><%=rs.getString("data")%></td>
	          <td><%=rs.getString("data0")%></td>
	          <td><%=rs.getString("metrica1")%></td>
	          <td><%=rs.getString("metrica2")%></td>
	          <td><%=rs.getString("metrica3")%></td>
	          <td><%=rs.getString("metrica4")%></td>
	          <td><%=rs.getString("metrica5")%></td>
	          <td><%=rs.getString("metrica6")%></td>
	          <td><%=rs.getString("metrica7")%></td>
	          <td><%=rs.getString("metrica8")%></td>
	          <td><%=rs.getString("metrica9")%></td>
	          <td><%=rs.getString("metrica10")%></td>
	          <td><%=rs.getString("metrica11")%></td>
	          <td><%=rs.getString("metrica12")%></td>
	          <td><%=rs.getString("metrica13")%></td>
	          <td><%=rs.getString("metrica14")%></td>
	          <td><%=rs.getString("metrica15")%></td>
	        </tr>
		<%
				}
			}
				
				catch(SQLException erroSQL)
				{
					out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
			}
		%>
		</tbody>
	  </table>
	  </div>
	<br>
	</div>
	
	<hr><br>			
	</body>
</html>