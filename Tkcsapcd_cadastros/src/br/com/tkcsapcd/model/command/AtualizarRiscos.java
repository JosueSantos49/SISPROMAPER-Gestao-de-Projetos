/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Riscos;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRiscosDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarRiscos implements InterfaceCommand {

	private InterfaceRiscosDAO riscosDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarRiscos(InterfaceRiscosDAO riscosDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.riscosDAO = riscosDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					Riscos riscos = new Riscos();
					
					riscos.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					riscos.setEmpresa(request.getParameter("empresa"));
					riscos.setOrgao(request.getParameter("orgao"));
					riscos.setSetor(request.getParameter("setor"));
					riscos.setPrograma(request.getParameter("programa"));
					riscos.setGerente(request.getParameter("gerente"));
					riscos.setFuncao(request.getParameter("funcao"));
					riscos.setAprovado(request.getParameter("aprovado"));
					riscos.setVersao(request.getParameter("versao"));		
					
					String data_1 = request.getParameter("dataaprovacao"); 
					Date dataaprovacao = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					riscos.setDataaprovacao(dataaprovacao);
					
					riscos.setEtapa1(request.getParameter("etapa1"));
					riscos.setEtapa2(request.getParameter("etapa2"));
					riscos.setEtapa3(request.getParameter("etapa3"));
					riscos.setEtapa4(request.getParameter("etapa4"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					riscos.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(riscos)){			
			riscosDAO.atualizar(riscos);
			request.setAttribute("mensagem", "Gerenciamento de Riscos: ("+riscos.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Gerenciamento de Riscos");
			return "TkcsapcdController?cmd=consultarRiscos";//Pagina de Retorno (pagina consulta)
	}

}
