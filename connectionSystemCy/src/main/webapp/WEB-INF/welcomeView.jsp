<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- import de la librairie JSTL, beaucoup plus facile à utiliser que les tags JSP purs --%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="design.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>Ma page d'accueil quand on est connecté</h1>
	<!-- on va pouvoir faire des opérations dynamiques dans une page JSP -->
	<!--injection directe de code Java : on va éviter en vrai  -->
	<% //commentaire Java autorisé dedans
	String s = "<p>à ne pas faire en vrai pour raison de clarté du code</p>"; out.print(s); %>
	<%-- un commentaire JSP qui ne sera pas lu dans HTML --%>
	<p><c:out value="Bienvenue, ${param.username } !"></c:out></p>
	
</body>
</html>