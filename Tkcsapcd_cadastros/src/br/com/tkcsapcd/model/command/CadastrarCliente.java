/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Cliente;
import br.com.tkcsapcd.model.dao.InterfaceClienteDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class CadastrarCliente implements InterfaceCommand {

	private InterfaceClienteDAO clienteDAO;	
	public CadastrarCliente(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception {		
		try {
			// Preencher o Bean com os valores do request
			Cliente cliente = new Cliente();
			
			cliente.setNome(request.getParameter("nome"));				
			cliente.setEndereco(request.getParameter("endereco"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setBairro(request.getParameter("bairro"));
			cliente.setCidade(request.getParameter("cidade"));
			cliente.setCep(request.getParameter("cep"));
			cliente.setEstado(request.getParameter("estado"));
			cliente.setFone(request.getParameter("fone"));
			cliente.setCelular(request.getParameter("celular"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setObs(request.getParameter("obs"));
			cliente.setRg(request.getParameter("rg"));
			cliente.setOrgaorg(request.getParameter("orgaorg"));
			cliente.setNascimento(request.getParameter("nascimento"));//linha alterada
			cliente.setDesde(request.getParameter("desde"));//linha alterada
			cliente.setCnpj(request.getParameter("cnpj"));
			cliente.setInsest(request.getParameter("insest"));	
			cliente.setSexo(request.getParameter("sexo"));
			cliente.setProfissao(request.getParameter("profissao"));
			cliente.setEmpresa(request.getParameter("empresa"));
			cliente.setFoneemp(request.getParameter("foneemp"));
			cliente.setRenda(request.getParameter("renda"));
			//cliente.setRenda(request.getParameter("renda").equals("") ? null : Double.valueOf(request.getParameter("renda")));
			cliente.setReferencia(request.getParameter("referencia"));
			cliente.setFoneref(request.getParameter("foneref"));			
			cliente.setAuditoria(request.getParameter("auditoria"));
			
			if(ValidationHelper.validar(cliente)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente WHERE cpf = '"+request.getParameter("cpf")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer cpf = rs.getInt("cpf");
				
				if(cpf >= 1){
					System.out.println("O cpf é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o CPF ("+cliente.getCpf()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarCliente";//Devolver para o editar					
				}else{
					System.out.println("Aviso 1: O cpf não é igual!");
					clienteDAO.salvar(cliente);
					request.setAttribute("mensagem", "Cliente: ("+cliente.getNome()+") cadastrado com sucesso!");
				}
				rs.close();
				stmt.close();
				con.close();
			}
					System.out.println("Aviso 2: O cpf não é igual!");
					clienteDAO.salvar(cliente);
					request.setAttribute("mensagem", "Cliente: ("+cliente.getNome()+") cadastrado com sucesso!");		
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("para");
					String assunto 	= request.getParameter("nome");
					String mensagem = request.getParameter("empresa");
					//String lista 	= request.getParameter("lista");
					//String file		= request.getParameter("file");
							
					RequestDispatcher rd = null;
					
					EnviaEmail enviaEmail = new EnviaEmail();
					
						//enviaEmail.setDe(de);
						enviaEmail.setPara(para);
						enviaEmail.setAssunto(assunto);
						enviaEmail.setMensagem(mensagem);			
						//enviaEmail.setLista(lista);		
						//enviaEmail.setFile(file);
					
					boolean enviado = enviaEmail.enviarForm();		
					
					if(enviado)
						request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
					else
						request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");				
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarCliente");
					rd.forward(request, response);
		}
			else{
				throw new Exception("Valor Inválido");
			}
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a gravação: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
			e.printStackTrace();
		}
			request.setAttribute("titulo", "Cadastro - Cliente");
			return "TkcsapcdController?cmd=editarCliente";//Devolver para o editar
	}
}
