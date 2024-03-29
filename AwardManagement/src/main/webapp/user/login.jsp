<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" /> --%>
<%@ include file="/shared/scripts.html"%>

<%-- <script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script> --%>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/utils.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/usercommon.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/userlogin.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl" value="<%=request.getContextPath()%>" />

	<header>
		<div class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header"></div>
				<div class="navbar-collapse collapse"></div>

			</div>
		</div>
	</header>
	<div class="jumbotron">
		<div class="container">
			<h1>Log In</h1>
		</div>
	</div>


	<form action="<%=request.getContextPath()%>/user/login" method="post">
		<fieldset>
			<br>
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-1">
					<label for="1">Usuario:</label>
				</div>
				<div class="col-md-1">
					<input type="text" name="username" required="required" />
				</div>
				<div class="col-md-5"></div>
			</div>
			<br>
			<div class="row"></div>
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-1">
					<label for="2">Password:</label>
				</div>
				<div class="col-md-1">
					<input type="password" name="password" required="required" />
				</div>
				<div class="col-md-5"></div>
			</div>
			<br>
			<div class="row"></div>
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-1">
					
				</div>
				<div class="col-md-1"><input class="btn btn-primary" type="submit" value="Guardar" /></div>
				<div class="col-md-5"></div>
			</div>




		</fieldset>
	</form>
	<br />
	<b style="color: red;"> <c:if test="${requestFailed}">Los datos suministrados no fueron correctos.</c:if>
	</b>
	<br />

</body>
</html>
