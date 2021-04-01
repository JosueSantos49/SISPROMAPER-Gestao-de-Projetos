<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page import="br.com.tkcsapcd.model.helper.Config"%>
<%@ page import="br.com.tkcsapcd.model.util.Conexao"%>
<%@ page import="javax.naming.InitialContext,javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<%!
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultset = null;
	String acesso;//sessao
	String ordenacao;
	
	public void jspInit(){
		try{
			connection = Conexao.getConnection();

		} catch (Exception e){
			System.out.println("Falha na conexao: " + e);
		}
	}
	
	public void jspDestroy(){
		try{
			statement.close();
			connection.close();

		} catch (Exception e){
			System.out.println("Nao consegui fechar: " + e);
		}
	}
	
	
%>
<%
	acesso = (String) session.getAttribute("login");
%>