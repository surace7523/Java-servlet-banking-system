<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account</title>
</head>
<body style="background: #b6dcb3;" >
	<div align="center">
		<h1>Create Account</h1>
		<form action="<%=request.getContextPath()%>/account" method="post">
			<table style="with: 100%">
				<tr>
					<td>Account No.: </td>
					<td><input type="text" name="accountNo" /></td>
				</tr>
				<tr>
					<td>Name: </td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>DOB: </td>
					<td><input type="text" name="dob" /></td>
				</tr>
				<tr>
					<td>Address: </td>
					<td><textarea  name="address" rows="4" cols="50"></textarea></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Account Type: </td>
					<td>
						<select name="type">
						  <option value="saving">Saving Account</option>
						  <option value="sb">SB Account</option>
						  <option value="checking">Checking Account</option>
						  <option value="money market">Money Market Account</option>
						</select>
					</td>
				</tr>		
			</table>
			<input type="submit" value="creat" />
			<div style="color: #FF0000;">${errorMessage}</div>
			<div style="color: #00FF00;"><a href="LandingPage.jsp">Main Menu</a></div>
		</form>
	</div>
</body>
</html>