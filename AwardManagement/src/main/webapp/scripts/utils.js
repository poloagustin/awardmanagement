var serverUrl = null;

function initUtils() {
	serverUrl = $("#serverUrl").val();
};

function setDropdownlistSelectedValue (element, value) {
	$("#" + element).val(value);
};
