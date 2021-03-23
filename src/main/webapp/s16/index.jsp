<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
<title>Welcome to the restricted area</title>
</head>
<body>
    <h1>Restricted area</h1>

    <c:choose>
        <c:when test="${logged eq true}">
            <p>The <a href="restricted/important.jsp">important</a> document</p>
        </c:when>
        <c:otherwise>
            <p>Please, <a href="restricted/login.html">login</a> to have access (once) to the area</p>
        </c:otherwise>
    </c:choose>

</body>
</html>