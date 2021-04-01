<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<jsp:include page="sessao.jsp" />
<%
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Grupo de Processos</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="wow/css/animate.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="layout" content="main"/>
    
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script src="js/jquery-1.9.1.js" type="text/javascript" ></script>
    <link href="css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
    
     <style type="text/css">
    .word-icon {
        font-family:"Helvetica", sans-serif;
        font-size: 24px;
        font-weight: bold;
        background-color: #0054a6;
        color: white;
        padding: 2px 5px;
        vertical-align: middle;
    }
    </style>

    <%
  //Implementando Data e Hora
    Date data = new Date();//criando objeto tipo Date e inicializando 
    SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
    String mostra_data = data_formatada.format(data); //Vari�vel para armazenar a data

    SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
    String mostra_hora = hora_formatada.format(data); //Vari�vel para armazenar a hora(aproveitando o mesmo objeto data)
    %>
</head>
    <body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000);" >
        
        <%@include file="menuperantecssadm.jsp" %> 
		
		<br>
		
		<div class="container">
			<div id="main">
				<div class="wow slideInLeft" data-wow-duration="3s">
		 			<div class="alert alert-danger">		 				
						<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %> <br>
						Esta se��o objetiva descrever de forma est�tica a lista de grupo de processo. Somente descri��o de informa��o.					
					</div>					
		            
				</div>
			</div>
		</div>
		        
         <div id="page-content" style="width:556px"><!-- /Formata��o export para doc -->
                
                 <!-- /.blog-main -->
	            <div class="col-xs-5">
	                <a class="btn jquery-word-export" href="javascript:void(0)">
	                    <span class="word-icon">W</span>
	                    Export as .doc
	                </a>
	            </div>
	            <!-- /.blog-sidebar -->         
         <br>
		
		 <div class="row">
            <div class="span18">
                <div class="box pattern pattern-sandstone">
                    <div class="box-header">
                        <i class="#"></i>
                        <h5>Lista de Grupo de Processos</h5>
                        <button class="btn btn-box-right" data-toggle="collapse" data-target=".box-list">
                            <i class="icon-reorder"></i>
                        </button>
                    </div>
                    <div class="box-content box-list collapse in">
                        <ul>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de Inicia��o</a>
                                    <p class="news-item-preview">4.1 Desenvolver o termo de abertura do projeto - O processo de desenvolver um documento que formalmente autoriza exist�ncia de um projeto e <br>
                                    d� ao gerente do projeto a autoridade necess�ria para aplicar recursos organizacionais �s atividades do projeto
                                    </p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de Inicia��o</a>
                                    <p class="news-item-preview">13.1 Identificar as partes interessadas - O processo de identificar as pessoas, grupos ou organiza��es que podem impactar ou serem impactados por <br>
                                    uma decis�o, atividade ou resultado do projeto e analisar e documentar informa��es relativas aos seus interesses, n�vel de engajamento, interdepend�ncias, influ�ncia, e seu impacto potencial no �ixo do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">4.2 Desenvolver o plano de gerenciamento do projeto - O processo de definir, preparar e coordenar todos os planos auxiliares e integr�-los a um plano de gerenciamento de projeto abrangente. <br>
                                    As linhas de base e os planos auxiliares integrados do projeto podem ser inclu�dos no plano de gerenciamento do projeto.
                                    </p>
                                </div>
                            </li>
                             <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">5.1 Planejar o gerenciamento do escopo - O processo de criar um plano de gerenciamento do escopo do projeto que documenta como tal escopo ser� definido, validade e controlado. <br>
                                    .
                                    </p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">5.2 Coletar os requisitos - O processo de determinar, documentar e gerenciar as necessidades e requisitos das partes interessadas a fim de atender aos objetivos do projeto. <br>
                                    .
                                    </p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">5.3 Definir o escopo - O processo de desenvolvimento de uma descri��o detalhada do projeto e do produto. <br>
                                    .
                                    </p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">5.4 Criar a EAP - O processo de subdivis�o das entregas e do trabalho do projeto em componetes menores e mais facimente gerenci�veis. <br>
                                    .
                                    </p>
                                </div>
                            </li>
                        </ul>
                        <div class="box-collapse">
                            <button class="btn btn-box" data-toggle="collapse" data-target=".more-list">
                                Grupo de processos de planejamento
                            </button>
                        </div>
                        <ul class="more-list collapse out">
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">6.1 Planejar o gerenciamento do gronograma - O processo de monitoramento do andamento do escopo do projeto e do produto e gerenciamento das mudan�as feitas na linha de base do escopo.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">6.2 Definir as atividades - O processo de identifica��o e documenta��o das a��es espec�ficas a serem realizadas para produzir as entregas do produto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">6.3 Sequenciar as atividades - O processo de identifica��o e documenta��o dos relacionamentos entre as atividades do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">6.4 O processo de identifica��o e documenta��o dos relacionamentos entre as atividades do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">6.5 Estimar as dura��es das atividades - O processo de estimativa do n�mero de per�odos de trabalho que ser�o necess�rios para terminar atividades espec�ficas com os recursos estimados.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">6.6 Desenvolver o cronograma - O processo de an�lise das sequ�ncias das atividade, suas dura��es , recursos necess�rios e restri��es do cronograma visando criar o modelo de cronograma do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">7.1 Planejar o gerenciamento dos custos - � o processo de estabelecer as pol�ticas, os procedimentos e a documenta��o para o planejamento, gest�o, despesas e controle dos custos do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">7.2 Estimar os custos - � o processo de desenvolvimento de uma estimativa de custos dos recursos monet�rios necess�rios para terminar as atividades do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">7.3 Determinar o or�amento - � o processo de agrega��o dos custos estimados de atividades individuais ou pacotes de trabalhos para estabelecer uma linha de base dos custos autorizada.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">8.1 Planejar o gerenciamento da qualidade - O processo de identifica��o dos requisitos, padr�es da qualidade do projeto e suas entregas, documenta��o de como o projeto demostrar� a conformidade com os requisitos e padr�es de qualidade.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">9.1 Planejar o gerenciamento dos recursos humanso - O processo de identifica��o e documenta��o de pap�is, responsabilidades, habilidades necess�rias, rela��es hier�quicas e cria��o de um plano de gerenciamento do pessoal.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">10.1 Planejar o gerencimaneto das comunica��es - O processo de desenvolver uma abordagem apropriada e um plano de comunica��es do projeto com base nas necessidades de informa��o e requisitos das partes interessadas, e nos ativos organizacionais dispon�veis.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">11.1 Planejar o gerenciamento dos riscos - O processo de defini��o de como conduzir as atividades de gerenciamento dos riscos de um projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">11.2 Identificar os riscos - O processo de determina��o dos riscos que podem afetar o projeto e de documenta��o das suas caracter�sticas.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">11.3 Realizar a an�lise qualitativa dos riscos - O processo de prioriza��o de riscos para an�lise ou a��o psoterior atrav�s da avalia��o e combina��o de sua probabilidade de ocorr�ncia e impacto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">11.4 Realizar a an�lise quantitativa dos riscos - O processo de analisar numericamente o efeito dos riscos identificados nos objetivos gerais do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">11.5 Planejar as respostas aos riscos - O processo de desenvolvimento de op��es e a��es para aumentar as oportunidades e reduzir as amea�as aos objetivos do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">12.1 Planejar o gerenciamento das aquisi��es - O processo de documenta��o das decis�es de compra do projeto, especificando a abordagem e identificando fornecedores em potencial.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de planejamento</a>
                                    <p class="news-item-preview">13.2 Planejar o gerenciamento das partes interessadas - O processo de desenvolver estrat�gias apropriadas de gerenciamento para engajar as partes interessadas de maneira eficaz no decorrer de todo o ciclo de vida do projeto, com base na an�lise das suas necessidades, interesses, e impacto potencial no sucesso do projeto.</p>
                                </div>
                            </li>
                        </ul>
                        
                         <div class="box-collapse">
                            <button class="btn btn-box" data-toggle="collapse" data-target=".more-list">
                                Grupo de processos de execu��o
                            </button>
                        </div>
                        <ul class="more-list collapse out">
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">4.3 Orientar e gerenciar o trabalho do projeto - O processo de liderar e realizar o trabalho definido no plano de gerenciamento do projeto e a implanta��o das mudan�as aprovadas para atingir os objetivos do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">8.2 Realizar a garantia da qualidade - O processo de auditoria dos requisitos de qualidade e dos resultados das meedi��es do controle de qualidade para garantir o uso dos padr�es de qualidade e das defini��es operacionais apropriadas.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">9.2 Mobilizar a equipe do projeto - O processo de confirma��o da disponibilidade dos recursos humanos e obten��o necess�ria para terminar as atividades do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">9.3 Desenvolver a equipe do projeto - O processo de melhoria de compet�ncias, da intera��o da equipe e do ambiente geral para aprimorar o desempenho do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">9.4 Gerenciar a equipe do grupo - O processo de acompnhamento dos membros da equipe, fornecer feedback, resolver problemas e gerenciar mudan�as para otimizar o desempenho do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">10.2 Gerenciar as comunica��es - O processo de criar, coletar, distribuir, armazenar, recuperar e de disposi��o final das informa��es do projeto de acordo com o plano de gerenciamento das comunica��es.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">12.2 Conduzir as aquisi��es - O processo de obten��o de respostas de fornecedores, sele��o de um fornecedor e adjudica��o de um contrato.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de execu��o</a>
                                    <p class="news-item-preview">13.3 Gerenciar o engajamento das partes interessadas - O processo de se comunicar e trabalhar com as partes interessadas para atender �s suas necessidades.</p>
                                </div>
                            </li>
                        </ul>
                        
                        <div class="box-collapse">
                            <button class="btn btn-box" data-toggle="collapse" data-target=".more-list">
                                Grupo de processos de monitoramento e controle
                            </button>
                        </div>
                        <ul class="more-list collapse out">
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">4.4 Monitorar e controlar o trabalho do projeto - O processo de acompanhar, revisar e registrar o progresso do projeto para atender aos objetivos de desempenho definidos no plano de gerenciamento do projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">4.5 Realizar o controle integrado de mudan�as - O processo de revisar todas as solicita��es de mudan�a, aprovar as mudan�as e gerar mudan�as nas entreguas, ativos de processos organizacionais, documentos do projeto e no plano de gerenciamento do projeto, e comunicar a decis�o sobre membros.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">5.5 Validar o escopo - O processo de formaliza��o da aceita��o das entreguas conclu�das do porojeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">5.6 Controlar o escopo - O processo de monitoramento do andamento do escopo do projeto e do produto e gerenciamento das mudan�as feitas na linha de bsae do escopo.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">6.7 Controlar o cronograma - O processo de monitoramento do andamento das atividades do projeto para atualiza��o no seu processo e gerenciamento das mudan�as feitas na linha de base do cronograma para realizar o planejamento.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">7.4 Controlar os custos - O processo de monitoramento do andamento do projeto para atualiza��o no seu or�amento e gerenciamento de mudan�as feitas na linha de base de custos.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">8.3 Controlar a qualidade - O processo de monitoramento e registro dos resultados da execu��o das atividades de qualidade para avaliar o desempenho e recomendar as mudan�as necess�rias.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">10.3 Controlar as comunica��es - O processo de monitorar e controlar as comunica��es no decorrer de todo o ciclo de vida do projeto para assegurar que as necessidades de informa��o das partes interessadas do projeto sejam atendidas.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">11.6 Controlar os riscos - O processo de implementar planos de respostas aos riscos, acompanhar os riscos identificados, monitorar riscos residuais, identificar novos riscos e avaliar a efic�cia do processo de gerenciamento dos riscos durante todo o projeto.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">12.3 Controlar as aquisi��es - O processo de gerenciamento das rela��es de aquisi��es, monitoramento do desempenho do contrato e realiza��o de mudan�as e corre��es nos contratos, conforme necess�rio.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de monitoramento e controle</a>
                                    <p class="news-item-preview">13.4 </p>
                                </div>
                            </li>
                        </ul>
                        
                        <div class="box-collapse">
                            <button class="btn btn-box" data-toggle="collapse" data-target=".more-list">
                                Grupo de processos de encerramento
                            </button>
                        </div>
                        <ul class="more-list collapse out">
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de encerramento</a>
                                    <p class="news-item-preview">4.6 Encerrar projeto ou fase - O processo de finaliza��o de todas as atividades de todos os grupos de processos de gerenciamento de projeto para encerramento do projeto para encerrar formalmente o projeto ou a fase.</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <a href="#" class="news-item-title">Grupo de processos de encerramento</a>
                                    <p class="news-item-preview">12.4 Encerrar as aquisi��es - O processo de finalizar cada uma das aquisi��es do projeto.</p>
                                </div>
                            </li>
                        </ul> 
                    </div>
                	</div>
            	</div>		
           	</div>    
        </div><!-- /Formata��o export para doc -->    

        <script src="bootstrap/bootstrap-transition.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-alert.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-modal.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-dropdown.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-scrollspy.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-tab.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-tooltip.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-popover.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-button.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-collapse.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-carousel.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-typeahead.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-affix.js" type="text/javascript" ></script>
        <script src="bootstrap/bootstrap-datepicker.js" type="text/javascript" ></script>
        
        <!-- FileSaver.js (necessary for saving the word document!) -->
	    <script src="js/FileSaver.js"></script>
	    <!-- jQuery-Word-Export plugin -->
	    <script src="js/jquery.wordexport.js"></script>
	    
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
    
    <script type="text/javascript">
    jQuery(document).ready(function($) {
        $("a.jquery-word-export").click(function(event) {
            $("#page-content").wordExport();
        });
    });
    </script>
    <%@include file="configuracao_wow.jsp" %>
	<%@ include file="rodape.jsp" %>
	
	</body>
</html>