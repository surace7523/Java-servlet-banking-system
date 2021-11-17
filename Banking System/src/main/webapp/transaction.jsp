<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body style="background: #b6dcb3;">
	<div align="center">
		<h1>Transaction</h1>
		<form action="<%=request.getContextPath()%>/transaction" method="post">
			<table style="with: 100%">
				<tr>
					<td>Account No: </td>
					<td><input type="text" name="accountNo" /></td>
				</tr>
				<tr>
					<td>Amount: </td>
					<td><input type="text" name="amount" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="withdraw" name="action" /></td>
					<td><input type="submit" value="deposit" name="action"/></td>
				</tr>
			</table>
			
			<div style="color: #FF0000;">${errorMessage}</div>
			<div style="color: #00FF00;"><a href="LandingPage.jsp">Main Menu</a></div>
		</form>
	</div>
</body>
</html>