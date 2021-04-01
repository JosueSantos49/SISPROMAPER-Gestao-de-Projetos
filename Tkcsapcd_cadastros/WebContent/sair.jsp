<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%
	
	/*
	O método removeAttribute () remove o atributo especificado.
	A diferença entre este método e o método removeAttributeNode () é que o método removeAttributeNode ()
	remove o objeto Atr especificada, embora este método remove o atributo com o nome especificado.
	O resultado será o mesmo. Além disso, este método não tem valor de retorno, enquanto o método removeAttributeNode ()
	retorna o atributo removido, como um objeto Attr.
	*/
	
	try{
		session.removeAttribute("login");
	} catch(Exception e){
		
	}

	//Invalidando a sessão
	session.invalidate();
		
	//redirecionando para o login
	response.sendRedirect("index.jsp");
%>