<%=session.getAttribute("theName")%>
	<%  
	//verifica se a sessao do usuario é válida  
	if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
%>	