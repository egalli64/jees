<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Feedback</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
</head>
<body>
    <p>
        The passed parameters are: <%=request.getAttribute("result")%>
    </p>

    <p>
        Back <a href="/jees/index.html">home</a>
    </p>
</body>
</html>