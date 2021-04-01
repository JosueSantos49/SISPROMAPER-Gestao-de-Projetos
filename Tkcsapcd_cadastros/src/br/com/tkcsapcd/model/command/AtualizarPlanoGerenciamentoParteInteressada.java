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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoParteInteressada;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoParteInteressada implements InterfaceCommand {

	private InterfacePlanoGerenciamentoParteInteressadaDAO planoGerenciamentoParteInteressadaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarPlanoGerenciamentoParteInteressada(InterfacePlanoGerenciamentoParteInteressadaDAO planoGerenciamentoParteInteressadaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoParteInteressadaDAO = planoGerenciamentoParteInteressadaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada = new PlanoGerenciamentoParteInteressada();
					
					planoGerenciamentoParteInteressada.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					planoGerenciamentoParteInteressada.setPlanogerenciamentointeressada(request.getParameter("planogerenciamentointeressada"));
					planoGerenciamentoParteInteressada.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					planoGerenciamentoParteInteressada.setData(data);
					
					planoGerenciamentoParteInteressada.setAutor(request.getParameter("autor"));
					planoGerenciamentoParteInteressada.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoParteInteressada.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoParteInteressada.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoParteInteressada.setProcesso(request.getParameter("processo"));					
					planoGerenciamentoParteInteressada.setParteinteressada(request.getParameter("parteinteressada"));
					planoGerenciamentoParteInteressada.setGerenciarparte(request.getParameter("gerenciarparte"));
					planoGerenciamentoParteInteressada.setControlaparte(request.getParameter("controlaparte"));
					planoGerenciamentoParteInteressada.setAnexo(request.getParameter("anexo"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					planoGerenciamentoParteInteressada.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(planoGerenciamentoParteInteressada)){			
			planoGerenciamentoParteInteressadaDAO.atualizar(planoGerenciamentoParteInteressada);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DAS PARTES INTERESSADAS: ("+planoGerenciamentoParteInteressada.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DAS PARTES INTERESSADAS");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoParteInteressada";//Pagina de Retorno (pagina consulta)
	}

}
