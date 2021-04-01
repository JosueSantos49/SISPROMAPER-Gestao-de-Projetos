<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="javax.mail.Part"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*" %>  
<%@ page import = "java.util.*" %>  
<%@ page import = "javax.activation.*"%>  
<%@ page import = "javax.mail.*"%>  
<%@ page import = "javax.mail.internet.*"%>  
<%@ page import = "javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Enviar e-mail</title>
<%  
String para 	= request.getParameter("conceicaojosue@outlook.com.br");  
String de 		= request.getParameter("jsjosue8@gmail.com");  
String attach 	= request.getParameter("caminhoArquivo");    
String assunto 	= request.getParameter("Envio de E-mail");  
String servidor = request.getParameter("sisproweb.com.br");  
String nome 	= request.getParameter("nomeArquivo");  
%>  
</head>
<body>
<%  
		Properties props = new Properties();  
		props.put("mail.smtp.host", servidor);  
		Session s = Session.getInstance(props,null);  
		              
		Message message = new MimeMessage(s);  
		// Estipula quem esta enviando  
		InternetAddress from = new InternetAddress(de);  
		message.setFrom(from);  
		                  
		//Estipula para quem será enviado  
		InternetAddress to = new InternetAddress(para);  
		message.addRecipient(Message.RecipientType.TO, to);  
		message.setSubject(assunto);  
  
        MimeMultipart mpRoot = new MimeMultipart("mixed");  
        MimeMultipart mpContent = new MimeMultipart("alternative");  
        MimeBodyPart contentPartRoot = new MimeBodyPart();  
        contentPartRoot.setContent(mpContent);  
        mpRoot.addBodyPart(contentPartRoot);  
          
        //enviando texto  
        MimeBodyPart mbp1 = new MimeBodyPart();  
        mbp1.setText("Testando");  
        mpContent.addBodyPart(mbp1);  
          
        //enviando html  
        MimeBodyPart mbp2 = new MimeBodyPart();  
        mbp2.setContent("<P> Teste de envio HTML </P>", "text/html");  
        mpContent.addBodyPart(mbp2);  
          
        //enviando anexo  
        MimeBodyPart mbp3 = new MimeBodyPart();  
        DataSource fds = new FileDataSource(attach);  
        mbp3.setDisposition(Part.ATTACHMENT);  
        mbp3.setDataHandler(new DataHandler(fds));  
        mbp3.setFileName(nome);  
          
        mpRoot.addBodyPart(mbp3);  
          
        message.setContent(mpRoot);  
        message.saveChanges();  
  
        Transport.send(message);  
%>  
</body>
</html>