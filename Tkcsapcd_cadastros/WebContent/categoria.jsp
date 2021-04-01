<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<!-- 
Copyright 2014 Jssor Foundation and other contributors
http://www.jssor.com/


Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:


The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.


THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>SisproMaper</title>
</head> 
<body style="margin:0;padding:0; background:#fff; font-family: Arial, Verdana, Sans-Serif;" onload="tamanhooriginal();"> 

<div id="conteudo"><!-- tratando o zoo da página -->
    
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap/css/estilos.css"> 
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
	<script type="text/javascript" src="js/ajax.js"></script><!-- / LOADER PAGE -->
	<script type="text/javascript" src="js/slide_jquery.js"></script><!-- esses aqui sao as bibliotecas necessarias para q o slide funcione. e so linkar as duas ao corpo do site -->
	<script type="text/javascript" src="js/slide_cycle.js"></script>
	<script type="text/javascript" src="js/validalogin.js"></script>
        
    <!-- <div id="preloader" align="center" ><img src="img/loader.gif" height="70px"></div> -->
        
    <!-- Cabeçalho da página -->
	<header>
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation"> <!-- <nav class="navbar navbar-inverse navbar-static-top" role="navigation"> -->
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
							<!-- <li class="active"><a href="#">Inicio</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
									CIC's <span class="caret"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="http://www.internetcomunitaria.rj.gov.br/modulo_senior.asp">Treinamentos</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/servicos.asp?categ=1">Serviços Cidadão</a></li>
									<li><a href="#" class="divider"></a></li>
									<li><a href="http://www.internetcomunitaria.rj.gov.br/onde_CIC.asp">Centros Comunitários</a></li>
								</ul>
							</li>-->
							<li><a href="index.jsp">Início</a></li>							
							<li><a href="parceiro.jsp">Parcerias</a></li>
							<li><a href="contato.jsp">Contato</a></li>
							<li><a href="testelogin.jsp" title="Clique aqui para efetuar o login!">Acesso</a></li>
						</ul>
												
						<!-- Filtro de  Busca -->						
						<form name="formlogin" id="formlogin" method="post" action="login.jsp" onsubmit="validalogin()" class="navbar-form navbar-right" >
						
							<div class="form-group">
								   <div class="form-group">								   	  
								      <label class="sr-only" for="usuario">Usuário</label>								      
								   	  <a href="solicitacao_cadastro.jsp">Solicitação Acesso</a>
								   	  <br>
								      <input type="text" id="usuario" name="usuario" class="form-control" required="true" placeholder="Usuário">
								   	  
								   	  	
								   </div>
								   <div class="form-group">
								      <label class="sr-only" for="pass">Senha</label>								     
								      <a href="solicitacao_cadastrorecuperarsenha.jsp">Recuperar Acesso</a>
								      <br>
								      <input type="password" id="senha" name="senha" class="form-control" required="true" placeholder="Senha">
								      
								      <button type="submit" name="valida"  id="valida" value="Login" onclick="validalogin();" class="btn btn-primary">					
										<span class="glyphicon glyphicon-thumbs-up"> Entrar</span>
									  </button>
									
								   </div>
								   
							</div>
							
						</form>
						
					</div>
				</div>
		</nav>
	</header>
	<!-- Fim cabeçalho -->
	
	<!-- Aqui vai um jum botron -->	
	<section class="list-group-item list-group-item-success "> <!-- alert alert-success -->
		<div class="container">
			<h1>SisproMaper</h1>
			<p>Sistema de Cadastro de Projeto (RFP-RPI) / Solicitação de Serviço de T.I</p>			

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
	<!-- Fim jum botron -->
    
    <!-- Fim Jssor.Slider.FullPack -->
    
    <!-- Container -->
    
	<section class="main container">
		<div class="row">
			<section class="post col-md-9">
				<div class="miga-de-pan">
				
    			<!-- Lista ordenada -->
					<ol class="breadcrumb">
						<li><a href="sobre_sispromaper.jsp">Sobre o SisproMaper</a></li>
						<!-- <li><a href="">Negócio</a></li> 
						<li class="active">Contato</li>-->
					</ol>
    			    	
					<!-- Zoon da página-->
					<input type="button" class="btn btn-primary" value="+" onclick="fonte('a');" title="Aumentar o tamanho da fonte">
					<input type="button" class="btn btn-primary" value="-" onclick="fonte('b');" title="Diminuir o tamanho da fonte">
					<input type="button" class="btn btn-primary" value="100%" onclick="fonte('c');" title="Fonte com tamanho padrão"> 					

					<!-- Inicio Codigo Visitas online gratis opromo.com  -->
					<script language="Javascript" src="http://www.opromo.com/servicos/usuariosonline/useronline.php?site=site1431805634&corfont1=000000&texto=2&formato=normal&tipo=verdana&tamanho=3&simbo=1" type="text/javascript"></script>
					<!-- Fim Codigo Visitas online gratis opromo.com  -->
					
				</div>
				
				<article classe="post clearfix">
					<!-- <a href="" class="thumb pull-left">
						<img id="zoom_02" class="img-thumbnail" alt="" src="img/img1.jpg" data-zoom-image="img/img1.jpg" width="400">
					</a> -->
					<h2 class="post-title">
						<a href="#">Gerenciar Projeto</a>
					</h2>
					<p><span class="post-fecha">10 de Maio de 2015</span> por <span class="post-outor"><a href="#">Josué C. Santos</span></p>
					<p class="post-contenido text-justify">
					O Sistema de Cadastro de Projeto objetiva gerenciamento de projeto com solicitação de proposta (RFP), pedido de informação (RFI), e Solicitação de Serviço de Tecnologia da Informação. O SisproMaper possibilita mapear a aplicação de conhecimentos, habilidades e técnicas para a execução de projetos de forma efetiva e eficaz.					</p>
					<br>
					<!--<div class="contenedor-botones">
						 <a href="" class="btn btn-primary">Comentário 1</a>
						<a href="" class="btn btn-success">Comentário 2 <span class="badge">20</span> </a>
					</div> -->
				</article>	
							
				<br>
				
				<article classe="post clearfix">
					<!-- <a href="" class="thumb pull-left">
						<img class="img-thumbnail" alt="" src="img/treinamento.png">
					</a> -->
					<h2 class="post-title">
						<a href="#">Solicitação de Proposta (RFP) / Pedido de Informação (RFI)</a>
					</h2>
					<p><span class="post-fecha">10 de Maio de 2015</span> por <span class="post-outor"><a href="#">Josué C. Santos</span></p>
					<p class="post-contenido text-justify">
					O objetivo da Solicitação de Proposta é obter proposta mais completas (comercial e técnica / plano de projeto). Indica que o fornecedor deverá comprovar através de informações mais detalhadas, que tem condições de gerir de maneira eficaz o projeto de fornecimento.
					<br><br>
					O objetivo do Pedido de Informação é obter informações sobre os fornecedores. Os principais itens observados são porte da empresa, estabilidade econômica, restrições jurídicas, volume de negócio, principais clientes e contratos etc. Pode ser considerada uma etapa eliminatória antes do envio da RFP.
					
					<br>
					<!-- <div class="contenedor-botones">
						<a href="" class="btn btn-primary">Comentário 1</a>
						<a href="" class="btn btn-success">Comentário 2 <span class="badge">20</span> </a>
					</div> -->
				</article>	
				
				<br>
				
				<article classe="post clearfix">
					<!--<a href="" class="thumb pull-left">
						<img class="img-thumbnail" alt="" src="img/ti.jpg">
					</a> -->
					<h2 class="post-title">
						<a href="#">Solicitação de Serviço de Tecnologia da Informação</a>
					</h2>
					<p><span class="post-fecha">10 de Maio de 2015</span> por <span class="post-outor"><a href="#">Josué C. Santos</span></p>
					<p class="post-contenido text-justify">
						Da solicitação a finalidade é estabelecer as diretrizes gerais para Solicitação de Serviço de Tecnologia da Informação. As atividades da Área de TI envolvem o gerenciamento, assim como a alteração, melhoria e a implantação de novos recursos de Tecnologia da Informação. Estas atividades podem ser mapeadas pelo SisproMaper.					</p>
					<br>
				
				</article>
				
				<br>				 
				
				<br>
				 
					<div class="contenedor-botones">
						<a href="https://www.facebook.com" target="_blank" class="btn btn-primary"><span class="glyphicon glyphicon-thumbs-up"></span> Facebook</a>
						<a href="http://www.bol.uol.com.br/" class="btn btn-success">Bol</a>
						<a href="https://twitter.com" target="_blank" class="btn btn-info">Twitter</a>
						<a href="https://www.google.com.br/" class="btn btn-warning">Google</a>
						<a href="http://www.youtube.com" class="btn btn-danger">You Tube</a>
						<a href="http://www.globo.com/" class="btn btn-default">Globo</a>
						<a href="#" class="btn btn-link">Privacidade</a>
					</div>					
						
				 	
			</section>
			
		<aside class="col-md-3 hidden-xs hidden-sm">
			<!-- <h4> Categorias</h4> -->	
			<div class="list-group">
				<a href="categoria.jsp" class="list-group-item list-group-item-success">CATEGORIA</a>
				<!--<a href="categoria.jsp" class="list-group-item ">Gerenciar Projeto</a>
				<a href="categoria.jsp" class="list-group-item ">Pedido de Informação (RFI)</a>
				<a href="categoria.jsp" class="list-group-item ">Solicitação de Proposta (RFP)</a>
				<a href="categoria.jsp" class="list-group-item ">Solicitação de Serviço de TI</a>
				<a href="categoria.jsp" class="list-group-item ">Discente</a>
				 <a href="categoria.jsp" class="list-group-item ">Unidades</a> -->
				<a href="galeria_evento.jsp" class="list-group-item ">Foto e Evento</a>
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
			
			<!-- Relógio  Analógico-->
			<div>		
				<table align="left">
					<tr>
						<td>					
							<script type="text/javascript" src="js/standardclock1.js"></script>			
						</td>
					</tr>
				</table>
			</div>		
			<br>
								
		</aside>
		
		<br><br>
		
		<div>
			</div>
		</div>
	</section>
	
</div>
	
	<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
</body> 
</html>
<% 
	session.invalidate();
%>