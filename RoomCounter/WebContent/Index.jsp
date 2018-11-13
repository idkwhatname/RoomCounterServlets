<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<c:url value="/addSession" var="addURL"></c:url>
	
		<form action='<c:out value="${addURL}"></c:out>' method="post">
			Name: <input type="text" name="name"><br>
			<input type="submit" value="Add Session">
		</form>
		  <%-- Room List Logic --%>
               <!-- <c:if test="${not empty requestScope.rooms}"> -->
               <table style="width:100%">
               		<tbody>
               			<tr>
               				<th>Room Name</th>
               				<th>Capacity</th>
               			</tr>
               			<!-- 
               			<c:forEach items="${requestScope.rooms}" var="room">
               				<td><c:out value="${room.name}"></c:out></td>
               				<td><c:out value="${room.capacity}"></c:out></td>   			
               			</c:forEach>
               			 -->
               		</tbody>
               </table>
              <!-- </c:if> -->

</body>
</html>