<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="library.admin.bean.Admin"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp"%>
<%@page import="library.admin.dao.AdminDao"%>
<%@page import="library.admin.dao.IssueBookDao"%>

<%
	Admin admin = (Admin) session.getAttribute("Admin");
	if (admin == null) {
		response.sendRedirect("login.jsp");

	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" >
<style>
body{
	background-image: url('../images/lib.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
</head>


<body>

 <form action="ViewIssuedBookServlet" method="get"> 
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark "
		style="background-color: #e3f2fd">

		<a class="btn btn-outline-success" href="viewuser.jsp">View User</a>


		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a
			class="btn btn-outline-success" href="viewbook.jsp">View Book</a>



		&nbsp;&nbsp;&nbsp; <a class="btn btn-outline-success" href="../ViewIssuedBookServlet">View Issued 
				Book</a> &nbsp;&nbsp;&nbsp; <a class="btn btn-outline-success" href="">Return
			Book</a> &nbsp;&nbsp;&nbsp; <a class="btn btn-outline-success" href="#">View
			Return Book</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp;



<span class="fa fa-user-circle fa-8x "  style="font-size:40px;color:white;">
				</span>&nbsp; &nbsp;
	 <button class="btn bg-success my-2 my-sm-0" type="submit">   <%=admin.getName() %></button>
	
		
		&nbsp; &nbsp; <a href="adminlogin.jsp"
			class="btn btn-outline-success my-2 my-sm-0 " type="submit">Logout</a>

	</nav>
	

	
    <a href="registernewadmin.jsp"
			class="btn btn-outline-success my-2 my-sm-0 " type="submit"><h3>Add new admin</h3></a>



	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<!-- <script > $(document).ready(function(){
			alert("document loaded")
		})</script> -->
	<script src="js/js.js" type="text/javascript">
	
	</script>
	</body>
	</html>