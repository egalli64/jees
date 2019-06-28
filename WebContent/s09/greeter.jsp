<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.time.Duration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Feedback</title>
</head>
<body>
    <h1>The greeter page</h1>

    <p>
        <%
            Duration duration = (Duration) request.getAttribute("duration");
            out.print("You started working on this stuff " + duration.getSeconds() + " seconds ago");
        %>
    </p>
</body>
</html>