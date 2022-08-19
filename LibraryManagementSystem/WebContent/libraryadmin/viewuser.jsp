<%@page import="library.connection.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="library.user.bean.User" %>
<%@page import="java.util.List" %>
<%@page import=" library.user.dao.UserDao" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<!DOCTYPE html>
<style>
body{
	background-image: url('../images/lib.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<nav class="navbar navbar-light bg-dark justify-content-between">
  <a class="navbar-brand"></a>

  <form class="form-inline" action="SearchUserServlet" method="get">
    <input class="form-control mr-sm-4" type="search" placeholder="Enter UserName" name="q" aria-label="Search">
    <button  class="btn btn-outline-success my-4 my-sm-2" type="submit" >Search</button>
      </form>
</nav>


  

<script>
function myfunction(id){
	if(confirm("Are you sure u want do delete")){
		document.location.href="DeletUserServlet?id="+id;
		document.location.href="viewuser.jsp";
		
	}
}


function myfunction1(id){
	if(confirm("update")){
		document.location.href="UpdateUserServlet?id="+id;
		document.location.href="viewuser.jsp";
		
	}else{
		
	}
}




</script>

  
  

  

		
	

		


	</table>
 
 
	<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">UserId</th>
      <th scope="col">UserName</th>
      <th scope="col">EmailAddress</th>
      <th scope="col">Gender</th>
      
      <th scope="col">Delete</th>
      
    </tr>
  </thead> 
  <%
  	UserDao ud = new UserDao();
	List<User> list = ud.getAll() ;
  	for(User u : list)
  	{
  %>
  		<tr>
  		
  		<td><%= u.getId()%></td>
  		<td><%= u.getName()%></td>
  		<td><%= u.getEmail()%></td>
  		<td><%= u.getGender()%></td>
  		
  		<%-- <td><a href="DeleteUserServlet?id=<%= u.getId()%>">delete</a></td> --%>
  		<form action ="DeletUserServlet" method="get"><td><a href="" onclick="myfunction(<%= u.getId()%>)">delete</a></td></form> 
  		
  			
  	</tr>
  	<%
  	}
  	%>
  	
  
  	
  
  



		
	

		

	<%-- <%
		try {
			Connection con = ConnectionProvider.getConnection();
			Statement st = con.createStatement();
			String query1 = request.getParameter("q1");
			String data=null;
			if(query1!=null)
			{
			     data="select * from user where name like '%"+query1+"%'";
			}
			else
			{
			    data = "select * from user";
			}
			ResultSet rs = st.executeQuery(data);
			while (rs.next()) {
	%>
	<tr>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(5)%></td>
		
		<td>&nbsp;<a href="login.jsp:doGet()">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<a
			href="Delete.jsp">Delete</a>&nbsp;
		</td>

	</tr>
	<%
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%> --%>
	</table>












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
		</body>
		</html>