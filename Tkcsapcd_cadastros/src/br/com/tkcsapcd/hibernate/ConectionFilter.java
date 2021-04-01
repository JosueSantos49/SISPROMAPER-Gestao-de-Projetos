package br.com.tkcsapcd.hibernate;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;
/*classe filtro que será responsável por abrir e fechar transações com o banco de dados.*/
public class ConectionFilter implements javax.servlet.Filter{
	private SessionFactory sessionFactory;
	 
    public void destroy() {
         
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            this.sessionFactory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sessionFactory.getCurrentSession().getTransaction().commit();
            this.sessionFactory.getCurrentSession().close();
        } catch (Throwable ex) {
            try {
                if ((this.sessionFactory.getCurrentSession().getTransaction().getStatus()) == TransactionStatus.ACTIVE) {
                    this.sessionFactory.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
 
    public void init(FilterConfig arg0) throws ServletException {
        this.sessionFactory = HibernateUtil.getFabricaDeSessoes();
    }
}
