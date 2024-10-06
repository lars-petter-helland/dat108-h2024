<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Linjen over må alltid være med som første linje i filen --%>
<html>
<body>
	<%-- ${navn} i linjen under er et uttrykk som henter attributten 
	     "person" fra modellen (den vi la til med model.setAttribute()) --%>
	<h1>Hallo på do, ${navn}</h1>
</body>
</html>
