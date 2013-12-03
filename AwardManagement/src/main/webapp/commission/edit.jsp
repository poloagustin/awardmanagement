<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actiualizar Adicional</title>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/jquery-2.0.3.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/scripts/utils.js"></script>
</head>
<body>
	<input type="hidden" id="serverUrl" value="<%=request.getContextPath()%>" />
	<%-- <input type="hidden" id="idCom" value="${commission.id}" /> --%>
	<h1>Actualizar Adicional</h1>
	<form action="<%=request.getContextPath()%>/commission/edit?id=${commission.id}" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Adicional:</td>
					<td><input type="number" name="saleCommission" required="required" value="${commission.saleCommission}"/></td>
				</tr>
			
				
				<tr>
					<td><input type="submit" value="Guardar Cambio" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br />
	<b style="color: red;"> <c:if test="${afterSaveBean}">
			<c:if test="${successBean}">La Comisi�n se ha modificado exitosamente.</c:if>
			<c:if test="${!successBean}">Ha habido un error al modificar la Comisi�n.</c:if>
		</c:if>
	</b>
	<br/>
	<a href="<%=request.getContextPath()%>/commission/index">&lt;== VOLVER</a>
</body>
</html>