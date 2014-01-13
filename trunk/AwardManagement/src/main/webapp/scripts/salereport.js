$(function() {
	initUtils();
	getReport();
});

function getReport() {
	$.get(serverUrl + "/commission/report", null, function(data) {
		var table = $("tbody");
		table.html("");
		$.each(data, function(val, text) {
			var html = "<tr><td>";
			html = html + text.salesman;
			html = html +"</td><td>"; 
			html = html + text.amount;
			html = html +"</td></tr>";
			table.html(table.html() + html);
		});
	}, "json");
};