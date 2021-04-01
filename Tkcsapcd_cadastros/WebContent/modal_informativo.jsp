
<%@ page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
	<head>
		<meta charset="utf-8">
		<title>Dica! </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap-modal-carousel.min.css">
		<style>
			.nav .external {
				margin-top: 30px;
			}
			.row + .row,
			.row-fluid + .row-fluid {
				margin-top: 20px;
			}
			.btn .glyphicon + span {
				margin-left: .5em;
			}
			@media (min-width: 768px) {
				h2:first-child, .h2:first-child, h3:first-child, .h3:first-child {
					margin-top: 0;
				}
			}
			
				/* EXAMPLE 1 */
				#myModal1 .modal-content {
					background: rgba(0, 0, 0, .5);
				}
				#myModal1 .modal-header {
					border: 0;
					color: #fff;
				}
				#myModal1 .modal-footer {
					border-color: rgba(0, 0, 0, .5);
				}
				/* EXAMPLE 2 */
				#myModal2 .modal-content {
					background: rgba(0, 0, 0, .5);
				}
				#myModal2 .modal-header {
					border: 0;
					color: #fff;
				}
				#myModal2 .modal-footer {
					border-color: rgba(0, 0, 0, .5);
				}
				#myModal2 .carousel-caption {
					background-color: rgba(0, 0, 0, .5);
					bottom: -100%;
					-webkit-transition: bottom 1s;
					transition: bottom 1s;
				}
				#myModal2 .item.active >.carousel-caption {
					bottom: 0;
				}
			
				.hero-unit {
				  padding: 5px;
				  margin-bottom: 30px;
				  font-size: 18px;
				  font-weight: 200;
				  line-height: 15px;
				  color: inherit;
				  background-color: #eeeeee;
				  -webkit-border-radius: 6px;
				     -moz-border-radius: 6px;
				          border-radius: 6px;
					}
		
				.hero-unit li {
				  line-height: 15px;
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
	
	<body>
			
		<div class="container">
		
		<br><div class="hero-unit"><h3>Dica do dia!</h3></div>
		
			<%@include file="tabela_operacoes.jsp" %>
			
			<div class="alert alert-success">
				<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br><br>
				<p><strong>Nota!</strong> Olá, seja bem-vindo <%@include file="sessao_usuario.jsp"%>a transação dica do dia com o objetivo de revelar ação para usar o sistema com autonomia e eficiência. Clicando sobre o botão verificar você será capaz de realizar transações com eficiência. Não fique fora dessa! </p>
				</br><a href="consulta_transacao.jsp" target="_parent" ><i class="glyphicon glyphicon-folder-open"></i> Transação Processo</a>
		    </div>
					
					<p>
					  <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal2" data-local="#myCarousel2">
					    <span class="glyphicon glyphicon-fullscreen"></span>
					    <span>Verificar</span>
					  </button>
					  <a href="index_principal.jsp" class="btn btn-info">Home</a> 
					</p>
					
					<div class="modal fade modal-fullscreen force-fullscreen " id="myModal2"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									
										<button type="button" class="btn btn-danger pull-right" data-dismiss="modal" aria-hidden="true">
											<span class="glyphicon glyphicon-remove"></span>
											<span>Fechar</span>
										</button>
									
									
										<h4 class="modal-title">Dicas do dia</h4>
										
										<div id="myCarousel2" class="carousel slide carousel-fit" data-ride="carousel" data-interval="60000">
						
					
											<!-- Wrapper for slides -->
											<div class="carousel-inner">
												<div class="item active">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Você Sabia">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>É possível acessar a tabela guia de processo com processo, área de conhecimento, grupo de processo e detalhe de saída. Um processo pode conter uma ou várias saídas.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>Você pode especificar a transação que desejar acessar através da ferramenta transação processo. Basta verificar o código, transação, descrição e pesquisar a transação. </p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>Você pode enviar e-mail para as pessoas envolvidas em seus projetos diretamente a partir do calendário de evento e envio de e-mail simples.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>O índice paliativo é responsável por informar sobre alguma transação que inicia com a sigla Cad. Cadastrar, Cons. Consultar e Rel. Relatório. Para cada grupo de processo como iniciação, plano de gerenciamento de projeto, execução, Monitoramento e Controle e Encerramento é permitido acessar a infraestrutura de formulário.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>Você pode acessar a opção de ajuda do sistema, onde, é disponibilizado uma lista com tópico de cada assunto. Cada arquivo possui um Id, nome, extensão, descrição e link para download.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>A seção grupo permite listar em uma visão geral de todos grupos de processos. É apresentado de forma estática a lista de cada grupo. Somente descrição de informação. Caso, necessário você poderá exportar as informações para um formato doc.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>Você pode executar a transação de Upload e Download de arquivo a ser salvo no banco de dados do servidor. Após executar o Upload é permitido a consulta com identificação, nome, descrição e link para executar o download do arquivo.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>A transação Processos permite verificar a visão geral de cada processo em formato WBS, basta somente clicar no link de cada linha da tabela, que será aberta a visão geral de cada processo em forma de WBS. Visão Geral do Gerenciamento da Integração do Projeto, Escopo do Projeto, Tempo do Projeto, Custos do Projeto, Qualidade do Projeto, Recursos Humanos do Projeto, Comunicações do Projeto, Aquisições do Projeto e Partes Interessadas do Projeto.</p>
													</div>
												</div>
												<div class="item">
													<img data-src="holder.js/600x180/auto/#555:#333/text:Dica!" alt="Third slide">
													<div class="carousel-caption">
														<h3><%@include file="sessao_usuario.jsp"%> você sabia...</h3>
														<p>Você pode registrar pedido de cotação. Ao informar o Item, descrição, quantidade, preço unitário e frete é gerado o total da cotação. Após o registro é permitido gerar o relatório com os dados informados.</p>
													</div>
												</div>
											</div>					
										
									</div>
									
								</div>
								<div class="modal-body">
									<p>One fine body&hellip;</p>
								</div>
								
									<div class="modal-footer">
										
											<!-- Controls -->
											<a class="left carousel-control" href="#myCarousel2" data-slide="prev">
												<span class="glyphicon glyphicon-chevron-left"></span>
											</a>
											<a class="right carousel-control" href="#myCarousel2" data-slide="next">
												<span class="glyphicon glyphicon-chevron-right"></span>
											</a>
										
									</div>
								
							</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
					
				</div>
				
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
		<script src="bootstrap/js/bootstrap-modal-carousel.min.js"></script>
		<script src="bootstrap/js/demo.min.js"></script>
	</body>
</html>

