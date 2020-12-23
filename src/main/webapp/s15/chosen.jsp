<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Colors</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
</head>
<body>
    <h1>Preferred colors</h1>
    <ul>
        <c:forEach var="color" items="${paramValues.colors}">
            <li>${color}</li>
        </c:forEach>
    </ul>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>