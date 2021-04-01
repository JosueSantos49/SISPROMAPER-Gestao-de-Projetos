/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.FornecedorQualificado;
import br.com.tkcsapcd.model.dao.InterfaceFornecedorQualificadoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarFornecedorQualificado implements InterfaceCommand {

	private InterfaceFornecedorQualificadoDAO fornecedorQualificadoDAO;
	public AtualizarFornecedorQualificado(InterfaceFornecedorQualificadoDAO fornecedorQualificadoDAO) {
		super();
		this.fornecedorQualificadoDAO = fornecedorQualificadoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request	
					FornecedorQualificado fornecedorQualificado = new FornecedorQualificado();
					
					fornecedorQualificado.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
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
			fornecedorQualificadoDAO.atualizar(fornecedorQualificado);
			request.setAttribute("mensagem", "Fornecedor Qualificado: ("+fornecedorQualificado.getCnpj()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Fornecedor Qualificado");
			return "TkcsapcdController?cmd=consultarFornecedorQualificado";//Pagina de Retorno (pagina consulta)
	}

}
