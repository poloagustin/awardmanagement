$(document).ready(function() {
	$("#btnAgregarItem").click(function() {
		if ($("#SalesItem tbody tr").length == 0) {
			createTable();			
		} else {
			addTable();
		}
	});
});

$(document).on('click','.EliminarItem',function(){
	deleteRow();	
});

function deleteRow() {
	 var current = window.event.srcElement;
	    //here we will delete the line
	    while ( (current = current.parentElement)  && current.tagName !="TR");
	         current.parentElement.removeChild(current);
	         if ($("#SalesItem tbody tr").length == 0) {
	        	 $("#SalesItem").hide();
	         } else{
	        	 
	        	 OrderTable();
	         }
	          
}

function OrderTable(){
	$("#SalesItem tbody tr").each(function(index) {
		$(this).children("td").each(function (index2) {
			
			alert($(this));
		});
	});

}

$(document).ready(function() {
	getProduct($("#prod").val());
});

function getProduct(id){	var serverUrl = $("#serverUrl").val();
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
	getProduct(productoSelected);
	
	var ammountSelected = product.ammount;
	var subTotal = ammountSelected * cantSelected;
	var row = '<tr>' + '<td id="' + (lastItemName.substr(0, 5) + sumItem)
			+ '">' + sumItem + '</td><td><input class="product" type="hidden" value="'
			+ productoSelected + '" id="'
			+ (lastProdName.substr(0, 4) + sumProd) + '" name="'
			+ (lastProdName.substr(0, 4) + sumProd) + '">' + productoSelected
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
	getProduct(productoSelected);
	var ammountSelected = product.ammount;
	var subTotal = ammountSelected * cantSelected;
	var row = '<tr>' + '<td id="'
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
			+ productoSelected
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

