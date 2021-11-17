<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Statement</title>
</head>
<body style="background: #b6dcb3;">
	<div align="center">
		<h1>Account Statement</h1>
		
			<table style="width: 40%">
				<tr align="center">
				    <th>Amount</th>
				    <th>Action</th>
				    <th>Date</th>
				 </tr>
				<tr align="center">
				    <td>${amount1}</td>
				    <td>${action1}</td>
				    <td>${date1}</td>
				</tr>
				<tr align="center">
				    <td>${amount2}</td>
				    <td>${action2}</td>
				    <td>${date2}</td>
				</tr>
				<tr align="center">
				    <td>${amount3}</td>
				    <td>${action3}</td>
				    <td>${date3}</td>
				</tr> 

			</table>
			
			<div style="color: #00FF00;"><a href="LandingPage.jsp">Main Menu</a></div>
		
	</div>
</body>
</html>