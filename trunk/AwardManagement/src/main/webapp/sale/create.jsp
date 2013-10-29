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
	<input type="hidden" id="serverUrl" value="<%=request.getContextPath()%>"/>
	<form id="newSale" action="<%=request.getContextPath()%>/sale/create"  method="post"> 
		<table id="SaleTable" class="newSale">
			<tbody>
				<tr>
					<td>Numero de Venta:</td>
					<td><input type="text" name="txtNumberSale" size="20" required="required"></td>
				</tr>
				<tr>
					<td>Fecha:</td>
					<td><input type="date" name="datetime" required="required"></td>
				</tr>
				<tr>
					<td>Vendedor:</td>
					<td><select id="salerman" name="salerman">
							<c:forEach items="${usersBean}" var="user">
								<option value="${user.username}">${user.username}</option>
							</c:forEach>
					</select></td>
				</tr>
			</tbody>
		</table>
		
	<!--  	<strong>Items</strong>
		<table id="tableSaleItem">
			<thead>
				<tr>
					<td>Producto</td>
					<td>Precio</td>
					<td>Cantidad</td>
					<td>Total</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><select id="productoId"></select></td>
					<td><input type="text" name="monto" size="20" required></td>
					<td><input type="number" name="cantidad" size="20" required></td>
					<td><input type="text" name="totalParcial" size="20" readonly></td>
				</tr>
			</tbody>
		</table>
		-->
		<div><a href="<%=request.getContextPath()%>/sale/AddSaleItem">Agregar Productos</a></div>
		<table id="tableEnviar">
			<tr>
			</tr>
			<tr>
				<td><input type="submit" name="btnGuardar" value="Guardar"></td>
				<td><input type="reset" name="btnCancelar" value="Cancelar"></td>
			</tr>

		</table>
	</form>
	<br />
	<b style="color: red;"> <c:if test="${afterSaveBean}">
			<c:if test="${successBean}">La venta ha sido creada.</c:if>
			<c:if test="${!successBean}">Ha habido un error guardar la venta.</c:if>
		</c:if>
	</b>
	<br/>
	<a href="<%=request.getContextPath()%>/sale/index">&gt;== VOLVER</a>
</body>
</html>