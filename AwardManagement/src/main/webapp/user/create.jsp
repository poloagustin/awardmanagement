<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Usuario</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/utils.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/usercommon.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/usercreate.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl" value="<%=request.getContextPath()%>" />
	<header>
		<div class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header"></div>
				<div class="navbar-collapse collapse">
					<form class="navbar-form navbar-right" role="form">
						<div class="btn-group">
							<a class="btn btn-primary"> <span class="glyphicon glyphicon-user"></span> ${user.username}
							</a> <a class="btn btn-info"> <c:if test="${user.role == 0}">HHRR</c:if> <c:if test="${user.role == 1}">SALESMAN</c:if> <c:if test="${user.role == 2}">ADMINISTRATOR</c:if>
							</a>
						</div>
					</form>
				</div>
				<!--/.navbar-collapse -->
			</div>
		</div>
	</header>

	<div class="jumbotron">
		<div class="container">
			<h1>Crear Usuario</h1>
		</div>
	</div>


	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form role="form" role="form" action="<%=request.getContextPath()%>/user/create" method="post">
				<fieldset>
					<table class="table">
						<tr>
							<td><label for="1">Usuario:</label></td>
							<td><input type="text" name="username" required="required" /></td>
						</tr>
						<tr>
							<td><label for="2">Password:</label></td>
							<td><input type="password" name="password" required="required" /></td>
						</tr>
						<tr>
							<td><label for="3">Nombre:</label></td>
							<td><input type="text" name="firstName" required="required" /></td>
						</tr>
						<tr>
							<td><label for="4">Apellido:</label></td>
							<td><input type="text" name="lastName" required="required" /></td>
						</tr>
						<tr>
							<td><label for="5">DNI:</label></td>
							<td><input type="text" name="dni" required="required" /></td>
						</tr>
						<tr>
							<td><label for="6">Role:</label></td>
							<td><select name="role" id="role">
									<%-- 							<c:forEach items="${rolesBean}" var="role"> --%>
									<%-- 								<option value="${role}">${role}</option> --%>
									<%-- 							</c:forEach> --%>
							</select></td>
						</tr>
						</table>
						<div class="row" align="center"><input type="submit" value="Guardar" class="btn btn-primary"/>
						</div>
						
				</fieldset>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	<br />
	<b style="color: red;"> <c:if test="${afterSaveBean}">
			<c:if test="${successBean}">El usuario se ha creado exitosamente.</c:if>
			<c:if test="${!successBean}">Ha habido un error al guardar el usuario.</c:if>
		</c:if>
	</b>
	
        <div class="container" align="center">
           <a href="<%=request.getContextPath()%>/user/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
        </div>
    
</body>
</html>