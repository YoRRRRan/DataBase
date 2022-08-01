<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- import de la librairie JSTL, beaucoup plus facile à utiliser que les tags JSP purs --%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Ma page d'accueil qd on est co</h1>
		<!--  On va pouvoir faire des opérations dynamique dans du html -->
		<!-- à ne pas faire, injection directe de code JAVA -->
		<% 
		String s ="<p align='center'>Don't do that</p>"; out.print(s); %>
		<c:out value="Bienvenue, ${param.username } !"></c:out>
</body>
</html>