<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>The Null Pointer Band</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
</head>
<body>
    <h1>The Null Pointer Band Music Store</h1>
    <nav>
        <span><a href="/jees/index.html">home</a></span>
        <c:if test="${not empty user}">
            <span><a href="logout">logout</a></span>
            <span><a href="buy.jsp">buy</a></span>
        </c:if>
    </nav>

    <h2>
        Hello<c:if test="${not empty user}">, ${user}</c:if>!
    </h2>
    
    <c:if test="${empty user}">
        <form action="login">
            <label>Login <input name="user" placeholder="..." autofocus></label>
            <button>OK</button>
        </form>
    </c:if>    
</body>
</html>