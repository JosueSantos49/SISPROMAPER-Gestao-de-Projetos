/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2016
 */
package br.com.tkcsapcd.hibernate;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.ServiceRegistry;

import br.com.tkcsapcd.jsf.domain.EventoCalendario;
import br.com.tkcsapcd.model.bean.AcompanhamentoProjeto;
import br.com.tkcsapcd.model.bean.AtaReuniao;
import br.com.tkcsapcd.model.bean.AtributoAtividade;
import br.com.tkcsapcd.model.bean.BusinessCase;
import br.com.tkcsapcd.model.bean.BusinessPlan;
import br.com.tkcsapcd.model.bean.Cliente;
import br.com.tkcsapcd.model.bean.DicionarioEAP;
import br.com.tkcsapcd.model.bean.GerenciamentoEscopo;
import br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito;
import br.com.tkcsapcd.model.bean.Organograma;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoParteInteressada;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRequisito;
import br.com.tkcsapcd.model.bean.ProjetoInicio;
import br.com.tkcsapcd.model.bean.RecursosHumanos;
import br.com.tkcsapcd.model.bean.RegistroParteInteressada;
import br.com.tkcsapcd.model.bean.RegistroRisco;
import br.com.tkcsapcd.model.bean.RegistroRiscoAcoes;
import br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca;
import br.com.tkcsapcd.model.bean.RfiProjeto;
import br.com.tkcsapcd.model.bean.Rfq;
import br.com.tkcsapcd.model.bean.Riscos;
import br.com.tkcsapcd.model.bean.SolicitacaoCadastro;
import br.com.tkcsapcd.model.bean.SolicitacaoMudanca;
import br.com.tkcsapcd.model.bean.TabelaParteInteressada;
import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;
import br.com.tkcsapcd.webservice.Usuario2;

import java.util.Properties;
/*Conversar com o BD provendo conexões.*/
public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();// variável
																				// global

	public static SessionFactory getFabricaDeSessoes() {
		if(fabricaDeSessoes == null){
			fabricaDeSessoes = criarFabricaDeSessoes();
			return fabricaDeSessoes;
		}else{
			return fabricaDeSessoes;
		}
	}

	public static Connection getConexao() {
		Session sessao = fabricaDeSessoes.openSession();

		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection conn) throws SQLException {
				return conn;
			}
		});
		return conexao;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			// verifica o arquivo hibernate.cfg.xml (registro de serviços),
			// verifica as informações.
			Configuration configuracao = new Configuration().configure();
			Properties p = new Properties();
			
			p.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
            p.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
            //p.setProperty("hibernate.connection.username", "");
            //p.setProperty("hibernate.connection.password", "");
            p.setProperty("hibernate.connection.datasource", "java:/comp/env/jdbc/pool");
            p.setProperty("hibernate.hbm2ddl.auto", "validate");//(validate, validate, update)
            p.setProperty("hibernate.current_session_context_class", "thread");  
            //p.setProperty("hibernate.format_sql","true");
            
			configuracao.addAnnotatedClass(ProjetoInicio.class);						
			configuracao.addAnnotatedClass(TermoAberturaProjeto.class);
			configuracao.addAnnotatedClass(RegistroParteInteressada.class);
			configuracao.addAnnotatedClass(PlanoGerenciamentoRequisito.class);
			configuracao.addAnnotatedClass(TabelaParteInteressada.class);
			configuracao.addAnnotatedClass(Organograma.class);
			configuracao.addAnnotatedClass(BusinessCase.class);
			configuracao.addAnnotatedClass(PlanoGerenciamentoProjeto.class);
			configuracao.addAnnotatedClass(RegistroRisco.class);
			configuracao.addAnnotatedClass(RegistroRiscoAcoes.class);
			configuracao.addAnnotatedClass(RfiProjeto.class);
			configuracao.addAnnotatedClass(GerenciamentoEscopo.class);
			configuracao.addAnnotatedClass(PlanoGerenciamentoParteInteressada.class);
			configuracao.addAnnotatedClass(MatrizRastreabilidadeRequisito.class);
			configuracao.addAnnotatedClass(Rfq.class);
			configuracao.addAnnotatedClass(Cliente.class);
			configuracao.addAnnotatedClass(EventoCalendario.class);
			configuracao.addAnnotatedClass(SolicitacaoCadastro.class);
			configuracao.addAnnotatedClass(DicionarioEAP.class);
			configuracao.addAnnotatedClass(Riscos.class);
			configuracao.addAnnotatedClass(SolicitacaoMudanca.class);
			configuracao.addAnnotatedClass(RegistroSolicitacaoMudanca.class);
			configuracao.addAnnotatedClass(AtaReuniao.class);
			configuracao.addAnnotatedClass(AcompanhamentoProjeto.class);
			configuracao.addAnnotatedClass(RecursosHumanos.class);
			configuracao.addAnnotatedClass(BusinessPlan.class);
			configuracao.addAnnotatedClass(AtributoAtividade.class);
			configuracao.addAnnotatedClass(PlanoGerenciamentoCronograma.class);
			
			//Teste Web-service
			configuracao.addAnnotatedClass(Usuario2.class);
			
			configuracao.setProperties(p);
			
			// Pega o registro de serviços
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

			// Passar e construir a fabrica de sessões
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);

			return fabrica;// variável local

		} catch (Throwable ex) {
			System.out.println("A fábrica de sessões, não pode ser criada: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
