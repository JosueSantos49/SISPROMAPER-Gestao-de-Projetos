<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.ListaOcorrencia"%>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Fatores Ambientais da Empresa</title>
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

<%@include file="menuperantecssadm.jsp"%>
</br></br>
	
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
	
<div class="container">
	<div class="well well-large">
		<h4>Os fatores ambientais da empresa são fatores internos ou externos que podem influenciar<br> o sucesso do projeto e que estão fora do escopo do projeto.</h4>
		<div id="form-content" class="modal hide fade in" style="display: none;">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h4>Fatores Ambientais da Empresa</h4>
			</div>
			<div class="modal-body">
				<h5>		
			Os fatores ambientais da empresa referem-se aos fatores ambientais internos e
			externos que cercam ou influenciam o sucesso de um projeto. Esses fatores são de qualquer
			uma ou de todas as empresas envolvidas no projeto. Os fatores ambientais da empresa podem
			aumentar ou restringir as opções de gerenciamento de projetos e podem ter uma influência
			positiva ou negativa no resultado. Eles são considerados como entradas na maioria dos
			processos de planejamento.<br><br>
			Os fatores ambientais da empresa incluem, mas não se limitam a:<br><br>
			- Cultura, estrutura e processos organizacionais;<br>
			- Normas governamentais ou do setor (por exemplo, regulamentos de agências
			reguladoras, códigos de conduta, padrões de produto, padrões de qualidade e
			padrões de mão-de-obra);<br>
			- Infra-estrutura (por exemplo, equipamentos e instalações existentes);<br>
			- Recursos humanos existentes (por exemplo, habilidades, disciplinas e
			conhecimento, tais como projeto, desenvolvimento, departamento jurídico,
			contratação e compras);<br>
			- Administração de pessoal (por exemplo, diretrizes de recrutamento, retenção,
			demissão, análises de desempenho dos funcionários e registros de treinamento,
			política de horas extras e controle do tempo);<br>
			- Sistemas de autorização do trabalho da empresa;<br>
			- Condições do mercado;<br>
			- Tolerância a risco das partes interessadas;<br>
			- Clima político;<br>
			- Canais de comunicação estabelecidos da organização;<br>
			- Bancos de dados comerciais (por exemplo, dados padronizados de estimativa
			de custos, informações sobre estudos de risco do setor e bancos de dados de
			riscos) e
			- Sistemas de informações do gerenciamento de projetos (por exemplo, uma
			ferramenta automatizada, como uma ferramenta de software para elaboração de
			cronogramas, um sistema de gerenciamento de configuração, um sistema de
			coleta e distribuição de informações ou interfaces Web para outros sistemas online
			automatizados).		
		</h5>
			</div>		
		</div>
		<br>
		<div id="thanks"><p><a data-toggle="modal" href="#form-content" class="btn btn-primary btn-large">Clique aqui!</a></p></div>
	</div>
</div>
</body>
</html>
