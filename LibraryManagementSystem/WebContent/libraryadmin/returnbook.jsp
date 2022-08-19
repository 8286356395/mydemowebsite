
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="library.admin.bean.IssueBook" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<style>
body
{
	background-image: url('../images/lib.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>

</head>
<body>



	<main class="p-2">
		<div class="container">
			<div class="col-md-6 offset-md-4">
				<div class="card">
					<div class="card-header text-center bg-info">
						
								<span class="" style="font-size:40px;"></span>
						 <br>
						<h1>Return Book</h1>
					</div>

					<div class="card-body">
						<form id="reg-form" action="ReturnBookServlet" method="get">
						
						
						
						<div class="form-group">
									<label for="exampleInputID">Issueid</label> <input type="text"
										class="form-control" placeholder="Enter issueid" name="issueid" > <small
										id="emailHelp" class="form-text text-muted" ></small>

								</div>
						    
							<div class="form-group">
								<label for="user_name">Return Date</label> <input name="returndate" required type="date"
									class="form-control"
									 placeholder="Enter Return Date">
									 
								<small id="emailHelp" class="form-text text-muted"></small>
							</div>

						
							<br>
                          
							<button type="submit" class="btn btn-primary">Submit</button>


						</form>

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

	<script src="js/load.js" type="text/javascript"></</script>
	
</body>
</htmltml>