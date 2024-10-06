<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
</head>
<body><%-- ${personliste} i linjen under er et uttrykk som henter attributten 
	     "personliste" fra modellen (den vi la til med model.setAttribute()) --%>
	<h4>Personliste - Generert av Java/JSP på webserveren</h4>
	<table id="persontabellen">
		<tr>
			<th align="left">Fornavn</th>
			<th align="left">Etternavn</th>
			<th>Alder</th>
		</tr>
		<c:forEach var="p" items="${personliste}"><tr>
			<td align="left">${p.firstName}</td>
			<td align="left">${p.lastName}</td>
			<td>${p.alder}</td></tr>
		</c:forEach>
	</table>
</body>
</html>
