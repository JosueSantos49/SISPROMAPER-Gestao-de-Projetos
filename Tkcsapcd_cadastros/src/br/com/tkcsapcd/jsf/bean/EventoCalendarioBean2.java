package br.com.tkcsapcd.jsf.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.tkcsapcd.jsf.domain.EventoCalendario;
import br.com.tkcsapcd.hibernate.HibernateUtil;
import br.com.tkcsapcd.jsf.dao.EventoCalendarioDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EventoCalendarioBean2 implements Serializable {

	private EventoCalendario eventoCalendario;
	private List<EventoCalendario> eventoCalendarios;

	public EventoCalendario getEventoCalendario() {
		return eventoCalendario;
	}

	public void setEventoCalendario(EventoCalendario eventoCalendario) {
		this.eventoCalendario = eventoCalendario;
	}

	public List<EventoCalendario> getEventoCalendarios() {
		return eventoCalendarios;
	}

	public void setEventoCalendarios(List<EventoCalendario> eventoCalendarios) {
		this.eventoCalendarios = eventoCalendarios;
	}

	@PostConstruct
	public void listar() {
		try {
			EventoCalendarioDAO eventoCalendarioDAO = new EventoCalendarioDAO();
			eventoCalendarios = eventoCalendarioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar o evento!");
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
	
	public void novo() {
		eventoCalendario = new EventoCalendario();
	}

	public void excluir(ActionEvent evento) {
		try {
			eventoCalendario = (EventoCalendario) evento.getComponent().getAttributes()
					.get("eventoCalendarioSelecionado");

			EventoCalendarioDAO eventoCalendarioDAO = new EventoCalendarioDAO();
			eventoCalendarioDAO.excluir(eventoCalendario);

			eventoCalendarios = eventoCalendarioDAO.listar();

			Messages.addGlobalInfo("Evento excluído com sucesso!");
			Messages.addGlobalInfo("Título: " + eventoCalendario.getTitulo());

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o estado!");
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
	
	public void imprimir() {

		try {
			// Navegar na arvore da aplicacao
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
			Map<String, Object> filtros = tabela.getFilters();

			String tituloEvento = (String) filtros.get("titulo");
			String inicioEvento = (String) filtros.get("inicio");

			String caminho = Faces.getRealPath("/WEB-INF/reports/eventoCalendario.jasper");

			Map<String, Object> parametros = new HashMap<>();

			if (tituloEvento == null) {
				parametros.put("titulo", "%%");
			} else {
				parametros.put("titulo", "%" + tituloEvento + "%");
			}
			if (inicioEvento == null) {
				parametros.put("inicio", "%%");
			} else {
				parametros.put("inicio", "%" + inicioEvento + "%");
			}

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperPrintManager.printReport(relatorio, true);

		} catch (JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar imprimir a pessoa!");
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
}
