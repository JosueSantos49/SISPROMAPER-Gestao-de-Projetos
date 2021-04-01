/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.TabelaParteInteressada;
import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.InterfaceTabelaParteInteressadaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarTabelaParteInteressada implements InterfaceCommand {

	private InterfaceTabelaParteInteressadaDAO tabelaParteInteressadaDAO;
	private InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO;
	public AtualizarTabelaParteInteressada(InterfaceTabelaParteInteressadaDAO tabelaParteInteressadaDAO, InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO) {
		super();
		this.tabelaParteInteressadaDAO = tabelaParteInteressadaDAO;
		this.registroParteInteressadaDAO = registroParteInteressadaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					TabelaParteInteressada tabelaParteInteressada = new TabelaParteInteressada();
					
					tabelaParteInteressada.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					tabelaParteInteressada.setNomegrport(request.getParameter("nomegrport"));
					tabelaParteInteressada.setCpfgrport(request.getParameter("cpfgrport"));
					tabelaParteInteressada.setEmailgrport(request.getParameter("emailgrport"));
					tabelaParteInteressada.setFonegrport(Integer.valueOf(request.getParameter("fonegrport")));
					tabelaParteInteressada.setOutrosport(request.getParameter("outrosport"));
					tabelaParteInteressada.setNomegrprograma(request.getParameter("nomegrprograma"));
					tabelaParteInteressada.setEmailgrprograma(request.getParameter("emailgrprograma"));
					tabelaParteInteressada.setFonegrprograma(Integer.valueOf(request.getParameter("fonegrprograma")));				
					tabelaParteInteressada.setNomegrprojeto(request.getParameter("nomegrprojeto"));	
					tabelaParteInteressada.setEmailgrprojeto(request.getParameter("emailgrprojeto"));
					tabelaParteInteressada.setFonegrprojeto(request.getParameter("fonegrprojeto"));
					tabelaParteInteressada.setNomeegprojeto(request.getParameter("nomeegprojeto"));
					tabelaParteInteressada.setEmaileqprojeto(request.getParameter("emaileqprojeto"));
					tabelaParteInteressada.setNomegrfuncional(request.getParameter("nomegrfuncional"));
					tabelaParteInteressada.setCpfgrfuncional(request.getParameter("cpfgrfuncional"));
					tabelaParteInteressada.setEmailgrfuncional(request.getParameter("emailgrfuncional"));
					tabelaParteInteressada.setFonegrfuncional(Integer.valueOf(request.getParameter("fonegrfuncional")));
					tabelaParteInteressada.setNomepatrocinador(request.getParameter("nomepatrocinador"));
					tabelaParteInteressada.setCpfpatrocinador(request.getParameter("cpfpatrocinador"));
					tabelaParteInteressada.setCnpjpatrocinador(request.getParameter("cnpjpatrocinador"));
					tabelaParteInteressada.setEmailpatrocinador(request.getParameter("emailpatrocinador"));	
					tabelaParteInteressada.setFonepatrocinador(Integer.valueOf(request.getParameter("fonepatrocinador")));					
					tabelaParteInteressada.setInvestimento(Double.parseDouble(request.getParameter("investimento")));
					tabelaParteInteressada.setNomeequipeproj(request.getParameter("nomeequipeproj"));
					tabelaParteInteressada.setSetorequipeproj(request.getParameter("setorequipeproj"));
					tabelaParteInteressada.setNomefornecedor(request.getParameter("nomefornecedor"));
					tabelaParteInteressada.setCpffornecedor(request.getParameter("cpffornecedor"));
					tabelaParteInteressada.setCnpjfornecedor(request.getParameter("cnpjfornecedor"));
					tabelaParteInteressada.setEmailfornecedor(request.getParameter("emailfornecedor"));
					tabelaParteInteressada.setFonefornecedor(Integer.valueOf(request.getParameter("fonefornecedor")));
					tabelaParteInteressada.setInvestimentoforne(Double.parseDouble(request.getParameter("investimentoforne")));
					
					Integer registroparteinteressada = Integer.valueOf(request.getParameter("registroparteinteressada"));										
					tabelaParteInteressada.setRegistroParteInteressada(registroParteInteressadaDAO.getRegistroParteInteressada(registroparteinteressada));
		
		if(ValidationHelper.validar(tabelaParteInteressada)){	
			response.setContentType("text/html; charset=ISO-8859-1");
			tabelaParteInteressadaDAO.atualizar(tabelaParteInteressada);
			request.setAttribute("mensagem", "Tabela Parte Interessadas: ("+tabelaParteInteressada.getRegistroParteInteressada().getRegistroparteinteressada()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Tabela Parte Interessadas");
			return "TkcsapcdController?cmd=consultarTabelaParteInteressada";//Pagina de Retorno (pagina consulta)
	}

}
