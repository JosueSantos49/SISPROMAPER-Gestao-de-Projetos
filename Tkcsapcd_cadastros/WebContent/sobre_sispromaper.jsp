<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.Config"%>
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<title>Sobre o SisproMaper</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
<link rel="stylesheet" href="css/galeria.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script> 
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/ajax.js"></script><!-- / LOADER PAGE -->
<script type="text/javascript" src="js/slide_jquery.js"></script><!-- esses aqui sao as bibliotecas necessarias para q o slide funcione. e so linkar as duas ao corpo do site -->
<script type="text/javascript" src="js/slide_cycle.js"></script>


<script type="text/javascript">
var tamanhotexto = new Number();
var tamanhotexto = 16;
	function tamanhooriginal(){
		document.getElementById("conteudo").style.fontSize=tamanhotexto+'px';
	}
	function fonte(e){
		var elemento=document.getElementById("conteudo");
		var atual=elemento.style.fontSize;
		if(e == 'a'){
			atual = parseInt(atual)+2+'px';
		}else if(e == 'b'){
			atual = parseInt(atual)-2+'px';
		}else if(e == 'c'){
			atual = 16+'px';
		}
		elemento.style.fontSize=atual;
	}
</script>

<script type="text/javascript">/*esse e um script de slide*/
		$('#galeria').cycle({ 
		    fx:      'scrollLeft',/*scroll e o parametro de dire��o ou seja 'Left' esquerda e 'right' direita*/ 
		    delay:   -1000 ,/*e o tempo da transi��o*/
		    next: '#proximo',/*essa e a fun��o  avan�ar o slide*/
			prev: '#voltar',/*essa e a fun��o voltar*/
		});
</script>

</head>

<body onload="tamanhooriginal();">	

<div id="conteudo"><!-- tratando o zoo da p�gina -->
    
<div id="preloader" align="center" ><img src="img/loader.gif" height="70px"></div>

	<!-- Cabe�alho da p�gina -->
	<header>
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion-fm">
						<span class="sr-only">Desplegar / Ocultar Menu</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">SisproMaper</a>
				</div>	
					<!-- Inicia Menu -->
					<div class="collapse navbar-collapse" id="navegacion-fm">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp">Inicio</a></li>
							<li class="dropdown">
								<!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
									CIC's <span class="caret"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="http://www.internetcomunitaria.rj.gov.br/modulo_senior.asp">Treinamentos</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/servicos.asp?categ=1">Servi�os Cidad�o</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/onde_CIC.asp">Centros Comunit�rios</a></li>
								</ul>-->
							</li>
							<li><a href="parceiro.jsp">Parcerias</a></li>
							<li><a href="contato.jsp">Contato</a></li>
							<!-- <li><a href="testelogin.jsp">Acesso</a></li> -->
						</ul>
						<!-- Filtro de  Busca -->
						<form action="" class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="buscar">
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>
					</div>
				</div>
		</nav>
	</header>
	
	<section class="list-group-item list-group-item-success "><!--jumbotron, list-group-item list-group-item-success -->
		<div class="container">
			<h1>SisproMaper</h1>
			<p>Sistema de Cadastro de Projeto (RFP-RPI) / Solicita��o de Servi�o de T.I</p>
			<div align="right">
				<div id="google_translate_element"></div>
					<script type="text/javascript">
						function googleTranslateElementInit() {
						new google.translate.TranslateElement({pageLanguage: 'pt', includedLanguages: 'en,pt', multilanguagePage: true}, 'google_translate_element');
						}
					</script>
					<script type="text/javascript" src="js/translate.google.txt"></script>        
			</div>
		</div>								
	</section>

	<!-- Container -->
	<section class="main container">
		<div class="row">
			<section class="post col-md-9">
				<div class="miga-de-pan">
				
					<!-- Zoon da p�gina-->
					<input type="button" class="btn btn-primary" value="+" onclick="fonte('a');" title="Aumentar o tamanho da fonte">
					<input type="button" class="btn btn-primary" value="-" onclick="fonte('b');" title="Diminuir o tamanho da fonte">
					<input type="button" class="btn btn-primary" value="100%" onclick="fonte('c');" title="Fonte com tamanho padr�o">
					
				</div>
				
				<article classe="post clearfix">					
					<h2 class="post-title">
						<a href="sobre_sispromaper.jsp">Sobre o SisproMaper</a>
					</h2>
					<p><span class="post-fecha">10 de Maio de 2015</span> por <span class="post-outor"><a href="#">Josu� C. Santos</span></p>
					<p class="post-contenido text-justify">
					Os recursos da Tecnologia da Informa��o (TI), nos dias de hoje tem provocado um grande impacto em v�rios segmentos da sociedade. Como exemplo pode se destacar um projeto para ser executado em um ambiente corporativo, onde, um ambiente corporativo, que possui um sistema para gerenciar projeto, pode contribuir para o desenvolvimento organizacional do ambiente corporativo, bem como automatizar um processo sem perda da integridade, confiabilidade e seguran�a da informa��o. O ambiente corporativo possui v�rios n�veis de estrat�gias possibilitando disseminar, e agilizar processos entre outros fatores. Muitas empresas ainda possuem car�ncia e dificuldade em rela��o a recursos de TI, onde, � poss�vel encontrar v�rios processos sendo feito manualmente ou por caminho paliativo. A TI possibilita recursos para automatiza��o de processo, onde com o Sistema de Cadastro de Projeto (SisproMaper), n�o � diferente. O SisproMaper � um Software funcional simples de se usar, que permite a intera��o do usu�rio final do computador conectado a uma rede de Internet.  
					</p>
					<br>
					<p class="post-contenido text-justify">
					O processo manual de elaborar documento e coletar dados atrav�s de formul�rios de planilhas eletr�nicas em folha de papel � umas das formas de a��o de determinadas empresas atualmente, onde demanda certo tempo para montar o documento e coletar as informa��es pertinentes ao projeto a ser executado, ou seja, criar documento manualmente para gerar relat�rio manualmente em uma planilha eletr�nica e modela a mesma, para montar um mapeamento do projeto, bem como outro tipo de processo n�o mencionado neste documento. 
					<br>
					<br>
					<p class="post-contenido text-justify">
					Com o projeto cadastrado no SisproMaper � garantida a melhoria do processo, onde a coleta de dado poder� ser feita em volume de dado, ou seja, n�o precisa ficar criando documento em planilha eletr�nica basta somente alimentar um formul�rio digital, onde os dados do mesmo ser�o cadastrados em um banco de dado. Em um ambiente corporativo � muito importante o desenvolvimento organizacional possibilitando mapear o rendimento da institui��o em rela��o ao projeto que esta em execu��o ou projeto a ser executado (onde estou errando, onde preciso melhorar, estou no caminho certo, etc.), seja em qualquer ramo de atividade que a empresa atua.  	
					<br>
					<p class="post-contenido text-justify">
					Visto que o ambiente corporativo necessita de mapear os fatores de acompanhamento de um projeto, ou seja, acompanhar o desenvolvimento do projeto at� chegar a ponto de produ��o, como autor, data, t�tulo, descri��o, respons�vel, �rea, tipo de projeto, status, data de implanta��o prevista, custo, justificativa, objetivo, benef�cio, produto, requisito, restri��o, permiss�o, riscos, status entre outras informa��es discutidas no presente documento. Seria um ganho para o ambiente corporativo automatizar o processo, bem como complementar algum processo de gerenciamento de projeto j� existente (manual), com automa��o via Tecnologia da Informa��o (sistema WEB).
					<br>
					<br>
					<p class="post-contenido text-justify">
					Com o SisproMaper � garantido automatizar o processo manual de levantamento de dados de gerenciamento de projeto e possibilitar a integridade das informa��es, sustentabilidade, ganho de tempo, menos esfor�o de trabalho e economia de papel contribuindo para o desenvolvimento organizacional. O sistema tamb�m executa Pedido de Informa��o (RFI), Solicita��o de Proposta (RFP) e Solicita��o de Servi�o de Tecnologia da Informa��o.   
					<br>
				</article>	
							
				<article classe="post clearfix">
					
					<h2 class="post-title">
						<a href="#">Ainda possui alguma d�vida?</a>
					</h2>
					<p><span class="post-fecha">Entre em contato </span> com <span class="post-outor"><a href="contato.jsp">Josu� C. Santos</span></p>
					<p class="post-contenido text-justify">

					</p>
				</article>
				
				<br>
							
				<table>
					<tr>
						<td><a href="https://www.facebook.com" target="_blank"><img src="img/facebook.gif" alt="facebook" border="0" height="18" width="18" /></a></td>
						<td><a href="https://twitter.com" target="_blank"><img src="img/twitter.gif" alt="twitter" border="0" height="18" width="18" /></a></td>
						<td><a href="http://www.youtube.com" target="_blank"><img src="img/youtube.gif" alt="youtube" border="0" height="18" width="18" /></a></td>
		
					</tr>			
				</table>				
			</section>
			
		<aside class="col-md-3 hidden-xs hidden-sm">
			<!-- <h4> Categorias</h4> -->	
			<div class="list-group">
				<a href="categoria.jsp" class=" list-group-item list-group-item-success ">CATEGORIA</a><!-- list-group-item active active -->
				<a href="categoria.jsp" class="list-group-item ">Gerenciar Projeto</a>
				<a href="categoria.jsp" class="list-group-item ">Pedido de Informa��o (RFI)</a>
				<a href="categoria.jsp" class="list-group-item ">Solicita��o de Proposta (RFP)</a>
				<a href="categoria.jsp" class="list-group-item ">Solicita��o de Servi�o de TI</a>
				<!--<a href="categoria.jsp" class="list-group-item ">Discente</a>
				 <a href="categoria.jsp" class="list-group-item ">Unidades</a> -->
				<a href="galeria_evento.jsp" class="list-group-item ">Foto e Evento</a>
				<!-- <a href="#" class="list-group-item ">Unidades</a>
				<a href="index_principal2.jsp" class="list-group-item ">Avalia��o de Rea��o de Treinamento</a> -->
			</div>	
			
			<h4>Artigos Recentes</h4>
			<a href="" class="list-group-item">
				<h4 class="list-group-item-heading">Java Web</h4>
				<p class="list-group-item-text">Executando JSP</p>
			</a>
			<br>
			<div>
				<iframe frameborder="0" allowtransparency="yes" scrolling="no" width="150" height="260" src="http://www.tempoagora.com.br/ta-widgets?cidades=RiodeJaneiro-RJ,Seropedica-RJ,SaoPaulo-SP&amp;tipo=vertical"></iframe>
			</div>
			<br>
			<div>
				<marquee class="marquee" direction="up" height100="" scrollamount="1">
				<p class="post-contenido text-justify">
					Automatizar processo com levantamento de dado possibilitando a integridade das informa��es, ganho de tempo, menos esfor�o de trabalho, economia de papel e sustentabilidade contribuindo para o desenvolvimento organizacional. </p>
				</marquee>
			</div>
						
		</aside>
	</section>		
	<br>				
	</div>	
	<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html> 
