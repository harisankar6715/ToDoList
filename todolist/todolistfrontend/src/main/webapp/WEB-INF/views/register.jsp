<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>SignUp</title>
</head>
<body>

<form:form action="here/register"  method="post" modelAttribute="user">
		<table align="center">
			
			<tr>
				<td><b>User Name:</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td><b>Mail ID:</td>
				<td><input type="text" name="Mailid" required></td>
			</tr>
			<tr>
				<td><b>Password:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			
			<tr>
				<td><input type="submit"
					value="<spring:message text="Register"/>" /></td>
				<td><input type="reset" value="<spring:message text="Reset"/>" />
				</td>
			</tr>
			
		</table>

	</form:form>

</body>
</html>