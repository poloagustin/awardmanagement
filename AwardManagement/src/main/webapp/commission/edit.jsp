<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actiualizar Adicional</title>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/utils.js"></script>
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
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-user"></span> Usuario
							</button>
							<button type="submit" class="btn btn-danger">
								<span class="glyphicon glyphicon-off"></span> Cerrar Sesión
							</button>
						</div>
					</form>
				</div>
				<!--/.navbar-collapse -->
			</div>
		</div>
	</header>


	<div class="jumbotron">
		<div class="container">
			<h1>Comisiones</h1>
		</div>
	</div>
	<%-- <input type="hidden" id="idCom" value="${commission.id}" /> --%>
	


	<form action="<%=request.getContextPath()%>/commission/edit?id=${commission.id}" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Adicional:</td>
					<td><input type="number" name="saleCommission" required="required" value="${commission.saleCommission}" /></td>
				</tr>


				<tr>
					<td><input type="submit" value="Guardar Cambio" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br />
	<b style="color: red;"> <c:if test="${afterSaveBean}">
			<c:if test="${successBean}">La Comisión se ha modificado exitosamente.</c:if>
			<c:if test="${!successBean}">Ha habido un error al modificar la Comisión.</c:if>
		</c:if>
	</b>
	<br />
	<a href="<%=request.getContextPath()%>/commission/index">&lt;== VOLVER</a>
</body>
</html>