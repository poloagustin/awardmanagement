<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Comisiones</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />

<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/editsalecommission.js"></script>


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
            <h1>Comisiones</h1>
        </div>
    </div>


	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Monto Mínimo</th>
						<th>Monto Máximo</th>
						<th>Adicional</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${commissions}" var="com">
						<tr>
							<td>${com.id}</td>
							<td>${com.minimumSalesAmount}</td>
							<td>${com.maximumSalesAmount}</td>
							<td>$ ${com.saleCommission}</td>
							<td align="center"><a id="${com.id}" class="btn btn-primary btnEditar">Editar</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>

	<div class="row" id="myRow" hidden="true">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Modificar Comisión</h3>
				</div>
				<div class="panel-body">
					<form action="<%=request.getContextPath()%>/commission/edit" class="form-inline" method="post">
						<div class="form-group">
							<label style="margin-left: 5px; margin-right: 5px;" for="modifySaleCommission">Usted está a punto de modificar La comisión con ID </label><label
								id="lblIdCommission" style="margin-right: 5px;"></label> <input type="number" class="form-control" id="inputCommission" placeholder="Ingrese el monto"
								name="saleCommission"> <input id="inputIdCommission" name="inputIdCommission" hidden="true">
							<button type="submit" class="btn btn-primary">Guardar Cambios</button>
						</div>
					</form>
				</div>
			</div>

		</div>
		<div class="col-md-2"></div>
	</div>

	<c:if test="${afterSaveBean}">
		<div class="row" id="message">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<c:if test="${successBean}">
					<div class="alert alert-success">La Comisión se ha modificado exitosamente.</div>
				</c:if>
				<c:if test="${!successBean}">
					<div class="alert alert-danger">Ha habido un error al modificar la Comisión. "${error}"</div>
				</c:if>

			</div>
			<div class="col-md-2"></div>
		</div>
	</c:if>



		<div class="container" align="center">
			<a href="<%=request.getContextPath()%>/commission/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
		</div>




</body>
</html>