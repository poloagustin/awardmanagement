$(document).ready(function() {
	getProduct($("#prod").val());
	$("#btnAgregarItem").click(function() {
		if ($("#SalesItem tbody tr").length == 0) {
			createTable();			
		} else {
			addTable();
		}
	});
	
	$("#prod").change(function(){
		getProduct($("#prod").val());	
	});
	
});

$(document).on('click','.EliminarItem',function(){
      $(this).parent().parent().remove();
      $(".product").each(function(index) {
    		var newProd= 'prod'+ index;
    	    $(this).attr({
				id:newProd,
				name:newProd});
	});
	$(".cantidad").each(function(index) {
    		var newCant= 'cant'+ index;
    	    $(this).attr({
				id:newCant,
				name:newCant});
	});
		$(".nItems").each(function(index) {
    	    $(this).text(index+1);
	});


 });

/*function OrderTable(){
	
}

$(document).ready(function() {
	getProduct($("#prod").val());
	$("#prod").change(function(){
		getProduct($("#prod").val());	
	});
});
*/

function getProduct(id){	
	var serverUrl = $("#serverUrl").val();
	$.getJSON(serverUrl+ "/product",
	{	idProd:id
		
	}, function(data,status){
		product = data;
	});
}

function addTable() {
	var tableBody = $("#SalesItem tbody");
	var lastProdName = $('#SalesItem  tbody tr:last').find("input[class='product']").attr("name");
	var lastCantName = $('#SalesItem  tbody tr:last').find("input[class='cantidad']").attr("name");
	var lastItemName = $("#SalesItem tbody tr:last td").attr("id");
	var productoSelected = $("#prod").val();
	var cantSelected = $("#cant").val();
	var sumProd = parseInt(lastProdName.substr(4, 5)) + 1;
	var sumCant = parseInt(lastCantName.substr(4, 5)) + 1;
	var sumItem = parseInt(lastItemName.substr(5, 6)) + 1;
	var ammountSelected = product.ammount;
	var subTotal = ammountSelected * cantSelected;
	var row = '<tr>' + '<td class="nItems" id="' + (lastItemName.substr(0, 5) + sumItem)
			+ '">' + sumItem + '</td><td><input class="product" type="hidden" value="'
			+ productoSelected + '" id="'
			+ (lastProdName.substr(0, 4) + sumProd) + '" name="'
			+ (lastProdName.substr(0, 4) + sumProd) + '">' + product.name
			+ '</td>' + '<td>$ '+ammountSelected+'</td><td><input class="cantidad" type="hidden" value="'
			+ cantSelected + '" id="' + (lastCantName.substr(0, 4) + sumCant)
			+ '" name="' + (lastCantName.substr(0, 4) + sumCant) + '">'
			+ cantSelected
			+ '</td><td>$ '+subTotal+'</td><td><input type="button" value="Eliminar Item"'
			+ 'class="EliminarItem"></td></tr>';

	tableBody.append(row);
	
}

function createTable() {
	var tableBody = $("#SalesItem tbody");
	var lastProdName = "prod0";
	var lastCantName = "cant0";
	var lastItemName = "nItem1";
	var productoSelected = $("#prod").val();
	var cantSelected = $("#cant").val();
	var ammountSelected = product.ammount;
	var subTotal = ammountSelected * cantSelected;
	var row = '<tr>' + '<td class="nItems" id="'
			+ lastItemName
			+ '">'
			+ 1
			+ '</td><td><input class="product" type="hidden" value="'
			+ productoSelected
			+ '" id="'
			+ lastProdName
			+ '" name="'
			+ lastProdName
			+ '">'
			+ product.name
			+ '</td>'
			+ '<td>$ '+ammountSelected+'</td><td><input class="cantidad" type="hidden" value="'
			+ cantSelected
			+ '" id="'
			+ lastCantName
			+ '" name="'
			+ lastCantName
			+ '">'
			+ cantSelected
			+ '</td><td>$ '+subTotal+'</td><td align="right">'
			+ '<input type="button" value="Eliminar Item" class="EliminarItem" id="EliminarItem0"></td></tr>';

	tableBody.append(row);
	$("#SalesItem").show();
}

