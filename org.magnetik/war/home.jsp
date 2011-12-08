<jsp:include page="inc/header.jsp" />

	    <form action="/service" method="post">
	      <div><textarea rows="10" cols="130" id="input"></textarea></div>
	      <div><textarea rows="10" cols="130" id="output"></textarea></div>
	      <div>Convert from <select id="inputType"><option>RDF/XML</option><option>N-TRIPLE</option><option>N3</option><option>TURTLE</option></select> to <select id="ouputType"><option>RDF/XML</option><option>N-TRIPLE</option><option>N3</option><option>TURTLE</option></select></div>
	      <div><input type="button" value="Convert !" onclick="doConvert();"/></div>
	    </form>
    
<jsp:include page="inc/footer.jsp" />
