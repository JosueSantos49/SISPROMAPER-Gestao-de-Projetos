<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
  <link href="https://tarruda.github.io/bootstrap-datetimepicker/assets/css/bootstrap.css" rel="stylesheet" /><!-- Formatacao datetimepicker -->
  <link href="https://tarruda.github.io/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" /><!-- Formatacao datetimepicker -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script><!-- Formatacao datetimepicker -->
</head>
<body>

 <div class='input-append date' id='datetimepicker1'>
    <input data-format='dd/MM/yyyy' type='text' /><!--Formatacao data dd/MM/yyyy hh:mm:ss -->
    <span class='add-on'>
      <i data-date-icon='icon-calendar' data-time-icon='icon-time'>
      </i>
    </span>
</div>

<script type='text/javascript'>
  $(function() {
    $('#datetimepicker1').datetimepicker({
    	language: 'pt-BR'
    });
  });
  /*language: 'pt-BR' ; pickTime: false*/
</script>
<script type="text/javascript" src="https://tarruda.github.io/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js"></script><!-- Formatacao datetimepicker --> 
<script type="text/javascript" src="https://tarruda.github.io/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js"></script><!-- Formatacao datetimepicker -->
</body>
</html>