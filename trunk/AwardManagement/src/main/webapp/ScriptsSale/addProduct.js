$(document).on('click','#btnAgregarItem',function(){				
	$("#btnAgregarItem").html('<span class="glyphicon glyphicon-minus-sign"></span> Cerrar Items');
	$("#btnAgregarItem").attr("id","btnCerrarItem");
	$("#itemsProd").slideToggle('600');	
});
	//close items-product 
	$(document).on('click','#btnCerrarItem',function(){				
		$("#btnCerrarItem").html('<span class="glyphicon glyphicon-plus-sign"></span> Agregar Item');
		$("#btnCerrarItem").attr({"id":"btnAgregarItem"});
		$("#itemsProd").slideToggle('600');	
	});
	//add amount of product adding to sale
	$(document).on('click','#AgregarCant',function(){				
		// find attr product selected
		var id = $(this).closest("tr").find(".idProd").text();
		var name = $(this).closest("tr").find(".nameProd").text();
		var ammount = $(this).closest("tr").find(".ammountProd").text();

		if(validateProductExist(id)==false){
			//set parameters
			$("#idProd").val(id);
			$("#nameProd").val(name);
			$("#ammountProd").val(ammount);
			$("#txtProd").text(name);
			$("#myModal").modal("show");
		}
		else {	 
	 	//create and show error validate
	 	$("#txtValidProd").text('El producto "'+name+'" ya se encuentra agregado.');
	 	$("#myModalValidate").modal("show");
	 }
	});
	//Send  amount of product adding to sale
	$(document).on('click','#btnCantSend',function(){				
		//getParameters
		var cant=$("#txtCant").val();
		var idProd=$("#idProd").val();
		var nameProd=$("#nameProd").val();
		var ammountProd=$("#ammountProd").val();
		//add new item to sale
		addTable(cant,idProd,nameProd,ammountProd);
		$("#txtCant").val(1);
	});
	//Edit amount of item adding to sale
	$(document).on('click','.EditarItem',function(){				
		var cant = $(this).closest("tr").find(".cantset").val();
		var prod = $(this).closest("tr").find(".productset").val();
		var nameProd = $(this).closest("tr").find(".Name").text();			
		$("#txtCantEdit").val(cant);
		$("#idProdEdit").val(prod);
		$("#txtProdEdit").text(nameProd);
		$("#myModalEdit").modal("show");	
	});
	//Send amount of Item adding to sale
	$(document).on('click','#btnCantEdit',function(){
		var prod = $("#idProdEdit").val();
		var cant = $("#txtCantEdit").val();
		$(".productset").each(function() {
			if($(this).val()==prod){
				$(this).closest("tr").find(".cantset").val(cant);
				$(this).closest("tr").find(".Cant").text(cant);
				var subTotal = parseInt($(this).closest("tr").find(".subTotal").text());
				var newSubtotal = cant*subTotal;
				$(this).closest("tr").find(".subTotal").text(newSubtotal);
			}
		});

		sortTableItems();
	});
	//Delete saleItem
	$(document).on('click','.EliminarItem',function(){				
		if (confirm("Desea Eliminar el Item de la Venta?")) {
			$(this).parent().parent().remove();	
			sortTableItems();
		}
	});

	function sumTotales(){
		var sumTotal = 0;
		$(".subTotal").each(function(index,val) {					
			var subTotal = parseInt($(this).text());			
			sumTotal = sumTotal + subTotal;	
		});
		$(".sumTotal").text("$" +" "+sumTotal);
	}

	function validateProductExist(id){
		var flag = new Boolean();
		$(".productset").each(function(index) {
			if($(this).val()==id){
				flag=true;
			}    		
		});
		return flag;
	}

	function sortTableItems(){	
		$(".productset").each(function(index) {
			var newProd= 'prod'+ index;
			$(this).attr({
				id:newProd,
				name:newProd});
		});
		$(".cantset").each(function(index) {
			var newCant= 'cant'+ index;
			$(this).attr({
				id:newCant,
				name:newCant});
		});
		$(".nItems").each(function(index) {
			$(this).text(index+1);
		});

		sumTotales();
	}

	function addTable(cant,idProd,nameProd,ammountProd) {
		var tableBody=$("#SalesItem tbody");
		var items=0;
		var subTotal=ammountProd * cant;		
		var row ='<tr>'
		+ '<td class="nItems" align="center">'+items+'</td>'
		+ '<td class="Name"align="center" ><input class="productset" type="hidden" value="'+ idProd+ '" id="prod" name="prod">'+nameProd+'</td>' 
		+ '<td align="center">'+ammountProd+'</td>'
		+ '<td class="Cant"align="center"><input class="cantset" type="hidden" value="'+ cant + '" id="cant" name="cant">'+cant+'</td>'
		+ '<td class="subTotal" align="center">'+subTotal+'</td>'
		+ '<td align="center"><a class="EditarItem btn btn-default btn-sm"><span class="glyphicon glyphicon-pencil"></span> Editar</a>'
		+ '<a class="btn btn-default btn-sm EliminarItem"><span class="glyphicon glyphicon-trash"></span> Eliminar</a></td>'
		+ '</tr>';	
		tableBody.append(row);		
		sortTableItems();				
	}