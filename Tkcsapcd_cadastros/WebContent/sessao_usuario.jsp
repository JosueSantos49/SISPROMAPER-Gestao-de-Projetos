<%=session.getAttribute("theName")%>
	<%  
	//verifica se a sessao do usuario � v�lida  
	if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
%>	