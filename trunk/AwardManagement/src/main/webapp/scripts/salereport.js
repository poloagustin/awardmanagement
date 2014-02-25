$(function() {
	initUtils();
	setYears();
	setUsers();
	// getReport();
});

function setYears() {
	var years = $("#year");
	var thisYear = new Date().getFullYear();
	var options = "";
	for (var i = thisYear - 1; i < thisYear + 1; i++) {
		options = options + "<option value='" + i + "'>" + i + "</option>";
	}
	years.html(years.html() + options);
};

function getReport() {
	var month = $("#month").find(":selected").val();
	var year = $("#year").find(":selected").val();
	var users = "";
	$("#users").find(":selected").each(function(i, selected) {
		users = users + (users == "" ? "" : ",") + $(selected).val();
	});
	$.post(serverUrl + "/commission/report", {
		"month" : month,
		"year" : year,
		"users" : users
	}, function(data) {
		var table = $("tbody");
		table.html("");
		$.each(data, function(val, text) {
			var html = "<tr><td>";
			html = html + text.salesman;
			html = html + "</td><td>";
			html = html + text.award;
			html = html + "</td></tr>";
			table.html(table.html() + html);
		});
	}, "json");
};

function setUsers() {
	$.post(serverUrl + "/user/getsalesmenmultiselect", null, function(data) {
		var users = $("#users");
		users.html("");
		var options = "";
		$.each(data, function(val, text) {
			options = options + "<option value='" + text.key + "'>"
					+ text.value + "</option>";
		});
		users.html(users.html() + options);
	}, "json");
};