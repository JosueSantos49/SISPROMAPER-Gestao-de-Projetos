<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*" import="java.io.PrintWriter" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>	

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da p�gina -->

<title>Alterar Solicita��o Cadastro</title>	
   
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>	
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<link rel="stylesheet" href="css/formatacaoTelaFormularioCadastroUsuario.css" type="text/css">
<script type="text/javascript" src="js/validacadusuario.js"></script>
<script type="text/javascript" src="js/validacaoFormularioUsuarioNivelSelect.js"></script>					
<script type="text/javascript" src="js/validacaoFormularioUsuario.js"></script><!-- A valida��o do formul�rio deve ser depois do n�vel (select) -->
<script type="text/javascript">function setFocus() {document.getElementById("usuario").focus();}</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<% 
	//Testando, usado para teste de pasagem de parametro.
	//out.println("codigo = "+request.getParameter("codigo"));
	//out.println("usuario = "+request.getParameter("usuario"));
	//out.println("senha = "+request.getParameter("senha"));
	//out.println("nivel = "+request.getParameter("nivel"));
	
	if(request.getParameter("acao") == null)
	{ 
	out.println(".");//out.println("N�o ouve a��o");			
%>

<br><br>
			
<div align="center">

	<form name="formcadusu" id="formcadusu" method="post" action="atualiza_solicitacaocadastro.jsp?acao=alterar" ><!-- onSubmit="return validacadusuario(this)" -->
					
			<center><h3><font color="red">${mensagem}</font></h3></center>
					
					<h3>ATUALIZAR SOLICITA��O CADASTRO</h3>
						<br>
						<p><font color="red">Campos de (*) s�o de preenchimento obrigat�rio.</font></p>
						<br>
						 
						<input type="hidden" name="cmd" value="cadastrarSolicitacaoCadastro"></input>
						
						<br>
						<div class="field">
							<label for="codigo">C�digo: </label>
						  	<input type="text" id="codigo" name="codigo" class="input" value="<%=request.getParameter("codigo")%>" maxlength="8" onkeypress="return Letra(event);" required="true">
							<p class="hint">O c�digo n�o dode ser alterado!</p>
						</div>
						 
						<div class="field">
							<label for="nome">Nome: *</label>
						  	<input type="text" id="nome" name="nome" class="input" value="<%=request.getParameter("nome")%>" maxlength="50" required="true" requiredMessage="Insira o usu�rio"></input>
							<p class="hint">Entre com o nome.</p>
						</div>
						
						<br>
						
						<div class="field">
							<label for="id">ID: *</label>
						  	<input type="text" name="id" id="id" class="input" value="<%=request.getParameter("id")%>" maxlength="11" required="true">
							<p class="hint">Entre com a ID.</p>
						</div>
						
						<br>
						
						<div class="field">
							<label for="email">E-mail: *</label>
						  	<input type="text" id="email" name="email" class="input" value="<%=request.getParameter("email")%>" maxlength="50" required="true" requiredMessage="Insira o usu�rio"></input>
							<p class="hint">Entre com o e-mail.</p>
						</div>
						
						<br>
						
						<div class="field">
							<label for="area">�rea: *</label>
						  	<input type="text" name="area" id="area" class="input" value="<%=request.getParameter("area")%>" maxlength="50" required="true">
							<p class="hint">Entre com a �rea.</p>
						</div>
						<br>
						
						<div class="field">
							<label for="funcao">Fun��o: *</label>
						  	<input type="text" name="funcao" id="funcao" class="input" value="<%=request.getParameter("funcao")%>" maxlength="50" required="true">
							<p class="hint">Entre com a Fun��o.</p>
						</div>
						<br>
						
						<div class="field">
							<label for="responsavel">Respons�vel: *</label>
						  	<input type="text" name="responsavel" id="responsavel" class="input" value="<%=request.getParameter("responsavel")%>" maxlength="11" required="true">
							<p class="hint">Entre com o responsavel.</p>
						</div>
						
						<br>
						
						<div class="field">
							<label for="telefone">Telefone: *</label>
						  	<input type="text" name="telefone" id="telefone" class="input" value="<%=request.getParameter("telefone")%>" maxlength="11" required="true">
							<p class="hint">Entre com o telefone.</p>
						</div>
						
						<div class="field">
						<label for="status">Status: *</label>						
						<select id="status" style="width:310px;height: 30px" name="status">
							<option value="0"></option>
							<option value="Solicita��o Acesso">Solicita��o Acesso</option>						
							<option value="Recuperar Acesso">Recuperar Acesso</option>
							<option value="Aguardando Aprova��o">Aguardando Aprova��o</option>
							<option value="concluido">Concluido</option>						
						</select>
						</div>
						
						<br>						
						<div class="field">
							<label for="obs">Observa��o: *</label>
						  	<input type="text" name="obs" id="obs" class="input" value="<%=request.getParameter("obs")%>" maxlength="300" required="true">
							<p class="hint">Entre com a bserva��o.</p>
						</div>
						<br>
						
						<input class="button" type="submit" name="gravar" id="gravar" value="Atualizar" title="Cadastrar Usu�rio" onclick="validacadusuario();">
						<br>
						
				</form>
		</div>
        <!--  Se ouve uma a��o, efetue a conex�o com o BD, para cadastra usu�rio-->
        <% } 
else
{
	//out.println("Ouve a��o");
	
	/*Alert altera��o de usu�rio*/
	PrintWriter oPrintWriter1 = response.getWriter();  
	response.setContentType("text/html");  
	out.println("<script type=\"text/javascript\">");  
	out.println("alert('Aten��o voc� esta na tela de altera��o de usu�rio!');");  
	out.println("</script>");
	
	//Antes de mandar gravar, devo perguntar se os campos obrigat�rios foram preechidos!
	//removido, devido a formata��o da tabela(|| (request.getParameter("tf_codigo").length() <= 0)),o codigo ser� altomatico.
	if((request.getParameter("nome").length() <= 0)|| (request.getParameter("id").length() <=0) || (request.getParameter("email").length() <= 0))	{
		
		//out.println("Aten��o, voc� deve digitar o nome do usu�rio!");		
		response.sendRedirect("consulta_usuarios.jsp");			
	}
	else
	{	 
		try
		{
		//Class.forName("com.mysql.jdbc.Driver");		
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tkcsapcd","root","josue123");	
		InitialContext initialContext = new InitialContext();
		DataSource dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/pool");
		Connection connection = dataSource.getConnection();
	
		Statement st = connection.createStatement();
		
		String sql=("update solicitacaocadastro set nome='"+request.getParameter("nome")+"', id='"+request.getParameter("id")+"', email='"+request.getParameter("email")+"', area='"+request.getParameter("area")+"', funcao='"+request.getParameter("funcao")+"', responsavel='"+request.getParameter("responsavel")+"', telefone='"+request.getParameter("telefone")+"', obs='"+request.getParameter("obs")+"', status='"+request.getParameter("status")+"' where codigo="+request.getParameter("codigo"));
				
			st.executeUpdate(sql);
			System.out.println(sql);
			out.println("sql = "+sql);
			response.sendRedirect("consulta_solicitacaocadastro.jsp"); 
			
			}
			catch(SQLException erroSQL)
			{
				out.println("Classe de conex�o com o Banco de Dados, erro"+erroSQL);
				
				/*Alert erro: Classe de conex�o com o Banco de Dados*/
				PrintWriter oPrintWriter3 = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Classe de conex�o com o Banco de Dados, erro: "+erroSQL+"');");  
				out.println("</script>");
		}	
	}	
} 
%>

</body>

</html>

