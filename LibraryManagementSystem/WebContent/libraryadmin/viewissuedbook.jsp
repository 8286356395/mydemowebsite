<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<style>
body {
	background-image: url('../images/lib.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>


</head>

<body>





	

		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">IssueId</th>
					<th scope="col">BookId</th>
					<th scope="col">BookName</th>
					<th scope="col">UserId</th>
					<th scope="col">UserName</th>
					<th scope="col">Period</th>
					<th scope="col">IssueDate</th>




					<!-- <th scope="col">IssueBook</th> -->
				</tr>

			</thead>

			<%-- <%
				IssueBookDao bd = new IssueBookDao();
				List<IssueBook> list = bd.getIssueAll();
				for (IssueBook b : list) {
			%>
			<tr>
				<td><%=b.getIssueid()%></td>
				<td><%=b.getBookid()%></td>
				<td><%=b.getBookname()%></td>
				<td><%=b.getUserid()%></td>
				<td><%=b.getUsername()%></td>
				<td><%=b.getPeriod()%></td>
				<td><%=b.getIssuedate()%></td>
				<td><a href="returnbook.jsp">Return</a><%=b.getReturndate()%></td>
			</tr>

			<%
				}
			%>


 --%>

			<tbody>
				<c:forEach var="items" items="${list}">
					<tr>

						<td><c:out value="${items.issueid}" /></td>
						<td><c:out value="${items.bookid}" /></td>
						<td><c:out value="${items.bookname}" /></td>
						<td><c:out value="${items.userid }" /></td>
						<td><c:out value="${items.username }" /></td>
						<td><c:out value="${items.period }" /></td>
						<td><c:out value="${items.issuedate }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</form>

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
	