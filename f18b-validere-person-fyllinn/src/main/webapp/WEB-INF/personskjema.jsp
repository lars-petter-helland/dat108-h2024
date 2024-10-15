<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="simple.css">
<title>Personskjema</title>
</head>

<body>
	<h3>Hei. Tast inn informasjon om personen</h3>
	
	<form action="sjekkPerson" method="get" id="person">
		Navn <input type="text" name="navn"><br>
		Mobil <input type="text" name="mobil"><br>
		Høyde i cm <input type="number" name="hoydecm"><br>
		Fødselsdato	<input type="date" name="fdato"><br>
		<input type="submit" value="Send!"/>
	</form>
	
</body>
</html>