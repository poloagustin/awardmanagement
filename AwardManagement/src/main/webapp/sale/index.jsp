<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas Realizadas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%-- 		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css"> --%>
<%-- 		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-responsive.css"> --%>
<%-- 		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/font-awesome/css/font-awesome.min.cs"> --%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery.mask.min.js"></script>
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
			<h1>Ventas realizadas</h1>
		</div>
	</div>


	<form action="<%=request.getContextPath()%>/sale/index" method="post">
		<div class="row-fluid">
			<div class="span3"></div>
			<div class="span6">
				<div class="panel panel-default">
					<div class="panel-heading">Datos de Filtro</div>
					<div class="panel-body">
						<div class="row-fluid">
							<div class="span4" align="center">
								<label>TimeFrame</label><select name="SelectTime" id="SelectTime">
									<option>Month</option>
									<option>Today</option>
									<option>Week</option>
									<option>Year</option>
								</select>
							</div>
							<div class="span4" align="center">
								<label>From</label> <input type="date" id="dateFrom" required="required">
							</div>
							<div class="span4" align="center">
								<label>To</label> <input type="date" id="dateTo" required="required">
							</div>
						</div>
						<br>
						<div class="row-fluid">
							<div class="span12" align="center">
								<input type="submit" class="btn btn-primary" value="Generar Reporte">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="span3"></div>
		</div>
	</form>
	<div class="row-fluid">
		<div class="span12">&nbsp;</div>
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

				<table class="table table-bordered table-striped table-hover table-condensed" id="SalesTable">
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
	
	 
        <div class="container" align="center">
           <a href="<%=request.getContextPath()%>/home/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
        </div>
    
</body>
</html>