<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<c:if test="${error_connect != null}">
	<p><c:out value="${error_connect}"></c:out></p></c:if>
<h1>Ma page formulaire de connexion</h1>
<!-- le formulaire transmet ses informations par la méthode post -->
<form action="connect" method="post">
	<div>
		<label for="user">User : </label>
			<input id="user" type="text" name="user"/>
	</div>
	<div>
		<label for="mdp">Password : </label>
			<input id="mdp" type="text" name="mdp"/>
	</div>
	<input type="submit" value="Se Connecter"/>
			
	
</form>
</body>
</html>