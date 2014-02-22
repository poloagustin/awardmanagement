<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Comisiones</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />
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
            <h1>Menu de Comisiones</h1>
        </div>
    </div>


	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="list-group">
				<a href="<%=request.getContextPath()%>/commission/list" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span> Administrar
					Comisiones</a>
					 <a href="<%=request.getContextPath()%>/commission/listproducts" class="list-group-item"><span class="glyphicon glyphicon-hand-right"></span>
					Administrar Comisiones de Productos</a>
			
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>

		<div class="container" align="center">
			<a href="<%=request.getContextPath()%>/home/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
		</div>
</body>
</html>