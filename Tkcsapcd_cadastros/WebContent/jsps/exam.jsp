<%@ page language="java" import="br.com.tkcsapcd.quizz.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questionário</title>
<link href="../bootstrap/css/bootstrap.quiz.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<!-- <style type="text/css">
body {
	background: url("${pageContext.request.contextPath}/jsps/images/background.jpg");
}
</style>-->

<script language ="javascript" >
/*
Tempo de duração de cada teste é armazenado no arquivo XML questionário, nós recuperamos
a duração do teste e guardá-lo na sessão do usuário como um atributo. Quando o usuário
submete uma questão que também apresentará o tempo para o controlador usando formulário 
personalizado apresentação com JavaScript. Então, quando mostramos a próxima pergunta que
 exibir o tempo restante correto. Quando o tempo de duração do teste é longo, o usuário
 será mostrada uma caixa de alerta dizendo "Tempo de exame encerrado!" e o teste será 
 avaliado eo resultado final será exibida.
 
 Contagem regressiva do tempo. Temos de diminuir o temporizador depois de cada segundo, 
 para fazer isso, vamos criar uma função JavaScript que será chamado pela primeira vez 
 quando a página do exame é carregado e, em seguida, vamos chamar essa função de forma 
 recursiva após cada segunda a contagem regressiva do tempo.
 */ 
        var tim;       
        var min = '${sessionScope.min}';
        var sec = '${sessionScope.sec}';       
        
        function customSubmit(someValue){  
        	 document.questionForm.minute.value = min;   
        	 document.questionForm.second.value = sec; 
        	 document.questionForm.submit();  
        	 }  
			
        function examTimer() {
            if (parseInt(sec) >0) {
			
			    document.getElementById("showtime").innerHTML = "Tempo restante : "+min+" Minuto ," + sec+" Segundos";
                sec = parseInt(sec) - 1;                
                tim = setTimeout("examTimer()", 1000);
            }
            else {
			/*
			Quando a duração do teste é longo, em outras palavras, quando ambos minuto e segundo se torna zero. 
			Temos que  mostrar uma caixa de alerta dizendo "Time Up" e defina o valor de minuto e segundo para
			zero e enviar o formulário.
			*/
			    if (parseInt(min)==0 && parseInt(sec)==0){
			    	document.getElementById("showtime").innerHTML = "Tempo restante : "+min+" Minuto, " + sec+" Segundos";
				     alert("Tempo de exame encerrado!");
				     document.questionForm.minute.value=0;
				     document.questionForm.second.value=0;
				     document.questionForm.submit();					 
			     }
				 
                if (parseInt(sec) == 0) {				
				    document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute, " + sec+" Seconds";					
                    min = parseInt(min) - 1;
					sec=59;
                    tim = setTimeout("examTimer()", 1000);
                }               
            }
        }
    </script>

</head><br/>

<body onload="examTimer()">

<div class="container">

<%
  int currentQuestion=((Exam)request.getSession().getAttribute("currentExam")).getCurrentQuestion();
  System.out.println("Número pergunta "+currentQuestion+ " recuperado ");
 %>
<strong>Pergunta atual:</strong> ${sessionScope.quest.questionNumber+1} / ${sessionScope.totalNumberOfQuizQuestions}

<br/>

<strong>Usuário:</strong>
<%=session.getAttribute("theName")%>
<%if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}%>


<div id="showtime" style="position:absolute;left:800px;top:20px"></div>

<div style="position:absolute;width:1100px;padding:25px;height: 400px;border: 1px solid blue ;left:100px;top:60px">
<span>${sessionScope.quest.question}</span><br/><br/>

<br>

<form action="exam" method="post" name="questionForm" > 
	 <c:forEach var="choice" items="${sessionScope.quest.questionOptions}" varStatus="counter">
	 	<input type="radio" name="answer" value="${counter.count}" >${choice}  <br/>
	 </c:forEach> <br/> 	 
	 
	 <c:if test="${sessionScope.quest.questionNumber > 0}">
	 	<input type="submit" name="action" value="Previous" onclick="customSubmit()" class="btn btn-primary"/>
	 </c:if>
	 
	 <c:if test="${sessionScope.quest.questionNumber < sessionScope.totalNumberOfQuizQuestions-1}">
	 	<input type="submit" name="action" value="Next" onclick="customSubmit()" class="btn btn-primary"/>
	 </c:if>  
	
	 <input type="submit" name="action" value="Finish Exam" onclick="customSubmit()" class="btn btn-primary"/>
	 
	<input type="hidden" name="minute"/> 
	<input type="hidden" name="second"/>
</form>

</div>
</div>
</body>
</html>