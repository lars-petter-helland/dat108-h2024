<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Kjøpe krypto</title>
</head>
<body>

<h2>Her kan du kjøpe krypto</h2>

<form action="kjopekrypto" method="post">
  <fieldset><legend>Kjøpsdetaljer</legend>
  
    <p>Antall <input type="text" name="antall" /></p>
    
    <p>Krypto<select name="krypto">
    	<c:forEach var="kkode" items="${kryptokoder}">
        	<option value="${kkode}" ${kkode == 'BTC' ? 'selected' : ''}>${kkode}</option>
    	</c:forEach>
    </select></p>
    
    <p>Fiat<select name="fiat">
    	<c:forEach var="fkode" items="${fiatkoder}">
        	<option value="${fkode}" ${fkode == 'NOK' ? 'selected' : ''}>${fkode}</option>
     	</c:forEach>
    </select></p>
    
    <p><input type="submit" value="Kjøp" /></p>
  </fieldset>
</form>

</body>
</html>