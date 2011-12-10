<jsp:include page="inc/header.jsp" />

   <h1>Code</h1>
   <p>The website uses <a href="http://incubator.apache.org/jena/">Jena</a> to convert files</p>
   <p>The code can be found on <a href="https://github.com/magnetik/semola-rdf">github/magnetik/semola-rdf</a></p>
   
   <h1>Distant access</h1>
   <p>The service is available by distant HTTP POST queries<p>
   	<ul>
   		<li>Endpoint : <strong><a href="http://semola-rdf.appspot.com/service">http://semola-rdf.appspot.com/service</a></strong></li>
   		<li>Method: <strong>POST</strong></li>
   		<li>Data:
   			<ul>
   				<li><strong>input</strong>: text to convert</li>
   				<li><strong>inputType</strong>: one of "RDF/XML", "N-TRIPLE", "TURTLE" or "N3"</li>
   				<li><strong>outputType</strong>: one of "RDF/XML", "N-TRIPLE", "TURTLE" or "N3"</li>
   			</ul>
   		</li>
   	</ul>
       
<jsp:include page="inc/footer.jsp" />
