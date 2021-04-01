/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2016
 */
package br.com.tkcsapcd.hibernate;

import org.hibernate.Session;

public class HibernateUtilTest {

	public static void main(String[] args) {
		// Capturar uma fabrica de sessões e pegar uma sessão
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();		
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
