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
<title>ToDoList | CreateTask</title>
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
          <ul class="nav navbar-nav">
            <li class="active"><a href="createTask">Create Task</a></li>
            <li><a href="existingTask">Existing Task</a></li>
           
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <li><a href="logout">SignOut</a></li> 
          
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
     <br><br><br><br><br>
	<h1 align="center">
		<b><u>CREATE TASK</u></b>
	</h1>
	<c:url var="addAction" value="tocreateTask"></c:url>
	<form:form action="${addAction }" commandName="task">
		<table align="center">
			
			<tr>
				<td><form:label path="task_title" required="true">
						<spring:message text="Title"></spring:message>
					</form:label></td>
				<td><form:input path="task_title" required="true"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="description">
						<spring:message text="Description"></spring:message>
					</form:label></td>
				<td><form:input path="description" required="true"></form:input></td>
			</tr>

			<tr>
				<!-- if the category is already exist, then edit -->
				<td><c:if test="${!empty task.task_title }">
						<input type="submit"
							value="<spring:message text="Edit"></spring:message>">
					</c:if> <c:if test="${empty task.task_title}">
						<input type="submit"
							value="<spring:message text="Add"></spring:message>">
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
</body>
</html>