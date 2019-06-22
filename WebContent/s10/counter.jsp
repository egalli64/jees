<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <%!int count = 0;%>
    <h1>
        <%
            out.print("Count was " + count);
        %>
        now is <%=++count%>
    </h1>
    <a href="..">back home</a>
</body>
</html>