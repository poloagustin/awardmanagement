<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas Realizadas</title>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/ScriptsSale/jquery-2.0.3.js"></script>
	<script type="application/javascript"
	src="<%=request.getContextPath()%>/ScriptsSale/initDate.js"></script>
	<script type="application/javascript"
	src="<%=request.getContextPath()%>/ScriptsSale/validateIndexSale.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl"
		value="<%=request.getContextPath()%>" />
	<h1>Ventas Realizadas:</h1>

	<div align="center">
		<form action="<%=request.getContextPath()%>/sale/index" method="post">
			<b>TimeFrame: <select id="salerMan" name="salerMan">
					<option>Mes</option>
			</select>From <input type="date" id="dateFrom"
				name="dateFrom" required="required">
				To <input type="date" id="dateTo" name="dateTo" required="required">  
				 <input type="submit" id="btnGenerarReporte" value="Generar Reporte"></b>
		</form>
	</div>
	<br>
		<div>
		<b style="color: blue;"> <c:if test="${afterSaveBean}">
		<c:if test="${!succesBean}">No se encontraron ventas.
		</c:if>
		</c:if>
	</b>
	</div>	
	<table id="SalesTable" border="1">
		<thead>
			<tr>
				<th>Numero de Venta</th>
				<th>Fecha de Venta</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${salesBean}" var="sale">
				<tr>
					<td>${sale.number}</td>
					<td>${sale.date}</td>
					<td>${sale.total}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<a href="<%=request.getContextPath()%>/sale/index">&gt;== VOLVER</a>
</body>
</html>