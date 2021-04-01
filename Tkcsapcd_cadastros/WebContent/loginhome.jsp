<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
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
%>
<jsp:forward page="testelogin.jsp"/>