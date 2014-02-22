$(function() {
	initUtils();
	getUsers();
});

function deleteUser(userId) {
	if (confirm("Desea eliminar este usuario?")) {
		$.ajax(serverUrl + "/user/delete", {
			async : false,
			data : {
				id : userId
			},
			type : "POST",
			success : function() {
				alert("El usuario se ha eliminado!");
				getUsers();
			}
		});
	}
};

function getUsers() {
	$.get(serverUrl + "/user/getusers", null, function(data) {
		var table = $("tbody");
		table.html("");
		$.each(data, function(val, text) {
			var html = "<tr><td>";
			html = html + text.username;
			html = html +"</td><td>"; 
			html = html + text.firstName;
			html = html +"</td><td>"; 
			html = html + text.lastName;
			html = html +"</td><td>"; 
			html = html + text.dni;
			html = html +"</td><td align='center'><a href='";
			html = html + serverUrl;
			html = html +"/user/edit?id=";
			html = html +text.id;
			html = html +"' class='btn btn-primary'>Editar</a></td><td align='center'><a href='#' onclick='deleteUser(";
			html = html + text.id;
			html = html+ ")' class='btn btn-danger'>Eliminar</a></td></tr>";
			table.html(table.html() + html);
		});
	}, "json");
};