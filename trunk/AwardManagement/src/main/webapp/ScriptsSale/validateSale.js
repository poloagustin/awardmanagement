$(document).ready(function() {
	$("form" ).submit(function(event) {
		if ($("#SalesItem tbody tr").length == 0) {
			$("#validation").text("Se debe ingresar al menos un producto de venta");
			event.preventDefault();
		}
		
		if ($("#cant").val()<0){
			$("#validation").text("Se la cantidad de productos no puede ser 0 o menor 0");
			event.preventDefault();
		}
	});
});