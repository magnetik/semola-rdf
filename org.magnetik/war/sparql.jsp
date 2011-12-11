<jsp:include page="inc/header.jsp" />
	<h1>A free SparQL endpoint</h1>
	<p>Enter the input RDF file to process, then the query to execute.</p>
	<p>This service is available for distant access. See <a href="about.jsp">about</a> page.</p>
	    <form action="/service" method="post">
	      <div>Input :<textarea rows="10" style="width:100%" id="input"></textarea></div>
	      <div>Query :<textarea rows="10" style="width:100%" id="query"></textarea></div>
	      <div>Result :<textarea rows="10" style="width:100%" id="output"></textarea></div>
	      <div>Input type : <select id="inputType"><option>RDF/XML</option><option>N-TRIPLE</option><option>N3</option><option>TURTLE</option></select> <br />
	       Ouput type : <select id="ouputType"><option>Text</option></select</div>
	      <div><input type="button" value="Execute query !" onclick="doQuery();"/></div>
	    </form>
    
<jsp:include page="inc/footer.jsp" />
