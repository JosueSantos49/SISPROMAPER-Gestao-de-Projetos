<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.PrintWriter"	import="java.sql.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FileBean"%>

<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Consultar Arquivo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="layout" content="main"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap/css/estilos.css">
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>

    <script src="../js/jquery/jquery-1.8.2.min.js" type="text/javascript" ></script>
    
    <link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />

	<!-- datatable 1.10.0 -->
	<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
	<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
	<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
	<!-- / datatable 1.10.0 -->

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
});
</script>

<!-- Configuração modal -->
<script type="text/javascript">
$(document).ready(function(){
    $(".show-text").click(function(){
    	$('#myModal').find(".lots-of-text").toggle();
        $('#myModal').modal('handleUpdate');
    });
});
</script>
<style type="text/css">
.bs-example{
	margin: 20px;
}
.lots-of-text{
    display: none;
}
</style>
<!-- Configuração modal -->

</head>
    <body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal();" >
    
        <%@include file="menuperantecssadm.jsp"%>
                
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> Segue a identificação, nome, descrição e link para executar o download do arquivo. 
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title"><!-- Titulo do modal --></h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	
				                    	<!-- Modal -->
				                    	O sistema permite executar download e upload de arquivos a serem salvos no banco de dados do servidor. A transação de consultar permitir exibir a identificação, nome, descrição e link para executar o download do arquivo.
				                    	
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
				
				<div id="main">
		      		 	<div class="wow fadeInDown top__element" data-wow-delay="2s">
		      		 	
						<div class="table-responsive">	
                               <table id="tabela" cellspacing="5" cellspacing="5" class="display">
								<thead>
									<tr>
										<th>ID</th>
										<th>Nome do Arquivo (Extensão)</th>
										<th>Descrição</th>
										<th>Download</th>
									</tr>
								</thead>
								<%
									List<FileBean> fileBeans = (List<FileBean>) request.getAttribute("fileBeans");
									for (FileBean fileBean : fileBeans) {
								%>
								<tr>
									<td><%=fileBean.getId()%></td>
									<td><%=fileBean.getName()%></td>
									<td><%=fileBean.getDescription()%></td>
									<td><a href="download.do?id=<%=fileBean.getId()%>">Baixar</a></td>
								</tr>
								<%
									}
								%>
							</table>
							</div>
						</div>
					</div>
           
        <script type="text/javascript">
        $(function() {
            $('#person-list.nav > li > a').click(function(e){
                if($(this).attr('id') == "view-all"){
                    $('div[id*="Person-"]').fadeIn('fast');
                }else{
                    var aRef = $(this);
                    var tablesToHide = $('div[id*="Person-"]:visible').length > 1
                            ? $('div[id*="Person-"]:visible') : $($('#person-list > li[class="active"] > a').attr('href'));

                    tablesToHide.hide();
                    $(aRef.attr('href')).fadeIn('fast');
                }
                $('#person-list > li[class="active"]').removeClass('active');
                $(this).parent().addClass('active');
                e.preventDefault();
            });

            $(function(){
                $('table').tablesorter();
                $("[rel=tooltip]").tooltip();
            });
        });
    </script>
	<%@ include file="rodape.jsp" %>
	</body>
</html>