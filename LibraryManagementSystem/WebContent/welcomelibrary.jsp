<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<style>
body{
	background-image: url('images/lib.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
.welcome{
transform: translate(326px,134px);
font-size: 70px;

}
.text-muted h1{
color: white;
font-family: ui-monospace;
}
.card-body{

}
</style>

<h3>
 
  <small class="text-muted "><h1  class="welcome" ; ">Welcome to library</h1  ></small>
</h3>


<div class="card text-center bg-light " style="width: 18rem; top:10rem; left:20rem;">

  <div class="card-body">
 
  
    <a href="libraryadmin/adminlogin.jsp" class="btn btn-outline-success my-4 my-sm-2 "><h5>Admin</h5></a>
      
  </div>
</div>

<div class="card text-center bg-light" style="width: 18rem;  top:3.5rem; left:40rem">

  <div class="card-body">
    <a href="user/userlogin.jsp" class="btn btn-outline-success my-4 my-sm-2 "><h5>User</h5></a>
  </div>
</div>





</body>
</html>