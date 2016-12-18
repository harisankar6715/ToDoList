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
<title>ToDoList | ExistingTask</title>
</head>
<body>

<h1 align="center"><b><u>TASKS</u></b></h1>
<c:if test="${!empty taskList}">
		<table border="1" align="center">
			<tr>
				<th> ID</th>
				<th> TASK TITLE</th>
				<th> DESCRIPTION</th>
				<th> STATUS</th>
				<th> DELETE</th>
				<th> UPDATE</th>
			</tr>

			<c:forEach items="${taskList }" var="task">
				<tr>
					<td>${task.task_id}</td>
					<td>${task.task_title}</td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td> <a href="<c:url value='task/delete/${task.task_id}' />">Delete</a></td>
					<td> <a href="<c:url value='task/update/${task.task_id}' />">Update</a></td>
					</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>