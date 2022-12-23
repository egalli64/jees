<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty albums}">
    <c:redirect url="/s06/home.jsp" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy From The Null Pointer Band</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" href="/jees/css/simple.css">
</head>
<body>
    <h1>The Null Pointer Band Music Store</h1>
    <nav>
        <a href="/jees/s06/home.jsp">home</a>
    </nav>

    <h2>You ordered these albums</h2>

    <ul>
        <c:forEach var="album" items="${albums}">
            <li>${album.title}:&nbsp;${album.quantity}</li>
        </c:forEach>
    </ul>

    <hr>
    <p>Thank you!</p>
</body>
</html>