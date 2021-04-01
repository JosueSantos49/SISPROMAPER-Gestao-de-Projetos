<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
 
<%@	page import="br.com.tkcsapcd.model.bean.RegistroParteInteressada"%>
<%@	page import="br.com.tkcsapcd.model.dao.RegistroParteInteressadaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@	page import="java.util.List,br.com.tkcsapcd.model.bean.TabelaParteInteressada"%>
<html>
<head>
<title>Tabela Parte Interessada</title>
<script type="" src="js/funcoesNumeroLetras.js"></script>
<style> .modal-body { max-height: 800px; } </style>

<script language="javascript" src="js/TexteareCadastroProjetoInicio.js"></script>

</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h3>SISPROMAPER</h3>
	</div>
	
	<form action="TkcsapcdController"> <!-- Inicio form -->
	<input type="hidden" name="cmd" value="cadastrarTabelaParteInteressada"></input>
	
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
			seja bem-vindo a etapa do registro das partes interessadas. Fique atento aos campos obrigatórios. As partes interessadas possuem diversos níveis de responsabilidade e de autoridade
			quando participam de um projeto e eles podem mudar ao longo do ciclo de vida do mesmo. Sua responsabilidade e autoridade variam desde contribuições ocasionais em estudos e dinâmicas de grupo até o patrocínio total do projeto, que inclui o fornecimento de apoio financeiro e político.
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
													<option id="registroparteinteressada"></option>
													<%
														RegistroParteInteressadaDAO registroParteInteressada = new RegistroParteInteressadaDAO();
														List <RegistroParteInteressada> resultado = registroParteInteressada.getRegistroParteInteressadas();
														for(RegistroParteInteressada pi: resultado){
													%>
													<option value=<%= pi.getCodigo() %>><%= pi.getRegistroparteinteressada() %></option>			
													<%} %>
											</select>
										</td>
																	
									<td><input type="text" id="nomegrport" name="nomegrport" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailgrport" name="emailgrport" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfgrport" name="cpfgrport" value="0" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonegrport" name="fonegrport" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
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
										   <textarea id="outrosport" name="outrosport" rows="5" cols="50" onkeyup="mostrarResultadoEtapa1(this.value,700,'spcontando0');contarCaracteresEtapa1(this.value,700,'sprestante0')"></textarea>
										
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
									<td><input type="text" id="nomegrprograma" name="nomegrprograma" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  /></td>
									<td><input type="text" id="emailgrprograma" name="emailgrprograma" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td><input type="text" id="fonegrprograma" name="fonegrprograma" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>								
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
									<td><input type="text" id="nomegrprojeto" name="nomegrprojeto" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailgrprojeto" name="emailgrprojeto" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td><input type="text" id="fonegrprojeto" name="fonegrprojeto" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>								
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
									<td><input type="text" class="form-control" id="nomeegprojeto" name="nomeegprojeto" style="height: 30px; width: 379px" autocomplete="off" placeholder=""/></td>
									<td><input type="text" id="emaileqprojeto" name="emaileqprojeto" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"/></td>
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
									<td><input type="text" id="nomegrfuncional" name="nomegrfuncional" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailgrfuncional" name="emailgrfuncional" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfgrfuncional" name="cpfgrfuncional" value="0"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonegrfuncional" name="fonegrfuncional" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
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
									<td><input type="text" id="nomepatrocinador" name="nomepatrocinador" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailpatrocinador" name="emailpatrocinador" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpfpatrocinador" name="cpfpatrocinador" value="0"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonepatrocinador" name="fonepatrocinador" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>CNPJ</th>
					    		<th>Investimento</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cnpjpatrocinador" name="cnpjpatrocinador" value="0" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="investimento" name="investimento" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
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
									<td><input type="text" id="nomefornecedor" name="nomefornecedor" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td><input type="text" id="emailfornecedor" name="emailfornecedor" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>										
							 		<td></td>								
								</tr>
							<tr>
					    		<th>CPF</th>
					    		<th>Telefone</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cpffornecedor" name="cpffornecedor" value="0"  class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="fonefornecedor" name="fonefornecedor" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" onkeypress="return numbers(event);"/></td>			
									<td></td>										
								</tr>
							<tr>
					    		<th>CNPJ</th>
					    		<th>Investimento</th>					    		
					    		<th></th>					    		
					    	</tr>
								<tr>
									<td><input type="text" id="cnpjfornecedor" name="cnpjfornecedor" value="0" class="form-control" style="height: 30px; width: 250px" placeholder="" aria-describedby="basic-addon2"  onkeypress="return numbers(event);"/></td>
									<td><input type="text" id="investimentoforne" name="investimentoforne" value="0" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2"/></td>			
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
									<td><input type="text" class="form-control" id="nomeequipeproj" name="nomeequipeproj" style="height: 30px; width: 379px" autocomplete="off" placeholder="" /></td>
									<td><input type="text" id="setorequipeproj" name="setorequipeproj" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"/></td>
									<td></td>									
								</tr>							
							</table>
						</div>
					</div>				      
			    </div><!-- /.container -->
			</div>
		</div><!-- Fim Equipe de Projeto -->
					
		<button class="btn update">Update</button>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn">Continuar</button>
		<button type="button" data-dismiss="modal" class="btn">Fechar</button>
	</div>
	
	</form><!-- fim form -->
</body>
</html>