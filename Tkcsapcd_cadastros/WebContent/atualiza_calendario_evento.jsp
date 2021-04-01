<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.CalendarioEvento"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.ProjetoInicio"%>
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
    <title>Atualizar Evento</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
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
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

<div class="container">
	<h3>Atualizar Evento</h3>
	<div class="alert alert-warning">	
				
		<p><strong></a></strong> 
		Olá, 
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}
			%>esta preparado para atualizar o evento de forma fácil e prática, a ser salvo no banco de dados do servidor.</p>
	</div>	
	<center>
		<h3>
			<font color="green"> ${mensagem}</font>
		</h3>
	</center>				
	<div class="row">
		<form action="TkcsapcdController" role="form" id="contact-form" class="contact-form">
					<input type="hidden" name="cmd" value="atualizarCalendarioEvento"></input>
					<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
						      <label for="sel1">Código Projeto:</label>		
								<input value="${calendarioEvento.codigoprojeto}" type="text" class="form-control" name="codigoprojeto" autocomplete="off" id="codigoprojeto" placeholder="">
						    </div>
						</div>
						<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Quando:</label>
	                            <input value="${calendarioEvento.data}" data-format='dd/MM/yyyy' type="text" class="form-control" name="data" autocomplete="off" id="data" placeholder="xx/xx/xxxx" required="true">
	                  		</div>
                  		</div>
					</div>
		                  	
                  	 <div class="row">
                		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Iniciar:</label>
                                    <input value="${calendarioEvento.iniciar}" type="text" class="form-control" name="iniciar" autocomplete="off" id="iniciar" placeholder="">
	                  		</div>
                  		</div>
                    	<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Local:</label>
	                            	<input type="text" class="form-control" name="local" autocomplete="off" id="local" placeholder="Local">	
	                  		</div>
                  		</div>
                  	</div>                  	
                  	
                  	<div class="row">
						<div class="col-md-6">
							<div class="form-group">
						      <label for="sel1">Frequência:</label>
		                      <input value="${calendarioEvento.frequencia}" type="text" class="form-control" name="frequencia" autocomplete="off" id="frequencia" placeholder="">
						    </div>
						</div>
						<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Responsável:</label>
	                            <input value="${calendarioEvento.responsavel}" type="text" class="form-control" name="responsavel" autocomplete="off" id="responsavel" placeholder="Reponsável pelo evento">
	                  		</div>
                  		</div>
					</div>
					
                  	<div class="row">
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Duração:</label>
	                  				<input value="${calendarioEvento.duracao}" type="text" class="form-control" name="duracao" autocomplete="off" id="duracao" placeholder="">	                            
	                  		</div>
                  		</div>
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Assunto:</label>
	                            <input value="${calendarioEvento.assunto}" type="text" class="form-control" name="assunto" autocomplete="off" id="assunto" placeholder="Adicionar um assunto">
	                  		</div>
                  		</div>
                  	</div>
                  	
                  	
                  	<div class="row">
                  		<div class="col-md-12">
	                  		<div class="form-group">
	                            <textarea class="form-control textarea" rows="3" name="descricao" id="descricao" placeholder="Adicionar uma descrição">${calendarioEvento.descricao}</textarea>
	                  		</div>
                  		</div>
                    </div>
                    
                    <div class="row">
                  		<div class="col-md-12">
	                  		<div class="form-group">
	                            <textarea class="form-control textarea" rows="3" name="participantes" id="participantes" placeholder="Adicionar e-mail de grupo perticipante. O sistema só permite disparar um e-mail. Adicionar somente um e-mail neste campo.">${calendarioEvento.participantes}</textarea>
	                  		</div>
                  		</div>
                    </div>
                    
                    <div class="row">
                    <div class="col-md-12">
                  <button type="submit" class="btn main-btn pull-right">Atualizar</button>
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
            codigoprojeto: {
                validators: {
                    notEmpty: {
                        message: 'The Name is required and cannot be empty'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    },
                    emailAddress: {
                        message: 'The email address is not valid'
                    }
                }
            },
            data: {
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
