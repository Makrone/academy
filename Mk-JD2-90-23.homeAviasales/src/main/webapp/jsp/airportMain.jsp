<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>
<h1>All AIRPORTS Information</h1>
    <table border="1">
        <tr>
            <td>Code:</td>
            <td>Name:</td>
            <td>City:</td>
            <td>Coordinates:</td>
            <td>TimeZone:</td>
        </tr>
    <c:forEach items="${airports}" var="airport">
    <tr>      
        <td>${airport.code}</td>
        <td>${airport.name}</td>
        <td>${airport.city}</td>
        <td>${airport.coordinates}</td>
        <td>${airport.timezone}</td>  
    </tr>
</c:forEach>
    </table>
</body>
</html>


