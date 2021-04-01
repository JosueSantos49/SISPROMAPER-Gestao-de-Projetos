/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Stakeholders;
import br.com.tkcsapcd.model.dao.InterfaceStakeholdersDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarStakeholders implements InterfaceCommand {

	private InterfaceStakeholdersDAO stakeholdersDAO;	
	public AtualizarStakeholders(InterfaceStakeholdersDAO stakeholdersDAO) {
		super();
		this.stakeholdersDAO = stakeholdersDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {				
					//  Preencher o Bean com os valores do request
					Stakeholders stakeholders = new Stakeholders();
					
					stakeholders.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					stakeholders.setEmpresa(request.getParameter("empresa"));
					stakeholders.setOrgao(request.getParameter("orgao"));
					stakeholders.setSetor(request.getParameter("setor"));
					stakeholders.setPrograma(request.getParameter("programa"));
					stakeholders.setProjeto(request.getParameter("projeto"));
					stakeholders.setGerente(request.getParameter("gerente"));
					stakeholders.setFuncao(request.getParameter("funcao"));
					stakeholders.setAprovado(request.getParameter("aprovado"));
					stakeholders.setVersao(request.getParameter("versao"));
					stakeholders.setDataaprovacao(request.getParameter("dataaprovacao"));
					stakeholders.setReferencia(request.getParameter("referencia"));
					stakeholders.setNome(request.getParameter("nome"));
					stakeholders.setEmpresaequipe(request.getParameter("empresaequipe"));
					stakeholders.setCargocompetencia(request.getParameter("cargocompetencia"));
					stakeholders.setEmail(request.getParameter("email"));
					stakeholders.setTelefone(request.getParameter("telefone"));
					stakeholders.setEndereco(request.getParameter("endereco"));
					stakeholders.setObs(request.getParameter("obs"));
					stakeholders.setCodigoprojeto(request.getParameter("codigoprojeto"));
			
		if(ValidationHelper.validar(stakeholders)){			
			stakeholdersDAO.atualizar(stakeholders);
			request.setAttribute("mensagem", "Stakeholders: ("+stakeholders.getCodigoprojeto()+") atualizado com sucesso!");
		}else{
			throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Stakeholders");
			return "TkcsapcdController?cmd=consultarStakeholders";//Pagina de Retorno (pagina consulta cliente)
	}

}
