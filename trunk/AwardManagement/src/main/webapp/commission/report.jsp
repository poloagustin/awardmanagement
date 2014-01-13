<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de comisiones y premios</title>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/utils.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/scripts/salereport.js"></script>
</head>
<body>
	<h1>Reporte de comisiones y premios</h1>
	<form method="post"
		action="<%=request.getContextPath()%>/commission/getreport">
		<fieldset>
			<legend>Parametros</legend>
			<b>Mes</b><br /> <input type="month" id="month" /><br /> <b>Año</b><br />
			<input type="number" id="year" /><br /> <input type="submit"
				id="submit" /><br />
		</fieldset>
	</form>
	<table>
		<thead>
			<tr>
				<th>Vendedor</th>
				<th>Monto</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>