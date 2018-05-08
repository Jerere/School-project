<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body {background-color: DarkSlateGray;
	  color: white;}
a {font-family: verdana;}
p    {color: red;}
td { padding: 8px;
    border-bottom: 1px solid; }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Morsekoodi tietokanta</title>
</head>
<body>
<div align="center">
<h1 style="font-family:verdana; font-size: 50px"> Morsekoodi tietokanta </h1>
<br>

<table width="70%" style="font-family:verdana; text-align: center; table-layout: fixed; "> 

<c:forEach items="${morset}" var="morse">

	<tr>
			<td>  <c:out value="${morse.teksti}"></c:out></td> 
			<td><c:out value="${morse.morsekoodi}"></c:out></td>
			<td> Lähettäjä:  <c:out value="${morse.nimimerkki}"></c:out> <br>
			<a style="text-decoration: none; position: static; color: darkred" href="http://localhost:8080/Harjoitustyo_Morse/poista-morse?morse.id=${morse.id}">
			Poista viesti</a> </td>
	</tr>

</c:forEach>
</table>
<br>
<br>
<a style="text-decoration: none; color: white" href="http://localhost:8080/Harjoitustyo_Morse/etusivu">Takaisin etusivulle</a>
</div>
</body>
</html>