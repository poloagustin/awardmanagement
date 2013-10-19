$(function() {
	initUtils();
	getRoles(setCurrentRole);
});

function setCurrentRole(data) {
	if (data != null) {
		var ddlRoles = $("#role");
		$.each(data, function(val, text) {
			// ddlRoles.add(new Option(text, text));
			ddlRoles.append("<option value='" + text + "'>" + text
					+ "</option>");
		});
		var currentRole = $("#currentRole").val();
		setDropdownlistSelectedValue("role", currentRole);
	}
};
