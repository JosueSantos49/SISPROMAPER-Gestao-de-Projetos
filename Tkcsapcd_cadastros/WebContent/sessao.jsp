<%@page import="java.io.PrintWriter"%>
<%  	
	request.getSession(false).setMaxInactiveInterval(1800000);  
	int duracaoSessao = request.getSession(false).getMaxInactiveInterval();  
	long now = System.currentTimeMillis();// retorna o tempo desde 1 de Janeiro de 1970, em milissegundos. O valor retornado é um longo, tempo transcorrido.  
	long ultimoAcesso = request.getSession(false).getLastAccessedTime();  
	
	if (now - ultimoAcesso > duracaoSessao) { 		
		
		/*Alert com confirmação de cadastro*/
		session.removeAttribute("theName");
		
		request.getRequestDispatcher("testelogin.jsp").forward(request, response);
		request.getRequestDispatcher("login.jsp").forward(request, response);	
		
		PrintWriter oPrintWriter = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Sessão expirou!');");  
		out.println("</script>");	        
        
	} else {  		
		out.println(" ");//request.getRequestDispatcher("index_menudinamico.jsp").forward(request, response);
	}	
%>  
