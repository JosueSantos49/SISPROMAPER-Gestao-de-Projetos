<!-- 
	Autor: Josu� da Concei��o Santos
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
						alert("Aten��o verificar campo obtigat�rio!");
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
		<h4>Os fatores ambientais da empresa s�o fatores internos ou externos que podem influenciar<br> o sucesso do projeto e que est�o fora do escopo do projeto.</h4>
		<div id="form-content" class="modal hide fade in" style="display: none;">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">�</a>
				<h4>Fatores Ambientais da Empresa</h4>
			</div>
			<div class="modal-body">
				<h5>		
			Os fatores ambientais da empresa referem-se aos fatores ambientais internos e
			externos que cercam ou influenciam o sucesso de um projeto. Esses fatores s�o de qualquer
			uma ou de todas as empresas envolvidas no projeto. Os fatores ambientais da empresa podem
			aumentar ou restringir as op��es de gerenciamento de projetos e podem ter uma influ�ncia
			positiva ou negativa no resultado. Eles s�o considerados como entradas na maioria dos
			processos de planejamento.<br><br>
			Os fatores ambientais da empresa incluem, mas n�o se limitam a:<br><br>
			- Cultura, estrutura e processos organizacionais;<br>
			- Normas governamentais ou do setor (por exemplo, regulamentos de ag�ncias
			reguladoras, c�digos de conduta, padr�es de produto, padr�es de qualidade e
			padr�es de m�o-de-obra);<br>
			- Infra-estrutura (por exemplo, equipamentos e instala��es existentes);<br>
			- Recursos humanos existentes (por exemplo, habilidades, disciplinas e
			conhecimento, tais como projeto, desenvolvimento, departamento jur�dico,
			contrata��o e compras);<br>
			- Administra��o de pessoal (por exemplo, diretrizes de recrutamento, reten��o,
			demiss�o, an�lises de desempenho dos funcion�rios e registros de treinamento,
			pol�tica de horas extras e controle do tempo);<br>
			- Sistemas de autoriza��o do trabalho da empresa;<br>
			- Condi��es do mercado;<br>
			- Toler�ncia a risco das partes interessadas;<br>
			- Clima pol�tico;<br>
			- Canais de comunica��o estabelecidos da organiza��o;<br>
			- Bancos de dados comerciais (por exemplo, dados padronizados de estimativa
			de custos, informa��es sobre estudos de risco do setor e bancos de dados de
			riscos) e
			- Sistemas de informa��es do gerenciamento de projetos (por exemplo, uma
			ferramenta automatizada, como uma ferramenta de software para elabora��o de
			cronogramas, um sistema de gerenciamento de configura��o, um sistema de
			coleta e distribui��o de informa��es ou interfaces Web para outros sistemas online
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
