<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
<%-- <link href="<%=request.getContextPath()%>/bootstrap/css/style.css" rel="stylesheet" /> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" />
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/utils.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/usercommon.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/userindex.js"></script>
</head>
<body>
<header>
</header>
<section id="main">

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
            <h1>Usuarios</h1>
        </div>
    </div>
	<div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <table class="table table-bordered">
		<thead>
			<tr>
				<th>Nombre de Usuario</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Dni</th>
			</tr>
		</thead>
		<tbody>
<%-- 			<c:forEach items="${users}" var="user"> --%>
<!-- 				<tr> -->
<%-- 					<td>${user.username}</td> --%>
<%-- 					<td>${user.firstName}</td> --%>
<%-- 					<td>${user.lastName}</td> --%>
<%-- 					<td>${user.dni}</td> --%>
<!-- 					<td><a -->
<%-- 						href="<%=request.getContextPath()%>/user/edit?id=${user.id}">Editar</a></td> --%>
<%-- 					<td><a href="#" onclick="deleteUser(${user.id})">Eliminar</a></td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
		</tbody>
	</table>
	</div>
        <div class="col-md-2"></div>
    </div>
    <div align="center"><a href="<%=request.getContextPath()%>/user/create" class="btn btn-success">Nuevo Usuario</a></div>
	
	<form method="get" action="<%=request.getContextPath()%>/user/search">
		<input type="text" required="required" name="username" /> <input
			type="submit" value="Buscar" />
	</form>
	</section>
	   
        <div class="container" align="center">
           <a href="<%=request.getContextPath()%>/home/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
        </div>
   
</body>
</html>