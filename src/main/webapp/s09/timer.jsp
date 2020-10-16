<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
<link rel="icon" type="image/x-icon" href="/mdwa/favicon.ico">
</head>
<body>
    <!-- HTML comment -->
    <h1>
        <%
            out.print(LocalTime.now());
        %>
    </h1>
    <%-- JSP comment --%>
    <p>
        Back <a href="/mdwa/index.html">home</a>
    </p>
</body>
</html>