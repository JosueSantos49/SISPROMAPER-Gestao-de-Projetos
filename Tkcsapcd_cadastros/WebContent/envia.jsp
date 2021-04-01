<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Envia E-mail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    .contact-form{ margin-top:15px;}
	.contact-form .textarea{ min-height:220px; resize:none;}
	.form-control{ box-shadow:none; border-color:#eee; height:49px;}
	.form-control:focus{ box-shadow:none; border-color:#00b09c;}
	.form-control-feedback{ line-height:50px;}
	.main-btn{ background:#00b09c; border-color:#00b09c; color:#fff;}
	.main-btn:hover{ background:#00a491;color:#fff;}
	.form-control-feedback {
	line-height: 50px;
	top: 0px;
	}
    </style>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<%@include file="menuperantecssadm.jsp"%>

<link rel="stylesheet" href="bootstrap/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="bootstrap/js/bootstrapValidator.min.js"></script>

<div class="container">
	<h3>Enviar E-mail</h3>
	<div class="alert alert-success">	
				
		<p><strong></a></strong> 
		Olá, 
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}
			%>esta preparado para o envio do e-mail de forma fácil e prática, a ser salvo no banco de dados do servidor. <strong><a href="modal_informativo.jsp" target="_parent">Dica!</a></strong></p>
	</div>
	<div class="row">
		<form action="EnviarController" method="post" role="form" id="contact-form" class="contact-form">
                    <div class="row">
                		<div class="col-md-6">
                  		<div class="form-group">
                            <input type="text" class="form-control" name="de" autocomplete="off" placeholder="Remetente - Adicionar somente um e-mail neste campo." required="true" style="height: 48px; width: 580px">
                  		</div>
                  	</div>
                    	<div class="col-md-6">
                  		<div class="form-group">
                            <input type="text" class="form-control" name="para" autocomplete="off" placeholder="Destinatário - Adicionar somente um e-mail neste campo." required="true" style="height: 48px; width: 580px">
                  		</div>
                  	</div>
                  	</div>
                  	<div class="row">
                		<div class="col-md-6">
                  		<div class="form-group">
                            <input type="text" class="form-control" name="lista" autocomplete="off" placeholder="CC - Adicionar somente um e-mail neste campo." required="true" style="height: 48px; width: 580px">
                  		</div>
                  	</div>
                    	<div class="col-md-6">
                  		<div class="form-group">
                            <input type="text" class="form-control" name="assunto" autocomplete="off" placeholder="Assunto" style="height: 48px; width: 580px">
                  		</div>
                  	</div>
                  	<!-- <div class="row">
                		<div class="col-md-6">
                  		<div class="form-group">
                            <input type="file" class="form-control" name="file" id="file" autocomplete="off" placeholder="File" required="true">
                  		</div>
                  	</div> -->                	
                  	</div>
                  	<div class="row">
                  		<div class="col-md-12">
                  		<div class="form-group">
                            <textarea class="form-control textarea" rows="3" name="mensagem" placeholder="Mensagem"></textarea>
                  		</div>
                  	</div>
                    </div>
                    <div class="row">
                    <div class="col-md-12">
                  		<button type="submit" name="enviar" class="btn main-btn pull-right">Enviar</button>
                  </div>
                  </div>
                </form>
	</div>
</div>
<script type="text/javascript">
$('#contact-form').bootstrapValidator({
//        live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            de: {
                validators: {
                    notEmpty: {
                        message: 'The Name is required and cannot be empty'
                    }
                }
            },
            para: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    },
                    emailAddress: {
                        message: 'The email address is not valid'
                    }
                }
            },
            Message: {
                validators: {
                    notEmpty: {
                        message: 'The Message is required and cannot be empty'
                    }
                }
            }
        }
    });
</script>
</body>
</html>


