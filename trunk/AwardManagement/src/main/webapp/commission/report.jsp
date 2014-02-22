<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de comisiones y premios</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />

<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/utils.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/salereport.js"></script>
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
            <h1>Reporte de comisiones y premios</h1>
        </div>
    </div>
	
	<!-- 	<form method="post" -->
	<%-- 		action="<%=request.getContextPath()%>/commission/report"> --%>
	<fieldset>
		<legend>Parametros</legend>
		<b>Mes</b><br /> <select id="month" name="month">
			<option value="1">Enero</option>
			<option value="2">Febrero</option>
			<option value="3">Marzo</option>
			<option value="4">Abril</option>
			<option value="5">Mayo</option>
			<option value="6">Junio</option>
			<option value="7">Julio</option>
			<option value="8">Agosto</option>
			<option value="9">Septiembre</option>
			<option value="10">Octubre</option>
			<option value="11">Noviembre</option>
			<option value="12">Diciembre</option>
		</select><br /> <b>Año</b><br /> <select id="year" name="year">
		</select><br /> <select id="users" name="users" multiple="multiple"></select><br />
		<button id="generateReport" name="generateReport" onclick="getReport()">Generar Reporte</button>
		<br />
	</fieldset>
	<!-- 	</form> -->
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