<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <%-- Just as example --%>
    <%!int unreliableCounter = 0;%>
    <h1>
        <%
            out.print("Counter was " + unreliableCounter);
        %>
        now is
        <%=++unreliableCounter%>
    </h1>
    <a href="..">back home</a>
</body>
</html>