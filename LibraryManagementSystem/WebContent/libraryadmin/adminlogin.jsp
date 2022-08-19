<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css">
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
	<main class="d-flex align-item-center">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-header text-center bg-info">
							<span class="fa fa-user-circle fa-8x" style="font-size: 40px"></span>
							<br> <h4>Login here</h4>
						</div>
						<div class="card-body ">
							<form action="AdminLoginServlet" method="get">
							
								<div class="form-group">
									<label for="exampleInputID">Login ID</label> <input type="text"
										class="form-control" placeholder="Enter login Id" name="email" > <small
										id="emailHelp" class="form-text text-muted" >We'll
										never share your ID with anyone else.</small>

								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" class="form-control"
										id="exampleInputPassword1" placeholder="Password" name="password"> 
								</div>
								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label"
										for="exampleCheck1">agree terms and condition</label>
								</div>
								<br>

								<button type="submit" class="btn btn-primary">Submit</button>
								<!-- <button type="signup" class="btn btn-primary" >Sign up for new user</button> -->



							</form>

						</div>
						<div class="card-footer text-center">
							
						</div>
					</div>
				</div>

			</div>

		</div>

	</main>






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
	<script src="js/load.js" type="text/javascript">
		
	</script>
</body>
</html>>