<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Comisiones</title>
</head>
<body>
<input type="hidden" id="serverUrl" value="<%=request.getContextPath()%>" />
	<h1>Comisiones</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Monto Mínimo</th>
				<th>Monto Máximo</th>
				<th>Adicional</th>
			</tr>
		</thead>
		<tbody>
 			<c:forEach items="${commissions}" var="com"> 
			<tr> 
					<td>${com.id}</td> 
					<td>${com.minimumSalesAmount}</td> 
 					<td>${com.maximumSalesAmount}</td> 
 					<td>${com.saleCommission}</td> 
 					<td><a 
 						href="<%=request.getContextPath()%>/commission/edit?id=${com.id}">Editar</a></td> 
 					
 				</tr> 
 			</c:forEach>
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/commission/create">Nueva Comisión</a>
	
	<a href="<%=request.getContextPath()%>/home/index.jsp">&lt;== VOLVER</a>
</body>
</html>