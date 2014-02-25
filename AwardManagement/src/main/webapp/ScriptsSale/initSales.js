	var serverUrl = null;

	$(document).ready(function() {
		initUtils();
		setProductListTable();
		setMasks();
	});

	function initUtils() {
		serverUrl = $("#serverUrl").val();
	};

	function setProductListTable(){		
		tbody=$("#Products tbody");
		$.get(serverUrl+"/getIndexproduct",null,function(data){
			$.each(data,function(val,text){
			var row = '<tr>' +
			'<td class="idProd" align="center">'+text.id+'</td>'+
			'<td class="nameProd" align="center">'+text.name +'</td>'+
			'<td class="ammountProd" align="center">'+text.ammount+'</td>'+
			'<td align="center"><a id="AgregarCant" data-toggle="modal" class="btn btn-primary">Agregar</a></td>'+
			'</tr>';
			tbody.append(row);	
		});
	},"json");
	}

function setMasks(){
	$(".number").mask("9999").val("1");
	$("#txtNumberSale").mask("AAAAAAAAAA");
}