<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Colors</title>
</head>
<body>
    <ul>
        <c:forEach var="color" items="${paramValues.colors}">
            <li>${color}</li>
        </c:forEach>
    </ul>
</body>
</html>