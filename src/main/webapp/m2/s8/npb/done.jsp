<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet and JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- user unknown, go to login --%>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="home.jsp" />
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>The NPB store</title>
<%@include file="/m2/include/link.html"%>
</head>
<body>
    <h1>The Null Pointer Band Music Store</h1>
    <nav>
        <a href="/jees/index.html">Home</a>
        <a href="home.jsp">Store home</a>
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