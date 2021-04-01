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

<jsp:include page="sessao.jsp" />

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<title>Parcerias</title>

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
					<a href="sobre_sispromaper.jsp" class="navbar-brand">SisproMaper</a>
				</div>	
					<!-- Inicia Menu -->
					<div class="collapse navbar-collapse" id="navegacion-fm">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp">Inicio</a></li>
							<!-- <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
									CIC's <span class="caret"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="http://www.internetcomunitaria.rj.gov.br/modulo_senior.asp">Treinamentos</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/servicos.asp?categ=1">Servi�os Cidad�o</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/onde_CIC.asp">Centros Comunit�rios</a></li>
								</ul>
							</li> -->
							<!--<li><a href="index.jsp">Home</a></li>
							 <li><a href="http://www.internetcomunitaria.rj.gov.br/fale.asp">Contato</a></li>
							<li><a href="testelogin.jsp">Acesso</a></li> -->
						</ul>
					</div>
				</div>
		</nav>
	</header>
	
	<section class="alert alert-success">
		<div class="container">
			<h1>SisproMaper</h1>
			<p></p>				
		
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
				
					<!-- Lista ordenada -->
					<ol class="breadcrumb">		
							
						<!-- <li ><a href="">teste</a></li>
						<li><a href="">Inicio</a></li>
						<li><a href="">Categoria</a></li>
						<li class="active">Contato</li> -->
					</ol>
					
				</div>
				
				<article classe="post clearfix">					
					<h2 class="post-title">
						<a href="#">Parceiros</a>
					</h2>
					<p><span class="post-fecha">10 de Maio de 2015</span> por <span class="post-outor"><a href="#">Josu� C. Santos</span></p>
					<!-- Our Clients -->
				    <div class="section">
				    	<div class="container">
							<div class="clients-logo-wrapper text-center row">
								<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="http://viagemdosonho.com/" target="_blank"><img src="img/viagemdosonho.jpg" alt="Client Name"></a></div>
								<div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="https://www.facebook.com/mastergroupinformatica" target="_blank"><img src="img/master_group.jpg" alt="Client Name"></a></div>					
							</div>
						</div>
				    </div><br>
				    <!-- End Our Clients -->
					<br>
				</article>	
							
				<br><br>
							
				<table>
					<tr>
						<td><a href="https://www.facebook.com" target="_blank"><img src="img/facebook.gif" alt="facebook" border="0" height="18" width="18" /></a></td>
						<td><a href="https://twitter.com" target="_blank"><img src="img/twitter.gif" alt="twitter" border="0" height="18" width="18" /></a></td>
						<td><a href="http://www.youtube.com" target="_blank"><img src="img/youtube.gif" alt="youtube" border="0" height="18" width="18" /></a></td>
		
					</tr>			
				</table>				
			</section>		
	
			<br>
			<div>
				<iframe frameborder="0" allowtransparency="yes" scrolling="no" width="150" height="260" src="http://www.tempoagora.com.br/ta-widgets?cidades=RiodeJaneiro-RJ,Seropedica-RJ,SaoPaulo-SP&amp;tipo=vertical"></iframe>
			</div>
			<br>	
		
	</div>	
	<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html> 
