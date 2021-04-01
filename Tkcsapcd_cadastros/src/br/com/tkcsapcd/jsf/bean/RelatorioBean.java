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
 * Managed Bean que gera o relat�rio das tr�s formas: passando conex�o, passando 
 * ResultSet e passando uma lista de objetos. O escopo � de sess�o por 
 * conta da vari�vel de inst�ncia saida ser avaliada na p�gina de exibi��o dos
 * relat�rios para mostrar se o relat�rio foi gerado com sucesso ou n�o (�bvio que 
 * haviam outras solu��es, mas o objetivo da aplica��o n�o era esse).
 *  
 * @author Pablo N�brega
 *
 */

@SuppressWarnings("serial")

@ManagedBean(name="relatorioBean")
@ViewScoped
public class RelatorioBean implements Serializable{

	private String saida;
		
	/**
	 * Esse tipo de gera��o de relat�rio � �til quando precisamos apenas da conex�o
	 * com o banco e quando o JasperReports precisa de nenhum ou de poucos 
	 * par�metros para realizar a query (exemplo: o id de um objeto que est� no banco).
	 * 
	 * @return String navigation rule que exibe o relat�rio 
	 */	
	public String geraRelatorioPassandoConexao() {
		saida = null;
		String jasper = getDiretorioReal("/reports/termoabertura.jasper");
		Connection conexao = null;

		try {
			// Abro a conex�o com o banco que ser� passada para o JasperReports
			conexao = ConexaoHelper.conectar();
			// Mando o jasper gerar o relat�rio
			JasperPrint print = JasperFillManager.fillReport(jasper, null, conexao);
			// Gero o PDF
			preenchePdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Sempre mando fechar a conex�o, mesmo que tenha dado erro
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
		 * Jogo na vari�vel sa�da o nome da aplica��o mais o 
		 * caminho para o PDF. Essa vari�vel ser� utilizada pela view 
		 */
		saida = getContextPath() + "/reports/relatorio.pdf";
	}
	
	/**
	 * M�todo para retornar o caminho completo do diret�rio onde se encontra o 
	 * arquivo 'jasper' e o arquivo 'pdf'
	 *  
	 * @param diretorio String diret�rio a ser localizado na aplica��o
	 * @return String caminho completo
	 */
	private String getDiretorioReal(String diretorio) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getServletContext().getRealPath(diretorio);
	}
	
	/**
	 * M�todo para retornar o nome da aplica��o
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
