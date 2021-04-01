<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma"%>
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

<title>Cadastrar Plano de Gerenciamento do Cronograma</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereCronograma.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarPlanoGerenciamentoCronograma";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("planogerenciamentoCronograma").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PLANO DE GERENCIAMENTO DO CRONOGRAMA</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O Plano de gerenciamento do cronograma estabelece os critérios e as atividades para o desenvolvimento e o controle do cronograma do projeto.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Plano de gerenciamento do cronograma</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	O Plano de gerenciamento do cronograma estabelece os critérios e as atividades para o desenvolvimento e o controle do cronograma do projeto.<br>
										Ele faz parte ou é um plano auxiliar do plano de gerenciamento do projeto.<br>
										Apesar de não ser citado diretamente como saída do processo Desenvolver o plano de gerenciamento do projeto, ele é um dos planos auxiliares relacionados.<br><br>
										Saída de: 4.2 Desenvolver o plano de gerenciamento do projeto.<br><br>
										Entrada para:</br>										
										11.1 Planejar o gerenciamento dos riscos</br>
										11.2 Identificar os riscos</br>
										11.4 Realizar a análise quantitativa dos riscos
										
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
				<input type="hidden" name="cmd" value="cadastrarPlanoGerenciamentoCronograma"></input>
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
						<td><p align="justify"><b>Plano de Gerenciamento do Cronograma <font color="red">*</font></b></p>
						<p align="justify">
								<input id="planogerenciamentocronograma" name="planogerenciamentocronograma"
									style="height: 30px; width: 379px" maxlength="150"
									value="${planoGerenciamentoCronograma.planogerenciamentocronograma}" class="input" required="true"></input>
							<p class="hint">[Informar o Plano de Gerenciamento da Cronograma.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
								<td><p align="justify"><b>Projeto <font color="red">*</font></b>
								<p align="justify">
									<select id="projetoinicio" name="projetoinicio">
										<option id="projetoinicio">Selecione</option>
										<%
											List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
											for(ProjetoInicio ProjetoInicio: projetoInicios){
												out.println("<option value='" + ProjetoInicio.getCodigo() + "'>"
														                      + ProjetoInicio.getProjeto());
											}
										%>	
									</select><p class="hint">[Informar o projeto.]</p>
								</td>
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
									value="${planoGerenciamentoCronograma.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a versão.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<!-- <tr class="field">
						<td><p align="justify">
								<b>Data <font color="red">*</font></b>
						<p align="justify">
								<input id="data" name="data"
									style="height: 30px; width: 100px"
									value="${planoGerenciamentoCronograma.data}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr> -->
					<tr class="field">
						<td><p align="justify">
								<b>Autor <font color="red">*</font></b></p>
						<p align="justify">
								<input id="autor" name="autor"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${planoGerenciamentoCronograma.autor}" class="input" required="true"
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
									value="${planoGerenciamentoCronograma.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revisão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Objetivo do Plano de gerenciamento do cronograma <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,550,'spcontando0');contarCaracteresEtapa1(this.value,550,'sprestante0')"></textarea>
							<p class="hint">[Descreva o objetivo do Plano de gerenciamento do cronograma]</p>
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
								<b>Método de gerenciamento do cronograma   <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="metodo" name="metodo" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,550,'spcontando');contarCaracteresEtapa2(this.value,550,'sprestante')"></textarea>
							<p class="hint">[Use as seções seguintes para identificar os componentes do Plano de gerenciamento do cronograma ou modifique-as para encontrar suas necessidades.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante"
									style="font-family: Arial;"></span></font>
							</h5>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Processos de cronograma <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="processo" name="processo" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,550,'spcontando1');contarCaracteresEtapa3(this.value,550,'sprestante1')"></textarea>
							<p class="hint">[Exemplo: Definir as Atividades, Sequenciar as Atividades, Estimar os Recursos da Atividade, Estimar a Duração da Atividade, Desenvolver o Cronograma e Controlar o Cronograma.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>Documentos padronizados do cronograma <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="documento" name="documento" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,550,'spcontando2');contarCaracteresEtapa4(this.value,550,'sprestante2')"></textarea>
							<p class="hint">[Descreva os documentos padronizados a serem usadas nos processos das aquisições. Indique onde estão armazenados, como serão usados, e os responsáveis envolvidos.]</p>
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
								<b>Ferramentas <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="ferramenta" name="ferramenta" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,550,'spcontando3');contarCaracteresEtapa5(this.value,550,'sprestante3')"></textarea>
							<p class="hint">[Descreve as ferramentas que o projeto empregará nos processos descritos neste plano, como serão usadas e seu responsável. ]</p>
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
								<b>Papéis e Responsabilidades da Equipe do Projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="papeis" name="papeis" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,550,'spcontando4');contarCaracteresEtapa6(this.value,550,'sprestante4')"></textarea>
							<p class="hint">[Descreva os papéis e suas responsabilidades, competências e autoridade necessárias relacionados com cronograma; onde: Papel: designação que descreve a parte de um projeto pela qual uma pessoa é responsável e responde pelos resultados. Responsabilidade: trabalho que se espera que um membro da equipe do projeto execute para concluir as atividades do projeto. Autoridade: direito de aplicar recursos do projeto, tomar decisões e aprovar. Competência: habilidade e capacidade necessária para concluir atividades do projeto. ]
							</p>
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
								<b>Plano de gerenciamento do cronograma<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="plano" name="plano" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,550,'spcontando5');contarCaracteresEtapa7(this.value,550,'sprestante5')"></textarea>
							<p class="hint">[Descreva abaixo todos os processos relacionados com o cronograma do projeto. ]</p>
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
						<td><p align="justify">
								<b>Definir as Atividades<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="atividade" name="atividade" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,550,'spcontando6');contarCaracteresEtapa8(this.value,550,'sprestante6')"></textarea>
							<p class="hint">[Descreva como as atividades serão identificadas. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando6"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante6"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Sequenciar as Atividades<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="sequenciar" name="sequenciar" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,550,'spcontando7');contarCaracteresEtapa9(this.value,550,'sprestante7')"></textarea>
							<p class="hint">[Descreva como as atividades serão relacionadas e como serão identificadas suas dependências. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando7"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante7"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Estimar os Recursos da Atividade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="estimarrecuso" name="estimarrecuso" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,550,'spcontando8');contarCaracteresEtapa10(this.value,550,'sprestante8')"></textarea>
							<p class="hint">[Descreva como os recursos das atividades serão estimados. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando8"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante8"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Estimar a Duração da Atividade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="estimarduracao" name="estimarduracao" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,550,'spcontando9');contarCaracteresEtapa11(this.value,550,'sprestante9')"></textarea>
							<p class="hint">[Descreva como a duração das atividades serão estimadas. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando9"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante9"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Desenvolver o cronograma<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="desenvolver" name="desenvolver" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,550,'spcontando10');contarCaracteresEtapa12(this.value,550,'sprestante10')"></textarea>
							<p class="hint">[Descreva como o cronograma será desenvolvido. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando10"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante10"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Controlar o cronograma<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="controlar" name="controlar" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,550,'spcontando14');contarCaracteresEtapa16(this.value,550,'sprestante14')"></textarea>
							<p class="hint">[Descreva como o cronograma será controlado e monitorado. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando14"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante14"
									style="font-family: Arial;"></span></font>
							</h5></td>
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
								onkeyup="mostrarResultadoEtapa19(this.value,300,'spcontando17');contarCaracteresEtapa19(this.value,300,'sprestante17')"></textarea>
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
	<%@ include file="rodape.jsp" %>
</body>
</html>
