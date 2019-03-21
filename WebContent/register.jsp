<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>please register</title>
	<style type="text/css">
		body{
			background-image: url("imgs/register.jpg");
			padding: 260px;
		}
		#regiset{
			padding: 360px;
		}
		#sub{
			text-align: center;
		}
	</style>
</head>
<body>
	<form method="post" action="RegisterServlet">
		<table id = "regiset" align="cneter">
			<tr>
				<td>
					RegisteName:<input type="text" name="uname" placeholder="RegisterName" style="text-align: center; opacity: 0.5; border-radius: 15px;width: 200px; height: 20px;">
				</td>
			</tr>
			<tr>
				<td>
					YesPassword:<input type="password" name="upsd" style="text-align: center; opacity: 0.5; border-radius: 15px;width: 200px; height: 20px;"><br>
				</td>
			</tr>
			<tr>
				<td id = "sub">
					<input type="submit" name="registe"style="text-align: center; opacity: 0.5; border-radius: 15px;width: 80px; height: 20px;">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>