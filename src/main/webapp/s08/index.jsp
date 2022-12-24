<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet
    https://github.com/egalli64/jees
 --%>
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
    <nav>
        <a href="/jees/index.html">Home</a>
    </nav>

    <c:choose>
        <c:when test="${logged eq true}">
            <p>An <a href="restricted/important.html">important</a> document</p>
            <p>An <a href="restricted/important">important</a> servlet</p>
        </c:when>
        <c:otherwise>
            <p>Please, login to have access (once) to the area</p>
            <form action="login" method="post">
                <label>User: <input name="user"></label>
                <label>Password: <input type="password" name="password"></label>
                <button>OK</button>
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>