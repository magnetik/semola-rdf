function doConvert() {
  $('#output').val("Querying...");
	$.ajax({
		type: "POST",
		url: "/converter",
		dataType: "text",
		data: "inputType=" + $('#inputType').val() + "&outputType=" + $('#ouputType').val() + "&input=" + $('#input').val(),
		statusCode: {
			200: function(responseText) {
				
				$('#output').prop('disabled', false);
				$('#output').val(responseText);
			},
			500: function(responseText) {
				$('#output').prop('disabled', true);
				$('#output').val("Error");
			}
		}
	});
	return false;
}	
function doQuery() {
  $('#output').val("Querying...");
	$.ajax({
		type: "POST",
		url: "/sparql",
		dataType: "text",
		data: "inputType=" + $('#inputType').val() + "&outputType=" + $('#ouputType').val() + "&input=" + $('#input').val() + "&query=" + $('#query').val(),
		statusCode: {
			200: function(responseText) {
				
				$('#output').prop('disabled', false);
				$('#output').val(responseText);
			},
			500: function(responseText) {
				$('#output').prop('disabled', true);
				$('#output').val("Error");
			}
		}
	});
	return false;
}	