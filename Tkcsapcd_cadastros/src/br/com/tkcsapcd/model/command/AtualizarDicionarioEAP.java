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

import br.com.tkcsapcd.model.bean.DicionarioEAP;
import br.com.tkcsapcd.model.dao.InterfaceDicionarioEAPDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarDicionarioEAP implements InterfaceCommand {

	private InterfaceDicionarioEAPDAO dicionarioEAPDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarDicionarioEAP(InterfaceDicionarioEAPDAO dicionarioEAPDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.dicionarioEAPDAO = dicionarioEAPDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					DicionarioEAP dicionarioEAP = new DicionarioEAP();
					
					dicionarioEAP.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					dicionarioEAP.setDicionarioeap(request.getParameter("dicionarioeap"));
					dicionarioEAP.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					dicionarioEAP.setData(data);
					
					dicionarioEAP.setAutor(request.getParameter("autor"));
					dicionarioEAP.setNotarevisao(request.getParameter("notarevisao"));
					dicionarioEAP.setAprovacao(request.getParameter("aprovacao"));
					dicionarioEAP.setCodigoeap(Integer.valueOf(request.getParameter("codigoeap")));			
					dicionarioEAP.setEntregapacote(request.getParameter("entregapacote"));					
					dicionarioEAP.setDescricao(request.getParameter("descricao"));
					dicionarioEAP.setCriterioaceitacao(request.getParameter("criterioaceitacao"));
					dicionarioEAP.setResponsavel(request.getParameter("responsavel"));
					dicionarioEAP.setAprovado(request.getParameter("aprovado"));
					dicionarioEAP.setConsultado(request.getParameter("consultado"));
					dicionarioEAP.setInformado(request.getParameter("informado"));
					dicionarioEAP.setTrabalhoenvolvido(request.getParameter("trabalhoenvolvido"));
					dicionarioEAP.setRiscos(request.getParameter("riscos"));
					dicionarioEAP.setRecusos(request.getParameter("recusos"));
					dicionarioEAP.setMacros(request.getParameter("macros"));
					dicionarioEAP.setCustos(request.getParameter("custos").equals("") ? null : Double.valueOf(request.getParameter("custos")));
					dicionarioEAP.setPrevisao(request.getParameter("previsao"));
					dicionarioEAP.setInformacoes(request.getParameter("informacoes"));
					dicionarioEAP.setStatus(request.getParameter("status"));
					dicionarioEAP.setComentarios(request.getParameter("comentarios"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					dicionarioEAP.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(dicionarioEAP)){			
			dicionarioEAPDAO.atualizar(dicionarioEAP);
			request.setAttribute("mensagem", "DICIONÁRIO DA EAP: ("+dicionarioEAP.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - DICIONÁRIO DA EAP");
			return "TkcsapcdController?cmd=consultarDicionarioEAP";//Pagina de Retorno (pagina consulta)
	}

}
