<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSTL conditions</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jes/css/simple.css">
</head>
<body>
    <h1>This JSP expects x or y as parameter</h1>

    <h2>Core if</h2>
    <c:if test="${param.x != null}">
        <p>Parameter x is ${param.x}</p>
    </c:if>
    <c:if test="${param.y != null}">
        <p>Parameter y is ${param.y}</p>
    </c:if>

    <h2>Core choose-when</h2>
    <c:choose>
        <c:when test="${param.x != null}">
            <p>Parameter x is ${param.x}</p>
        </c:when>
        <c:when test="${param.y != null}">
            <p>There's no x, but y is ${param.y}</p>
        </c:when>
        <c:otherwise>
            <p>Neither x nor y among parameters!</p>
        </c:otherwise>
    </c:choose>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>