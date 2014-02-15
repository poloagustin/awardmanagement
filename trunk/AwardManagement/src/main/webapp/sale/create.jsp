<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Nueva Venta</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-responsive.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/font-awesome/css/font-awesome.min.css">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery-2.0.3.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery.mask.min.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/initSales.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/addProduct.js"></script>
		<script type="application/javascript" src="<%=request.getContextPath()%>/ScriptsSale/validateCreateSale.js"></script>
	</head>
<body>
	<input type="hidden" id="serverUrl"
		value="<%=request.getContextPath()%>" />
	<form id="newSale" action="<%=request.getContextPath()%>/sale/create"
		method="post">
		<div class="row-fluid">
						<div class="span12">

							<div class="navbar navbar-fixed-top navbar-inverse">

								<div class="navbar-inner">
									<div class="container">
									<a href="<%=request.getContextPath()%>/sale/create" class="brand">Agregar Venta</a>
									<ul class="nav pull-right">
										<a style="color:white" href="#">UserName(Saler) |</a>
										<a href="#">Cerrar Session</a>
									</ul>
								</div>
							</div>
						</div>
					</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							&nbsp;	
						</div>
					</div>					
					<div class="well container">
					<div class="row-fluid">
						<div class="span4">
						 <div class="row-fluid">
						 	<div class="span4">Numero de Venta: </div>						 	
						 	<div class="span4"><input class="number" id="txtNumberSale" type="text" name="txtNumberSale" size="20">
						 	</div>
						 </div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span4">
						 <div class="row-fluid">
						 	<div class="span4">Id Vendedor: </div>
						 	<div class="span4">"${user.username}"</div>
						 </div>
						 </div>
						 </div>
						 <div class="row-fluid">
						 <div class="span4">
						 <div class="row-fluid">
						 	<div class="span4">Fecha de Venta: </div>
						 	<div class="span4">${dateBean}</div>
						 </div>
						 </div>
						 </div>
						</div>
					<div class="row-fluid">
						<div class="span12">
						&nbsp;	
						</div>
					</div>
					<div class="container">
					<div class="row-fluid">
					<div class="span4">
						<a id="btnAgregarItem" class="btn btn-primary">Agregar Items</a>
					</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							&nbsp;	
						</div>
					</div>					
					<div class="row-fluid" hidden="true" id="itemsProd">
						<div class="row-fluid">
						<div style="{background:gray}" class="span8">Selecione Items:
						</div>
					</div>
					<div class="row-fluid">
						<div class="span8">
					<table class="table table-bordered table-striped table-hover table-condensed" id="Products">
						<thead>
							<tr>
								<th>ID</th>
								<th>Nombre de Producto</th>
								<th>P.Unitario</th>
								<th>Accion</th>
							</tr>

						</thead>
						<tbody>
						</tbody>
					</table>
					</div>
					</div>
				</div>
					<div class="row-fluid" id="example">
						<div class="span8">
							<div id="myModal" class="modal hide fade">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>Ingrese una cantidad del producto:</h4><h3 id="txtProd"></h3>
								<input id="idProd" type="hidden">
								<input id="nameProd" type="hidden">
								<input id="ammountProd" type="hidden">
								</div>
								<div class="modal-body">
									Cantidad:<input class="number" type="number" id="txtCant"  data-mask="0" name="txtCant">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
									<button id="btnCantSend" type="button" data-dismiss="modal" class="btn btn-success">Enviar</button>
								</div>
							</div>
							<div id="myModalValidate" class="modal hide">
	 			<div class="modal-header"><button type="button" class="close" data-dismiss="modal">&times;</button>
	 			<h2>Alert:</h2></div><div class="modal-body"><h4 id="txtValideProd"></h4>
	 			</div><div class="modal-footer"><button type="button" data-dismiss="modal" class="btn">Ok</button>
	 			</div>
	 				</div>
	 				<div id="myModalEdit" class="modal hide fade">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>Ingrese una cantidad del producto:</h4>
								</div>
								<input id="idProdEdit" type="hidden">
								<div class="modal-body">
									Cantidad:<input class="number" type="number" id="txtCantEdit" name="txtCantEdit">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
									<button id="btnCantEdit" type="button" data-dismiss="modal" class="btn btn-success">Enviar</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
						&nbsp;		
						</div>
					</div>
					<div class="row-fluid" id="listSaleItems">
					<div class="span12">Sale Items Agregados</div>
					<div class="span12">
					<table class="table table-bordered table-striped table-hover table-condensed" id="SalesItem">
						<thead>
							<tr>
								<th>#</th>
								<th>Producto</th>
								<th>P.Unitario</th>
								<th>Cantidad</th>
								<th>Total</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					</div>
					</div>					
				&nbsp;
				<div class="row-fluid" >
					<div class="span4">	
						<div class="span4"><input class="btn btn-success" type="submit" name="btnGuardar" id="btnGuardar"
								value="Guardar"></div>
						<div class="span4"><input class="btn btn-danger" type="submit" name="btnCancelar" value="Cancelar"></div>
					</div>
				</div>
				</div>				
				</form>		
				&nbsp;
				&nbsp;
				<a class="btn btn-link" href="<%=request.getContextPath()%>/sale/index">&gt;== VOLVER</a>

</body>
</html>