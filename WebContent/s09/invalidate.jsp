<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>So long</title>
</head>
<body>
    <h1>Goodbye</h1>
    <%
        session.invalidate();
    %>
</body>
</html>