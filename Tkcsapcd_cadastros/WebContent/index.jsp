<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Bem vindo!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <meta name="layout" content="main"/> 
       
    <link rel="stylesheet" href="wow/css/animate.css"><!-- wow -->
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script src="js/jquery/jquery-1.8.2.min.js" type="text/javascript" ></script>
    <link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
    <link href="css/modal_dialog_alterado.css" type="text/css" media="screen, projection" rel="stylesheet" />    
    <script type="text/javascript" src="js/validalogin.js"></script>
    <script type="text/javascript" src="js/zoom_fonte_configuracao.js"></script>
    <link href="css/formatacao_type_button.css" type="text/css" media="screen, projection" rel="stylesheet" /> 
    
    <script type="text/javascript" src="js/language_jquery_json.js"></script>
	<script type="text/javascript" src="js/language_translate.js"></script>
	    
</head>
    <body onload="waitingDialog.show('Operando.....', {dialogSize: 'sm', progressType: 'warning'});setTimeout(function () {waitingDialog.hide();}, 3000); tamanhooriginal();">
        
        <div id="conteudo"><!-- tratando o zoo da página -->
        
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button class="btn btn-navbar" data-toggle="collapse" data-target="#app-nav-top-bar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="section--blue wow bounceInLeft brand"><i class="">SISPROMAPER</i></a><!-- icon-leaf -->
                    <div id="app-nav-top-bar" class="nav-collapse">
                        <ul class="nav">
                            
                                <li class="wow fadeInDown dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Solicitação Acesso
                                        <b class="caret hidden-phone"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="solicitacao_cadastro.jsp">Solicitação Acesso</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="wow fadeInDown dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Recuperar Acesso
                                        <b class="caret hidden-phone"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="solicitacao_cadastrorecuperarsenha.jsp">Recuperar Acesso</a>
                                        </li>
                                    </ul>
                                </li>
                                <!-- <li class="dropdown">
                                	<a class="translate" id="en">US</a> 
                                </li> -->
                            
                        </ul>
                        <ul class="section--purple wow slideInRight nav pull-right">
                            <li>
                                <a href="index.jsp">Acesso</a>
                            </li>     
                            
                            <li>
								<a>
								<!-- Zoon da página-->
								<input type="button" value="+" onclick="fonte('a');" title="Aumentar o tamanho da fonte">
								<input type="button" value="-" onclick="fonte('b');" title="Diminuir o tamanho da fonte">
								<input type="button" value="100%" onclick="fonte('c');" title="Fonte com tamanho padrão">
								<!-- Fim Zoon da página-->
								</a>	
							</li>
							                       
                        </ul>
                    </div>
                </div>
            </div>
        </div>
       
        
        <div id="body-container">
            <div id="body-content">                       
            <div class='container'>                
                <div class="signin-row row">
                    <div class="span4"></div>
                    <div class="span8">
                        <div class="container-signin">
                            <legend>Acesso</legend>
                            <form action="login.jsp" onsubmit="validalogin();" method='POST' id='loginForm' class='form-signin' autocomplete='off'>
                            
                            <div align="center"><span class="style1"><font color="red" class="lang" id="identifique">IDENTIFIQUE-SE - ACESSO</font></span></div><br>
                            
                                <div class="form-inner">
                                    <div class="input-prepend">
                                        
                                        <span class="add-on" rel="tooltip" title="Username or E-Mail Address" data-placement="top"><i class="icon-envelope"></i></span>
                                        <input 	type='text' class='span4' id="usuario" name="usuario"
                                        		style="height: 30px; width: 250px"
                                         required="true" requiredMessage="Insira o usuário" Placeholder="Usuário o campo é obrigatório!" autofocus/>
                                         
                                    </div>

                                    <div class="input-prepend">
                                        
                                        <span class="add-on"><i class="icon-key"></i></span>
                                        <input 	type='password' class='span4' id="senha" name="senha"
                                        		style="height: 30px; width: 250px"
                                         required="true" requiredMessage="Insira a senha" Placeholder="Senha o campo é obrigatório!"/>
                                    </div>
                                </div>
                                <footer class="signin-actions">
                                    <input class="btn btn-primary" type='submit' id="submit" value='Login' onclick="validalogin();"/>
                                </footer>
                            </form>
                        </div>
                    </div>
                    <div class="span3"></div>
                </div>                
            	</div>
            </div>
        </div>
        
        
        <script type="text/javascript">
            $(function(){
                document.forms['loginForm'].elements['j_username'].focus();
                $('body').addClass('pattern pattern-sandstone');
                $("[rel=tooltip]").tooltip();
            });
        </script>
       
        <%@include file="configuracao_wow.jsp" %>	
        <script src="bootstrap/js/jquery-1.11.3.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>  
		<script src="js/modal_dialog.js"></script>
		 
		</div><!-- fim zoom -->
	</body>
</html>
<% 
	session.invalidate();
%>
