<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@include file="httpservletrequest.jsp"%>
<%@page import="br.com.tkcsapcd.model.helper.Hash"%>
<%@page import="br.com.tkcsapcd.model.util.Conexao"%>
<html>

<head>	

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Acesso ao Sistema</title>
	<link rel="stylesheet" href="wow/css/animate.css"><!-- wow -->
	<script src="js/jquery/jquery-1.8.2.min.js" type="text/javascript" ></script>
    <link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
    <link href="css/modal_dialog.css" type="text/css" media="screen, projection" rel="stylesheet" />
    <script type="text/javascript" src="js/validalogin.js"></script>
    <script type="text/javascript" src="js/zoom_fonte_configuracao.js"></script>
    <link href="css/formatacao_type_button.css" type="text/css" media="screen, projection" rel="stylesheet" /> 
    
    <script type="text/javascript" src="js/language_jquery_json.js"></script>
	<script type="text/javascript" src="js/language_translate.js"></script>

</head>
<%!
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultset = null;
	String acesso;//sessao
	String ordenacao;	
%>
<% 
	connection = Conexao.getConnection();	
%>
<%
	//Validação: Se acesso for igual a null direciona para a página solicita login. Se não tiver sessão
	try{
		if(acesso==null){	
			acesso = "00";
%>
	<jsp:forward page="login.jsp"/>
<%
		}
	}catch (Exception e){
		System.out.println("Erro ao validar:"+e);
	}
%>

<%acesso = (String) session.getAttribute("login");%>

<%
	if (requisita("valida") != null){
		try{						
			if(request.getParameter("usuario").trim().equals("") && request.getParameter("usuario")==null || request.getParameter("senha").trim().equals("") && request.getParameter("senha")==null)
				{
					response.sendRedirect("erro.jsp");
					String msg = "Os campos marcados com (*) são obrigatórios.";
					throw new Exception(msg);
				}
				else{			
					String sqlacesso = "SELECT log_usuario, log_senha, log_nivelacesso FROM login WHERE log_usuario = ? AND log_senha =?";
					statement = (PreparedStatement)connection.prepareStatement(sqlacesso);
					statement.setString(1, requisita("usuario"));
					statement.setString(2, Hash.cripografar(requisita("senha")));//Hash cripografar
									
					resultset = statement.executeQuery();
				
				if(resultset.next()){
					session.setAttribute("login", resultset.getString("log_nivelacesso"));					
	%>			
	<%				
			 	String nome = httpServletRequest.getParameter("usuario");				
			 	session.setAttribute ("theName", nome);
			 				 	
	%>
				<jsp:forward page="index_principal.jsp"/>
	<%
				}
			}//fechando o else	
			
				statement.close();
				resultset.close();
				connection.close();
			
			} catch(Exception e){
				System.out.println("Erro ao tentar executar login no sistema: " + e);
				throw new SQLException();
			}finally {
				// fecha todos os recursos e devolve a conexao ao pool
		        if (resultset != null) try { resultset.close(); } catch (SQLException e) {e.printStackTrace();resultset=null;}
		        if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();statement=null;}
		        if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();connection=null;}
			}		
	}	
%>

<script type="text/javascript">	function setFocus() {  	document.getElementById("usuario").focus();  }</script>

<body onload="waitingDialog.show('Operando.....', {dialogSize: 'sm', progressType: 'warning'});setTimeout(function () {waitingDialog.hide();}, 3000); tamanhooriginal();">

<div id="conteudo"><!-- tratando o zoo da página -->

<div id="preloader" align="center" ><img src="img/loader.gif" height="70px"></div>

		<div id="login"></div>
		
			<div align="left">
			
			<%@include file="menuperantecsslogin.jsp" %></div>
					   			  		 
	    		<div id="body-container">
                    <div id="body-content">                       
			            <div class='container'>                
			                <div class="signin-row row">
			                    <div class="span4"></div>
			                    <div class="span8">
			                        <div class="container-signin">
			                            <legend>Acesso</legend>			                                             
			                            
			                            <form action="login.jsp" onsubmit="validalogin();" method='POST' id='loginForm' class='form-signin' autocomplete='off'>
			                            
			                            <div align="center"><span class="style1"><font color="red" class="lang" id="identifique" >IDENTIFIQUE-SE - ACESSO</font></span></div>
								 			
								 			<div><center><font color="red"><%=httpServletRequest.getParameter("valida") == null ? "Informe seu usuário e senha" : "\n\n" %></font></center></div>
								 			
								 			<%
									 			/*Alert com confirmação de cadastro*/
												PrintWriter oPrintWriter = response.getWriter();  
												response.setContentType("text/html");  
												out.println("<script type=\"text/javascript\">");  
												out.println("alert('Informe seu usuário e senha. Seus dados são inválidos ou usuário não autorizado a efetuar a transação! Enter your username and password. Your data is invalid or unauthorized user to complete the transaction!');");  
												out.println("</script>");
								 			%>
								 			<br>
			                                <div class="form-inner">
			                                    <div class="input-prepend">
			                                        
			                                        <span class="add-on" rel="tooltip" title="Username or E-Mail Address" data-placement="top"><i class="icon-envelope"></i></span>
			                                        <input type='text' class='span4' id="usuario" name="usuario"
			                                        		style="height: 30px; width: 250px"
			                                         required="true" requiredMessage="Insira o usuário" Placeholder="Digite o usuário o campo é obrigatório!" autofocus/>
			                                    </div>
			
			                                    <div class="input-prepend">
			                                        
			                                        <span class="add-on"><i class="icon-key"></i></span>
			                                        <input type='password' class='span4' id="senha" name="senha"
			                                        		style="height: 30px; width: 250px"
			                                         required="true" requiredMessage="Insira a senha" Placeholder="Digite a senha o campo é obrigatório!"/>
			                                    </div>
			                                </div>
			                                <footer class="signin-actions">
			                                    <input class="btn btn-primary" type='submit' id="submit" value='Login'/>
			                                </footer>
			                            </form>
			                        </div>
			                    </div>
			                    <div class="span3"></div>
			                </div>                
			            	</div>
            	</div>
        	</div>  
        <!-- </div> -->  	
    <%@include file="configuracao_wow.jsp" %>	
	<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>    	
	<script src="js/modal_dialog.js"></script>	
			
	</body>
</html>
<% 
	session.invalidate();
%>