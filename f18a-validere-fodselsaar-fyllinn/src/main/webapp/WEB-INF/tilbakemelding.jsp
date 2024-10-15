<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="simple.css">
<title>Tilbakemelding</title>
</head>

<body>
	Tilbakemelding!
	
	<br> Parameteren fodselsaar = |${param.fodselsaar}|
	
	<br> Fødselsåret er ${gyldig ? "gyldig" : "ikke gyldig"}
</body>
</html>