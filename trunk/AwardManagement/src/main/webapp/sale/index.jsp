<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas Realizadas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Nueva Venta</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-responsive.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/font-awesome/css/font-awesome.min.cs">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery-2.0.3.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery.mask.min.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl"
		value="<%=request.getContextPath()%>" />
	<form action="<%=request.getContextPath()%>/sale/index" method="post">
		<div class="row-fluid">
						<div class="span12">

							<div class="navbar navbar-fixed-top navbar-inverse">

								<div class="navbar-inner">
									<div class="container">
									<a href="<%=request.getContextPath()%>/sale/create" class="brand">Agregar Venta</a>
									<ul class="nav pull-right">
										<a style="color:white" href="#">UserName(Saler) |</a>
										<a href="#">Cerrar Session</a>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

		<div class="row-fluid">
			<div class="span12">
				<div class="navbar navbar-inverse">
					<div class="navbar-inner">
						<div class="container">
							<ul class="nav pull-center">
								<label>TimeFrame</label>
								<select name="SelectTime" id="SelectTime">
									<option>Month</option>
									<option>Today</option>
									<option>Week</option>
									<option>Year</option>
								</select>
								<label>From</label>
								<input type="date" id="dateFrom" required="required">
								<label>To</label>
								<input type="date" id="dateTo" required="required">
								<input type="submit" class="btn btn-primary" value="Generar Reporte">
							</ul>
						</div>
				</div>
					
				</div>
			</div>
		</div>					
		</form>
		<div class="row-fluid">
			<div class="span12">
				&nbsp;
			</div>
		</div>
	<div>
		<b style="color: blue;"> <c:if test="${afterSaveBean}">
		<c:if test="${!succesBean}">No se encontraron ventas.
		</c:if>
		</c:if>
	</b>
	</div>
	<div class="container">
		<div class="row-fluid">
			<div class="span8">
				
	<table  class="table table-bordered table-striped table-hover table-condensed" id="SalesTable">
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
			</div>
		</div>
	</div>
	<br>
	<br>
	<a href="<%=request.getContextPath()%>/sale/index">&gt;== VOLVER</a>
</body>
</html>