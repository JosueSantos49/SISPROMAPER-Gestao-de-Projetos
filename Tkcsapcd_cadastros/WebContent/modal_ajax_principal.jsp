<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html> 
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Menu Sugerido</title>

<script type="" src="js/funcoesNumeroLetras.js"></script>
<style> .modal-body { max-height: 800px; } </style>

<script language="javascript" src="js/TexteareCadastroProjetoInicio.js"></script>

</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h3>SISPROMAPER</h3>
	</div>
	
	<form action="TkcsapcdController"> <!-- Inicio form -->
	<input type="hidden" name="cmd" value="cadastrarProjetoInicio"></input>
	
	<div class="modal-body">
		
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab1" data-toggle="tab">Passo 1</a></li>												
		</ul>
		
		 <div class="alert alert-success">
			Olá, 
			<%=session.getAttribute("theName")%>
				<%  
				//verifica se a sessao do usuario é válida  
				if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
			%>
			seja bem-vindo a etapa do registro do projeto ou proposta de projeto. Fique atento aos campos obrigatórios. Um projeto é um
	 		esforço temporário empreendido para criar um produto, serviço ou resultado exclusivo. 
		</div>	
										
		<div class="tab-content">
		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Novo Projeto</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
					    		<th>Código</th>
					    		<th>Projeto</th>
					    		<!-- <th>Data Registro</th> -->
					    	</tr>
					    		<tr>
									<td><input type="text" id="codigoprojeto" name="codigoprojeto" class="form-control" style="height: 30px; width: 150px" placeholder="Código" aria-describedby="basic-addon2" required="true" onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="projeto" name="projeto" class="form-control" style="height: 30px; width: 379px" placeholder="Projeto" aria-describedby="basic-addon2" required="true"/></td>
									<!-- Salvar Data Atual <td><input type="text" id="data" name="data" style="height: 30px; width: 150px" placeholder="dd/mm/yyyyy"/></td> -->										
								</tr>
							<tr>
					    		<th>Atribuir como:</th>
					    		<th>Tipo de Projeto</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td>
										<div class="form-group">
										  <!-- <label for="sel1">Selecionar lista:</label>  -->
										  <select class="form-control" id="atribuiprojeto" name="atribuiprojeto">
										    <option></option>
										    <option value="Projeto">Projeto</option>
										    <option value="Proposta Projeto">Proposta de Projeto</option>
										  </select>
										</div>
									</td>
									<td>
										<div class="form-group">
										  <!-- <label for="sel1">Selecionar lista:</label>  -->
										  <select class="form-control" id="tipoprojeto" name="tipoprojeto">
										    <option></option>
										    <option value="Construção">Construção</option>
										    <option value="Desenvolvimento">Desenvolvimento</option>
										    <option value="Educacional">Educacional</option>
										    <option value="Software">Software</option>
										    <option value="Hardware">Hardware</option>
										    <option value="Logística">Logística</option>
										    <option value="Infra-estrutura">Infra-estrutura</option>
										    <option value="Marketing">Marketing</option>
										    <option value="Mercado">Mercado</option>
										    <option value="RH">RH</option>
										    <option value="Social">Social</option>
										    <option value="Pesquisa">Pesquisa</option>
										    <option value="Metodologia">Metodologia</option>
										    <option value="Processamento">Processamento</option>
										    <option value="Outros">Outros</option>
										  </select>
										</div>							 		
							 		</td>	
							 		<td></td>								
								</tr>
							<tr>
					    		<th>Objetivo:</th>
					    		<th></th>
					    		<th></th>
					    	</tr>
					    		<tr>
									<td colspan="3">
										<div class="form-group">
										  <label for="comment">Descrever o objetivo:</label>
										   <textarea id="objetivo" name="objetivo" rows="16" cols="150" onkeyup="mostrarResultadoEtapa1(this.value,2000,'spcontando0');contarCaracteresEtapa1(this.value,2000,'sprestante0')"></textarea>
										
											<h5 align="left">
												<font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family: Arial;"></span></font>
											</h5>
											<h5 align="left">
												<font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family: Arial;"></span></font>
											</h5>
										</div>
									</td>
									<td></td>
									<td></td>
								</tr>					
							<tr>
					    		<th>Cliente:</th>
					    		<th>Programa</th>
					    		<th>Área de Execução</th>
					    	</tr>
								<tr>
									<td><input type="text" id="cliente" name="cliente" class="form-control" style="height: 30px; width: 379px" placeholder="Cliente" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="programa" name="programa" class="form-control" style="height: 30px; width: 379px" placeholder="Programa" aria-describedby="basic-addon2"/></td>
									<td>
										<div class="form-group">
										  <!-- <label for="sel1"></label> -->
										  <select class="form-control" id="area" name="area">
										  	<option value=""></option>
										    <option value="Presidência">Presidência</option>
										    <option value="Administração">Administração</option>
										    <option value="Infra-estrutura">Infra-estrutura</option>
										    <option value="Infra-estrutura Operacional">Infra-estrutura Operacional</option>										    
										    <option value="RH">RH</option>
										    <option value="PMO">PMO</option>
										    <option value="Fiscal">Fiscal</option>
										    <option value="Financeiro">Financeiro</option>
										    <option value="Engenharia">Engenharia</option>
										    <option value="Outros">Outros</option>
										  </select>
										</div>	
									</td>
								</tr>
							<tr>
								<th>E-mail:</th>
					    		<th>Roi:</th>
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" class="form-control" name="copia" style="height: 30px; width: 379px" autocomplete="off" placeholder="E-mail"/></td>
									<td><input type="text" id="roi" name="roi" value="0" class="form-control" style="height: 30px; width: 379px" placeholder="Retorno sobre investimento" aria-describedby="basic-addon2"/></td>
									<td></td>									
								</tr>
							<tr>
					    		<th>Descrição:</th>
					    		<th></th>
					    		<th></th>
					    	</tr>
								<tr>
									<td colspan="3">
										<div class="form-group">
										  <label for="comment"></label>
										  <textarea rows="16" cols="150" id="descricao" name="descricao" onkeyup="mostrarResultadoEtapa2(this.value,2000,'spcontando');contarCaracteresEtapa2(this.value,2000,'sprestante')"></textarea>
							
											<h5 align="left">
												<font size="1" color="#6C7B8B"><span id="spcontando" style="font-family: Arial;"></span></font>
											</h5>
											<h5 align="left">
												<font size="1" color="#6C7B8B"><span id="sprestante" style="font-family: Arial;"></span></font>
											</h5>
							
										</div>
									</td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div>
					
		<button class="btn update">Update</button>
		
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn">Continuar</button>
		<button type="button" data-dismiss="modal" class="btn">Fechar</button>
	</div>
	
</body>
</html>