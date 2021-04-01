<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@page import="br.com.tkcsapcd.model.bean.RegistroParteInteressada"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.dao.RegistroParteInteressadaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Atualizar Tabela Parte Interessada</title>
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
<script type="" src="js/funcoesNumeroLetras.js"></script>
<style> .modal-body { max-height: 800px; } </style>

<script language="javascript" src="js/TexteareCadastroProjetoInicio.js"></script>

</head>
<body>
	
	<form action="TkcsapcdController"> 
	
	<div class="container">	
	
		<div class="modal-header"><h3>SISPROMAPER</h3></div>
		
		<input type="hidden" name="cmd" value="atualizarTabelaParteInteressada"></input>
		<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
		
		
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
				seja bem-vindo a etapa da atualização das partes interessadas. Fique atento aos campos obrigatórios. As partes interessadas possuem diversos níveis de responsabilidade e de autoridade
				quando participam de um projeto e eles podem mudar ao longo do ciclo de vida do mesmo. Sua responsabilidade e autoridade variam desde contribuições ocasionais em estudos e dinâmicas de grupo até o patrocínio total do projeto, que inclui o fornecimento de apoio financeiro e político.
			</div>	
		</div>
										
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente de Portfólios</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
								<th>Registro Parte Interessada</th>
					    		<th>Nome</th>
					    		<th>E-mail</th>					    		
					    	</tr>
								<tr>
									<td>
										<select id="registroparteinteressada"	name="registroparteinteressada" style="width: 250px" class="form-control">													
													<%
														RegistroParteInteressadaDAO registroParteInteressada = new RegistroParteInteressadaDAO();
														List <RegistroParteInteressada> resultado = registroParteInteressada.getRegistroParteInteressadas();
														for(RegistroParteInteressada pi: resultado){
													%>
													<option value=<%= pi.getCodigo() %>><%= pi.getRegistroparteinteressada() %></option>			
													<%} %>
											</select>									
									</td>			
									<td><input type="text" id="nomegrport" name="nomegrport" value="${tabelaParteInteressada.nomegrport}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  /></td>
									<td><input type="text" id="emailgrport" name="emailgrport" value="${tabelaParteInteressada.emailgrport}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfgrport" name="cpfgrport" value="${tabelaParteInteressada.cpfgrport}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonegrport" name="fonegrport" value="${tabelaParteInteressada.fonegrport}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>Outros dados:</th>
					    		<th></th>
					    		<th></th>
					    	</tr>
					    		<tr>
									<td>
										<div class="form-group">
										  <label for="comment">Descrever:</label>
										   <textarea id="outrosport" name="outrosport" rows="5" cols="50" onkeyup="mostrarResultadoEtapa1(this.value,700,'spcontando0');contarCaracteresEtapa1(this.value,700,'sprestante0')">${tabelaParteInteressada.outrosport}</textarea>
										
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
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim gerente portifólio -->
	
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente de Programas</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th>Telefone</th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomegrprograma" name="nomegrprograma" value="${tabelaParteInteressada.nomegrprograma}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  /></td>
									<td><input type="text" id="emailgrprograma" name="emailgrprograma" value="${tabelaParteInteressada.emailgrprograma}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td><input type="text" id="fonegrprograma" name="fonegrprograma" value="${tabelaParteInteressada.fonegrprograma}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>								
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Gerente de Programas -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente de Projetos</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th>Telefone</th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomegrprojeto" name="nomegrprojeto" value="${tabelaParteInteressada.nomegrprojeto}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  /></td>
									<td><input type="text" id="emailgrprojeto" name="emailgrprojeto" value="${tabelaParteInteressada.emailgrprojeto}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td><input type="text" id="fonegrprojeto" name="fonegrprojeto" value="${tabelaParteInteressada.fonegrprojeto}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>								
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Gerente de Projetos -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Equipe de Gerenciamento do Projeto</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
								<th>Equipe Gerenciamento Projeto:</th>
					    		<th>E-mail:</th>
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" class="form-control" id="nomeegprojeto" name="nomeegprojeto" value="${tabelaParteInteressada.nomeegprojeto}" style="height: 30px; width: 379px" autocomplete="off" placeholder=""/></td>
									<td><input type="text" id="emaileqprojeto" name="emaileqprojeto" value="${tabelaParteInteressada.emaileqprojeto}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td></td>									
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Gerente de Programas -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Gerente Funcional</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomegrfuncional" name="nomegrfuncional" value="${tabelaParteInteressada.nomegrfuncional}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailgrfuncional" name="emailgrfuncional" value="${tabelaParteInteressada.emailgrfuncional}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfgrfuncional" name="cpfgrfuncional" value="${tabelaParteInteressada.cpfgrfuncional}"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonegrfuncional" name="fonegrfuncional" value="${tabelaParteInteressada.fonegrfuncional}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
									<td></td>										
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim gerente funcional -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Patocinadores</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomepatrocinador" name="nomepatrocinador" value="${tabelaParteInteressada.nomepatrocinador}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  /></td>
									<td><input type="text" id="emailpatrocinador" name="emailpatrocinador" value="${tabelaParteInteressada.emailpatrocinador}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfpatrocinador" name="cpfpatrocinador" value="${tabelaParteInteressada.cpfpatrocinador}"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonepatrocinador" name="fonepatrocinador" value="${tabelaParteInteressada.fonepatrocinador}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>CNPJ</th>
					    		<th>Investimento</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cnpjpatrocinador" name="cnpjpatrocinador" value="${tabelaParteInteressada.cnpjpatrocinador}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="investimento" name="investimento" value="${tabelaParteInteressada.investimento}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
									<td></td>										
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim gerente funcional -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Fornecedores / Parceiros Comerciais</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">					    	
							<tr>
					    		<th>Nome</th>
					    		<th>E-mail</th>
					    		<th></th>
					    	</tr>
								<tr>
									<td><input type="text" id="nomefornecedor" name="nomefornecedor" value="${tabelaParteInteressada.nomefornecedor}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailfornecedor" name="emailfornecedor" value="${tabelaParteInteressada.emailfornecedor}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpffornecedor" name="cpffornecedor" value="${tabelaParteInteressada.cpffornecedor}"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonefornecedor" name="fonefornecedor" value="${tabelaParteInteressada.fonefornecedor}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>CNPJ</th>
					    		<th>Investimento</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cnpjfornecedor" name="cnpjfornecedor" value="${tabelaParteInteressada.cnpjfornecedor}" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="investimentoforne" name="investimentoforne" value="${tabelaParteInteressada.investimentoforne}" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2"/></td>			
									<td></td>										
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Fornecedores / Parceiros Comerciais -->
		
		<div class="tab-content">		
			<div class="tab-pane active" id="tab1"><p></p>
				 
				 <div class="container">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Equipe de Projeto</h3>
					  </div>
					  <div class="panel-body">
					  
					    <table class="table">
					    	<tr>
								<th>Nome:</th>
					    		<th>Setor da Empresa:</th>
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" class="form-control" id="nomeequipeproj" name="nomeequipeproj" value="${tabelaParteInteressada.nomeequipeproj }" style="height: 30px; width: 379px" autocomplete="off" placeholder="" /></td>
									<td><input type="text" id="setorequipeproj" name="setorequipeproj" value="${tabelaParteInteressada.setorequipeproj}" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td></td>									
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Equipe de Projeto -->
		<div align="right"><button type="submit" class="btn">Atualizar</button></div>
	</div>	
	</form><!-- fim form -->
</body>
</html>