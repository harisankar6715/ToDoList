<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDoList | SignIn</title>
</head>
<body> 

<!-- Fixed navbar --> 
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">ToDoList</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
         
          <li><a href="register">SignUp</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<h5 align="center">Please login with your credentials</h5>
<c:url var="action" value="/login"></c:url>
	<form:form action="${action}" method="post">
		<table align="center">
			<tr>
				<td><b>Mail ID</td>
				<td><input type="text" name="name" required></td>
			</tr>
			
			<tr>
			
				<td><b>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="SignIn"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>