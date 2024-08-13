<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet and JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>The Null Pointer Band</title>
<%@include file="/m2/include/link.html"%>
</head>
<body>
    <h1>The Null Pointer Band Music Store</h1>
    <nav>
        <span><a href="/jees/index.html#m2">Home</a></span>
        <%-- if user is in the session scope, more commands are available --%>
        <c:if test="${not empty sessionScope.user}">
            <span><a href="logout">logout</a></span>
            <span><a href="buy.jsp">buy</a></span>
        </c:if>
    </nav>

    <h2>
        <%-- greet the user, when known --%>
        Hello<c:if test="${not empty sessionScope.user}">, ${user}</c:if>!
    </h2>

    <%-- ask for login, when user unknown --%>
    <c:if test="${empty sessionScope.user}">
        <form action="login">
            <label>Login <input name="user" placeholder="..." autofocus></label>
            <button>OK</button>
        </form>
    </c:if>
</body>
</html>