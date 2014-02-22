$(document).ready(function() {



$(".btnEditar").click(function(){
	$("#lblIdCommission").text(this.id);
	$("#inputIdCommission").val(this.id);
	$("#inputCommission").text("");
	
	$("#message").hide();
	$("#myRow").show();
	
});


$(".btnEditarProducto").click(function(){
	$("#lblIdProducto").text(this.id);
	$("#inputIdProducto").val(this.id);
	$("#inputCommissionProducto").text("");
	
	$("#message").hide();
	$("#myRow").show();
	
});


});
