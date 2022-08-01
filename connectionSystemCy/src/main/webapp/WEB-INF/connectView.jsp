<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="design.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- si la condition test du if est validée on processe le code dans le if --%>
	<c:if test="${error_connect != null}">
		<p><c:out value="${error_connect}"></c:out></p>
	</c:if>
	<h1>ma page formulaire de connexion</h1>
	<!-- le formulaire transmet habituellement ses informations par la méthode HTTP POST -->
	<form action="connect" method="post">
		<div>
		<!-- le nom d'utilisateur -->
			<label for="username">User</label>
			<!-- ne jamais oublier l'attribut name sur un champ dont on veut récupérer le contenu -->
			<input id="username" type="text" name="username"/>
		</div>
		<div>
		<!-- le mot de passe -->
			<label for="password">Password</label>
			<input id="password" type="password" name="password"/>
		</div>
		<!-- le champ submit permet de valider le formulaire -->
		<input type="submit" value="Se Connecter"/>
	</form>

</body>
</html>