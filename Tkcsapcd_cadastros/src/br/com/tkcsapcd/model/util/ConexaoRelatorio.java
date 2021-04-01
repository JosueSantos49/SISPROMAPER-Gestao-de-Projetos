package br.com.tkcsapcd.model.util;
import java.sql.*;
import javax.swing.JOptionPane;

import br.com.tkcsapcd.model.helper.Config;

public class ConexaoRelatorio {
	
	public Connection getConnection(){
		
		Connection cn = null;
		
		try {
			Class.forName(Config.getDriver());
			cn = DriverManager.getConnection(Config.getHost(),Config.getUsuarioBanco(),Config.getSenhaBanco());
			System.out.println(cn);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return cn;
	}
}
