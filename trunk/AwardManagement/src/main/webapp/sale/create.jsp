<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Nueva Venta</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap3/css/style.css" /><meta name="viewport" content="width=device-width,initial-scale=1.0">
	<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/jquery-2.0.3.js"></script>
	<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/bootstrap.min.js"></script>
	<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap3/js/jquery.mask.min.js"></script>
	<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/initSales.js"></script>
	<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/addProduct.js"></script>
	<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/validateCreateSale.js"></script>	
</head>
<body>
	<header>
		<div class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header"></div>
				<div class="navbar-collapse collapse">
					<form class="navbar-form navbar-right" role="form">
						<div class="btn-group">
							<a class="btn btn-primary"> <span class="glyphicon glyphicon-user"></span> ${user.username}
							</a> <a class="btn btn-info"> <c:if test="${user.role == 0}">HHRR</c:if> <c:if test="${user.role == 1}">SALESMAN</c:if> <c:if test="${user.role == 2}">ADMINISTRATOR</c:if>
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
		<h1>Nueva Venta</h1>
	</div>
</div>
<input type="hidden" id="serverUrl"	value="<%=request.getContextPath()%>">
<form id="newSale" action="<%=request.getContextPath()%>/sale/create" method="post" class="form-horizontal" role="form">
	<div class="row-fluid">
		<div class="span12">
			&nbsp;	
		</div>
	</div>
	<!-- Alert Message-->
	<div class="container">
		<p>
		<c:if test="${succesBean}">
		<div class="row-fluid">
			<div class="container-fluid">					
				<div class="alert alert-success alert-dismissable span12">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		  			<h4>Venta Registrada!!</h4>
		  			<strong></strong>Se ha registrado la nueva venta exitosamente!! 
				</div>				
				</div>
			</div>
		</c:if>
		</p>	
	</div>
	<div class="row-fluid">
		<div class="container">
			<div class="well span8">
				<div class="row-fluid">
					<div class="form-group">						
					<div class="span3">
						<div class="span1"></div>
						<label for="txtNumberSale">Numero de Venta:</label>
					</div>
					<div class="span3">
						<input id="txtNumberSale" type="text" 
						name="txtNumberSale" class="form-control" size="20">
					</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span3"><label>Id Vendedor:</label></div>
					<div class="span3">${user.userId}</div>				
				</div>
				<div class="row-fluid">							
					<div class="span3"><label>Fecha de Venta:</label></div>
					<div class="span3">${dateBean}</div>					
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="container">
			<div class="span2">
				<a id="btnAgregarItem" class="btn btn-primary">
					<span id="iconAgregarItem" class="glyphicon glyphicon-plus-sign"></span>
					Agregar Items
				</a>
			</div>
		</div>
	</div>
	<div class="row-fluid" hidden="true" id="itemsProd">
		<div class="container">
			<div class="span8">
				&nbsp;	
				<div class="row-fluid">
					<div style="background:blue" class="span8">
						<div class="span8">
							<b style="color:white">Seleccione Items:</b>
						</div>						
					</div>
				</div>
				<div class="row-fluid">
					<div class="span8" data-spy="scroll">
						<table class="table table-bordered table-striped table-hover table-condensed" 
								id="Products">
							<thead>
								<tr>
									<th>ID</th>
									<th>Producto</th>
									<th>P.Unitario</th>
									<th>Accion</th>
								</tr>
							</thead>
							<tbody></tbody>							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="txtProd" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="txtProd"></h4>
					<input id="idProd" type="hidden">
					<input id="nameProd" type="hidden">
					<input id="ammountProd" type="hidden">
				</div>
				<div class="modal-body">
					<div class="row-fluid">
						<div class="span8">							
							<div class="group-form">
								<label for="txtCant">Ingrese Cantidad:</label>
								<input type="text" id="txtCant" class="form-control number">
							</div>
						</div>
					</div>
				</div>					
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
					<button id="btnCantSend" type="button" data-dismiss="modal" class="btn btn-success">Enviar
					</button>
				</div>
			</div>
		</div>
	</div>
	<div id="myModalValidate" class="modal fade bs-example-modal-sm" tabindex="-1" 
	role="dialog" aria-labelledby="title-modal" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">				
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>			
				<h4 id="title-modal">Mensaje:</h4>
			</div>
			<div class="modal-body">
				<h4 id="txtValidProd" style="color:red"></h4>
			</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn">Ok
				</button>
			</div>
		</div>
	</div>
</div>
	<div id="myModalEdit" class="modal fade bs-example-modal-sm" tabindex="-1" 
		role="dialog" aria-labelledby="title-modal" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;
				</button>
				<h4 id="txtProdEdit"></h4>
				<input id="idProdEdit" type="hidden">
			</div>				
			<div class="modal-body">
				<div class="row-fluid">
					<div class="span8">						
						<div class="group-form">
							<label for="txtCantEdit">Ingrese Cantidad:</label>
							<input class="form-control number" id="txtCantEdit">
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar
				</button>
				<button id="btnCantEdit" type="button" data-dismiss="modal" 
				class="btn btn-success">Enviar
			</button>
		</div>
		</div>
	</div>
	</div>
&nbsp;		
<div class="row-fluid" id="listSaleItems">
	<div class="container">
		<div class="span12">
			<div class="row-fluid">
				<div class="span12">
					<legend>Items agregados a la venta:</legend>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span1">&nbsp;</div>
				<div class="span10">
					<table class="table table-bordered table-striped table-hover table-condensed" id="SalesItem">
						<thead style="background:black" align="center">
							<tr style="color:white">
								<th>#</th>
								<th>Producto</th>
								<th>P.Unitario($)</th>
								<th>Cantidad</th>
								<th>Total($)</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody></tbody>
						<tfoot>
							<tr class="info">
								<td align="left"><strong>Total:</strong></td>
								<td colspan="5" class="sumTotal" align="right">$ 0</td>
							</tr>
							</tfoot>
					</table>
				</div>
				<div class="span1">&nbsp;</div>
			</div>
		</div>
	</div>
</div>
&nbsp;
<div class="row-fluid" >
	<div class="container">
		<div class="span4">	
			<div class="row-fluid">
				<div class="span4">
					<a href="<%=request.getContextPath()%>/home/index.jsp" class="btn btn-danger">Cancelar</a>
				</div>
				<div class="span4">
					<button class="btn btn-primary" type="submit">Guardar</button>
				</div>
			</div>
		</div>
	</div>
</div>				
</form>		
&nbsp;
&nbsp;
<div class="row-fluid">
	<div class="container">
		<a href="<%=request.getContextPath()%>/home/index.jsp" class="btn btn-primary" style="margin-top: 10px;">VOLVER</a>
	</div>
</div>
</body>
</html>