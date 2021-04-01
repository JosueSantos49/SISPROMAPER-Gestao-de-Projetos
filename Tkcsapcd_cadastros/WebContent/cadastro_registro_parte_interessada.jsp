<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.RegistroParteInteressada"%>


<html>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon">

<title>Cadastrar Registro das Partes Interessadas</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroRegistroParteInteressada.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<%@include file="autocompletar.jsp" %>

<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
}
-->
</style>

<!-- Calendário -->
<script>
	$(function() {
		$("#data").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#dataimplantacaoprevista").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<!-- Dialogo -->
<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			height : 150,
			modal : true,
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#data").mask("99/99/9999"); //dataProjeto  
	});
</script>

<script>
	$(function() {
		$("#").datepicker({//dataProjeto
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<script>
	function show_confirm() {

		var r = confirm("Click em OK, para continuar!");
		if (r == true) {
			alert("Continuando...");
			return true;
		} else {
			alert("Click em OK, para cancelar!");
			location.href = "TkcsapcdController?cmd=consultarregistroParteInteressada";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("registroParteInteressada").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">
	
	<div class="wow fadeInDown top__element" data-wow-delay="1s">
		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">REGISTRO DAS PARTES INTERESSADAS</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O registro das partes interessadas contém todos os detalhes relativos às partes identificadas.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Registro das partes interessadas</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Definir a importância da parte interessada. (Importância = Poder na empresa x Interesse no projeto) onde:<br>

										Poder: Nível de autoridade / Posição hierárquica ou de carisma ou liderança pessoal;<br>
										Interesse: Nível de preocupação em relação aos resultados do projeto.<br><br>
										
										O registro das partes interessadas contém todos os detalhes relativos às partes identificadas, incluindo, entre outros:

										Informações de identificação:
										nome, posição na organização, local, papel no projeto, informações de contato.<br><br>
										
										Informações de avaliação:
										requisitos essenciais, principais expectativas,
										influência potencial no projeto, fase de maior interesse no ciclo de vida.<br><br>
										
										Classificação das partes interessadas:
										interna/externa,
										apoiadora/neutra/resistente, etc.<br><br>										
										
										Saída de: Identificar as partes interessadas<br>
										Entrada para: Coletar os requisitos; Planejar o gerenciamento da qualidade; Planejar o gerenciamento das comunicações;
										Identificar os riscos.
				                    </div>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
				<!-- Fim Modal explicando o objetivo da transação -->
				
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigatório.<br></font>
					</p>
					<br>
				</div>
				<br> 
				<input type="hidden" name="cmd" value="cadastrarRegistroParteInteressada"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
					<tr>
						<td>
							<p>
								<font color="red">Campos de (*) obrigatório.</font>
							</p>
							<br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Registro Parte Interessada <font color="red">*</font></b></p>
						<p align="justify">
								<input id="registroparteinteressada" name="registroparteinteressada"
									style="height: 30px; width: 379px" maxlength="150"
									value="${registroParteInteressada.registroparteinteressada}" class="input" required="true"></input>
							<p class="hint">[Informar Registro da Parte Interessada]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Projeto <font color="red">*</font></b></p>
						<p align="justify">
									
							<select id="projetoinicio"	name="projetoinicio" style="width: 150px" class="form-control">
								<option id="projetoinicio">Selecionar</option>
								<%
									ProjetoInicioDAO projetoInicio = new ProjetoInicioDAO();
									List <ProjetoInicio> resultado = projetoInicio.getProjetoInicios();
									for(ProjetoInicio pi: resultado){
								%>
								<option value=<%= pi.getCodigo() %>><%= pi.getProjeto() %></option>			
								<%} %>
						</select>
							<p class="hint">[Informar o Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>					
					<tr class="field">
						<td><p align="justify">
								<b>Código de Registro Parte Interessada <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoparteinteressada" name="codigoparteinteressada"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${registroParteInteressada.codigoparteinteressada}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o Código de Registro Parte Interessada]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Versão <font color="red">*</font></b>
						<p align="justify">
								<input id="versao" name="versao"
									style="height: 30px; width: 100px"
									value="${registroParteInteressada.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a versão.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Importância <font color="red">*</font></b>
						<p align="justify">
								<input id="importancia" name="importancia"
									style="height: 30px; width: 100px"
									value="${registroParteInteressada.importancia}"
									 class="input" required="true"></input>
							<p class="hint">[Informar a importância.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data <font color="red">*</font></b>
						<p align="justify">
								<input id="data" name="data"
									style="height: 30px; width: 100px"
									value="${registroParteInteressada.data}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Autor <font color="red">*</font></b></p>
						<p align="justify">
								<input id="autor" name="autor"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${registroParteInteressada.autor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o autor]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Notas de revisão <font color="red">*</font></b></p>
						<p align="justify">
								<input id="notarevisao" name="notarevisao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${registroParteInteressada.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revisão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Parte interessada <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="parteinteressada" name="parteinteressada" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,500,'spcontando0');contarCaracteresEtapa1(this.value,500,'sprestante0')"></textarea>
							<p class="hint">[Pessoa, comunidade ou organização envolvida cujos interesses podem ser afetados pelo projeto. Exercem influência sobre o projeto, suas entregas e sua equipe]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando0"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante0"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Empresa  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="empresa" name="empresa" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,500,'spcontando');contarCaracteresEtapa2(this.value,500,'sprestante')"></textarea>
							<p class="hint">[Empresa]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Função no projeto <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="funcaoprojeto" name="funcaoprojeto" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,500,'spcontando1');contarCaracteresEtapa3(this.value,500,'sprestante1')"></textarea>
							<p class="hint">[Função que exerce no projeto]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando1"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante1"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
					<td><p align="justify">
							E-mail <font color="red">*</font>
						<p align="justify">
							<input id="email" name="email" style="height: 30px; width: 379px"
								class="input" value="${registroParteInteressada.email}"
								Placeholder="exemplo@exemplo.com.br"></input></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><p align="justify">Celular <font color="red">*</font>
							<p align="justify">
								<input id="celular" name="celular"
									style="height: 30px; width: 150px" class="input"
									value="${registroParteInteressada.celular}"
									maxlength="9"
									onKeyPress="return digitos(event, this);"></input>(xxx-xxxxx-xxxx)</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
					<td><p align="justify">Telefone <font color="red">*</font>
						<p align="justify">
							<input id="fone" name="fone" style="height: 30px; width: 150px"
								class="input" value="${registroParteInteressada.fone}"></input>(xxx-xxxx-xxxx)</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Requisitos de Comunicação <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="requisito" name="requisito" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,500,'spcontando2');contarCaracteresEtapa4(this.value,500,'sprestante2')"></textarea>
							<p class="hint">[Quando houver necessidades de informação específicas]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando2"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante2"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Principais responsabilidades <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsabilidade" name="responsabilidade" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,500,'spcontando3');contarCaracteresEtapa5(this.value,500,'sprestante3')"></textarea>
							<p class="hint">[Principais responsabilidades a serem exercidas no projeto]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando3"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante3"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Principais expectativas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="expectativas" name="expectativas" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,500,'spcontando4');contarCaracteresEtapa6(this.value,500,'sprestante4')"></textarea>
							<p class="hint">[Principais expectativas a serem atendidas]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando4"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante4"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Poder na empresa <font color="red">*</font></b></p>
						<p align="justify">
								<input id="poder" name="poder"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${registroParteInteressada.poder}" class="input" required="true">
								</input>
							<p class="hint">[Nível de autoridade; Posição hierárquica ou de carisma ou liderança pessoal. Exemplo: 1-Muito baixo, 2-Baixo, 3-Médio, 4-Alto e 5-Muito Alto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>					
					<tr class="field">
						<td><p align="justify">
								<b>Interesse no projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="interesse" name="interesse"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${registroParteInteressada.interesse}" class="input" required="true">
								</input>
							<p class="hint">[Nível de preocupação em relação aos resultados do projeto. Exemplo: 1-Muito baixo, 2-Baixo, 3-Médio, 4-Alto e 5-Muito Alto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentários<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentario" name="comentario" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,500,'spcontando5');contarCaracteresEtapa7(this.value,500,'sprestante5')"></textarea>
							<p class="hint">[Comentários quando desejar registrar mais alguma informação relevante]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando5"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante5"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>E-mail Confirmação<font color="red">*</font></b></p>
						<p align="justify">
								<input type="text" name="para"
									style="height: 30px; width: 379px" 
									maxlength="150" 
									placeholder="Destinatário"
									class="input" 
									required="true"></input>
							<p class="hint">[Inserir e-mail para receber confirmação de registro, por e-mail.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprovação<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aprovacao" name="aprovacao" required="true"
								onkeyup="mostrarResultadoEtapa19(this.value,500,'spcontando17');contarCaracteresEtapa19(this.value,500,'sprestante17')"></textarea>
							<p class="hint">[Participantes, datas, etc.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando17"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante17"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Cadastrar"
					onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
