<%@ page contentType="text/html; charset=ISO-8859-1" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<%
	Date data = new Date();//criando objeto tipo Date e inicializando 
	SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
	String mostra_data = data_formatada.format(data); //Variável para armazenar a data
	
	SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
	String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
%>