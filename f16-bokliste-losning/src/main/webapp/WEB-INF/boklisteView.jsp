<%-- Denne må alltid være med for å si at resultatet er av typen ... --%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%-- Denne tar bort whitespace i toppen av generert HTML --%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- Denne må være med for å kunne bruke <c:forEach>-taggen --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
  </head>
  <body>
	<h4>Bokliste</h4>
	<a href="sokeside.html">Gjør et nytt søk</a><br>
	<a href="alleboker">Se listen av alle bøker</a><br>
	<table><tr>
			<th align="left">Tittel</th>
			<th align="left">Forfatter</th>
			<th>År</th>
		</tr>
		<c:forEach var="b" items="${bokliste}"><tr>
			<td align="left">${b.tittel}</td>
			<td align="left">${b.forfatter}</td>
			<td>${b.utgivelsesaar}</td>
		</tr></c:forEach>
	</table>
	
  </body>
</html>
