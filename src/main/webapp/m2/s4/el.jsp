<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet & JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Expression Language</title>
<%@include file="/m2/include/link.html"%>
</head>
<body>
    <h1>Expression Language</h1>
    <%@include file="/m2/include/backHome.html"%>

    <h2>Accessing the doc JavaBean</h2>
    <p>The bean implicitly converted to string is ${doc}</p>
    <p>The doc title is ${doc.title}</p>
    <p>The doc user name is ${doc.user.name} and the user id ${doc.user["id"]}</p>

    <h2>Accessing the names collection</h2>
    <p>The names collection implicitly converted to string is ${names}</p>
    <p>First element in the names collection is ${names[0]}</p>

    <h2>Evaluating values</h2>
    <p>Is the doc user id 42? ${doc.user.id eq 42 ? "Yes" : "No"}</p>
    <p>Is the names collection empty? ${empty names}</p>
</body>
</html>