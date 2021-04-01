<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" import="java.sql.*" %>
 <%
if(request.getParameter("submit")!=null)
{
 	Connection con = ConexaoHelper.conectar();	
try{
	Statement st = con.createStatement();
	String quest = request.getParameter("quest").toString();
	String QA = request.getParameter("QA").toString();
	String QB = request.getParameter("QB").toString();
	String QC = request.getParameter("QC").toString();
	String QD = request.getParameter("QD").toString();
	String correctAns = request.getParameter("correctAns").toString();
    out.println("quest : " + quest);

    String qry = "insert into questiniciacao(quest,QA,QB,QC,QD,correctAns) values('"+quest+"','"+QA+"','"+QB+"','"+QC+"','"+QD+"','"+correctAns+"')";
    System.out.println("SQL: "+qry);
    out.println("qry : " + qry);
	
	int val = st.executeUpdate(qry);
	System.out.println("val: "+val);
	con.close();
        if(val>0)
        {
          response.sendRedirect("quizeApplication.jsp");
        }	
}
catch(SQLException ex){
	System.out.println("SQL statment not found: "+ex);
}

catch(Exception e){
	e.printStackTrace();
}
}
%>