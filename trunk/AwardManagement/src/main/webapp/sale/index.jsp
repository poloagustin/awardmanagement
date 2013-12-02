<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas Realizadas</title>
</head>
<body>
	<input type="hidden" id="serverUrl"
		value="<%=request.getContextPath()%>" />
		<h1>Ventas Realizadas:</h1>
		
		
		<div align="center">
		<form action="<%=request.getContextPath()%>/sale/index" method="post">
			<b>TimeFrame:	From <input type="date" id="dateFrom" name="dateFrom">	To <input
				type="date" id="dateTo" name="dateTo">	<select id="salerMan" name="salerMan"> <c:forEach items="${UsersBean}" var="user">
								<option value="${user.username}">${user.username}</option></c:forEach></select>    <input type="submit" id="btnGenerarReporte" value="Generar Reporte"></b>
		</form>
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
</tr>
</c:forEach>
</tbody>
</table>		
<br>
</body>
</html>