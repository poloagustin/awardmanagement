$(function() {
	initUtils();
});

function deleteUser(userId) {
	if (confirm("Desea eliminar este usuario?")) {
		$.ajax(serverUrl + "/user/delete", {
			async : false,
			data : userId,
			type : "POST",
		});
	}
};