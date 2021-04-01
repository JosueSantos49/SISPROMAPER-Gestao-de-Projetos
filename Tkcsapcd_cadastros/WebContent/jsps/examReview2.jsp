<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<!-- <style type="text/css">
body {
	background: url("${pageContext.request.contextPath}/jsps/images/background.jpg");
}
</style>-->
<title>Revisão do exame</title>
</head>

<body>

<div class="container">

<br><h3 align="center">QUESTIONÁRIO COMENTÁRIO</h3><br>

<c:forEach var="q" items="${requestScope.reviewQuestions}" varStatus="counter">
<br>
${counter.count}. ${q.question}<br/><br/>

<c:forEach var="option" items="${q.questionOptions}" varStatus="counter">
${counter.count}.   ${option}<br/><br/>
</c:forEach>

<font color="green">Resposta correta : ${q.correctOptionIndex+1}</font><br/>
<br>

<c:if test='${q.userSelected == -1}'>
<font color="#1334F1">Sem resposta</font><br/>
</c:if>
<c:if test='${q.userSelected != -1}'>
<font color="#1334F1">Resposta selecionada : ${q.userSelected}</font><br/>
</c:if>
<br/>
<c:if test='${q.userSelected == q.correctOptionIndex+1}'>
<img height="30" width="30" src="${pageContext.request.contextPath}/jsps/images/correct.png"/>
</c:if>

<c:if test='${q.userSelected != q.correctOptionIndex+1}'>
<img height="30" width="30" src="${pageContext.request.contextPath}/jsps/images/redcross.png"/>
</c:if>
<br/>
<br/>

<hr color="blue">

<!--
____________________________________________________________________________________________________________________________________________________<br>
 -->

</c:forEach><br/><br/>


<div align="center">
  <a href="../home.jsp"><img  height="50" width="50" src="${pageContext.request.contextPath}/jsps/images/home.jpg"></img></a>
</div>

</div>
  
</body>
</html>