<!-- 
	Autor: Josué da Conceição Santos
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

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Alterar Solicitação Cadastro</title>	
   
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>	
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<link rel="stylesheet" href="css/formatacaoTelaFormularioCadastroUsuario.css" type="text/css">
<script type="text/javascript" src="js/validacadusuario.js"></script>
<script type="text/javascript" src="js/validacaoFormularioUsuarioNivelSelect.js"></script>					
<script type="text/javascript" src="js/validacaoFormularioUsuario.js"></script><!-- A validação do formulário deve ser depois do nível (select) -->
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
	out.println(".");//out.println("Não ouve ação");			
%>

<br><br>
			
<div align="center">

	<form name="formcadusu" id="formcadusu" method="post" action="atualiza_solicitacaocadastro.jsp?acao=alterar" ><!-- onSubmit="return validacadusuario(this)" -->
					
			<center><h3><font color="red">${mensagem}</font></h3></center>
					
					<h3>ATUALIZAR SOLICITAÇÃO CADASTRO</h3>
						<br>
						<p><font color="red">Campos de (*) são de preenchimento obrigatório.</font></p>
						<br>
						 
						<input type="hidden" name="cmd" value="cadastrarSolicitacaoCadastro"></input>
						
						<br>
						<div class="field">
							<label for="codigo">Código: </label>
						  	<input type="text" id="codigo" name="codigo" class="input" value="<%=request.getParameter("codigo")%>" maxlength="8" onkeypress="return Letra(event);" required="true">
							<p class="hint">O código não dode ser alterado!</p>
						</div>
						 
						<div class="field">
							<label for="nome">Nome: *</label>
						  	<input type="text" id="nome" name="nome" class="input" value="<%=request.getParameter("nome")%>" maxlength="50" required="true" requiredMessage="Insira o usuário"></input>
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
						  	<input type="text" id="email" name="email" class="input" value="<%=request.getParameter("email")%>" maxlength="50" required="true" requiredMessage="Insira o usuário"></input>
							<p class="hint">Entre com o e-mail.</p>
						</div>
						
						<br>
						
						<div class="field">
							<label for="area">Área: *</label>
						  	<input type="text" name="area" id="area" class="input" value="<%=request.getParameter("area")%>" maxlength="50" required="true">
							<p class="hint">Entre com a Área.</p>
						</div>
						<br>
						
						<div class="field">
							<label for="funcao">Função: *</label>
						  	<input type="text" name="funcao" id="funcao" class="input" value="<%=request.getParameter("funcao")%>" maxlength="50" required="true">
							<p class="hint">Entre com a Função.</p>
						</div>
						<br>
						
						<div class="field">
							<label for="responsavel">Responsável: *</label>
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
							<option value="Solicitação Acesso">Solicitação Acesso</option>						
							<option value="Recuperar Acesso">Recuperar Acesso</option>
							<option value="Aguardando Aprovação">Aguardando Aprovação</option>
							<option value="concluido">Concluido</option>						
						</select>
						</div>
						
						<br>						
						<div class="field">
							<label for="obs">Observação: *</label>
						  	<input type="text" name="obs" id="obs" class="input" value="<%=request.getParameter("obs")%>" maxlength="300" required="true">
							<p class="hint">Entre com a bservação.</p>
						</div>
						<br>
						
						<input class="button" type="submit" name="gravar" id="gravar" value="Atualizar" title="Cadastrar Usuário" onclick="validacadusuario();">
						<br>
						
				</form>
		</div>
        <!--  Se ouve uma ação, efetue a conexão com o BD, para cadastra usuário-->
        <% } 
else
{
	//out.println("Ouve ação");
	
	/*Alert alteração de usuário*/
	PrintWriter oPrintWriter1 = response.getWriter();  
	response.setContentType("text/html");  
	out.println("<script type=\"text/javascript\">");  
	out.println("alert('Atenção você esta na tela de alteração de usuário!');");  
	out.println("</script>");
	
	//Antes de mandar gravar, devo perguntar se os campos obrigatórios foram preechidos!
	//removido, devido a formatação da tabela(|| (request.getParameter("tf_codigo").length() <= 0)),o codigo será altomatico.
	if((request.getParameter("nome").length() <= 0)|| (request.getParameter("id").length() <=0) || (request.getParameter("email").length() <= 0))	{
		
		//out.println("Atenção, você deve digitar o nome do usuário!");		
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
				out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
				
				/*Alert erro: Classe de conexão com o Banco de Dados*/
				PrintWriter oPrintWriter3 = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Classe de conexão com o Banco de Dados, erro: "+erroSQL+"');");  
				out.println("</script>");
		}	
	}	
} 
%>

</body>

</html>

