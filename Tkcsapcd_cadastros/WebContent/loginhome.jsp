<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%
	/*
	O m�todo removeAttribute () remove o atributo especificado.
	A diferen�a entre este m�todo e o m�todo removeAttributeNode () � que o m�todo removeAttributeNode ()
	remove o objeto Atr especificada, embora este m�todo remove o atributo com o nome especificado.
	O resultado ser� o mesmo. Al�m disso, este m�todo n�o tem valor de retorno, enquanto o m�todo removeAttributeNode ()
	retorna o atributo removido, como um objeto Attr.
	*/
	
	try{
		session.removeAttribute("login");
	} catch(Exception e){
		
	}
%>
<jsp:forward page="testelogin.jsp"/>