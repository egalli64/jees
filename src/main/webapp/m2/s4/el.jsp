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

    <h2>Accessing a JavaBean</h2>
    <p>Implicitly converted to string: '${doc}'</p>
    <p>Its title field is '${doc.title}'</p>
    <p>Its user name is '${doc.user.name}' and its user id is '${doc.user["id"]}'</p>

    <h2>Accessing a record</h2>
    <p>Implicitly converted to string: '${bob}'</p>
    <p>Its name is '${bob['name']}" and its id is '${bob.id}'</p>

    <h2>Accessing a collection</h2>
    <p>Implicitly converted to string: '${names}'</p>
    <p>First element is '${names[0]}'</p>

    <h2>Evaluating values</h2>
    <p>Is the doc user id 42? ${doc.user.id eq 42 ? "Yes" : "No"}</p>
    <p>Is the names collection empty? ${empty names}</p>
</body>
</html>