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
function exampleConvert() {
    $('#input').val('<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"\n\
  xmlns:foaf="http://xmlns.com/foaf/0.1/"\n\
  xmlns:rss="http://purl.org/rss/1.0/"\n\
  xmlns:dc="http://purl.org/dc/elements/1.1/">\n\
        <foaf:Person rdf:about="http://example.net/Paul_Dupont">\n\
                <foaf:name>Paul Dupont</foaf:name>\n\
                <foaf:img rdf:resource="http://example.net/Paul_Dupont.jpg"/>\n\
                <foaf:knows rdf:resource="http://example.net/Pierre_Dumoulin"/>\n\
        </foaf:Person>\n\
        <foaf:Person rdf:about="http://example.net/Pierre_Dumoulin">\n\
                <foaf:name>Pierre Dumoulin</foaf:name>\n\
                <foaf:img rdf:resource="http://example.net/Pierre_Dumoulin.jpg"/>\n\
        </foaf:Person>\n\
        <foaf:Image rdf:about="http://example.net/Paul_Dupont.jpg">\n\
                <dc:description>Photo d\'identit� de Paul Dupont</dc:description>\n\
        </foaf:Image>\n\
        <foaf:Image rdf:about="http://example.net/Pierre_Dumoulin.jpg">\n\
                <dc:description>Photo d\'identit� de Pierre Dumoulin</dc:description>\n\
        </foaf:Image>\n\
</rdf:RDF>');
}
