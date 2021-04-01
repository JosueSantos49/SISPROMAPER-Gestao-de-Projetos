package br.com.tkcsapcd.model.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LiberarRecursoHelper {

	@SuppressWarnings("unused")
	public static LiberarRecursoHelper getLiberarRecursoHelper(){
		
		ResultSet rs = null;
		PreparedStatement st = null;
		Connection con = null;
		
			if (rs!=null) try  { rs.close(); } catch (Exception ignore){}
			if (st!=null) try  { st.close(); } catch (Exception ignore){}
			if (con!=null) try { con.close();} catch (Exception ignore){}
			return null;
			
			
	}
}
