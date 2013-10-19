function setRoles() {
	getRoles(function(data) {
		if (data != null) {
			var ddlRoles = $("#role");
			$.each(data, function(val, text) {
//				ddlRoles.add(new Option(text, text));
				ddlRoles.append("<option value='" + text + "'>" + text + "</option>");
			});
		}
	});
};

function getRoles(onSuccess) {
	$.getJSON(serverUrl + "/roles", "", onSuccess);
};
