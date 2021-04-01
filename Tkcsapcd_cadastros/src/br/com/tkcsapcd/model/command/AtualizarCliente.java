/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Cliente;
import br.com.tkcsapcd.model.dao.InterfaceClienteDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;

//M�todo registrado na InterfaceCommand
public class AtualizarCliente implements InterfaceCommand {

	private InterfaceClienteDAO clienteDAO;		
	public AtualizarCliente(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {	
			Cliente cliente = new Cliente();// Codigo de processamento			
		
			cliente.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
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
									
			clienteDAO.atualizar(cliente);			
			request.setAttribute("mensagem", "Cliente: ("+cliente.getNome()+") atualizado com sucesso!");
			
			/*Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
			 * O Metodo enviarForm() � respons�vel, por enviar e-mail de confirma��o de envio de formul�rios.
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
				request.setAttribute("msg","Enviado confirma��o de registro por e-mail!");
			else
				request.setAttribute("msg","N�o, enviado c�pia de confirma��o de registro por e-mail!");				
			
			rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarCliente");
			rd.forward(request, response);
		
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualiza��o - Cliente");
			return "TkcsapcdController?cmd=consultarCliente";//Pagina de Retorno (pagina consulta)
	}

}
