<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@ page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
  <title>Tabela Parte Interessada</title>
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
  <link href="bootstrap/css/prettify.css" rel="stylesheet" />
  <link href="bootstrap/css/bootstrap-modal-bs3patch.css" rel="stylesheet" />
  <link href="bootstrap/css/bootstrap-modal.css" rel="stylesheet" />

<style>  
  body { 
    padding-top: 40px; 
  }    
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
   			<%
				Date data = new Date();//criando objeto tipo Date e inicializando 
				SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
				String mostra_data = data_formatada.format(data); //Variável para armazenar a data
				
				SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
				String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
			%>

</head>
<body  onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000);">
		<%@include file="menuperantecsslivre.jsp"%>					
				  
				  <div class="page-container">
				    <div class="container" style="position: relative">      
				      <div class="row">
				        <div class="col-md-10">                             
				          <div class="ajax" style="position: relative; overflow: hidden">    
							
							<div id="main">							
								<div class="wow slideInLeft" data-wow-duration="1s">
												          
						            <div class="alert alert-success">
										<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br><br>
										<p><strong>Nota!</strong> As partes interessadas são pessoas ou organizações (por exemplo, clientes, patrocinadores, organização executora ou o público) ativamente envolvidas no projeto ou cujos interesses
																podem ser positiva ou negativamente afetados pela execução ou término do projeto. As partes interessadas podem exercer influência sobre o projeto, suas entregas e sobre os membros da equipe
																do projeto.</p>
										
										 </br><a href="consulta_transacao.jsp" target="_parent" ><i class="glyphicon glyphicon-folder-open"></i> Transação Processo</a>
		                                    
									</div>
							
								</div>    
							</div>
							        
				            <div class="marketing">
				        		<p class="muted"><font color="red">Clique para registrar e listar Parte Interessada!</font></p>           
				            	<button class="demo btn btn-primary btn-lg" data-toggle="modal">Novo registro</button>
				            	<a href="TkcsapcdController?cmd=consultarTabelaParteInteressada" class="btn">Listar registro</a>   				            					            	       
				            </div>
				          </div>
				          <br/>          
				        </div>
				      </div>
				    </div>
					<div id="ajax-modal" class="modal fade" tabindex="-1" style="display: none;"></div>
					</div>   

<%@include file="configuracao_wow.jsp" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://getbootstrap.com/2.3.2/assets/js/google-code-prettify/prettify.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.js"></script>
<script src="bootstrap/bootstrap-modalmanager.js"></script>
<script src="bootstrap/js/bootstrap-modal.js"></script>

<script type="text/javascript">
  $(function(){

    $.fn.modal.defaults.spinner = $.fn.modalmanager.defaults.spinner = 
      '<div class="loading-spinner" style="width: 200px; margin-left: -100px;">' +
        '<div class="progress progress-striped active">' +
          '<div class="progress-bar" style="width: 100%;"></div>' +
        '</div>' +
      '</div>';

    $.fn.modalmanager.defaults.resize = true;

    $('[data-source]').each(function(){
      var $this = $(this),
        $source = $($this.data('source'));

      var text = [];
      $source.each(function(){
        var $s = $(this);
        if ($s.attr('type') == 'text/javascript'){
          text.push($s.html().replace(/(\n)*/, ''));
        } else {
          text.push($s.clone().wrap('<div>').parent().html());
        }
      });
      
      $this.text(text.join('\n\n').replace(/\t/g, '    '));
    });

    prettyPrint();
  });
</script>

<script id="ajax" type="text/javascript">

var $modal = $('#ajax-modal');

$('.ajax .demo').on('click', function(){
  // create the backdrop and wait for next modal to be triggered
  $('body').modalmanager('loading');

  setTimeout(function(){
     $modal.load('cadastro_tabela_parte_interessada_modal_ajax.jsp', '', function(){
      $modal.modal();
    });
  }, 1000);
});

$modal.on('click', '.update', function(){
  $modal.modal('loading');
  setTimeout(function(){
    $modal
      .modal('loading')
      .find('.modal-body')
        .prepend('<div class="alert alert-info fade in">' +
          'Verificar todos campos obrigatórios para submeter dados do projeto!<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '</div>');
  }, 1000);
});

</script> 

  <script>
    window.twttr=(function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],t=window.twttr||{};if(d.getElementById(id))return t;js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);t._e=[];t.ready=function(f){t._e.push(f);};return t;}(document,"script","twitter-wjs"));
  </script>
   </body>
</html>
