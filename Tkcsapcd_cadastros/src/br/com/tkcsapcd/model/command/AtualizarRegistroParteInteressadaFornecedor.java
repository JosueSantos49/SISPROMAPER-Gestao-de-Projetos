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

import br.com.tkcsapcd.model.bean.RegistroParteInteressadaFornecedor;
import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaFornecedorDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarRegistroParteInteressadaFornecedor implements InterfaceCommand {

	private InterfaceRegistroParteInteressadaFornecedorDAO registroParteInteressadaFornecedorDAO;
	public AtualizarRegistroParteInteressadaFornecedor(InterfaceRegistroParteInteressadaFornecedorDAO registroParteInteressadaFornecedorDAO) {
		super();
		this.registroParteInteressadaFornecedorDAO = registroParteInteressadaFornecedorDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request	
					RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor = new RegistroParteInteressadaFornecedor();
					
					registroParteInteressadaFornecedor.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					registroParteInteressadaFornecedor.setRegistroparteinteressada(request.getParameter("registroparteinteressada"));
					registroParteInteressadaFornecedor.setProjeto(request.getParameter("projeto"));
					registroParteInteressadaFornecedor.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					registroParteInteressadaFornecedor.setVersao(request.getParameter("versao"));
					registroParteInteressadaFornecedor.setData(request.getParameter("data"));
					registroParteInteressadaFornecedor.setAutor(request.getParameter("autor"));
					registroParteInteressadaFornecedor.setNotarevisao(request.getParameter("notarevisao"));
					registroParteInteressadaFornecedor.setAprovacao(request.getParameter("aprovacao"));
					registroParteInteressadaFornecedor.setCodigofornecedor(Integer.valueOf(request.getParameter("codigofornecedor")));				
					registroParteInteressadaFornecedor.setRazaosocial(request.getParameter("razaosocial"));					
					registroParteInteressadaFornecedor.setFone(request.getParameter("fone"));
					registroParteInteressadaFornecedor.setSite(request.getParameter("site"));
					registroParteInteressadaFornecedor.setContrato(request.getParameter("contrato"));
					registroParteInteressadaFornecedor.setComentario(request.getParameter("comentario"));
					registroParteInteressadaFornecedor.setProposta(request.getParameter("proposta"));
					registroParteInteressadaFornecedor.setResponsabilidade(request.getParameter("responsabilidade"));
					registroParteInteressadaFornecedor.setControle(request.getParameter("controle"));
		
		if(ValidationHelper.validar(registroParteInteressadaFornecedor)){			
			registroParteInteressadaFornecedorDAO.atualizar(registroParteInteressadaFornecedor);
			request.setAttribute("mensagem", "REGISTRO DAS PARTES INTERESSADA FORNECEDOR: ("+registroParteInteressadaFornecedor.getCodigoprojeto()+") atualizado com sucesso!");
			
			/*Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
			 * O Metodo enviarForm() � respons�vel, por enviar e-mail de confirma��o de envio de formul�rios.
			 */
			
			//String de 		= request.getParameter("de");
			String para 	= request.getParameter("para");
			String assunto 	= request.getParameter("codigoprojeto");
			String mensagem = request.getParameter("registroparteinteressada");
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
			
			rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarRegistroParteInteressadaFornecedor");
			rd.forward(request, response);
		}
		else{
			throw new Exception("Valor inv�lido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualiza��o - REGISTRO DAS PARTES INTERESSADA FORNECEDOR");
			return "TkcsapcdController?cmd=consultarRegistroParteInteressadaFornecedor";//Pagina de Retorno (pagina consulta)
	}

}
