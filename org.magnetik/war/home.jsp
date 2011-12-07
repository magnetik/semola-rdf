<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  </head>

  <body>
  	<script>
  	function doConvert() {
		$.ajax({
			type: "POST",
			url: "/service",
			data: "inputType=test&outputType=test&input=" + $('#input').val(),
			statusCode: {
				200: function(responseText) {
					$('#output').append(responseText);
				},
				500: function(responseText) {
				}
			}
		});
		return false;
	}	
  	</script>
    <form action="/service" method="post">
      <div><textarea rows="3" cols="60" id="input"></textarea></div>
      <div><textarea rows="3" cols="60" id="output"></textarea></div>
      <div><input type="button" value="Convert !" onclick="doConvert();"/></div>
    </form>

  </body>
</html>
