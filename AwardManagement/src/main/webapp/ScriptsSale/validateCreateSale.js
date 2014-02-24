$(document).ready(function() {
	$("form").submit(function(event){
		var flag = new Boolean();
		// remove all errors before
		$(".alert").remove();
		/*
		 * Check out each validate before send data form
		 */
		if (!CheckNumberFormat()) {
			flag = true;
		} else {
			if (!CheckSaleItemsEmptys()) {
				flag = true;
			} else {
				if (!CheckOutNumber()) {
					flag = true;
				}
			}
		}
		// if flag = true -> stop sending data form
		if (flag == true) {
			event.preventDefault();
		}
	});
});

// Verify that saleItems not are empty
function CheckSaleItemsEmptys() {
	var flag=new Boolean();
	if ($("#SalesItem tbody tr").length == 0) {
		$("#SalesItem").before(
		'<div class="alert alert-block alert-danger">'+
		'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'+
		'<h4>Verificar!!:</h4> Se debe ingresar al menos un producto para la venta.');				
		return false;
	}
	return true;
}

// validate that saleNumber is not empty and format
function CheckNumberFormat() {
	var number = $("#txtNumberSale").val();
	if (number.length == 0) {
		$("p").html('<div class="alert alert-block alert-danger">'+
			'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'+
			'<h4>Verificar!!:</h4> Se debe ingresar un numero de venta.');			
		return false;
	}
	return true;
}

// Verify that SaleNumber is not exists
function CheckOutNumber() {
	serverUrl = $("#serverUrl").val();
	var number = $("#txtNumberSale").val();
	var flag = new Boolean();

	$.ajax({
		url : serverUrl + "/sale/CheckOutNumber",
		async : false,
		dataType : "json",
		data : "number=" + number,
		success : function(check) {
			flag = check;
		}
	});
	if (!flag) {
		$.get(serverUrl + "/sale/getSalerMan",{number:number},function(data) {					
			$("p").html(
			'<div class="alert alert-block alert-danger">'+
			'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'+
			'<h4>Numero de Venta Invalido:</h4> Ya existe una venta registrada con el numero de venta ingresado.\n'+
			'<ul><li><strong>Nombre del  Vendedor:</strong>'
			+ data[0] +' '
			+ data[1]
			+ '</li><li><strong>Fecha de venta registrada: </strong>'
			+ data[2]
			+ '</li></ul></div>');
			}, "json");
		}
	return flag;
}