<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.ListaOcorrencia"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Lista de Ocorrência</title>
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="bootstrap/modal/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="bootstrap/modal/bootstrap.min.js"></script>
    <script>
		$(document).ready(function () {
			$("input#submit").click(function(){
				$.ajax({
					type: "POST",
					url: "cadastro_lista_ocorrencia.jsp", // 
					data: $('form.contact').serialize(),
					success: function(msg){
						$("#thanks").html(msg)
						$("#form-content").modal('hide');	
					},
					error: function(){
						alert("Atenção verificar campo obtigatório!");
					}
				});
			});
		});
    </script>

	<style type="text/css">
		body { margin: 50px; background: url(assets/bglight.png); }
		.well { background: #fff; text-align: center; }
		.modal { text-align: left; }
	</style>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecsslivre.jsp"%>

</br></br>
	
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
	
<div class="container">
	<div class="well well-large">
		<h4>Este documento tem como objetivo listar todos os problemas<br> ou situações não previstas enfrentados durante o projeto e como foram solucionadas.</h4>
		<div id="form-content" class="modal hide fade in" style="display: none;">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h4>Lista Ocorrência</h4>
			</div>
			<div class="modal-body">
				<form action="TkcsapcdController">
				<input type="hidden" name="cmd" value="cadastrarListaOcorrencia"></input>
					<table class="table" border="0">
					    	<tr>
					    		<th>Código do Projeto</th>
					    		<th>Data</th>
					    		<th></th>
					    	</tr>
					    		<tr>
									<td>
									
									<!-- -<input type="text" id="codigoprojeto" name="codigoprojeto" class="form-control" placeholder="Código" aria-describedby="basic-addon2" required="true" onkeypress="return numbers(event);"/> -->
									
									<select id="codigoprojeto"	name="codigoprojeto" required="true">
											<option id="codigoprojeto"></option>
											<%
												List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
												for(ProjetoInicio ProjetoInicio: projetoInicios){
													out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
															                      + ProjetoInicio.getCodigoprojeto());
												}
											%>
									</select>									
									</td>
									<td><input type="text" id="data" name="data" class="form-control" placeholder="Data" aria-describedby="basic-addon2" value="00/00/0000"/></td>
									<td></td>
								</tr>
							<tr>
					    		<th>Gerente do Projeto</th>
					    		<th>Preparado por:</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="gerente" name="gerente" class="form-control" placeholder="Gerente de projeto" aria-describedby="basic-addon2" required="true"/></td>
									<td><input type="text" id="preparado" name="preparado" class="form-control" placeholder="Nome" aria-describedby="basic-addon2"/></td>
									<td></td>								
								</tr>							
					</table>
					<label class="label" for="issue">Cliente</label><br>
					<input type="text" id="cliente" name="cliente" class="input-xlarge"><br><br>
					<label class="label" for="issue">Descrição da Issue</label><br>
					<input type="text" id="issue" name="issue" class="input-xlarge"><br><br>
					<label class="label" for="severidade">Severidade</label><br>
					<input type="text" id="severidade" name="severidade" class="input-xlarge"><br><br>
					<label class="label" for="urgencia">Urgência</label><br>
					<input type="text" id="urgencia" name="urgencia" class="input-xlarge"><br><br>
					
					<label class="label" for="message">Objetivo do Documento</label><br>
					<textarea name="objetivo" id="objetivo" class="input-xlarge" cols="20" rows="5"></textarea><br><br>
					
					<label class="label" for="message">Resumo de Ocorrências</label><br>
					<textarea name="resumo" id="resumo" class="input-xlarge" cols="20" rows="5"></textarea>
					
					<table class="table" border="0">
					    	<tr>
					    		<th>Responsável</th>
					    		<th>Data de Conclusão</th>
					    		<th></th>
					    	</tr>
					    		<tr>
									<td><input type="text" id="responsavel" name="responsavel" class="form-control" placeholder="Nome Responsável" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="dataocorrencia" name="dataocorrencia" class="form-control" placeholder="Data" aria-describedby="basic-addon2" value="00/00/0000"/></td>
									<td></td>
								</tr>							
					</table>
					
					<label class="label" for="message">Conclusões / Recomendações</label><br>
					<textarea name="conclusao" id="conclusao" class="input-xlarge" cols="20" rows="5"></textarea>	
					
					<div class="modal-footer">
						<input class="btn btn-success" type="submit" value="Enviar" id="submit">
						<a href="#" class="btn" data-dismiss="modal">Cancelar</a>
					</div>				
					</form>
			</div>		
		</div>
		<br>
		<div id="thanks"><p><a data-toggle="modal" href="#form-content" class="btn btn-primary btn-large">Registrar</a></p></div>
	</div>
</div>
</body>
</html>
