<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	<h3>Modal header</h3>
</div>
<div class="modal-body">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab1" data-toggle="tab">Tab 1</a></li>
		<li><a href="#tab2" data-toggle="tab">Tab 2</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab1"><p>This modal was loaded in via ajax</p></div>
		<div class="tab-pane" id="tab2"><p>This is some other tab content</p></div>
	</div>
	<button class="btn update">Update</button>
</div>
<div class="modal-footer">
	<button type="button" data-dismiss="modal" class="btn">Close</button>
	<button type="button" class="btn btn-primary">Ok</button>
</div>
</body>
</html>