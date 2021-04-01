<%!
	/*
	HttpServletRequest Classe interna do java, usada como correio, carteiro. 
	Variável (httpServletRequest), criada para resgatar valores. 
	Exemplo: <input name="usuario" type="text" id="usuario" value="<%=httpServletRequest.getParameter("nome")>/>
	nome: variável do link alterar, vindo da pagina listausuarios.jsp
	*/
	HttpServletRequest httpServletRequest;
	String requisita(String valor){
		String temp = httpServletRequest.getParameter(valor);
		if(temp == null)
			temp = "";
		return temp;
	}
%>
<%	httpServletRequest = request; %>