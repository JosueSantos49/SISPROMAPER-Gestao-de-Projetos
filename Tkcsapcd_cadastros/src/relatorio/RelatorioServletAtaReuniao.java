package relatorio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import br.com.tkcsapcd.model.bean.AtaReuniao;
import br.com.tkcsapcd.model.dao.AtaReuniaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.view.JasperViewer;

@WebServlet("/RelatorioServletAtaReuniao")
public class RelatorioServletAtaReuniao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<AtaReuniao> ataReuniaos;	
	private InterfacePool pool;
       
    public RelatorioServletAtaReuniao() {
        super();
    }
    
@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AtaReuniaoDAO ataReuniaoDAO = new AtaReuniaoDAO(pool);
		ataReuniaos = ataReuniaoDAO.getAtaReuniaos();
				
		try {
			
			String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");	
			System.out.println("Alção relatório Ata Reunião: "+acao);
			
			String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/relatorio/") + "/";			
			String caminho = getServletContext().getRealPath("/");
			
			JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(ataReuniaos);
			
			Map parametros = new HashMap();			
			parametros.put(ataReuniaos, jrDT);			
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "atareuniao.jasper", parametros, jrDT);
						
			if("visualizar".equals(acao)) {
				
				JasperViewer.viewReport(jasperPrint, false);
				
			} else if("pdf".equals(acao)) {
				
				JasperPrintManager.printReportToPdfFile(jasperPrint, caminho + "/Relatorio_Ata_Reuniao.pdf");
				response.sendRedirect("Relatorio_Ata_Reuniao.pdf");
				
			} else if("doc".equals(acao)) {
				
				response.addHeader("Content-disposition","attachment; filename=Relatorio_Ata_Reuniao.doc");
				ServletOutputStream outStream = response.getOutputStream();
				
				JRDocxExporter exporter = new JRDocxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
				exporter.exportReport();
				
				outStream.flush();
				outStream.close();
				
			}else if("ppt".equals(acao)) {
				
				response.addHeader("Content-disposition","attachment; filename=Relatorio_Ata_Reuniao.ppt");
				ServletOutputStream outStream = response.getOutputStream();
				
				JRPptxExporter exporter = new JRPptxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
				exporter.exportReport();
				
				outStream.flush();
				outStream.close();
				
			} /*else {
				response.sendRedirect("index_principal.jsp");
			}*/			
					
		} catch (JRException e) {			
			e.printStackTrace();
		}

    }

@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
public void processRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AtaReuniaoDAO ataReuniaoDAO = new AtaReuniaoDAO(pool);
		ataReuniaos = ataReuniaoDAO.getAtaReuniaos();
		
		Connection con = ConexaoHelper.conectar();
		Statement stmt = null;
		
		try {
			
			String codigo = request.getParameter("codigo") == null ? "" : request.getParameter("codigo");	
			System.out.println("Código da alção relatório Ata Reunião: "+codigo);
						 
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);			
			String sql = "SELECT * FROM atareuniao WHERE codigo = '"+codigo+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Long codigo1 = rs.getLong("codigo");
								
				if(codigo1 >= 1){
					
					String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/relatorio/") + "/";			
					String caminho = getServletContext().getRealPath("/");
					
					JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(ataReuniaos);
					
					PreparedStatement ps = null;
					ResultSet rs2 = null;
					String sql2 = "SELECT * FROM atareuniao WHERE codigo = '"+codigo+"'";
					ps = con.prepareStatement(sql2);
					rs2 = ps.executeQuery();
					
					Map parametros = new HashMap();			
					parametros.put(codigo, rs2);		
					
					JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "atareuniao.jasper", parametros, jrDT);
									
					JasperPrintManager.printReportToPdfFile(jasperPrint, caminho + "/Relatorio_Ata_Reuniao.pdf");
					response.sendRedirect("Relatorio_Ata_Reuniao.pdf");
				}
			}
			stmt.close();
			rs.close();
			con.close();			
								
		} catch (JRException e) {			
			e.printStackTrace();
		}

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
			processRequest2(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
			processRequest2(request, response);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	public List<AtaReuniao> getAtaReuniaos() {
		return ataReuniaos;
	}

	public void setAtaReuniaos(List<AtaReuniao> ataReuniaos) {
		this.ataReuniaos = ataReuniaos;
	}
	
	

}
