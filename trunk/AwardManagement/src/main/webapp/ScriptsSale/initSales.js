	var serverUrl = null;

	$(document).ready(function() {
		initUtils();
		setProductListTable();
		setMask();
	});

	function initUtils() {
		serverUrl = $("#serverUrl").val();
	};

	function setProductListTable(){		
		tbody=$("#Products tbody");
		$.get(serverUrl+"/getIndexproduct",null,function(data){
			$.each(data,function(val,text){
			var row = '<tr>' +
			'<td class="idProd">'+text.id+'</td>'+
			'<td class="nameProd">'+text.name +'</td>'+
			'<td class="ammountProd">'+text.ammount+'</td>'+
			'<td><a id="AgregarCant" data-toggle="modal" class="btn btn-primary">Agregar</a></td>'+
			'</tr';
			tbody.append(row);	
			});

		},"json");
	}

function setMask(){
	$(".number").mask("0#");
}

