<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
  </head>
  <body>
	<h4>Bokliste</h4>
	<a href="sokeside.html">Gjør et boksøk</a><br>
	<a href="alleboker">Se listen av alle bøker</a><br>
	<table><tr>
			<th align="left">Tittel</th>
			<th align="left">Forfatter</th>
			<th>År</th>
			<th align="left">Genre</th>
		</tr>
		<c:forEach var="bok" items="${boker}">
		<tr>
			<td align="left">${bok.tittel}</td> <!-- bok.getTittel() -->
			<td align="left">${bok.forfatter}</td>
			<td>${bok.utgivelsesaar}</td>
			<td align="left">${bok.genre}</td>
		</tr>
		</c:forEach>
	</table>
	
  </body>
</html>
