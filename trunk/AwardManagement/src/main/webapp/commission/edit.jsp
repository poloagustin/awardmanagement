<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<form action="<%=request.getContextPath()%>/comission/create" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Monto Mínimo:</td>
					<td><input type="number" name="maximumSalesAmount" required="required" /></td>
				</tr>
				<tr>
					<td>Monto Máximo:</td>
					<td><input type="number" name="minimumSalesAmount" required="required" /></td>
				</tr>
				<tr>
					<td>Camición:</td>
					<td><input type="number" name="saleCommission" required="required" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Guardar" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br />
	<b style="color: red;"> <c:if test="${afterSaveBean}">
			<c:if test="${successBean}">La Comisión se ha creado exitosamente.</c:if>
			<c:if test="${!successBean}">Ha habido un error al guardar la Comisión.</c:if>
		</c:if>
	</b>
	<br/>
	
</body>
</html>