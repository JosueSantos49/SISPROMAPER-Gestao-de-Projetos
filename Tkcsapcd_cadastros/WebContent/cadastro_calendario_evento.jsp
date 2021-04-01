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
    <title>Registrar Evento</title>
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

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<link rel="stylesheet" href="bootstrap/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="bootstrap/js/bootstrapValidator.min.js"></script>

<div class="container">
	<h3>Registrar Evento</h3>
	<div class="alert alert-success">	
				
		<p><strong></a></strong> 
		Olá, 
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}
			%>esta preparado para iniciar o registro de evento de forma fácil e prática, a ser salvo no banco de dados do servidor.</p>
	</div>	
	<center>
		<h3>
			<font color="green"> ${mensagem}</font>
		</h3>
	</center>				
	<div class="row">
		<form action="TkcsapcdController" role="form" id="contact-form" class="contact-form">
					<input type="hidden" name="cmd" value="cadastrarCalendarioEvento"></input>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
						      <label for="sel1">Código Projeto:</label>				      
						      	<select id="codigoprojeto"	name="codigoprojeto" class="form-control" required="true">
									<option id="codigoprojeto"></option>
									<%
										ProjetoInicioDAO projetoInicio = new ProjetoInicioDAO();
										List <ProjetoInicio> resultado = projetoInicio.getProjetoInicios();
										for(ProjetoInicio pi: resultado){
									%>
									<option value=<%= pi.getCodigoprojeto() %>><%= pi.getCodigoprojeto() %></option>			
									<%} %>
								</select>
						    </div>
						</div>
						<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Quando:</label>
	                            <input data-format='dd/MM/yyyy' type="text" class="form-control" name="data" autocomplete="off" id="data" placeholder="xx/xx/xxxx" required="true" style="height: 48px; width: 470px">
	                  		</div>
                  		</div>
					</div>
		                  	
                  	 <div class="row">
                		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Iniciar:</label>
	                            <select name="iniciar" id="iniciar" class="form-control">
                                        <option value=""></option>
                                        <option value="00:00">00:00</option>
                                        <option value="00:30">00:30</option>
                                        <option value="01:00">01:00</option>
                                        <option value="02:00">02:00</option>
                                        <option value="03:00">03:00</option>
                                        <option value="04:00">04:00</option>
                                        <option value="04:30">04:30</option>
                                        <option value="05:00">05:00</option>
                                        <option value="05:30">05:30</option>
                                        <option value="06:00">06:00</option>
                                        <option value="06:30">06:30</option>
                                        <option value="07:00">07:00</option>
                                        <option value="07:30">07:30</option>
                                        <option value="08:00">08:00</option>
                                        <option value="08:30">08:30</option>
                                        <option value="09:00">09:00</option>
                                        <option value="09:30">09:30</option>
                                        <option value="10:00">10:00</option>
                                        <option value="10:30">10:30</option>
                                        <option value="11:00">11:00</option>
                                        <option value="11:30">11:30</option>
                                        <option value="12:00">12:00</option>
                                        <option value="12:30">12:30</option>
                                        <option value="13:00">13:00</option>
                                        <option value="13:30">13:30</option>
                                        <option value="14:00">14:00</option>
                                        <option value="00:00">14:30</option>
                                        <option value="00:00">15:00</option>
                                        <option value="00:00">15:30</option>
                                        <option value="00:00">16:00</option>
                                        <option value="00:00">16:30</option>
                                        <option value="00:00">17:00</option>
                                        <option value="00:00">17:30</option>
                                        <option value="00:00">18:00</option>
                                        <option value="00:00">18:30</option>
                                        <option value="00:00">19:00</option>
                                        <option value="00:00">19:30</option>
                                        <option value="00:00">20:00</option>
                                        <option value="00:00">20:30</option>
                                        <option value="00:00">21:00</option>
                                        <option value="00:00">21:30</option>
                                        <option value="00:00">22:00</option>
                                        <option value="00:00">22:30</option>
                                        <option value="00:00">23:00</option>
                                        <option value="00:00">23:30</option>
                                    </select>
	                  		</div>
                  		</div>
                    	<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Local:</label>
	                            	<input type="text" class="form-control" name="local" autocomplete="off" id="local" placeholder="Local" style="height: 48px; width: 470px">	
	                  		</div>
                  		</div>
                  	</div>                  	
                  	
                  	<div class="row">
						<div class="col-md-6">
							<div class="form-group">
						      <label for="sel1">Frequência:</label>				      
						      <select name="frequencia" id="frequencia" class="form-control">
		                        <option value=""></option>
		                        <option value="Uma vez">Uma vez</option>
		                        <option value="Diariamente">Diariamente</option>
		                        <option value="Mensalmente">Mensalmente</option>
		                        <option value="Anualmente">Anualmente</option>
		                      </select>
						    </div>
						</div>
						<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Responsável:</label>
	                            <input type="text" class="form-control" name="responsavel" autocomplete="off" id="responsavel" placeholder="Reponsável pelo evento" style="height: 48px; width: 470px">
	                  		</div>
                  		</div>
					</div>
					
                  	<div class="row">
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Duração:</label>
	                  				<select name="duracao" id="duracao" class="form-control">
                                        <option value=""></option>
                                        <option value="00:00">0 minutos</option>
                                        <option value="00:30">30 minutos</option>
                                        <option value="01:00">1 hora</option>
                                        <option value="02:00">90 minutos</option>
                                        <option value="03:00">2 horas</option>
                                        <option value="04:00">O dia inteiro</option>
                                        <option value="04:30">Personalizado</option>
                                    </select>
	                            
	                  		</div>
                  		</div>
                  		<div class="col-md-6">
	                  		<div class="form-group">
	                  			<label for="sel1">Assunto:</label>
	                            <input type="text" class="form-control" name="assunto" autocomplete="off" id="assunto" placeholder="Adicionar um assunto" style="height: 48px; width: 470px">
	                  		</div>
                  		</div>
                  	</div>
                  	
                  	
                  	<div class="row">
                  		<div class="col-md-12">
	                  		<div class="form-group">
	                            <textarea class="form-control textarea" rows="3" name="descricao" id="descricao" placeholder="Adicionar uma descrição"></textarea>
	                  		</div>
                  		</div>
                    </div>
                    
                    <div class="row">
                  		<div class="col-md-12">
	                  		<div class="form-group">
	                            <textarea class="form-control textarea" rows="3" name="participantes" id="participantes" placeholder="Adicionar e-mail de grupo perticipante. O sistema só permite disparar um e-mail. Adicionar somente um e-mail neste campo." required="true"></textarea>
	                  		</div>
                  		</div>
                    </div>
                    
                    <div class="row">
                    <div class="col-md-12">
                  <button type="submit" class="btn main-btn pull-right">Enviar</button>
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
<%@ include file="rodape.jsp" %>
</body>
</html>
