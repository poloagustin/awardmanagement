<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />


</head>
<body>
	<header>
		<div class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header"></div>
				<div class="navbar-collapse collapse">
					<form class="navbar-form navbar-right" role="form">
						<div class="btn-group">
							<a class="btn btn-primary">
								<span class="glyphicon glyphicon-user"></span> ${user.username}
							</a>
							<a class="btn btn-info">
								<c:if test="${user.role == 0}">HHRR</c:if>
								<c:if test="${user.role == 1}">SALESMAN</c:if>
								<c:if test="${user.role == 2}">ADMINISTRATOR</c:if>
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
			<h1>Menu Principal</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="list-group">
			
			    <c:if test="${user.role == 0}">
                    <a href="<%=request.getContextPath()%>/commission/index.jsp" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span> Comisiones y Premios</a>
                    <a href="<%=request.getContextPath()%>/commission/report" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span> Generar reporte de comisiones y premios</a>
                </c:if>
			    
			    <c:if test="${user.role == 1}">
				    <a href="<%=request.getContextPath()%>/sale/create" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span> Agregar Venta</a>
				    <a	href="<%=request.getContextPath()%>/sale/index" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span> Ventas Realizadas</a>
				</c:if>
				
				<c:if test="${user.role == 2}">
                    <a href="<%=request.getContextPath()%>/user/index" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span> Usuarios</a>
			    </c:if>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>


	<!-- 	<ul> -->
	<%-- 		<li><a href="<%=request.getContextPath()%>/sale/create">Agregar Venta</a></li> --%>
	<%-- 		<li><a href="<%=request.getContextPath()%>/sale/index">Ventas Realizadas</a></li> --%>
	<%-- 		<li><a href="<%=request.getContextPath()%>/commission/index">Ver Comisiones y Premios</a></li> --%>
	<%-- 		<li><a href="<%=request.getContextPath()%>/commission/report">Generar reporte de comisiones y premios</a></li> --%>
	<%-- 		<li><a href="<%=request.getContextPath()%>/user/index">Usuarios</a></li> --%>
	<!-- 	</ul> -->

	<!-- 	</div> -->
	<div id="footer"  style="position: absolute;">
		<div class="container" align="center">
			<%--             <a href="<%=request.getContextPath()%>/commission/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a> --%>
		</div>
	</div>


	<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/bootstrap.min.js"></script>
</body>
</html>