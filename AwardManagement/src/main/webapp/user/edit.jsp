<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Usuario</title>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/utils.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/usercommon.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/useredit.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl"
		value="<%=request.getContextPath()%>" />
	<input type="hidden" id="currentRole" value="${userBean.role}" />
	<form action="<%=request.getContextPath()%>/user/edit" method="put">
		<fieldset>
			<input type="hidden" id="id" name="id" value="${userBean.id}" />
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="username" required="required"
						value="${userBean.userName}" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required"
						value="${userBean.password}" /></td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="firstName" required="required"
						value="${userBean.firstName}" /></td>
				</tr>
				<tr>
					<td>Apellido:</td>
					<td><input type="text" name="lastName" required="required"
						value="${userBean.lastName}" /></td>
				</tr>
				<tr>
					<td>DNI:</td>
					<td><input type="text" name="dni" required="required"
						value="${userBean.dni}" /></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><select name="role" id="role">
							<%-- 							<c:forEach items="${rolesBean}" var="role"> --%>
							<%-- 								<option value="${role}">${role}</option> --%>
							<%-- 							</c:forEach> --%>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Guardar" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br />
	<b style="color: red;"> <c:if test="${afterEditBean}">
			<c:if test="${successBean}">El usuario se ha modificado exitosamente.</c:if>
			<c:if test="${!successBean}">Ha habido un error al guardar el usuario.</c:if>
		</c:if>
	</b>
	<br/>
	<a href="<%=request.getContextPath()%>/user/index">&lt;== VOLVER</a>
</body>
</html>