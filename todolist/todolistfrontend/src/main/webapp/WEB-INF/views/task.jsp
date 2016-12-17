<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table width="50%">
		<tr>
			<td align="left"><a href="newTask"
				style="textfont-size: 200%; font-family: verdana; color: #00000F">New Task</a></td>
				
			<td align="right"><a href="pendingTask"
				style="textfont-size: 200%; font-family: verdana; color: #00000F">Existing Task</a></td>
			<td></td><td align="center"><a href="completedTask"
				style="textfont-size: 200%; font-family: verdana; color: #00000F">Completed Task
				</a></td>

		</tr>

	</table>


<div id="newTask">
			<c:if test="${isnewTask==true }">
				<%@ include file="newTask.jsp"%>
			</c:if>
		</div>
		
<div id="pendingTask">
			<c:if test="${ispendingTask==true }">
				<%@ include file="pendingTask.jsp"%>
			</c:if>
		</div>
		
<div id="completedTask">
			<c:if test="${iscompletedTask==true }">
				<%@ include file="completedTask.jsp"%>
			</c:if>
		</div>


<table width="100%">
<tr>
				<c:choose>
					<c:when test="${empty loggedInUser}">
					</c:when>

					<c:when test="${not empty loggedInUser}">
						<td>Welcome ${loggedInUser},</td>
						<td align="right"><a href="logout"> logout</a></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<c:if test="${loggedOut==true}">
					<td>${logoutMessage}</td>
				</c:if>
			</tr>
</table>

</body>
</html>