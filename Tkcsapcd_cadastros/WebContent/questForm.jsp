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

<html>
<title>Quize application in jsp</title>
<head>

<script>
	function validateForm(theForm){

	if(theForm.quest.value==""){			
			alert("Please enter Question.");
			theForm.quest.focus();
			return false;
	}
	
      return true;
    } 
 </script>
</head>

<body>
<br>
<br/>
<center>

<table border="1" width="450px" bgcolor="pink" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%">
      <form method="POST" action="" onsubmit="return validateForm(this);">
     
        <h2 align="center"><font color="red">Quize Application in JSP</font></h2>
        <table border="0" width="400px" cellspacing="4" cellpadding="8">
          <tr>
            <td width="50%"><b>Enter Question:</b></td>
            <td width="50%"><input type="text" name="quest" size="40"/> </td>
          </tr>
	<tr>
            <td width="50%"><b>Enter Answer(A.):</b></td>
            <td width="50%"><input type="text" name="QA" size="40"/> </td>
          </tr>
	 <tr>
            <td width="50%"><b>Enter Answer(B.):</b></td>
            <td width="50%"><input type="text" name="QB" size="40"/> </td>
          </tr>

          <tr>
            <td width="50%"><b>Enter Answer(C.):</b></td>
            <td width="50%"><input type="text" name="QC" size="40"/> </td>
          </tr>

	<tr>
            <td width="50%"><b>Enter Answer(D.):</b></td>
            <td width="50%"><input type="text" name="QD" size="40"/> </td>
          </tr>
	 
	<tr>
            <td width="50%"><b>Correct Answer:</b></td>
            <td width="50%"><input type="text" name="correctAns" size="10"/> </td>
          </tr>	

        </table>
	<center>
        <p><input type="submit" value="Submit" name="submit">
          <input type="reset" value="Reset" name="reset"></p>
        </center>  
      </form>
    </td>
  </tr>
</table>
</center>
</body>

</html>
