<jsp:include page="inc/header.jsp" />

	<h1>A free RDF converter</h1>
	<p>Semola RDF is a free RDF/XML to N3 or Turtle conveter. Simply enter your data in the next field.</p>
	<p>This service is available for distant access. See <a href="about.jsp">about</a> page.</p>
	    <form action="/converter" method="post">
	      <div>Input (<a href="#" onclick="exampleConvert();">example</a>):<textarea rows="10" style="width:100%" id="input"></textarea></div>
	      <div>Ouput:<textarea rows="10" style="width:100%" id="output"></textarea></div>
	      <div>Convert from <select id="inputType"><option>RDF/XML</option><option>N-TRIPLE</option><option>N3</option><option>TURTLE</option><option>XHTML</option></select> to <select id="ouputType"><option>RDF/XML</option><option>N-TRIPLE</option><option selected="selected">N3</option><option>TURTLE</option></select></div>
	      <div><input type="button" value="Convert !" onclick="doConvert();"/></div>
	    </form>
    
<jsp:include page="inc/footer.jsp" />
