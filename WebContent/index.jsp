<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login or register</title>
	<style type="text/css">
		body{
			background-image: url("imgs/login.jpg");
			padding: 260px;
		}
	</style>
</head>
<body>
	<form action="LoginServlet" method="post">
		<table id = "logset" align="center">
			<tr>
				<td  colspan="2">
					<input type="text" name="uname" placeholder="please input your LoginName" style="text-align: center; opacity: 0.5; border-radius: 15px;width: 200px; height: 20px;">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="password" name="upsd" style="text-align: center; opacity: 0.5; border-radius: 15px;width: 200px; height: 20px;">
				</td>
			</tr>
			<tr >
				<td  align="left"><input type="submit" name="login" value="Login" style="opacity: 0.5; border-radius: 15px;width:50px; height: 20px;">
				</td>
				<td  align="right">
					<a href=""><button name = "register.jsp" value = "regeste" style="border-radius: 15px;width: 50px;height: 20px;opacity: 0.5;"></button></a>
				</td>
			</tr>
		</table>
	</form>
	</form>
</body>
</html>