/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoMelhoriaProcesso;
import br.com.tkcsapcd.model.dao.InterfacePlanoMelhoriaProcessoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoMelhoriaProcesso implements InterfaceCommand {

	private InterfacePlanoMelhoriaProcessoDAO planoMelhoriaProcessoDAO;
	public AtualizarPlanoMelhoriaProcesso(InterfacePlanoMelhoriaProcessoDAO planoMelhoriaProcessoDAO) {
		super();
		this.planoMelhoriaProcessoDAO = planoMelhoriaProcessoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoMelhoriaProcesso planoMelhoriaProcesso = new PlanoMelhoriaProcesso();
					
					planoMelhoriaProcesso.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					planoMelhoriaProcesso.setPlanomelhoriaprocesso(request.getParameter("planomelhoriaprocesso"));
					planoMelhoriaProcesso.setProjeto(request.getParameter("projeto"));
					planoMelhoriaProcesso.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					planoMelhoriaProcesso.setVersao(request.getParameter("versao"));
					planoMelhoriaProcesso.setData(request.getParameter("data"));
					planoMelhoriaProcesso.setAutor(request.getParameter("autor"));
					planoMelhoriaProcesso.setNotarevisao(request.getParameter("notarevisao"));
					planoMelhoriaProcesso.setObjetivo(request.getParameter("objetivo"));
					planoMelhoriaProcesso.setLimite(request.getParameter("limite"));
					planoMelhoriaProcesso.setConfiguracao(request.getParameter("configuracao"));
					planoMelhoriaProcesso.setMetrica(request.getParameter("metrica"));
					planoMelhoriaProcesso.setMeta(request.getParameter("meta"));
					planoMelhoriaProcesso.setAprovacao(request.getParameter("aprovacao"));
		
		if(ValidationHelper.validar(planoMelhoriaProcesso)){			
			planoMelhoriaProcessoDAO.atualizar(planoMelhoriaProcesso);
			request.setAttribute("mensagem", "PLANO DE MELHORIA DO PROCESSO: ("+planoMelhoriaProcesso.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE MELHORIA DO PROCESSO");
			return "TkcsapcdController?cmd=consultarPlanoMelhoriaProcesso";//Pagina de Retorno (pagina consulta)
	}

}
