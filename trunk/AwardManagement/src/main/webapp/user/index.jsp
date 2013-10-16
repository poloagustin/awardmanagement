<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<h1>Usuarios</h1>
	<table>
		<thead>
			<tr>
				<th>Nombre de Usuario</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Dni</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.dni}</td>
					<td><a
						href="<%=request.getContextPath()%>/user/edit?id='${user.id}'">Editar</a></td>
					<td><a
						href="<%=request.getContextPath()%>/user/delete?id='${user.id}'">Eliminar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/user/create">Nuevo Usuario</a>
	<form method="get" action="<%=request.getContextPath()%>/user/search">
		<input type="text" required="required" name="username"/>
		<input type="submit" value="Buscar" />
	</form>
</body>
</html>