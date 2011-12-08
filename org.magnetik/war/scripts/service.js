function doConvert() {
    $('#output').val("Querying...");
		$.ajax({
			type: "POST",
			url: "/service",
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