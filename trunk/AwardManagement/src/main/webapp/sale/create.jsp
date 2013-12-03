<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Venta</title>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/ScriptsSale/jquery-2.0.3.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/ScriptsSale/addProduct.js"></script>
<script type="application/javascript"
	src="<%=request.getContextPath()%>/ScriptsSale/validateSale.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl"
		value="<%=request.getContextPath()%>" />
	<form id="newSale" action="<%=request.getContextPath()%>/sale/create"
		method="post">
		<table id="SaleTable" class="newSale">
			<tbody>
				<tr>
					<td>Numero de Venta:</td>
					<td><input type="text" name="txtNumberSale" size="20"
						value="<%=request.getSession().getAttribute("txtNumberSaleSave")%>"
						required="required"></td>
				</tr>
				<tr>
					<td>Vendedor:</td>
					<td><select id="salerman" name="salerman">
							<c:forEach items="${UsersBean}" var="user">
								<option value="${user.username}">${user.username}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Fecha de Venta:</td>
					<td>${dateBean}<input type="hidden" name="dateSale"
						value="${dateBean}" id="dateSale"></td>
				</tr>
			</tbody>
		</table>
		<br>
		<table>
			<tbody>
				<tr>
					<td><strong>Seleccione Item:</strong> <select id="prod"
						name="prod">
							<c:forEach items="${ProductsBean}" var="prod">
								<option value="${prod.id}">${prod.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><strong>Seleccione Cantidad de Items</strong> <input
						type="number" id="cant" name="cant" value="1" size="7"></td>
				</tr>
			</tbody>
		</table>
		<br>
		<table id="SalesItem" border="1" hidden="false">
			<thead>
				<tr>
					<th>N Item</th>
					<th>Producto</th>
					<th>Importe</th>
					<th>Cantidad</th>
					<th>Precio Total</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
		<br>
		<div>
			<input type="button" id="btnAgregarItem" name="btnAgregarItem"
				value="Agregar Item">
			<!--  <input type="button" value="Eliminar Item" class="EliminarItem">-->
		</div>

		<table id="tableEnviar">
			<tr>
			</tr>
			<tr>
				<td><input type="submit" name="btnGuardar" id="btnGuardar"
					value="Guardar"></td>
				<td><input type="reset" name="btnCancelar" value="Cancelar"></td>
			</tr>

		</table>
	</form>
	<div id="validation" style="color: red;">
		<c:if test="${not empty SaleBean}">
			<b>El venta ya se encuentra registrada!</b>
			<ul>
				<li><b>Nombre del Vendedor: </b>${SalerManExist.firstName} ${SalerManExist.lastName}</li>
				<li><b>Fecha de venta registrada:</b> ${SaleBean.date}</li>
			</ul>
		</c:if>
	</div>
	<b style="color: red;"> <c:if test="${afterSaveBean}">
			<c:if test="${!succesBean}">Ha habido un error guardar la venta.</c:if>
		</c:if>
	</b>
	<b style="color: green;"> <c:if test="${afterSaveBean}">
			<c:if test="${succesBean}">La venta ha sido creada.</c:if>
		</c:if>
	</b>
	<br>
	<br />
	<a href="<%=request.getContextPath()%>/sale/index">&gt;== VOLVER</a>
</body>
</html>