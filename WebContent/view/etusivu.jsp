<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body {background-color: DarkSlateGray;
	  color: white; }
a {font-family: verdana;}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Morse kääntäjä</title>
</head>
<body>

<script type="text/javascript">
function vainKirjaimia(input) {
    var regex = /[^A-ZÅÄÖa-zåäö ]/gi;
    input.value = input.value.replace(regex, "");
	}
	
function josTyhjaEiTallenna() {
	var a = document.forms["tallenna"]["tulos"].value;
	if(a==null || a=="") {
	alert("Lisää muunnettava teksti / Muunna teksti");
	} else {
	document.getElementById("tallenna").action = "lisaaMorseServlet";
	}	
} 
</script>
<div align="center">
	<h1 style="font-family: verdana; font-size: 50px">Morse Kääntäjä</h1>
	<form name="muunna" method="post">
		<p style="font-family: verdana">Muunnettava teksti (Max 50 merkkiä):</p>
		<input type="hidden" name="id" value="0"> 
		<input type="text" name="teksti" size="50" maxlength="50" onkeyup="vainKirjaimia(this)" required/ > 
		<input type="submit" value="Muunna" name="muunna"> <br> <br>
		<p style="font-family: verdana"> <c:out value="${tekstiAlk}"></c:out> </p>
		<br>
		<textarea name="tulos" rows="5" cols="50"><c:out value="${tulos}"></c:out></textarea>
		<br>
		<br>
	</form>
	
	<form name="tallenna" id="tallenna" method="post">
		<input type="hidden" name="tulos" value="${tulos}">
		<input type="hidden" name="teksti" value="${tekstiAlk}">
		<input type="text" name="nimimerkki" maxlength="15" placeholder="Nimimerkki" required/ > 
		<input type="hidden" name="id" value="0"> 
		<input type="submit" value="Tallenna viesti" name="tallenna" onclick="josTyhjaEiTallenna();">
		
		<br> <br> 
		<a style="text-decoration: none; color: white" href="http://localhost:8080/Harjoitustyo_Morse/lista">Tallennetut viestit</a>
		<br>
		<br>
	</form>
</div>
</body>
</html>