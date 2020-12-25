<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Null Pointer</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
<link rel="stylesheet" type="text/css" href="/jes/css/simple.css">
</head>
<body>
    <h1>
        The <i>Null Pointer</i> band
    </h1>

    <h2>You ordered these albums</h2>

    <c:forEach var="album" items="${albums}">
        <p>${album.title}: ${album.quantity}</p>
    </c:forEach>

    <hr>
    <p>Thank you!</p>

    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>