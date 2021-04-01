<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Registrar Questionário</title>
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
    
    <script>
	function validateForm(theForm){

	if(theForm.quest.value==""){
			//Please enter username
			alert("Por favor, preencher todos os campos obrigatórios!");
			theForm.quest.focus();
			return false;
	}	
      return true;
    } 
   </script>
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<link rel="stylesheet" href="bootstrap/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="bootstrap/js/bootstrapValidator.min.js"></script>

<div class="container">
	<h3>Registrar Questionário</h3>
	<div class="alert alert-success">					
		<p><strong></a></strong> 
		Olá, 
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}
			%>esta preparado para iniciar o registro do questionário.</p>
	</div>
			
	<div class="row">
		<form method="post" action="processar_questionario.jsp" onsubmit="return validateForm(this);" role="form" id="contact-form" class="contact-form">
					
					 <div class="row">
                  		<div class="col-md-12">
	                  		<div class="form-group">
	                  			<label for="sel1">Entre com a Pergunta:</label>
	                            <textarea class="form-control textarea" rows="3" name="quest" placeholder="Adicionar uma pergunta neste campo!" required="true"></textarea>
	                  		</div>
                  		</div>
                    </div>
		                  	
                  	 <div class="row">                		
                    	<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Entre com a resposta (A):</label>
	                            	<input type="text" class="form-control" name="QA" autocomplete="off" placeholder="Adicionar uma resposta neste campo!" style="height: 48px; width: 1200px" required="true">	
	                  		</div>
                  		</div>
                  	</div>                  	
                  	
                  	<div class="row">						
						<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Entre com a resposta (B):</label>
	                            <input type="text" class="form-control" name="QB" autocomplete="off" placeholder="Adicionar uma resposta neste campo!" style="height: 48px; width: 1200px" required="true">
	                  		</div>
                  		</div>
					</div>
					
                  	<div class="row">                  		
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Entre com a resposta (C):</label>
	                            <input type="text" class="form-control" name="QC" autocomplete="off" placeholder="Adicionar uma resposta neste campo!" style="height: 48px; width: 1200px" required="true">
	                  		</div>
                  		</div>
                  	</div>
                  	
                  	<div class="row">                  		
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Entre com a resposta (D):</label>
	                            <input type="text" class="form-control" name="QD" autocomplete="off" placeholder="Adicionar uma resposta neste campo!" style="height: 48px; width: 1200px" required="true">
	                  		</div>
                  		</div>
                  	</div>
                  	
                  	<div class="row">                  		
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Entre com a resposta certa:</label>
	                            <input type="text" class="form-control" name="correctAns" autocomplete="off" placeholder="Exemplo: QA, QB, QC ou QD" style="height: 48px; width: 300px" required="true">
	                  		</div>
                  		</div>
                  	</div>
                    
                    <div class="row">
	                    <div class="col-md-12">
	                    	<input type="submit" value="Enviar" name="submit">                
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
            quest: {
                validators: {
                    notEmpty: {
                        message: 'Entre com a Pergunta!'
                    }
                }
            },            
            QA: {
                validators: {
                    notEmpty: {
                        message: 'Entre com a resposta (A)'
                    }
                }
            },
            QB: {
                validators: {
                    notEmpty: {
                        message: 'Entre com a resposta (B)'
                    }
                }
            },
            QC: {
                validators: {
                    notEmpty: {
                        message: 'Entre com a resposta (C)'
                    }
                }
            },
            QD: {
                validators: {
                    notEmpty: {
                        message: 'Entre com a resposta (D)'
                    }
                }
            },
            correctAns: {
                validators: {
                    notEmpty: {
                        message: 'Entre com a resposta certa'
                    }
                }
            }
        }
    });
</script>
<%@ include file="rodape.jsp" %>
</body>
</html>
