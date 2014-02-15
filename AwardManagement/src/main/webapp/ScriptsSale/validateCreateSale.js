$(document).ready(function() {
	$("form").submit(function(event) {
		var flag = new Boolean();
		// remove all errors before
		$(".error-validate").remove();
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
	if ($("#SalesItem tbody tr").length == 0) {
		$("#SalesItem")
				.after(
						'<div class="error-validate">Se debe ingresar al menos un producto para la venta.</div>');
		return false;
	}
	return true;
}

// validate that saleNumber is not empty and format
function CheckNumberFormat() {
	var number = $("#txtNumberSale").val();

	if (number.length == 0) {
		$("#txtNumberSale")
				.after(
						'<div class="alert alert-warning">Se debe ingresar un numero de venta.</div>');
		return false;
	} else {
		// allow caracters inside to []
		var characterReg = /^\s*[0-9a-zA-Z-]+\s*$/;
		if (!characterReg.test(number)) {
			$("#txtNumberSale").after(
					'<div class="alert alert-warning">Caracteres Invalidos.</div>');
			return false;
		}
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
			$("#SalesItem").after(
			'<div class="alert alert-warning">Ya existe una venta registrada con el numero de venta ingresado.\n'
			+ '<ul><li><b>Nombre del  Vendedor: </b>'
			+ data[0] +' '
			+ data[1]
			+ '</li><li><b>Fecha de venta registrada: </b>'
			+ data[2]
			+ '</li></ul></div>');
			}, "json");
		}
	return flag;
}