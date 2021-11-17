<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Statement</title>
</head>
<body style="background: #b6dcb3;">
	<div align="center">
		<h1>Account Statement</h1>
		<form action="<%=request.getContextPath()%>/statement" method="post">
			<table style="with: 100%">
				<tr>
					<td>Account No.: </td>
					<td><input type="text" name="account" /></td>
				</tr>
				<tr>
					<td>From (YYYY-MM-DD): </td>
					<td><input type="text" name="from" /></td>
				</tr>
				<tr>
					<td>To (YYYY-MM-DD): </td>
					<td><input type="text" name="to" /></td>
				</tr>

			</table>
			<input type="submit" value="Generate" />
			<div style="color: #FF0000;">${errorMessage}</div>
			<div style="color: #00FF00;"><a href="LandingPage.jsp">Main Menu</a></div>
		</form>
	</div>
</body>
</html>