<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Venta</title>
</head>
<body>
<form action="<%=request.getContextPath()%>" method="get">
<input type="text" name="txtSaleNumber" size="20">	
<input type="submit" name="btnIngresar">
<select>
<c:forEach items="${usersBean}" var="user"> 
<option value="${user.username}">${user.username}</option>
</c:forEach>
</select>
</form>
</body>
</html>