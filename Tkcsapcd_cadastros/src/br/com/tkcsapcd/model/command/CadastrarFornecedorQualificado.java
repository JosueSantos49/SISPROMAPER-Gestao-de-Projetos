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

import br.com.tkcsapcd.model.bean.FornecedorQualificado;
import br.com.tkcsapcd.model.dao.InterfaceFornecedorQualificadoDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarFornecedorQualificado implements InterfaceCommand {

	private InterfaceFornecedorQualificadoDAO fornecedorQualificadoDAO;
	public CadastrarFornecedorQualificado(InterfaceFornecedorQualificadoDAO fornecedorQualificadoDAO) {
		super();
		this.fornecedorQualificadoDAO = fornecedorQualificadoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			FornecedorQualificado fornecedorQualificado = new FornecedorQualificado();
			
			fornecedorQualificado.setRazaosocial(request.getParameter("razaosocial"));
			fornecedorQualificado.setTelefone(Integer.valueOf(request.getParameter("telefone")));
			fornecedorQualificado.setFax(Integer.valueOf(request.getParameter("fax")));
			fornecedorQualificado.setEndereco(request.getParameter("endereco"));
			fornecedorQualificado.setBairro(request.getParameter("bairro"));
			fornecedorQualificado.setCidade(request.getParameter("cidade"));
			fornecedorQualificado.setEstado(request.getParameter("estado"));
			fornecedorQualificado.setCep(Integer.valueOf(request.getParameter("cep")));
			fornecedorQualificado.setCnpj(Integer.valueOf(request.getParameter("cnpj")));				
			fornecedorQualificado.setInscricaoestadual(request.getParameter("inscricaoestadual"));					
			fornecedorQualificado.setInscricaomunicipal(request.getParameter("inscricaomunicipal"));
			fornecedorQualificado.setContato(request.getParameter("contato"));
			fornecedorQualificado.setNomefantasia(request.getParameter("nomefantasia"));
			fornecedorQualificado.setCelular(Integer.valueOf(request.getParameter("celular")));
			fornecedorQualificado.setEmail(request.getParameter("email"));
			fornecedorQualificado.setHomepage(request.getParameter("homepage"));
			fornecedorQualificado.setProdutos(request.getParameter("produtos"));
			fornecedorQualificado.setMarcas(request.getParameter("marcas"));					
			fornecedorQualificado.setBanco(Integer.valueOf(request.getParameter("banco")));
			fornecedorQualificado.setAgencia(Integer.valueOf(request.getParameter("agencia")));
			fornecedorQualificado.setConta(Integer.valueOf(request.getParameter("conta")));
			fornecedorQualificado.setContratosocial(request.getParameter("contratosocial"));	
			fornecedorQualificado.setCartaocnpj(request.getParameter("cartaocnpj"));
			fornecedorQualificado.setFazendafederal(request.getParameter("fazendafederal"));
			fornecedorQualificado.setFazendaestadual(request.getParameter("fazendaestadual"));
			fornecedorQualificado.setFazendamunicipal(request.getParameter("fazendamunicipal"));
			fornecedorQualificado.setInss(request.getParameter("inss"));
			fornecedorQualificado.setFgts(request.getParameter("fgts"));
			fornecedorQualificado.setCapacidadetecnica(request.getParameter("capacidadetecnica"));
			fornecedorQualificado.setRelacaocliente(request.getParameter("relacaocliente"));
			fornecedorQualificado.setReferenciacomenrcail(request.getParameter("referenciacomenrcail"));
			fornecedorQualificado.setRegistro(request.getParameter("registro"));
			fornecedorQualificado.setCertidaonegativa(request.getParameter("certidaonegativa"));
			
			if(ValidationHelper.validar(fornecedorQualificado)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedorqualificado WHERE cnpj = '"+request.getParameter("cnpj")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer cnpj = rs.getInt("cnpj");
				
				if(cnpj >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o CNPJ ("+fornecedorQualificado.getCnpj()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=consultarFornecedorQualificado";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					fornecedorQualificadoDAO.salvar(fornecedorQualificado);
					request.setAttribute("mensagem", "Fornecedor Qualificado: ("+fornecedorQualificado.getCnpj()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					fornecedorQualificadoDAO.salvar(fornecedorQualificado);
					request.setAttribute("mensagem", "Fornecedor Qualificado: ("+fornecedorQualificado.getCnpj()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("email");
					String assunto 	= request.getParameter("razaosocial");
					String mensagem = request.getParameter("razaosocial");
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
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarFornecedorQualificado");
					rd.forward(request, response);
			}
			else{
				throw new Exception("Valor inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - Fornecedor Qualificado");
				return "TkcsapcdController?cmd=consultarFornecedorQualificado";//devolver p/ editar cadastro		
	}
}
