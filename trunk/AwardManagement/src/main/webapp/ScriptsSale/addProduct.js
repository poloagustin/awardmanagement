$(document).ready(function() {
});

	$(document).on('click','#btnAgregarItem',function(){
	$("#itemsProd").show();
	
	//change button
	$("#btnAgregarItem").text("Cerrar Items");
	$("#btnAgregarItem").attr({
		"id":"btnCerrarItem",
	});
});

$(document).on('click','#btnCerrarItem',function(){
	$("#itemsProd").hide();
	
	//change button
	$("#btnCerrarItem").text("Agregar Items");
	$("#btnCerrarItem").attr({
		"id":"btnAgregarItem",
	});
});

$(document).on('click','#AgregarCant',function(){
 
 $("myModal").modal({
 	backdrop:false,
 	keyboard:false,
 	show:false});
 
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
	 else{
	 	$("myModalValidate").modal({
 		backdrop:false,
	 	keyboard:false,
	 	show:false});

	 	//create and show error validate
	 	$("#txtValideProd").text('El producto "'+name+'" ya se encuentra agregado');
	 	$("#myModalValidate").modal("show");
	 }
 });

$(document).on('click','.EditarItem',function(){
	var cant = $(this).closest("tr").find(".cantset").val();
	var prod = $(this).closest("tr").find(".productset").val();
	var nameProd = $(this).closest("tr").find(".Name").text();	
	$("myModalEdit").modal({
 		backdrop:false,
	 	keyboard:false,
	 	show:false});

	$("#txtCantEdit").val(cant);
	$("#idProdEdit").val(prod);
	$("txtProdEdit").text(nameProd);
	$("#myModalEdit").modal("show");
});

$(document).on('click','#btnCantEdit',function(){
	var prod = $("#idProdEdit").val();
	var cant = $("#txtCantEdit").val();
	$(".productset").each(function() {
    		if($(this).val()==prod){
    			$(this).closest("tr").find(".cantset").val(cant);
    			$(this).closest("tr").find(".Cant").text(cant);
    		}
    		});
});

function validateProductExist(id){
	var flag = new Boolean();
	$(".productset").each(function(index) {
    		if($(this).val()==id){
    			flag=true;
    			
    		}    		
	});
	return flag;
}

$(document).on('click','#btnCantSend',function(){
 //getParameters
 var cant=$("#txtCant").val();
 var idProd=$("#idProd").val();
 var nameProd=$("#nameProd").val();
 var ammountProd=$("#ammountProd").val();
 
 addTable(cant,idProd,nameProd,ammountProd);
});


/*
 * Eliminar Sale Item
 */
$(document).on('click','.EliminarItem',function(){
      $(this).parent().parent().remove();
      sortTableItems();
    
 });

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
}

function addTable(cant,idProd,nameProd,ammountProd) {
	var tableBody = $("#SalesItem tbody");
	var items=0;
	var subTotal = ammountProd * cant;
	var row ='<tr>'
			+ '<td class="nItems">'+items+'</td>'
			+ '<td class="Name" ><input class="productset" type="hidden" value="'+ idProd+ '" id="prod" name="prod">'+nameProd+'</td>' 
			+ '<td>'+ammountProd +'</td>'
			+ '<td class="Cant"><input class="cantset" type="hidden" value="'+ cant + '" id="cant" name="cant">'+cant+'</td>'
			+ '<td>'+subTotal+'</td>'
			+ '<td><input type="button" class="EditarItem btn btn-warning" value="Editar Item">'
			+ '<input type="button" class="EliminarItem btn btn-danger" value="Eliminar Item"></td>'
			+ '</tr>';
	tableBody.append(row);
	sortTableItems();
}
