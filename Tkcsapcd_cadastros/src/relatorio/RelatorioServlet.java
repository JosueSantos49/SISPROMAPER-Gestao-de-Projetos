package relatorio;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;
import br.com.tkcsapcd.model.dao.TermoAberturaProjetoDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.view.JasperViewer;

@WebServlet("/RelatorioServlet")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<TermoAberturaProjeto> termoAberturaProjetos;
	
	private InterfacePool pool;

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TermoAberturaProjetoDAO termoAberturaProjetoDAO = new TermoAberturaProjetoDAO(pool);
		termoAberturaProjetos = termoAberturaProjetoDAO.getTermoAberturaProjetos();
    			
		try {
			
			String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
			
			String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/relatorio/") + "/";
			String caminho = getServletContext().getRealPath("/");
			
			JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(termoAberturaProjetos);
			
			Map parametros = new HashMap();
			
			parametros.put(termoAberturaProjetos, jrDT);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "termoabertura.jasper", parametros, jrDT);
			
			if("visualizar".equals(acao)) {
				
				JasperViewer.viewReport(jasperPrint, false);
				
			} else if("pdf".equals(acao)) {
				
				JasperPrintManager.printReportToPdfFile(jasperPrint, caminho + "/Relatorio_Termo_Abertura_Projeto.pdf");
				response.sendRedirect("Relatorio_Termo_Abertura_Projeto.pdf");
				
			} else if("doc".equals(acao)) {
				
				response.addHeader("Content-disposition","attachment; filename=Relatorio_Termo_Abertura_Projeto.doc");
				ServletOutputStream outStream = response.getOutputStream();
				
				JRDocxExporter exporter = new JRDocxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
				exporter.exportReport();
				
				outStream.flush();
				outStream.close();
				
			}else if("ppt".equals(acao)) {
				
				response.addHeader("Content-disposition","attachment; filename=Relatorio_Termo_Abertura_Projeto.ppt");
				ServletOutputStream outStream = response.getOutputStream();
				
				JRPptxExporter exporter = new JRPptxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
				exporter.exportReport();
				
				outStream.flush();
				outStream.close();
				
			} else {
				response.sendRedirect("index_principal.jsp");
			}
					
		} catch (JRException e) {			
			e.printStackTrace();
		}

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			processRequest(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	public List<TermoAberturaProjeto> getTermoAberturaProjetos() {
		return termoAberturaProjetos;
	}

	public void setTermoAberturaProjetos(List<TermoAberturaProjeto> termoAberturaProjetos) {
		this.termoAberturaProjetos = termoAberturaProjetos;
	}
	
	
}
