<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Usuario</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/user/create" method="put">
		<fieldset>
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="username" required="required" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="firstName" required="required" /></td>
				</tr>
				<tr>
					<td>Apellido:</td>
					<td><input type="text" name="lastName" required="required" /></td>
				</tr>
				<tr>
					<td>DNI:</td>
					<td><input type="text" name="dni" required="required" /></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td>
						<select name="role">
							<c:forEach items="${rolesBean}" var="role">
								<option value="${role}">${role}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Guardar"/></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br/>
	<b style="color: red;">
		<c:if test="${afterSaveBean}">
			<c:if test="${successBean}">El usuario se ha creado exitosamente.</c:if>
			<c:if test="${!successBean}">Ha habido un error al guardar el usuario.</c:if>
		</c:if>
	</b>
</body>
</html>