<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	<ul>
		<li><a href="<%=request.getContextPath()%>/sale/create">Agregar
				Venta</a></li>
		<li><a href="<%=request.getContextPath()%>/sale/index">Ventas
				Realizadas</a></li>
		<li><a href="<%=request.getContextPath()%>/commission/index">Ver
				Comisiones y Premios</a></li>
		<li><a href="<%=request.getContextPath()%>/commission/report">Generar
				reporte de comisiones y premios</a></li>
		<li><a href="<%=request.getContextPath()%>/user/index">Usuarios</a></li>
	</ul>
</body>
</html>