<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Productos a la Venta</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/sale/AddSaleItem">
<table id="tableProductIndex" border="1px">
<tbody>

<tr>
<td>
<select id="products" name="products">
	<c:forEach items="${productBean}" var="product">
								<option value="${product.id}">${product.id}</option>
							</c:forEach>
</select>
</td>
<td>
<input type="text" name="txtCantidad" value="1">
<input type="submit" name="btnEnviar" value="Agregar">
</td>
</tr>
</tbody>
</table>
</form>
</body>
</html>