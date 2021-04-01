/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ModificacaoEscopo;
import br.com.tkcsapcd.model.dao.InterfaceModificacaoescopoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarModificacaoEscopo implements InterfaceCommand {

	private InterfaceModificacaoescopoDAO modificacaoescopoDAO;
	public AtualizarModificacaoEscopo(InterfaceModificacaoescopoDAO modificacaoescopoDAO) {
		super();
		this.modificacaoescopoDAO = modificacaoescopoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {		
					//  Preencher o Bean com os valores do request
					ModificacaoEscopo modificacaoEscopo = new ModificacaoEscopo();
					
					modificacaoEscopo.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					modificacaoEscopo.setEmpresa(request.getParameter("empresa"));
					modificacaoEscopo.setOrgao(request.getParameter("orgao"));
					modificacaoEscopo.setSetor(request.getParameter("setor"));
					modificacaoEscopo.setPrograma(request.getParameter("programa"));
					modificacaoEscopo.setProjeto(request.getParameter("projeto"));
					modificacaoEscopo.setGerente(request.getParameter("gerente"));
					modificacaoEscopo.setRequerido(request.getParameter("requerido"));
					modificacaoEscopo.setNumero_me(request.getParameter("numero_me"));
					modificacaoEscopo.setDataemissao(request.getParameter("dataemissao"));				
					modificacaoEscopo.setDescricao(request.getParameter("descricao"));
					modificacaoEscopo.setMotivo(request.getParameter("motivo"));
					modificacaoEscopo.setImpacto(request.getParameter("impacto"));
					modificacaoEscopo.setEscopo(request.getParameter("escopo"));
					modificacaoEscopo.setCusto(request.getParameter("custo"));
					modificacaoEscopo.setPrazo(request.getParameter("prazo"));
					modificacaoEscopo.setComentarios(request.getParameter("comentarios"));
					modificacaoEscopo.setReferencia(request.getParameter("referencia"));				
					modificacaoEscopo.setAnexo(request.getParameter("anexo"));
					modificacaoEscopo.setParecer(request.getParameter("parecer"));
					modificacaoEscopo.setAprovacao(request.getParameter("aprovacao"));
					modificacaoEscopo.setCodigoprojeto(request.getParameter("codigoprojeto"));
		
		if(ValidationHelper.validar(modificacaoEscopo)){			
			modificacaoescopoDAO.atualizar(modificacaoEscopo);
			request.setAttribute("mensagem", "SOLICITAÇÃO DE MODIFICAÇÃO DE ESCOPO - ME: ("+modificacaoEscopo.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Gerenciamento do Escopo");
			return "TkcsapcdController?cmd=consultarModificacaoEscopo";//Pagina de Retorno (pagina consulta)
	}

}
