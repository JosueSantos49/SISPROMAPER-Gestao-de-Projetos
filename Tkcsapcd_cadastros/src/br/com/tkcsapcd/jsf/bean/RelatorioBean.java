package br.com.tkcsapcd.jsf.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.tkcsapcd.model.helper.ConexaoHelper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Managed Bean que gera o relatório das três formas: passando conexão, passando 
 * ResultSet e passando uma lista de objetos. O escopo é de sessão por 
 * conta da variável de instância saida ser avaliada na página de exibição dos
 * relatórios para mostrar se o relatório foi gerado com sucesso ou não (óbvio que 
 * haviam outras soluções, mas o objetivo da aplicação não era esse).
 *  
 * @author Pablo Nóbrega
 *
 */

@SuppressWarnings("serial")

@ManagedBean(name="relatorioBean")
@ViewScoped
public class RelatorioBean implements Serializable{

	private String saida;
		
	/**
	 * Esse tipo de geração de relatório é útil quando precisamos apenas da conexão
	 * com o banco e quando o JasperReports precisa de nenhum ou de poucos 
	 * parâmetros para realizar a query (exemplo: o id de um objeto que está no banco).
	 * 
	 * @return String navigation rule que exibe o relatório 
	 */	
	public String geraRelatorioPassandoConexao() {
		saida = null;
		String jasper = getDiretorioReal("/reports/termoabertura.jasper");
		Connection conexao = null;

		try {
			// Abro a conexão com o banco que será passada para o JasperReports
			conexao = ConexaoHelper.conectar();
			// Mando o jasper gerar o relatório
			JasperPrint print = JasperFillManager.fillReport(jasper, null, conexao);
			// Gero o PDF
			preenchePdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Sempre mando fechar a conexão, mesmo que tenha dado erro
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
				
			}
		}
		
		return "exibeRelatorio";
	}
	
	

	private void preenchePdf(JasperPrint print) throws JRException {
		// Pego o caminho completo do PDF desde a raiz
		saida = getDiretorioReal("/reports/relatorio.pdf");
		// Exporto para PDF
		JasperExportManager.exportReportToPdfFile(print, saida);
		/*
		 * Jogo na variável saída o nome da aplicação mais o 
		 * caminho para o PDF. Essa variável será utilizada pela view 
		 */
		saida = getContextPath() + "/reports/relatorio.pdf";
	}
	
	/**
	 * Método para retornar o caminho completo do diretório onde se encontra o 
	 * arquivo 'jasper' e o arquivo 'pdf'
	 *  
	 * @param diretorio String diretório a ser localizado na aplicação
	 * @return String caminho completo
	 */
	private String getDiretorioReal(String diretorio) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getServletContext().getRealPath(diretorio);
	}
	
	/**
	 * Método para retornar o nome da aplicação
	 *  
	 * @return String nome da aplicacao 
	 */
	private String getContextPath() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getServletContext().getContextPath();
	}
	
	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
}
