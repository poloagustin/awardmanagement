<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas Realizadas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/bootstrap-datetimepicker.min.css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/bootstrap.min.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/bootstrap-datetimepicker.js">
</script>
<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/initIndexSales.js"></script>
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
	<form action="<%=request.getContextPath()%>/sale/index" method="post" class="form-inline" role="form">
			<div class="row-fluid">	
			<div class="span2"></div>
				<div class="span8">
					<div class="panel panel-default" align="center">
						<div class="panel-heading"><strong style="color:blue">Filtros de Ventas:</strong>
							<div class="panel-body">								
								<div class="span3">
										<div class="form-group">
										<label for="selectTime">TimeFrame:</label>
										<div class="input-group">											
										<select name="selectTime" id="selectTime" class="form-control">
											<option>Hoy</option>
											<option>Ayer</option>
											<option>Semana</option>
											<option>Mes</option>
											<option>Año</option>					
										</select>
										</div>
									</div>
									</div>
									<div class="span3" align="center">
										<label for="dateFrom">From:</label>
										<div class='input-group date datetimepickerFrom' 
											 data-date-format="dd/mm/yyyy" data-link-field="dateFrom" 
											 data-link-format="yyyy-mm-dd 00:00:00"> 
											<input type='text' class="form-control" size="10" required="required">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
										<input type='hidden' id="dateFrom" name="dateFrom">
									</div>
									<div class="span3" align="center">
										<label for="dateTo">To:</label>
										<div class='input-group date datetimepickerTo'
											 data-date-format="dd/mm/yyyy" data-link-field="dateTo" 
											 data-link-format="yyyy-mm-dd 00:00:00"> 
											<input type='text' class="form-control" size="10" required="required">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
										<input type='hidden' id="dateTo" name="dateTo">
									</div>
									<div class="span3" align="center">
										<div class="span1"></div>
										<input type="submit" id="btnGenerarReport" class="btn btn-primary" value="Generar Reporte">
									</div>			
								</div>
							</div>
						</div>
					</div>
					<div class="span2"></div>
				</div>				
	</form>			
	<!-- Alert Message-->
	<p>
	<c:if test="${succesBean==false}">		
			<div class="row-fluid">
				<div class="span2"></div>
				<div class="alert alert-info alert-dismissable span8">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		  			<h4>Resultado de Busqueda:</h4>
		  			<strong>No se encontraron ventas</strong> para el perido seleccionado.
				</div>
				<div class="span2"></div>
			</div>
		</c:if>	
	</p>
	<!-- Alert Message-->
	<c:if test="${succesBean}">
	<div class="row-fluid">	
			<div class="span1"></div>
			<div class="span10">
				<table  class="table table-bordered table-striped table-hover table-condensed" id="SalesTable">
					<thead style="background:black">
						<tr style="color:white">
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
			<div class="span1"></div>		
	</div>
	</c:if>
	<br>
	<div class="row-fluid">
		<div class="container">
			<div class="span4">
				<a href="<%=request.getContextPath()%>/home/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
			</div>
		</div>	
	</div>
</body>
</html>