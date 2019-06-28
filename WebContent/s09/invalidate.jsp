<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.time.Duration"%>
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

        Duration duration = (Duration) request.getAttribute("duration");
        out.print("You worked on this stuff for " + duration.getSeconds() + " seconds");
    %>
</body>
</html>