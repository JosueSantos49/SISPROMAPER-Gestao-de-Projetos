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

import br.com.tkcsapcd.model.bean.AtaReuniao;
import br.com.tkcsapcd.model.dao.InterfaceAtaReuniaoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarAtaReuniao implements InterfaceCommand {

	private InterfaceAtaReuniaoDAO ataReuniaoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarAtaReuniao(InterfaceAtaReuniaoDAO ataReuniaoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.ataReuniaoDAO = ataReuniaoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					AtaReuniao ataReuniao = new AtaReuniao();
					
					ataReuniao.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					ataReuniao.setAta(request.getParameter("ata"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					ataReuniao.setData(data);
					
					ataReuniao.setLocal(request.getParameter("local"));
					ataReuniao.setParticipante(request.getParameter("participante"));
					ataReuniao.setObjetivo(request.getParameter("objetivo"));
					ataReuniao.setTopico(request.getParameter("topico"));				
					ataReuniao.setAcoestomadas(request.getParameter("acoestomadas"));
					ataReuniao.setProximareuniao(request.getParameter("proximareuniao"));
					ataReuniao.setAcoestomadas(request.getParameter("acoestomadas"));
					ataReuniao.setAdicionais(request.getParameter("adicionais"));
					ataReuniao.setAprovacao(request.getParameter("aprovacao"));
					
					ataReuniao.setVersao(Long.valueOf(request.getParameter("versao")));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					ataReuniao.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(ataReuniao)){			
			ataReuniaoDAO.atualizar(ataReuniao);
			request.setAttribute("mensagem", "Ata de Reunião: ("+ataReuniao.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Ata de Reunião");
			return "TkcsapcdController?cmd=consultarAtaReuniao";//Pagina de Retorno (pagina consulta)
	}

}
