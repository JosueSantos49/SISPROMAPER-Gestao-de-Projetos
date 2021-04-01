<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relat�rio em Java</title>
<script type="text/javascript">
	function visualizarRelatorio() {		
		enviar("visualizar");		
	}

	function gerarRelatorioPDF() {		
		enviar("pdf");
	}

	function enviar(acao) {
		document.forms[0].acao.value = acao;
		document.forms[0].target = "_blank";
		document.forms[0].action = "./RelatorioServlet";
		document.forms[0].submit();
	}
</script>
</head>
<body>
<h1>Relat�rios</h1>
<form action="./RelatorioServlet" method="post" onsubmit="return false;">
	<input type="hidden" name="acao" />	
	<input type="submit" value="Visualizar Relatorio" onclick="javascript:visualizarRelatorio();">
	<input type="submit" value="Gerar Relat�rio PDF" onclick="javascript:gerarRelatorioPDF();">	
</form>
</body>
</html>