<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.RecursosHumanos"%>
<%@ page import="br.com.tkcsapcd.model.bean.RecursosHumanos"%>

<jsp:include page="sessao.jsp" />
<html>
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<title>Atualizar Pessoa Envolvida no Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->	
<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery.validate.min.js"></script> 
<script src="js/jquery.maskedinput.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/funcoes.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorio.js"></script>

<!-- Configuração para exibir modal automaticamente -->
 <script type="text/javascript">
	  $(document).ready(function () {
		  $('#myModal').modal('show');
	  });
</script>

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#consProjeto1").mask("99/99/9999");
	});
</script >

<script src="excellentexport-master/excellentexport.js"></script>

<style>
table,tr,td {
	border: 0px black solid;
}
</style>
<style>      
  .text-center { 
    text-align: center; 
  }

  .marketing h1 {
    font-size: 50px;
    font-weight: lighter;
    line-height: 1;
  }

  .marketing p {
    font-size: 18px;
  }  
 </style>
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<div id="preloader">
		<h1>
			<img src="img/ajax-loaderazul.gif" height="30px">
		</h1>
	</div>
	
<%@include file="menuperantecsslivre.jsp"%>

 
<br><br>
		<div align="justify">			
			  <div class="page-container">
				    <div class="container" style="position: relative">      
				      <div class="row">
				        <div class="col-md-10">                             
				          <div class="ajax" style="position: relative; overflow: hidden">            
				            <div class="marketing">
				        		<p class="muted"><font color="red">Clique para registrar pessoas ao projeto!</font></p>           
				            	<button type="button" class="demo btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Atualizar Registro de Pessoas</button>
				            	<a href="TkcsapcdController?cmd=consultarEnvolvimentoPessoaProjetoInicio" class="btn">Listar Registro de Pessoas</a>            
				            </div>
				          </div>
				          <br/>          
				        </div>
				      </div>
				    </div>
					<div id="ajax-modal" class="modal fade" tabindex="-1" style="display: none;"></div>
					</div>
					
					<br>				
							<!-- Modal Relatório -->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog modal-lg">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">${mensagem}</h4>
								          <h5>Atualizar Envolvimento de Pessoas</h5>
								        </div>
								        <div class="modal-body">
								        
								        
								        
								        <div class="table-responsive">
								        
								       	<form action="TkcsapcdController">
								       
								       	<input type="hidden" name="cmd" value="atualizarEnvolvimentoPessoaProjetoInicio"></input>
										<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
								        
												<table id="tabela" cellspacing="5" cellspacing="5" class="display">
													<thead>
														<tr>
															<th>Projeto</th>
															<th>Organização</th>
															<th>Recursos Humanos</th>
															<th>Tipo RH</th>
															<th>Período</th>
															<th>Esforço Prévio</th>
														</tr>
													</thead>
													<tbody>
														<!-- 1 linha -->
														<tr>		
															<td>
																<select id="codigoprojeto1"	name="codigoprojeto1" class="form-control" required="true">
																		<option id="codigoprojeto1">${envolvimentoPessoaProjetoInicio.codigoprojeto1}</option>
																		<%
																			List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
																			for(ProjetoInicio ProjetoInicio: projetoInicios){
																				out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
																						                      + ProjetoInicio.getCodigoprojeto());
																			}
																		%>
																</select>
															</td>		
															<td>
																<select id="organizacao1" name="organizacao1" class="form-control" required="true">
																	<option id="organizacao1">${envolvimentoPessoaProjetoInicio.organizacao1}</option>
																	<option>Organização 1</option>
																	<option>Organização 2</option>
																<select>
															</td>
															
															<td>																
																<select id="rh1" name="rh1" class="form-control" required="true">
																	<option id="rh1">${envolvimentoPessoaProjetoInicio.rh1}</option>
																		<%
																		List<RecursosHumanos> recursosHumanoss = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
																		for(RecursosHumanos recursosHumanos: recursosHumanoss){
																				out.println("<option value='" + recursosHumanos.getNome() + "'>"
																						                      + recursosHumanos.getNome());
																			}
																		%>
																</select>
															</td>
															<td>
																<select id="tiporh1" name="tiporh1" class="form-control" required="true">																	
																	<option>${envolvimentoPessoaProjetoInicio.tiporh1}</option>
																	<option>Responsável</option>
																	<option>Analista de Sistemas</option>
																	<option>Executor</option>
																	<option>Equipe</option>
																	<option>Valida</option>
																	<option>Avalia</option>
																	<option>Comenta</option>
																	<option>Observa</option>
																<select>
															</td>
															<td>
																<input type="text" id="periodo1" name="periodo1" size="1" class="form-control" required="true" value="${envolvimentoPessoaProjetoInicio.periodo1}" style="height: 30px; width: 150px"/>
															</td>
															<td>
																<input type="text" id="esforco1" name="esforco1" size="1" class="form-control" required="true" value="${envolvimentoPessoaProjetoInicio.esforco1}" style="height: 30px; width: 100px"/>
															</td>
														</tr>	
														<!-- fim 1 linha -->	
														
														<!-- 2 linha -->
														<tr>		
															<td>
																<select id="codigoprojeto2"	name="codigoprojeto2" class="form-control">
																		<option id="codigoprojeto2">${envolvimentoPessoaProjetoInicio.codigoprojeto2}</option>
																		<%
																			List<ProjetoInicio> projetoInicios2 = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
																			for(ProjetoInicio ProjetoInicio: projetoInicios){
																				out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
																						                      + ProjetoInicio.getCodigoprojeto());
																			}
																		%>
																</select>
															</td>		
															<td>
																<select id="organizacao2" name="organizacao2" class="form-control">
																	<option id="organizacao2">${envolvimentoPessoaProjetoInicio.organizacao2}</option>
																	<option>Organização 1</option>
																	<option>Organização 2</option>
																<select>
															</td>
															
															<td>																
																<select id="rh2" name="rh2" class="form-control">
																	<option id="rh2">${envolvimentoPessoaProjetoInicio.rh2}</option>
																		<%
																		List<RecursosHumanos> recursosHumanoss2 = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
																		for(RecursosHumanos recursosHumanos: recursosHumanoss){
																				out.println("<option value='" + recursosHumanos.getNome() + "'>"
																						                      + recursosHumanos.getNome());
																			}
																		%>
																</select>
															</td>
															<td>
																<select id="tiporh2" name="tiporh2" class="form-control">
																	<option>${envolvimentoPessoaProjetoInicio.tiporh2}</option>
																	<option>Responsável</option>
																	<option>Analista de Sistemas</option>
																	<option>Executor</option>
																	<option>Equipe</option>
																	<option>Valida</option>
																	<option>Avalia</option>
																	<option>Comenta</option>
																	<option>Observa</option>
																<select>
															</td>
															<td>
																<input type="text" id="periodo2" name="periodo2" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.periodo2}" style="height: 30px; width: 150px"/>
															</td>
															<td>
																<input type="text" id="esforco2" name="esforco2" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.esforco2}" style="height: 30px; width: 100px"/>
															</td>
														</tr>
														<!-- fim 2 linha -->	
														
														<!-- 3 linha -->
														<tr>		
															<td>
																<select id="codigoprojeto3"	name="codigoprojeto3" class="form-control">
																		<option id="codigoprojeto3">${envolvimentoPessoaProjetoInicio.codigoprojeto3}</option>
																		<%
																			List<ProjetoInicio> projetoInicios3 = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
																			for(ProjetoInicio ProjetoInicio: projetoInicios){
																				out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
																						                      + ProjetoInicio.getCodigoprojeto());
																			}
																		%>
																</select>
															</td>		
															<td>
																<select id="organizacao3" name="organizacao3" class="form-control">
																	<option id="organizacao3">${envolvimentoPessoaProjetoInicio.organizacao3}</option>
																	<option>Organização 1</option>
																	<option>Organização 2</option>
																<select>
															</td>
															
															<td>																
																<select id="rh3" name="rh3" class="form-control">
																	<option id="rh3">${envolvimentoPessoaProjetoInicio.rh3}</option>
																		<%
																		List<RecursosHumanos> recursosHumanoss3 = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
																		for(RecursosHumanos recursosHumanos: recursosHumanoss){
																				out.println("<option value='" + recursosHumanos.getNome() + "'>"
																						                      + recursosHumanos.getNome());
																			}
																		%>
																</select>
															</td>
															<td>
																<select id="tiporh3" name="tiporh3" class="form-control">
																	<option>${envolvimentoPessoaProjetoInicio.tiporh3}</option>
																	<option>Responsável</option>
																	<option>Analista de Sistemas</option>
																	<option>Executor</option>
																	<option>Equipe</option>
																	<option>Valida</option>
																	<option>Avalia</option>
																	<option>Comenta</option>
																	<option>Observa</option>
																<select>
															</td>
															<td>
																<input type="text" id="periodo3" name="periodo3" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.periodo3}" style="height: 30px; width: 150px"/>
															</td>
															<td>
																<input type="text" id="esforco3" name="esforco3" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.esforco3}" style="height: 30px; width: 100px"/>
															</td>
														</tr>
														<!-- fim 3 linha -->
														
														<!-- 4 linha -->
														<tr>		
															<td>
																<select id="codigoprojeto4"	name="codigoprojeto4" class="form-control">
																		<option id="codigoprojeto4">0</option>
																		<%
																			List<ProjetoInicio> projetoInicios4 = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
																			for(ProjetoInicio ProjetoInicio: projetoInicios){
																				out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
																						                      + ProjetoInicio.getCodigoprojeto());
																			}
																		%>
																</select>
															</td>		
															<td>
																<select id="organizacao4" name="organizacao4" class="form-control">
																	<option id="organizacao4">${envolvimentoPessoaProjetoInicio.organizacao4}</option>
																	<option>Organização 1</option>
																	<option>Organização 2</option>
																<select>
															</td>
															
															<td>																
																<select id="rh4" name="rh4" class="form-control">
																	<option id="rh4">${envolvimentoPessoaProjetoInicio.rh4}</option>
																		<%
																		List<RecursosHumanos> recursosHumanoss4 = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
																		for(RecursosHumanos recursosHumanos: recursosHumanoss){
																				out.println("<option value='" + recursosHumanos.getNome() + "'>"
																						                      + recursosHumanos.getNome());
																			}
																		%>
																</select>
															</td>
															<td>
																<select id="tiporh4" name="tiporh4" class="form-control">
																	<option>${envolvimentoPessoaProjetoInicio.tiporh4}</option>
																	<option>Responsável</option>
																	<option>Analista de Sistemas</option>
																	<option>Executor</option>
																	<option>Equipe</option>
																	<option>Valida</option>
																	<option>Avalia</option>
																	<option>Comenta</option>
																	<option>Observa</option>
																<select>
															</td>
															<td>
																<input type="text" id="periodo4" name="periodo4" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.periodo4}" style="height: 30px; width: 150px"/>
															</td>
															<td>
																<input type="text" id="esforco4" name="esforco4" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.esforco4}" style="height: 30px; width: 100px"/>
															</td>
														</tr>
														<!-- fim 4 linha -->
														
														<!-- 5 linha -->
														<tr>		
															<td>
																<select id="codigoprojeto5"	name="codigoprojeto5" class="form-control">
																		<option id="codigoprojeto5">${envolvimentoPessoaProjetoInicio.codigoprojeto5}</option>
																		<%
																			List<ProjetoInicio> projetoInicios5 = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
																			for(ProjetoInicio ProjetoInicio: projetoInicios){
																				out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
																						                      + ProjetoInicio.getCodigoprojeto());
																			}
																		%>
																</select>
															</td>		
															<td>
																<select id="organizacao5" name="organizacao5" class="form-control">
																	<option id="organizacao5">${envolvimentoPessoaProjetoInicio.organizacao5}</option>
																	<option>Organização 1</option>
																	<option>Organização 2</option>
																<select>
															</td>
															
															<td>																
																<select id="rh5" name="rh5" class="form-control">
																	<option id="rh5">${envolvimentoPessoaProjetoInicio.rh5}</option>
																		<%
																		List<RecursosHumanos> recursosHumanoss5 = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
																		for(RecursosHumanos recursosHumanos: recursosHumanoss){
																				out.println("<option value='" + recursosHumanos.getNome() + "'>"
																						                      + recursosHumanos.getNome());
																			}
																		%>
																</select>
															</td>
															<td>
																<select id="tiporh5" name="tiporh5" class="form-control">
																	<option>${envolvimentoPessoaProjetoInicio.tiporh5}</option>
																	<option>Responsável</option>
																	<option>Analista de Sistemas</option>
																	<option>Executor</option>
																	<option>Equipe</option>
																	<option>Valida</option>
																	<option>Avalia</option>
																	<option>Comenta</option>
																	<option>Observa</option>
																<select>
															</td>
															<td>
																<input type="text" id="periodo5" name="periodo5" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.periodo5}" style="height: 30px; width: 150px"/>
															</td>
															<td>
																<input type="text" id="esforco5" name="esforco5" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.esforco5}" style="height: 30px; width: 100px"/>
															</td>
														</tr>
														<!-- fim 5 linha -->
																												
														<!-- 6 linha -->
														<tr>		
															<td>
																<select id="codigoprojeto6"	name="codigoprojeto6" class="form-control">
																		<option id="codigoprojeto6">${envolvimentoPessoaProjetoInicio.codigoprojeto6}</option>
																		<%
																			List<ProjetoInicio> projetoInicios6 = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
																			for(ProjetoInicio ProjetoInicio: projetoInicios){
																				out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
																						                      + ProjetoInicio.getCodigoprojeto());
																			}
																		%>
																</select>
															</td>		
															<td>
																<select id="organizacao6" name="organizacao6" class="form-control">
																	<option id="organizacao6">${envolvimentoPessoaProjetoInicio.organizacao6}</option>
																	<option>Organização 1</option>
																	<option>Organização 2</option>
																<select>
															</td>
															
															<td>																
																<select id="rh6" name="rh6" class="form-control">
																	<option id="rh6">${envolvimentoPessoaProjetoInicio.rh6}</option>
																		<%
																		List<RecursosHumanos> recursosHumanoss6 = (List<RecursosHumanos>) request.getAttribute("recursosHumanoss");
																		for(RecursosHumanos recursosHumanos: recursosHumanoss){
																				out.println("<option value='" + recursosHumanos.getNome() + "'>"
																						                      + recursosHumanos.getNome());
																			}
																		%>
																</select>
															</td>
															<td>
																<select id="tiporh6" name="tiporh6" class="form-control">
																	<option>${envolvimentoPessoaProjetoInicio.tiporh6}</option>
																	<option>Responsável</option>
																	<option>Analista de Sistemas</option>
																	<option>Executor</option>
																	<option>Equipe</option>
																	<option>Valida</option>
																	<option>Avalia</option>
																	<option>Comenta</option>
																	<option>Observa</option>
																<select>
															</td>
															<td>
																<input type="text" id="periodo6" name="periodo6" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.periodo6}" style="height: 30px; width: 150px"/>
															</td>
															<td>
																<input type="text" id="esforco6" name="esforco6" size="1" class="form-control" value="${envolvimentoPessoaProjetoInicio.esforco6}" style="height: 30px; width: 100px"/>
															</td>
														</tr>
														<!-- fim 6 linha -->				
													</tbody>
												</table>
												<br>
												
												<div class="modal-footer">		
													<input type="submit" value="Executar" class="btn btn-default">						        	
										          	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
										        </div>
												</form>												
											</div>
								        </div>
								        							        
								        
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Relatório -->	
				</div>
	<%@include file="rodape.jsp" %>
</body>
</html>