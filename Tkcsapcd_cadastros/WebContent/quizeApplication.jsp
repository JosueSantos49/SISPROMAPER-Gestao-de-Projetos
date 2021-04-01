<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questões Gerenciamento de Projeto</title>
<%@include file="configuracao_relatorio_link_css_js.jsp" %>
</head>
<body>
<div class="container">
<% 
        Connection con = ConexaoHelper.conectar();
		Statement st = null;
		ResultSet rs = null;
				
		try {			
			//Processo Paginação
			int limite = 1;// quantidade de resultados por página
			String numPagina = request.getParameter("numpagina");
			
			if(numPagina == null){
				numPagina = "1";
			}
			
			int offset = (Integer.parseInt(numPagina) * limite) - limite;
			//out.println("Limite = "+limite);
			//out.println("numPagina = "+numPagina);
			//out.println("Offset = "+offset+"<br><br>");	
			
			String sql1 = "select * from questiniciacao LIMIT 1 OFFSET 0"+offset;
			PreparedStatement ps = con.prepareStatement(sql1);
		    rs = ps.executeQuery();
			//Processo Paginação		
	
			String ans=" ";			
			if(request.getParameter("correctAns")!=null)
			{ans=request.getParameter("correctAns").toString();}
				
			String s,g;	
			int count=0;
			
			//st = con.createStatement();
			//rs = st.executeQuery("select * from questiniciacao");	
			
			while(rs.next()) {
%>
<br><br/>

	<table border="1" width="1000px" bgcolor="" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="100%">	
			<form name="form1">				
				<h3 align="center"><font color="red">QUESTÕES GERENCIAMENTO DE PROJETOS</font></h3>				
				<b>Escolha a resposta correta!</b>
					<table border="0" width="600px" cellspacing="2" cellpadding="4">
						<tr>				
						<td width="50%"> Questão:</td>
						<input type="hidden" name="correctAns" value="<%=rs.getString(7)%>" />
						<tr>
						<td><%= rs.getString("quest") %></td></tr>
						<tr>
						<td>
						
						1: <input type="radio" name="a" value= "QA" /></td>
						    <td><%= rs.getString("QA") %></td></tr> 
						<tr>
						<td>
						2: <input type="radio" name="a" value="QB" /></td>
						<td><%= rs.getString("QB") %></td></tr>
						
						<tr>
						<td>
						3: <input type="radio" name="a" value="QC" /></td>
						<td><%= rs.getString("QC") %> </td></tr>
						
						<tr>
						<td>
						4: <input type="radio" name="a" value="QD" /> </td>
						<td> <%= rs.getString("QD") %> </td></tr>
						
						<tr>
						<td>
						<center>
				   		<input type="submit" value="Verificar resposta!" name="submit">
				   		<a href="index_principal.jsp" class="">Home</a>
				   		</center></td></tr>	
				</table>				
			</form>
	 		</td>
		</tr>
	</table>

<%
//Processo Paginação
String sqlConta = "select count(*) AS contaRegistros from questiniciacao";
PreparedStatement psConta = con.prepareStatement(sqlConta);
ResultSet rsConta = psConta.executeQuery();
rsConta.next();

int totalRegistros = Integer.parseInt(rsConta.getString("contaRegistros"));
int totalPaginas = totalRegistros / limite;

if(totalRegistros % limite != 0)
	totalPaginas++; 
out.println("Total Perguntas: "+totalRegistros);
//out.println("Total de páginas a serem mostradas: "+totalPaginas);

int pagAnterior;
if(Integer.parseInt(numPagina) > 1){
	pagAnterior = Integer.parseInt(numPagina) -1;
	out.println("<ul class='pagination'>");
	out.println("<li><a href=quizeApplication.jsp?numpagina="+pagAnterior+"> << Anterior </a></li>");
	out.println("</ul>");
}			
for(int i=1;i<=totalPaginas;i++){
	if(i == Integer.parseInt(numPagina))
		out.println();// aqui pode ser colocado o i, esta vazio porque fica mostrando na página
	else
		out.println("<a href=quizeApplication.jsp?numpagina="+i+"></a>");
		out.println("<ul class='pagination'>");
		out.println("<li><a href=quizeApplication.jsp?numpagina="+i+">"+ i +"</a></li>");
		out.println("</ul>");
}											
int proximaPag;
if(totalRegistros - (Integer.parseInt(numPagina) * limite) > 0){
	proximaPag = Integer.parseInt(numPagina) + 1;
	out.println("<ul class='pagination'>");
	out.println("<li><a href=quizeApplication.jsp?numpagina="+proximaPag+"> Próxima >> </a></li>");
	out.println("</ul>");
}
//Fim Processo Paginação
%>
<br>
<% 
	//Aqui pode ser adicionada a regra de confirmação da resposta, porem, ocorre duplicação de resposta.
	//Cada campo do form esta com o name (a), onde, é atribuido na variavel (g). 
	g=request.getParameter("a");
	out.println("Name "+g);
	
	
	%>	
	<% 
	//o valor de cada campo é comparado com a resposta ans. Se tiver algum valor do campo igual a ans valida.
	if(g.equals(ans)){
		count++;		
		out.println("Correta resposta");
	}
	else{
		out.println("Falsa resposta");
	}
%>

<%
	}
		//Confirmação de resposta com saida para o usuário fora do laço para não aver duplicação de resposta.
} 
catch (Exception ex) {
ex.printStackTrace();
%>

<%

} finally {
	if (rs != null) rs.close();	if (st != null) st.close();	if (con != null) con.close();
}		
		
%>  
<div>
</body>      
</html>