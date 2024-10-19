<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet and JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
<title>Hello JSP</title>
</head>
<body>
    <!-- a HTML comment -->
    <nav>
        <a href="/jees/index.html#m2">Home</a>
    </nav>
    <h1>
        <%
        // this is pure Java code!
        out.print(LocalTime.now());
        %>
    </h1>
    <%-- a JSP comment --%>
</body>
</html>